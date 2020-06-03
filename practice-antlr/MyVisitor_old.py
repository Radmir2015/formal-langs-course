import sys
from antlr4 import *
from syntaxVisitor import syntaxVisitor
from syntaxParser import syntaxParser


class MyVisitor(syntaxVisitor):
    def __init__(self):
        self.memory = {}

    def visitAssign(self, ctx):
        name = ctx.ID().getText()
        value = self.visit(ctx.sumExpr())
        self.memory[name] = value
        return value

    def visitPrintExpr(self, ctx):
        value = self.visit(ctx.sumExpr())
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
        return '0'

    def visitSumOp(self, ctx):
        left = int(self.visit(ctx.sumExpr()))
        if ctx.oper:
            right = int(self.visit(ctx.productExpr()))
            if ctx.oper.text == 'or':
                return left or right
            elif ctx.oper.text == 'xor':
                return int((left and not right) or (not left and right))
        else:
            return left

    def visitMulOp(self, ctx):
        left = int(self.visit(ctx.productExpr()))
        if ctx.oper:
            right = int(self.visit(ctx.unaryExpr()))
            if ctx.oper.text == 'and':
                return left and right
        else:
            return left

    def visitUnaryOp(self, ctx):
        left = int(self.visit(ctx.unaryExpr()))
        if ctx.oper.text == 'not':
            return int(not left)
        return 0

    def visitParens(self, ctx):
        return self.visit(ctx.sumExpr())

    def visitToProductExpr(self, ctx):
        return self.visit(ctx.productExpr())

    def visitToUnaryExpr(self, ctx):
        return self.visit(ctx.unaryExpr())

    def visitToAtom(self, ctx):
        return self.visit(ctx.atom())