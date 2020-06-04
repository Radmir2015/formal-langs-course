import sys
from antlr4 import *
from syntaxLexer import syntaxLexer
from syntaxListener import syntaxListener
from syntaxParser import syntaxParser

ID_TOKEN = 14
INT_TOKEN = 15

VERBOSE = False

memory = {
    # 'input': [5, 4, 2, 14, 2, 3],
    "input": [5, -99, 2123, 0, -444, 3],
    "flags": {"equal": False, "greater": False},
    "labels": {},
    "vars": {},
}

PC = {}
CX = 1


class syntaxListener(syntaxListener):
    def memory_dump(self):
        return "\n\tРЕГИСТРЫ = {}\n\tФЛАГИ = {}\n\tВВОД = {}\n".format(
            memory["vars"], memory["flags"], memory["input"]
        )

    def print_command(self, ctx, command_string=None, mem_dump=True):
        input()
        print(
            "PC =",
            self.pc("{},{}".format(str(ctx.start.line), str(ctx.start.column))),
            end=" ",
        )
        if command_string is not None:
            print(command_string)
        if mem_dump:
            print(self.memory_dump())

    def pc(self, line):
        global PC
        global CX
        if line not in PC:
            PC[line] = CX
            CX += 1
        return PC[line]

    def enterProg(self, ctx):
        for inx, c in enumerate(list(ctx.getChildren())[:-1]):
            if c.getChildCount() > 1:
                memory["labels"][c.start.text] = [list(c.getChildren())[1]]

                # add EOF token (TODO: finish when faced EOF)

        if VERBOSE:
            print("start_memory", memory)

    def exitJmp(self, ctx):
        # save only one code-block after the jump
        # because increase of block-to-run causes multi-running this blocks in nested labels env
        # actually it's enough to assign label's block once

        if ctx.parentCtx.getChildCount() < 2:
            ctx.parentCtx.children += memory["labels"][ctx.labelName.labelName.text]

        if VERBOSE:
            self.print_command(ctx, "jmp {}".format(ctx.labelName.labelName.text))

    def exitJe(self, ctx):
        if VERBOSE:
            self.print_command(ctx, "je {}".format(ctx.labelName.labelName.text))

        if memory["flags"]["equal"]:
            if ctx.parentCtx.getChildCount() < 2:
                ctx.parentCtx.children += memory["labels"][ctx.labelName.labelName.text]
        else:
            for r in range(1, ctx.parentCtx.getChildCount()):
                del ctx.parentCtx.children[r]

    def exitJg(self, ctx):
        if VERBOSE:
            self.print_command(ctx, "jg {}".format(ctx.labelName.labelName.text))

        if memory["flags"]["greater"]:
            if ctx.parentCtx.getChildCount() < 2:
                ctx.parentCtx.children += memory["labels"][ctx.labelName.labelName.text]
        else:
            for r in range(1, ctx.parentCtx.getChildCount()):
                del ctx.parentCtx.children[r]

    def assignTwoVariables(self, ctx, op="="):
        temp_storage = None
        from_to = {}

        if ctx.fromInt:  # push number
            temp_storage = int(ctx.fromInt.text)
            from_to["from"] = {"address": None}

        if ctx.fromId:  # push variable
            if ctx.fromId.text in memory["vars"]:
                temp_storage = memory["vars"][ctx.fromId.text]
                from_to["from"] = {"address": ctx.fromId.text}
            else:
                print(ctx.fromId.text, "is not in the memory.")

        if ctx.fromIntAddress:  # push [int]
            if 0 <= int(ctx.fromIntAddress.text) < len(memory["input"]):
                temp_storage = memory["input"][int(ctx.fromIntAddress.text)]
                from_to["from"] = {"address": "[{}]".format(ctx.fromIntAddress.text)}
            else:
                print(
                    '[{}] is not in the memory["input"].'.format(
                        ctx.fromIntAddress.text
                    )
                )

        if ctx.fromIdAddress:  # push [variable]
            if ctx.fromIdAddress.text in memory["vars"] and 0 <= memory["vars"][
                ctx.fromIdAddress.text
            ] < len(memory["input"]):
                temp_storage = memory["input"][memory["vars"][ctx.fromIdAddress.text]]
                from_to["from"] = {
                    "address": "[{}( = {})]".format(
                        ctx.fromIdAddress.text, memory["vars"][ctx.fromIdAddress.text]
                    )
                }
            else:
                print(
                    '[{}] is not in the memory["input"].'.format(ctx.fromIdAddress.text)
                )

        if temp_storage is not None:
            from_to["from"]["value"] = temp_storage
            if ctx.toId:
                from_to["to"] = {
                    "address": ctx.toId.text,
                    "value": memory["vars"][ctx.toId.text]
                    if ctx.toId.text in memory["vars"]
                    else None,
                }
                if op == "=":
                    memory["vars"][ctx.toId.text] = temp_storage
                elif op == "+":
                    memory["vars"][ctx.toId.text] += temp_storage
                elif op == "-":
                    memory["vars"][ctx.toId.text] -= temp_storage
                elif op == "*":
                    memory["vars"][ctx.toId.text] *= temp_storage
                elif op == "/":
                    memory["vars"][ctx.toId.text] /= temp_storage
                from_to["result"] = memory["vars"][ctx.toId.text]
            elif ctx.toIdAddress:
                from_to["to"] = {
                    "address": "[{}( = {})]".format(
                        ctx.toIdAddress.text, memory["vars"][ctx.toIdAddress.text]
                    ),
                    "value": memory["input"][memory["vars"][ctx.toIdAddress.text]],
                }
                if op == "=":
                    memory["input"][memory["vars"][ctx.toIdAddress.text]] = temp_storage
                elif op == "+":
                    memory["input"][
                        memory["vars"][ctx.toIdAddress.text]
                    ] += temp_storage
                elif op == "-":
                    memory["input"][
                        memory["vars"][ctx.toIdAddress.text]
                    ] -= temp_storage
                elif op == "*":
                    memory["input"][
                        memory["vars"][ctx.toIdAddress.text]
                    ] *= temp_storage
                elif op == "/":
                    memory["input"][
                        memory["vars"][ctx.toIdAddress.text]
                    ] /= temp_storage
                from_to["result"] = memory["input"][
                    memory["vars"][ctx.toIdAddress.text]
                ]
            else:
                print("Assign error...")

        return from_to

    def exitAdd(self, ctx):
        result = self.assignTwoVariables(ctx, "+")

        if VERBOSE:
            self.print_command(ctx, "add {}".format(result))

    def exitMov(self, ctx):
        result = self.assignTwoVariables(ctx)

        if VERBOSE:
            self.print_command(ctx, "mov {}".format(result))

    def exitDec(self, ctx):
        memory["vars"][ctx.var.text] -= 1

        if VERBOSE:
            self.print_command(
                ctx,
                "dec {0} => {0} = {1}".format(
                    ctx.var.text, memory["vars"][ctx.var.text]
                ),
            )

    def exitCmp(self, ctx):
        a, b = None, None

        if ctx.a:
            a = (
                memory["vars"][ctx.a.text]
                if ctx.a.type == ID_TOKEN
                else int(ctx.a.text)
            )
        elif ctx.addressA:
            a = (
                memory["input"][memory["vars"][ctx.addressA.text]]
                if ctx.addressA.type == ID_TOKEN
                else memory["input"][int(ctx.addressA.text)]
            )

        if ctx.b:
            b = (
                memory["vars"][ctx.b.text]
                if ctx.b.type == ID_TOKEN
                else int(ctx.b.text)
            )
        elif ctx.addressB:
            b = (
                memory["input"][memory["vars"][ctx.addressB.text]]
                if ctx.addressB.type == ID_TOKEN
                else memory["input"][int(ctx.addressB.text)]
            )

        if a is not None and b is not None:
            memory["flags"]["equal"] = a == b
            memory["flags"]["greater"] = a > b

        if VERBOSE:
            self.print_command(ctx, "cmp")

    def exitPrt(self, ctx):
        if VERBOSE:
            self.print_command(ctx, mem_dump=False)
            print("OUTPUT: ", end="")
        if ctx.a.type == ID_TOKEN:  # variable
            print(memory["vars"][ctx.a.text])
        elif ctx.a.type == INT_TOKEN:  # number
            print(ctx.a.text)

    def exitRet(self, ctx):
        if VERBOSE:
            print("end_memory", memory)

        quit(0)


def main(argv):
    input_stream = FileStream(argv[1])
    lexer = syntaxLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = syntaxParser(stream)

    tree = parser.prog()

    printer = syntaxListener()
    walker = ParseTreeWalker()
    walker.walk(printer, tree)

    # print(tree)


if __name__ == "__main__":
    VERBOSE = True
    main(sys.argv)
