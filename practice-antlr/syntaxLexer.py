# Generated from syntax.g4 by ANTLR 4.7.2
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys



def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22")
        buf.write("m\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7")
        buf.write("\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16")
        buf.write("\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3\2\3\2\3")
        buf.write("\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6")
        buf.write("\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3")
        buf.write("\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n")
        buf.write("\3\n\5\nR\n\n\3\13\6\13U\n\13\r\13\16\13V\3\f\6\fZ\n\f")
        buf.write("\r\f\16\f[\3\r\6\r_\n\r\r\r\16\r`\3\r\3\r\3\16\3\16\3")
        buf.write("\17\3\17\3\20\3\20\3\20\3\21\3\21\2\2\22\3\3\5\4\7\5\t")
        buf.write("\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20")
        buf.write("\37\21!\22\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2")
        buf.write("r\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13")
        buf.write("\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3")
        buf.write("\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2")
        buf.write("\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5")
        buf.write("\'\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\63\3\2\2\2\r\66\3")
        buf.write("\2\2\2\179\3\2\2\2\21=\3\2\2\2\23Q\3\2\2\2\25T\3\2\2\2")
        buf.write("\27Y\3\2\2\2\31^\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3")
        buf.write("\2\2\2!k\3\2\2\2#$\7p\2\2$%\7q\2\2%&\7v\2\2&\4\3\2\2\2")
        buf.write("\'(\7P\2\2()\7Q\2\2)*\7V\2\2*\6\3\2\2\2+,\7c\2\2,-\7p")
        buf.write("\2\2-.\7f\2\2.\b\3\2\2\2/\60\7C\2\2\60\61\7P\2\2\61\62")
        buf.write("\7F\2\2\62\n\3\2\2\2\63\64\7q\2\2\64\65\7t\2\2\65\f\3")
        buf.write("\2\2\2\66\67\7Q\2\2\678\7T\2\28\16\3\2\2\29:\7z\2\2:;")
        buf.write("\7q\2\2;<\7t\2\2<\20\3\2\2\2=>\7Z\2\2>?\7Q\2\2?@\7T\2")
        buf.write("\2@\22\3\2\2\2AB\7R\2\2BC\7T\2\2CD\7K\2\2DE\7P\2\2ER\7")
        buf.write("V\2\2FG\7r\2\2GH\7t\2\2HI\7k\2\2IJ\7p\2\2JR\7v\2\2KL\7")
        buf.write("R\2\2LM\7T\2\2MR\7V\2\2NO\7r\2\2OP\7t\2\2PR\7v\2\2QA\3")
        buf.write("\2\2\2QF\3\2\2\2QK\3\2\2\2QN\3\2\2\2R\24\3\2\2\2SU\t\2")
        buf.write("\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\26\3\2\2")
        buf.write("\2XZ\t\3\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2")
        buf.write("\\\30\3\2\2\2]_\t\4\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2")
        buf.write("`a\3\2\2\2ab\3\2\2\2bc\b\r\2\2c\32\3\2\2\2de\7*\2\2e\34")
        buf.write("\3\2\2\2fg\7+\2\2g\36\3\2\2\2hi\7<\2\2ij\7?\2\2j \3\2")
        buf.write("\2\2kl\7=\2\2l\"\3\2\2\2\7\2QV[`\3\b\2\2")
        return buf.getvalue()


class syntaxLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    T__5 = 6
    T__6 = 7
    T__7 = 8
    PRINT = 9
    ID = 10
    INT = 11
    WS = 12
    LPAR = 13
    RPAR = 14
    ASSIGN = 15
    COL = 16

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'not'", "'NOT'", "'and'", "'AND'", "'or'", "'OR'", "'xor'", 
            "'XOR'", "'('", "')'", "':='", "';'" ]

    symbolicNames = [ "<INVALID>",
            "PRINT", "ID", "INT", "WS", "LPAR", "RPAR", "ASSIGN", "COL" ]

    ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", 
                  "T__7", "PRINT", "ID", "INT", "WS", "LPAR", "RPAR", "ASSIGN", 
                  "COL" ]

    grammarFileName = "syntax.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7.2")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


