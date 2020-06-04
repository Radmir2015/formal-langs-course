# Generated from syntax.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .syntaxParser import syntaxParser
else:
    from syntaxParser import syntaxParser

# This class defines a complete listener for a parse tree produced by syntaxParser.
class syntaxListener(ParseTreeListener):

    # Enter a parse tree produced by syntaxParser#prog.
    def enterProg(self, ctx:syntaxParser.ProgContext):
        pass

    # Exit a parse tree produced by syntaxParser#prog.
    def exitProg(self, ctx:syntaxParser.ProgContext):
        pass


    # Enter a parse tree produced by syntaxParser#stat.
    def enterStat(self, ctx:syntaxParser.StatContext):
        pass

    # Exit a parse tree produced by syntaxParser#stat.
    def exitStat(self, ctx:syntaxParser.StatContext):
        pass


    # Enter a parse tree produced by syntaxParser#block.
    def enterBlock(self, ctx:syntaxParser.BlockContext):
        pass

    # Exit a parse tree produced by syntaxParser#block.
    def exitBlock(self, ctx:syntaxParser.BlockContext):
        pass


    # Enter a parse tree produced by syntaxParser#line.
    def enterLine(self, ctx:syntaxParser.LineContext):
        pass

    # Exit a parse tree produced by syntaxParser#line.
    def exitLine(self, ctx:syntaxParser.LineContext):
        pass


    # Enter a parse tree produced by syntaxParser#lab.
    def enterLab(self, ctx:syntaxParser.LabContext):
        pass

    # Exit a parse tree produced by syntaxParser#lab.
    def exitLab(self, ctx:syntaxParser.LabContext):
        pass


    # Enter a parse tree produced by syntaxParser#mov.
    def enterMov(self, ctx:syntaxParser.MovContext):
        pass

    # Exit a parse tree produced by syntaxParser#mov.
    def exitMov(self, ctx:syntaxParser.MovContext):
        pass


    # Enter a parse tree produced by syntaxParser#add.
    def enterAdd(self, ctx:syntaxParser.AddContext):
        pass

    # Exit a parse tree produced by syntaxParser#add.
    def exitAdd(self, ctx:syntaxParser.AddContext):
        pass


    # Enter a parse tree produced by syntaxParser#cmp.
    def enterCmp(self, ctx:syntaxParser.CmpContext):
        pass

    # Exit a parse tree produced by syntaxParser#cmp.
    def exitCmp(self, ctx:syntaxParser.CmpContext):
        pass


    # Enter a parse tree produced by syntaxParser#dec.
    def enterDec(self, ctx:syntaxParser.DecContext):
        pass

    # Exit a parse tree produced by syntaxParser#dec.
    def exitDec(self, ctx:syntaxParser.DecContext):
        pass


    # Enter a parse tree produced by syntaxParser#je.
    def enterJe(self, ctx:syntaxParser.JeContext):
        pass

    # Exit a parse tree produced by syntaxParser#je.
    def exitJe(self, ctx:syntaxParser.JeContext):
        pass


    # Enter a parse tree produced by syntaxParser#jmp.
    def enterJmp(self, ctx:syntaxParser.JmpContext):
        pass

    # Exit a parse tree produced by syntaxParser#jmp.
    def exitJmp(self, ctx:syntaxParser.JmpContext):
        pass


    # Enter a parse tree produced by syntaxParser#jg.
    def enterJg(self, ctx:syntaxParser.JgContext):
        pass

    # Exit a parse tree produced by syntaxParser#jg.
    def exitJg(self, ctx:syntaxParser.JgContext):
        pass


    # Enter a parse tree produced by syntaxParser#prt.
    def enterPrt(self, ctx:syntaxParser.PrtContext):
        pass

    # Exit a parse tree produced by syntaxParser#prt.
    def exitPrt(self, ctx:syntaxParser.PrtContext):
        pass


    # Enter a parse tree produced by syntaxParser#ret.
    def enterRet(self, ctx:syntaxParser.RetContext):
        pass

    # Exit a parse tree produced by syntaxParser#ret.
    def exitRet(self, ctx:syntaxParser.RetContext):
        pass


