# Generated from syntax.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .syntaxParser import syntaxParser
else:
    from syntaxParser import syntaxParser

# This class defines a complete generic visitor for a parse tree produced by syntaxParser.

class syntaxVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by syntaxParser#program.
    def visitProgram(self, ctx:syntaxParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#line.
    def visitLine(self, ctx:syntaxParser.LineContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#orXorOp.
    def visitOrXorOp(self, ctx:syntaxParser.OrXorOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#parens.
    def visitParens(self, ctx:syntaxParser.ParensContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#andOp.
    def visitAndOp(self, ctx:syntaxParser.AndOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#notOp.
    def visitNotOp(self, ctx:syntaxParser.NotOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#ident.
    def visitIdent(self, ctx:syntaxParser.IdentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#integer.
    def visitInteger(self, ctx:syntaxParser.IntegerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#printId.
    def visitPrintId(self, ctx:syntaxParser.PrintIdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#printExpr.
    def visitPrintExpr(self, ctx:syntaxParser.PrintExprContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by syntaxParser#assignExpr.
    def visitAssignExpr(self, ctx:syntaxParser.AssignExprContext):
        return self.visitChildren(ctx)



del syntaxParser