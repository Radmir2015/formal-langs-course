# Generated from syntax.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .syntaxParser import syntaxParser
else:
    from syntaxParser import syntaxParser

# This class defines a complete listener for a parse tree produced by syntaxParser.
class syntaxListener(ParseTreeListener):

    # Enter a parse tree produced by syntaxParser#program.
    def enterProgram(self, ctx:syntaxParser.ProgramContext):
        pass

    # Exit a parse tree produced by syntaxParser#program.
    def exitProgram(self, ctx:syntaxParser.ProgramContext):
        pass


    # Enter a parse tree produced by syntaxParser#line.
    def enterLine(self, ctx:syntaxParser.LineContext):
        pass

    # Exit a parse tree produced by syntaxParser#line.
    def exitLine(self, ctx:syntaxParser.LineContext):
        pass


    # Enter a parse tree produced by syntaxParser#orXorOp.
    def enterOrXorOp(self, ctx:syntaxParser.OrXorOpContext):
        pass

    # Exit a parse tree produced by syntaxParser#orXorOp.
    def exitOrXorOp(self, ctx:syntaxParser.OrXorOpContext):
        pass


    # Enter a parse tree produced by syntaxParser#parens.
    def enterParens(self, ctx:syntaxParser.ParensContext):
        pass

    # Exit a parse tree produced by syntaxParser#parens.
    def exitParens(self, ctx:syntaxParser.ParensContext):
        pass


    # Enter a parse tree produced by syntaxParser#andOp.
    def enterAndOp(self, ctx:syntaxParser.AndOpContext):
        pass

    # Exit a parse tree produced by syntaxParser#andOp.
    def exitAndOp(self, ctx:syntaxParser.AndOpContext):
        pass


    # Enter a parse tree produced by syntaxParser#notOp.
    def enterNotOp(self, ctx:syntaxParser.NotOpContext):
        pass

    # Exit a parse tree produced by syntaxParser#notOp.
    def exitNotOp(self, ctx:syntaxParser.NotOpContext):
        pass


    # Enter a parse tree produced by syntaxParser#ident.
    def enterIdent(self, ctx:syntaxParser.IdentContext):
        pass

    # Exit a parse tree produced by syntaxParser#ident.
    def exitIdent(self, ctx:syntaxParser.IdentContext):
        pass


    # Enter a parse tree produced by syntaxParser#integer.
    def enterInteger(self, ctx:syntaxParser.IntegerContext):
        pass

    # Exit a parse tree produced by syntaxParser#integer.
    def exitInteger(self, ctx:syntaxParser.IntegerContext):
        pass


    # Enter a parse tree produced by syntaxParser#printId.
    def enterPrintId(self, ctx:syntaxParser.PrintIdContext):
        pass

    # Exit a parse tree produced by syntaxParser#printId.
    def exitPrintId(self, ctx:syntaxParser.PrintIdContext):
        pass


    # Enter a parse tree produced by syntaxParser#printExpr.
    def enterPrintExpr(self, ctx:syntaxParser.PrintExprContext):
        pass

    # Exit a parse tree produced by syntaxParser#printExpr.
    def exitPrintExpr(self, ctx:syntaxParser.PrintExprContext):
        pass


    # Enter a parse tree produced by syntaxParser#assignExpr.
    def enterAssignExpr(self, ctx:syntaxParser.AssignExprContext):
        pass

    # Exit a parse tree produced by syntaxParser#assignExpr.
    def exitAssignExpr(self, ctx:syntaxParser.AssignExprContext):
        pass


