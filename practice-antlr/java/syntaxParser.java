// Generated from syntax.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class syntaxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NOT=1, AND=2, OR=3, XOR=4, PRINT=5, ID=6, INT=7, WS=8, LPAR=9, RPAR=10, 
		ASSIGN=11, COL=12;
	public static final int
		RULE_program = 0, RULE_line = 1, RULE_logExpr = 2, RULE_print = 3, RULE_assign = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "line", "logExpr", "print", "assign"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "'('", "')'", "':='", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NOT", "AND", "OR", "XOR", "PRINT", "ID", "INT", "WS", "LPAR", 
			"RPAR", "ASSIGN", "COL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "syntax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public syntaxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(syntaxParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PRINT || _la==ID) {
				{
				{
				setState(10);
				line();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				print();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogExprContext extends ParserRuleContext {
		public LogExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logExpr; }
	 
		public LogExprContext() { }
		public void copyFrom(LogExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrXorOpContext extends LogExprContext {
		public Token oper;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(syntaxParser.OR, 0); }
		public TerminalNode XOR() { return getToken(syntaxParser.XOR, 0); }
		public OrXorOpContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterOrXorOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitOrXorOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitOrXorOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends LogExprContext {
		public TerminalNode LPAR() { return getToken(syntaxParser.LPAR, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(syntaxParser.RPAR, 0); }
		public ParensContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOpContext extends LogExprContext {
		public Token oper;
		public List<LogExprContext> logExpr() {
			return getRuleContexts(LogExprContext.class);
		}
		public LogExprContext logExpr(int i) {
			return getRuleContext(LogExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(syntaxParser.AND, 0); }
		public AndOpContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterAndOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitAndOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitAndOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotOpContext extends LogExprContext {
		public Token oper;
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(syntaxParser.NOT, 0); }
		public NotOpContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterNotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitNotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitNotOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentContext extends LogExprContext {
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public IdentContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends LogExprContext {
		public TerminalNode INT() { return getToken(syntaxParser.INT, 0); }
		public IntegerContext(LogExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogExprContext logExpr() throws RecognitionException {
		return logExpr(0);
	}

	private LogExprContext logExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogExprContext _localctx = new LogExprContext(_ctx, _parentState);
		LogExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_logExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23);
				match(LPAR);
				setState(24);
				logExpr(0);
				setState(25);
				match(RPAR);
				}
				break;
			case NOT:
				{
				_localctx = new NotOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				((NotOpContext)_localctx).oper = match(NOT);
				setState(28);
				logExpr(5);
				}
				break;
			case ID:
				{
				_localctx = new IdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29);
				match(ID);
				}
				break;
			case INT:
				{
				_localctx = new IntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(39);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new AndOpContext(new LogExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(33);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(34);
						((AndOpContext)_localctx).oper = match(AND);
						setState(35);
						logExpr(5);
						}
						break;
					case 2:
						{
						_localctx = new OrXorOpContext(new LogExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logExpr);
						setState(36);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(37);
						((OrXorOpContext)_localctx).oper = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==OR || _la==XOR) ) {
							((OrXorOpContext)_localctx).oper = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(38);
						logExpr(4);
						}
						break;
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
	 
		public PrintContext() { }
		public void copyFrom(PrintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintIdContext extends PrintContext {
		public TerminalNode PRINT() { return getToken(syntaxParser.PRINT, 0); }
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public PrintIdContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterPrintId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitPrintId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitPrintId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExprContext extends PrintContext {
		public TerminalNode PRINT() { return getToken(syntaxParser.PRINT, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public PrintExprContext(PrintContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_print);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new PrintIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(PRINT);
				setState(45);
				match(ID);
				setState(46);
				match(COL);
				}
				break;
			case 2:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(PRINT);
				setState(48);
				logExpr(0);
				setState(49);
				match(COL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	 
		public AssignContext() { }
		public void copyFrom(AssignContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignExprContext extends AssignContext {
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(syntaxParser.ASSIGN, 0); }
		public LogExprContext logExpr() {
			return getRuleContext(LogExprContext.class,0);
		}
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public AssignExprContext(AssignContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof syntaxListener ) ((syntaxListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof syntaxVisitor ) return ((syntaxVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			_localctx = new AssignExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(ID);
			setState(54);
			match(ASSIGN);
			setState(55);
			logExpr(0);
			setState(56);
			match(COL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return logExpr_sempred((LogExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logExpr_sempred(LogExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3\3"+
		"\3\3\5\3\27\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\"\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\66\n\5\3\6\3\6\3\6\3\6\3\6\3\6\2\3\6\7\2\4\6\b\n\2\3\3\2\5\6\2?\2\17"+
		"\3\2\2\2\4\26\3\2\2\2\6!\3\2\2\2\b\65\3\2\2\2\n\67\3\2\2\2\f\16\5\4\3"+
		"\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\22\3\2\2\2"+
		"\21\17\3\2\2\2\22\23\7\2\2\3\23\3\3\2\2\2\24\27\5\b\5\2\25\27\5\n\6\2"+
		"\26\24\3\2\2\2\26\25\3\2\2\2\27\5\3\2\2\2\30\31\b\4\1\2\31\32\7\13\2\2"+
		"\32\33\5\6\4\2\33\34\7\f\2\2\34\"\3\2\2\2\35\36\7\3\2\2\36\"\5\6\4\7\37"+
		"\"\7\b\2\2 \"\7\t\2\2!\30\3\2\2\2!\35\3\2\2\2!\37\3\2\2\2! \3\2\2\2\""+
		"+\3\2\2\2#$\f\6\2\2$%\7\4\2\2%*\5\6\4\7&\'\f\5\2\2\'(\t\2\2\2(*\5\6\4"+
		"\6)#\3\2\2\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-+\3\2"+
		"\2\2./\7\7\2\2/\60\7\b\2\2\60\66\7\16\2\2\61\62\7\7\2\2\62\63\5\6\4\2"+
		"\63\64\7\16\2\2\64\66\3\2\2\2\65.\3\2\2\2\65\61\3\2\2\2\66\t\3\2\2\2\67"+
		"8\7\b\2\289\7\r\2\29:\5\6\4\2:;\7\16\2\2;\13\3\2\2\2\b\17\26!)+\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}