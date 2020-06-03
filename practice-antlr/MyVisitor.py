import sys
from antlr4 import *
from syntaxVisitor import syntaxVisitor
from syntaxParser import syntaxParser


class MyVisitor(syntaxVisitor):
    def __init__(self):
        self.memory = {}

    def visitAssignExpr(self, ctx):
        name = ctx.ID().getText()
        value = self.visit(ctx.logExpr())
        self.memory[name] = value
        return value

    def visitPrintExpr(self, ctx):
        value = self.visit(ctx.logExpr())
        print(value)
        return 0

    def visitPrintId(self, ctx):
        name = ctx.ID().getText()
        print(self.memory[name])
        # print(self.visit(ctx.id()))
        return 0

    def visitInteger(self, ctx):
        return ctx.INT().getText()

    def visitIdent(self, ctx):
        name = ctx.ID().getText()
        if name in self.memory:
            return self.memory[name]
        print('[NOTICE]: variable wasn\'t declared, assigned 0 to', name)
        self.memory[name] = '0'
        return self.memory[name]

    def visitOrXorOp(self, ctx):
        left = int(self.visit(ctx.logExpr(0)))
        right = int(self.visit(ctx.logExpr(1)))
        if ctx.oper:
            if ctx.oper.text.lower() == 'or':
                return int(left or right)
            elif ctx.oper.text.lower() == 'xor':
                return int((left and not right) or (not left and right))
        else:
            return left

    def visitAndOp(self, ctx):
        left = int(self.visit(ctx.logExpr(0)))
        right = int(self.visit(ctx.logExpr(1)))
        if ctx.oper.text.lower() == 'and':
            return left and right
        else:
            return left

    def visitNotOp(self, ctx):
        left = int(self.visit(ctx.logExpr()))
        if ctx.oper.text.lower() == 'not':
            return int(not left)
        return 0

    def visitParens(self, ctx):
        return self.visit(ctx.logExpr())