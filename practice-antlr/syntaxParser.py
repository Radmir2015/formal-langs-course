# Generated from syntax.g4 by ANTLR 4.7.2
# encoding: utf-8
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22")
        buf.write("=\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n")
        buf.write("\2\f\2\16\2\21\13\2\3\2\3\2\3\3\3\3\5\3\27\n\3\3\4\3\4")
        buf.write("\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\"\n\4\3\4\3\4\3\4\3\4")
        buf.write("\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3\5\3\5\3\5\3")
        buf.write("\5\3\5\5\5\66\n\5\3\6\3\6\3\6\3\6\3\6\3\6\2\3\6\7\2\4")
        buf.write("\6\b\n\2\5\3\2\3\4\3\2\5\6\3\2\7\n\2?\2\17\3\2\2\2\4\26")
        buf.write("\3\2\2\2\6!\3\2\2\2\b\65\3\2\2\2\n\67\3\2\2\2\f\16\5\4")
        buf.write("\3\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2")
        buf.write("\2\2\20\22\3\2\2\2\21\17\3\2\2\2\22\23\7\2\2\3\23\3\3")
        buf.write("\2\2\2\24\27\5\b\5\2\25\27\5\n\6\2\26\24\3\2\2\2\26\25")
        buf.write("\3\2\2\2\27\5\3\2\2\2\30\31\b\4\1\2\31\32\7\17\2\2\32")
        buf.write("\33\5\6\4\2\33\34\7\20\2\2\34\"\3\2\2\2\35\36\t\2\2\2")
        buf.write("\36\"\5\6\4\7\37\"\7\f\2\2 \"\7\r\2\2!\30\3\2\2\2!\35")
        buf.write("\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"+\3\2\2\2#$\f\6\2\2$%")
        buf.write("\t\3\2\2%*\5\6\4\7&\'\f\5\2\2\'(\t\4\2\2(*\5\6\4\6)#\3")
        buf.write("\2\2\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2")
        buf.write("\2\2-+\3\2\2\2./\7\13\2\2/\60\7\f\2\2\60\66\7\22\2\2\61")
        buf.write("\62\7\13\2\2\62\63\5\6\4\2\63\64\7\22\2\2\64\66\3\2\2")
        buf.write("\2\65.\3\2\2\2\65\61\3\2\2\2\66\t\3\2\2\2\678\7\f\2\2")
        buf.write("89\7\21\2\29:\5\6\4\2:;\7\22\2\2;\13\3\2\2\2\b\17\26!")
        buf.write(")+\65")
        return buf.getvalue()


class syntaxParser ( Parser ):

    grammarFileName = "syntax.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'not'", "'NOT'", "'and'", "'AND'", "'or'", 
                     "'OR'", "'xor'", "'XOR'", "<INVALID>", "<INVALID>", 
                     "<INVALID>", "<INVALID>", "'('", "')'", "':='", "';'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "PRINT", "ID", "INT", "WS", "LPAR", "RPAR", 
                      "ASSIGN", "COL" ]

    RULE_program = 0
    RULE_line = 1
    RULE_logExpr = 2
    RULE_print_ = 3
    RULE_assign = 4

    ruleNames =  [ "program", "line", "logExpr", "print_", "assign" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    T__6=7
    T__7=8
    PRINT=9
    ID=10
    INT=11
    WS=12
    LPAR=13
    RPAR=14
    ASSIGN=15
    COL=16

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7.2")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class ProgramContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EOF(self):
            return self.getToken(syntaxParser.EOF, 0)

        def line(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(syntaxParser.LineContext)
            else:
                return self.getTypedRuleContext(syntaxParser.LineContext,i)


        def getRuleIndex(self):
            return syntaxParser.RULE_program

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterProgram" ):
                listener.enterProgram(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitProgram" ):
                listener.exitProgram(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitProgram" ):
                return visitor.visitProgram(self)
            else:
                return visitor.visitChildren(self)




    def program(self):

        localctx = syntaxParser.ProgramContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_program)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 13
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while _la==syntaxParser.PRINT or _la==syntaxParser.ID:
                self.state = 10
                self.line()
                self.state = 15
                self._errHandler.sync(self)
                _la = self._input.LA(1)

            self.state = 16
            self.match(syntaxParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class LineContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def print_(self):
            return self.getTypedRuleContext(syntaxParser.Print_Context,0)


        def assign(self):
            return self.getTypedRuleContext(syntaxParser.AssignContext,0)


        def getRuleIndex(self):
            return syntaxParser.RULE_line

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterLine" ):
                listener.enterLine(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitLine" ):
                listener.exitLine(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitLine" ):
                return visitor.visitLine(self)
            else:
                return visitor.visitChildren(self)




    def line(self):

        localctx = syntaxParser.LineContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_line)
        try:
            self.state = 20
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [syntaxParser.PRINT]:
                self.enterOuterAlt(localctx, 1)
                self.state = 18
                self.print_()
                pass
            elif token in [syntaxParser.ID]:
                self.enterOuterAlt(localctx, 2)
                self.state = 19
                self.assign()
                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class LogExprContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return syntaxParser.RULE_logExpr

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)


    class OrXorOpContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.oper = None # Token
            self.copyFrom(ctx)

        def logExpr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(syntaxParser.LogExprContext)
            else:
                return self.getTypedRuleContext(syntaxParser.LogExprContext,i)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterOrXorOp" ):
                listener.enterOrXorOp(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitOrXorOp" ):
                listener.exitOrXorOp(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitOrXorOp" ):
                return visitor.visitOrXorOp(self)
            else:
                return visitor.visitChildren(self)


    class ParensContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def LPAR(self):
            return self.getToken(syntaxParser.LPAR, 0)
        def logExpr(self):
            return self.getTypedRuleContext(syntaxParser.LogExprContext,0)

        def RPAR(self):
            return self.getToken(syntaxParser.RPAR, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterParens" ):
                listener.enterParens(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitParens" ):
                listener.exitParens(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitParens" ):
                return visitor.visitParens(self)
            else:
                return visitor.visitChildren(self)


    class AndOpContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.oper = None # Token
            self.copyFrom(ctx)

        def logExpr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(syntaxParser.LogExprContext)
            else:
                return self.getTypedRuleContext(syntaxParser.LogExprContext,i)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAndOp" ):
                listener.enterAndOp(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAndOp" ):
                listener.exitAndOp(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAndOp" ):
                return visitor.visitAndOp(self)
            else:
                return visitor.visitChildren(self)


    class NotOpContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.oper = None # Token
            self.copyFrom(ctx)

        def logExpr(self):
            return self.getTypedRuleContext(syntaxParser.LogExprContext,0)


        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterNotOp" ):
                listener.enterNotOp(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitNotOp" ):
                listener.exitNotOp(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitNotOp" ):
                return visitor.visitNotOp(self)
            else:
                return visitor.visitChildren(self)


    class IdentContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(syntaxParser.ID, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterIdent" ):
                listener.enterIdent(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitIdent" ):
                listener.exitIdent(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitIdent" ):
                return visitor.visitIdent(self)
            else:
                return visitor.visitChildren(self)


    class IntegerContext(LogExprContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.LogExprContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def INT(self):
            return self.getToken(syntaxParser.INT, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterInteger" ):
                listener.enterInteger(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitInteger" ):
                listener.exitInteger(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitInteger" ):
                return visitor.visitInteger(self)
            else:
                return visitor.visitChildren(self)



    def logExpr(self, _p:int=0):
        _parentctx = self._ctx
        _parentState = self.state
        localctx = syntaxParser.LogExprContext(self, self._ctx, _parentState)
        _prevctx = localctx
        _startState = 4
        self.enterRecursionRule(localctx, 4, self.RULE_logExpr, _p)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 31
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [syntaxParser.LPAR]:
                localctx = syntaxParser.ParensContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx

                self.state = 23
                self.match(syntaxParser.LPAR)
                self.state = 24
                self.logExpr(0)
                self.state = 25
                self.match(syntaxParser.RPAR)
                pass
            elif token in [syntaxParser.T__0, syntaxParser.T__1]:
                localctx = syntaxParser.NotOpContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 27
                localctx.oper = self._input.LT(1)
                _la = self._input.LA(1)
                if not(_la==syntaxParser.T__0 or _la==syntaxParser.T__1):
                    localctx.oper = self._errHandler.recoverInline(self)
                else:
                    self._errHandler.reportMatch(self)
                    self.consume()
                self.state = 28
                self.logExpr(5)
                pass
            elif token in [syntaxParser.ID]:
                localctx = syntaxParser.IdentContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 29
                self.match(syntaxParser.ID)
                pass
            elif token in [syntaxParser.INT]:
                localctx = syntaxParser.IntegerContext(self, localctx)
                self._ctx = localctx
                _prevctx = localctx
                self.state = 30
                self.match(syntaxParser.INT)
                pass
            else:
                raise NoViableAltException(self)

            self._ctx.stop = self._input.LT(-1)
            self.state = 41
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,4,self._ctx)
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1:
                    if self._parseListeners is not None:
                        self.triggerExitRuleEvent()
                    _prevctx = localctx
                    self.state = 39
                    self._errHandler.sync(self)
                    la_ = self._interp.adaptivePredict(self._input,3,self._ctx)
                    if la_ == 1:
                        localctx = syntaxParser.AndOpContext(self, syntaxParser.LogExprContext(self, _parentctx, _parentState))
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_logExpr)
                        self.state = 33
                        if not self.precpred(self._ctx, 4):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 4)")
                        self.state = 34
                        localctx.oper = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not(_la==syntaxParser.T__2 or _la==syntaxParser.T__3):
                            localctx.oper = self._errHandler.recoverInline(self)
                        else:
                            self._errHandler.reportMatch(self)
                            self.consume()
                        self.state = 35
                        self.logExpr(5)
                        pass

                    elif la_ == 2:
                        localctx = syntaxParser.OrXorOpContext(self, syntaxParser.LogExprContext(self, _parentctx, _parentState))
                        self.pushNewRecursionContext(localctx, _startState, self.RULE_logExpr)
                        self.state = 36
                        if not self.precpred(self._ctx, 3):
                            from antlr4.error.Errors import FailedPredicateException
                            raise FailedPredicateException(self, "self.precpred(self._ctx, 3)")
                        self.state = 37
                        localctx.oper = self._input.LT(1)
                        _la = self._input.LA(1)
                        if not((((_la) & ~0x3f) == 0 and ((1 << _la) & ((1 << syntaxParser.T__4) | (1 << syntaxParser.T__5) | (1 << syntaxParser.T__6) | (1 << syntaxParser.T__7))) != 0)):
                            localctx.oper = self._errHandler.recoverInline(self)
                        else:
                            self._errHandler.reportMatch(self)
                            self.consume()
                        self.state = 38
                        self.logExpr(4)
                        pass

             
                self.state = 43
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,4,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.unrollRecursionContexts(_parentctx)
        return localctx


    class Print_Context(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return syntaxParser.RULE_print_

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class PrintIdContext(Print_Context):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.Print_Context
            super().__init__(parser)
            self.copyFrom(ctx)

        def PRINT(self):
            return self.getToken(syntaxParser.PRINT, 0)
        def ID(self):
            return self.getToken(syntaxParser.ID, 0)
        def COL(self):
            return self.getToken(syntaxParser.COL, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterPrintId" ):
                listener.enterPrintId(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitPrintId" ):
                listener.exitPrintId(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitPrintId" ):
                return visitor.visitPrintId(self)
            else:
                return visitor.visitChildren(self)


    class PrintExprContext(Print_Context):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.Print_Context
            super().__init__(parser)
            self.copyFrom(ctx)

        def PRINT(self):
            return self.getToken(syntaxParser.PRINT, 0)
        def logExpr(self):
            return self.getTypedRuleContext(syntaxParser.LogExprContext,0)

        def COL(self):
            return self.getToken(syntaxParser.COL, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterPrintExpr" ):
                listener.enterPrintExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitPrintExpr" ):
                listener.exitPrintExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitPrintExpr" ):
                return visitor.visitPrintExpr(self)
            else:
                return visitor.visitChildren(self)



    def print_(self):

        localctx = syntaxParser.Print_Context(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_print_)
        try:
            self.state = 51
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,5,self._ctx)
            if la_ == 1:
                localctx = syntaxParser.PrintIdContext(self, localctx)
                self.enterOuterAlt(localctx, 1)
                self.state = 44
                self.match(syntaxParser.PRINT)
                self.state = 45
                self.match(syntaxParser.ID)
                self.state = 46
                self.match(syntaxParser.COL)
                pass

            elif la_ == 2:
                localctx = syntaxParser.PrintExprContext(self, localctx)
                self.enterOuterAlt(localctx, 2)
                self.state = 47
                self.match(syntaxParser.PRINT)
                self.state = 48
                self.logExpr(0)
                self.state = 49
                self.match(syntaxParser.COL)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class AssignContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser


        def getRuleIndex(self):
            return syntaxParser.RULE_assign

     
        def copyFrom(self, ctx:ParserRuleContext):
            super().copyFrom(ctx)



    class AssignExprContext(AssignContext):

        def __init__(self, parser, ctx:ParserRuleContext): # actually a syntaxParser.AssignContext
            super().__init__(parser)
            self.copyFrom(ctx)

        def ID(self):
            return self.getToken(syntaxParser.ID, 0)
        def ASSIGN(self):
            return self.getToken(syntaxParser.ASSIGN, 0)
        def logExpr(self):
            return self.getTypedRuleContext(syntaxParser.LogExprContext,0)

        def COL(self):
            return self.getToken(syntaxParser.COL, 0)

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterAssignExpr" ):
                listener.enterAssignExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitAssignExpr" ):
                listener.exitAssignExpr(self)

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAssignExpr" ):
                return visitor.visitAssignExpr(self)
            else:
                return visitor.visitChildren(self)



    def assign(self):

        localctx = syntaxParser.AssignContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_assign)
        try:
            localctx = syntaxParser.AssignExprContext(self, localctx)
            self.enterOuterAlt(localctx, 1)
            self.state = 53
            self.match(syntaxParser.ID)
            self.state = 54
            self.match(syntaxParser.ASSIGN)
            self.state = 55
            self.logExpr(0)
            self.state = 56
            self.match(syntaxParser.COL)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx



    def sempred(self, localctx:RuleContext, ruleIndex:int, predIndex:int):
        if self._predicates == None:
            self._predicates = dict()
        self._predicates[2] = self.logExpr_sempred
        pred = self._predicates.get(ruleIndex, None)
        if pred is None:
            raise Exception("No predicate with index:" + str(ruleIndex))
        else:
            return pred(localctx, predIndex)

    def logExpr_sempred(self, localctx:LogExprContext, predIndex:int):
            if predIndex == 0:
                return self.precpred(self._ctx, 4)
         

            if predIndex == 1:
                return self.precpred(self._ctx, 3)
         




