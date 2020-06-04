// Generated from d:\Документы\Задания от ВУЗа\3 курс\1 семестр\ТАиФЯ\assembler-emulator-antlr\syntax.g4 by ANTLR 4.7.1
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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MOV=5, ADD=6, CMP=7, DEC=8, JE=9, JMP=10, 
		JG=11, PRT=12, RET=13, ID=14, INT=15, WS=16, COL=17;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_block = 2, RULE_line = 3, RULE_lab = 4, 
		RULE_mov = 5, RULE_add = 6, RULE_cmp = 7, RULE_dec = 8, RULE_je = 9, RULE_jmp = 10, 
		RULE_jg = 11, RULE_prt = 12, RULE_ret = 13;
	public static final String[] ruleNames = {
		"prog", "stat", "block", "line", "lab", "mov", "add", "cmp", "dec", "je", 
		"jmp", "jg", "prt", "ret"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','", "'['", "']'", null, null, null, null, null, null, 
		null, null, null, null, null, null, "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "MOV", "ADD", "CMP", "DEC", "JE", "JMP", 
		"JG", "PRT", "RET", "ID", "INT", "WS", "COL"
	};
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
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(syntaxParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				stat();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MOV) | (1L << ADD) | (1L << CMP) | (1L << DEC) | (1L << JE) | (1L << JMP) | (1L << JG) | (1L << PRT) | (1L << RET) | (1L << ID))) != 0) );
			setState(33);
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

	public static class StatContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LabContext lab() {
			return getRuleContext(LabContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MOV:
			case ADD:
			case CMP:
			case DEC:
			case JE:
			case JMP:
			case JG:
			case PRT:
			case RET:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				block();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(36);
				lab();
				setState(37);
				block();
				}
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

	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(41);
					line();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(44); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public MovContext mov() {
			return getRuleContext(MovContext.class,0);
		}
		public CmpContext cmp() {
			return getRuleContext(CmpContext.class,0);
		}
		public AddContext add() {
			return getRuleContext(AddContext.class,0);
		}
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public JeContext je() {
			return getRuleContext(JeContext.class,0);
		}
		public JmpContext jmp() {
			return getRuleContext(JmpContext.class,0);
		}
		public JgContext jg() {
			return getRuleContext(JgContext.class,0);
		}
		public PrtContext prt() {
			return getRuleContext(PrtContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_line);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MOV:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				mov();
				}
				break;
			case CMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				cmp();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				add();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				dec();
				}
				break;
			case JE:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				je();
				}
				break;
			case JMP:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				jmp();
				}
				break;
			case JG:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				jg();
				}
				break;
			case PRT:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				prt();
				}
				break;
			case RET:
				enterOuterAlt(_localctx, 9);
				{
				setState(54);
				ret();
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

	public static class LabContext extends ParserRuleContext {
		public Token labelName;
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public LabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lab; }
	}

	public final LabContext lab() throws RecognitionException {
		LabContext _localctx = new LabContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lab);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((LabContext)_localctx).labelName = match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(58);
				match(T__0);
				}
			}

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

	public static class MovContext extends ParserRuleContext {
		public Token toId;
		public Token fromId;
		public Token fromInt;
		public Token fromIdAddress;
		public Token fromIntAddress;
		public Token toIdAddress;
		public TerminalNode MOV() { return getToken(syntaxParser.MOV, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(syntaxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(syntaxParser.ID, i);
		}
		public TerminalNode INT() { return getToken(syntaxParser.INT, 0); }
		public MovContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mov; }
	}

	public final MovContext mov() throws RecognitionException {
		MovContext _localctx = new MovContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mov);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(MOV);
				setState(62);
				((MovContext)_localctx).toId = match(ID);
				setState(63);
				match(T__1);
				setState(64);
				((MovContext)_localctx).fromId = match(ID);
				setState(65);
				match(COL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(MOV);
				setState(67);
				((MovContext)_localctx).toId = match(ID);
				setState(68);
				match(T__1);
				setState(69);
				((MovContext)_localctx).fromInt = match(INT);
				setState(70);
				match(COL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(MOV);
				setState(72);
				((MovContext)_localctx).toId = match(ID);
				setState(73);
				match(T__1);
				setState(74);
				match(T__2);
				setState(75);
				((MovContext)_localctx).fromIdAddress = match(ID);
				setState(76);
				match(T__3);
				setState(77);
				match(COL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(MOV);
				setState(79);
				((MovContext)_localctx).toId = match(ID);
				setState(80);
				match(T__1);
				setState(81);
				match(T__2);
				setState(82);
				((MovContext)_localctx).fromIntAddress = match(INT);
				setState(83);
				match(T__3);
				setState(84);
				match(COL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				match(MOV);
				setState(86);
				match(T__2);
				setState(87);
				((MovContext)_localctx).toIdAddress = match(ID);
				setState(88);
				match(T__3);
				setState(89);
				match(T__1);
				setState(90);
				((MovContext)_localctx).fromId = match(ID);
				setState(91);
				match(COL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				match(MOV);
				setState(93);
				match(T__2);
				setState(94);
				((MovContext)_localctx).toIdAddress = match(ID);
				setState(95);
				match(T__3);
				setState(96);
				match(T__1);
				setState(97);
				((MovContext)_localctx).fromInt = match(INT);
				setState(98);
				match(COL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
				match(MOV);
				setState(100);
				match(T__2);
				setState(101);
				((MovContext)_localctx).toIdAddress = match(ID);
				setState(102);
				match(T__3);
				setState(103);
				match(T__1);
				setState(104);
				match(T__2);
				setState(105);
				((MovContext)_localctx).fromIdAddress = match(ID);
				setState(106);
				match(T__3);
				setState(107);
				match(COL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(108);
				match(MOV);
				setState(109);
				match(T__2);
				setState(110);
				((MovContext)_localctx).toIdAddress = match(ID);
				setState(111);
				match(T__3);
				setState(112);
				match(T__1);
				setState(113);
				match(T__2);
				setState(114);
				((MovContext)_localctx).fromIntAddress = match(INT);
				setState(115);
				match(T__3);
				setState(116);
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

	public static class AddContext extends ParserRuleContext {
		public Token toId;
		public Token fromId;
		public Token fromInt;
		public Token fromIdAddress;
		public Token fromIntAddress;
		public Token toIdAddress;
		public TerminalNode ADD() { return getToken(syntaxParser.ADD, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(syntaxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(syntaxParser.ID, i);
		}
		public TerminalNode INT() { return getToken(syntaxParser.INT, 0); }
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_add);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(ADD);
				setState(120);
				((AddContext)_localctx).toId = match(ID);
				setState(121);
				match(T__1);
				setState(122);
				((AddContext)_localctx).fromId = match(ID);
				setState(123);
				match(COL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(ADD);
				setState(125);
				((AddContext)_localctx).toId = match(ID);
				setState(126);
				match(T__1);
				setState(127);
				((AddContext)_localctx).fromInt = match(INT);
				setState(128);
				match(COL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(ADD);
				setState(130);
				((AddContext)_localctx).toId = match(ID);
				setState(131);
				match(T__1);
				setState(132);
				match(T__2);
				setState(133);
				((AddContext)_localctx).fromIdAddress = match(ID);
				setState(134);
				match(T__3);
				setState(135);
				match(COL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				match(ADD);
				setState(137);
				((AddContext)_localctx).toId = match(ID);
				setState(138);
				match(T__1);
				setState(139);
				match(T__2);
				setState(140);
				((AddContext)_localctx).fromIntAddress = match(INT);
				setState(141);
				match(T__3);
				setState(142);
				match(COL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				match(ADD);
				setState(144);
				match(T__2);
				setState(145);
				((AddContext)_localctx).toIdAddress = match(ID);
				setState(146);
				match(T__3);
				setState(147);
				match(T__1);
				setState(148);
				((AddContext)_localctx).fromId = match(ID);
				setState(149);
				match(COL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(150);
				match(ADD);
				setState(151);
				match(T__2);
				setState(152);
				((AddContext)_localctx).toIdAddress = match(ID);
				setState(153);
				match(T__3);
				setState(154);
				match(T__1);
				setState(155);
				((AddContext)_localctx).fromInt = match(INT);
				setState(156);
				match(COL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(157);
				match(ADD);
				setState(158);
				match(T__2);
				setState(159);
				((AddContext)_localctx).toIdAddress = match(ID);
				setState(160);
				match(T__3);
				setState(161);
				match(T__1);
				setState(162);
				match(T__2);
				setState(163);
				((AddContext)_localctx).fromIdAddress = match(ID);
				setState(164);
				match(T__3);
				setState(165);
				match(COL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				match(ADD);
				setState(167);
				match(T__2);
				setState(168);
				((AddContext)_localctx).toIdAddress = match(ID);
				setState(169);
				match(T__3);
				setState(170);
				match(T__1);
				setState(171);
				match(T__2);
				setState(172);
				((AddContext)_localctx).fromIntAddress = match(INT);
				setState(173);
				match(T__3);
				setState(174);
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

	public static class CmpContext extends ParserRuleContext {
		public Token a;
		public Token b;
		public Token addressA;
		public Token addressB;
		public TerminalNode CMP() { return getToken(syntaxParser.CMP, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public List<TerminalNode> ID() { return getTokens(syntaxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(syntaxParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(syntaxParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(syntaxParser.INT, i);
		}
		public CmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmp; }
	}

	public final CmpContext cmp() throws RecognitionException {
		CmpContext _localctx = new CmpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmp);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(CMP);
				setState(178);
				((CmpContext)_localctx).a = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).a = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(179);
				match(T__1);
				setState(180);
				((CmpContext)_localctx).b = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).b = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(181);
				match(COL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(CMP);
				setState(183);
				match(T__2);
				setState(184);
				((CmpContext)_localctx).addressA = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).addressA = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(185);
				match(T__3);
				setState(186);
				match(T__1);
				setState(187);
				((CmpContext)_localctx).b = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).b = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(188);
				match(COL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				match(CMP);
				setState(190);
				((CmpContext)_localctx).a = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).a = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(191);
				match(T__1);
				setState(192);
				match(T__2);
				setState(193);
				((CmpContext)_localctx).addressB = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).addressB = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				match(T__3);
				setState(195);
				match(COL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				match(CMP);
				setState(197);
				match(T__2);
				setState(198);
				((CmpContext)_localctx).addressA = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).addressA = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(199);
				match(T__3);
				setState(200);
				match(T__1);
				setState(201);
				match(T__2);
				setState(202);
				((CmpContext)_localctx).addressB = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
					((CmpContext)_localctx).addressB = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				match(T__3);
				setState(204);
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

	public static class DecContext extends ParserRuleContext {
		public Token var;
		public TerminalNode DEC() { return getToken(syntaxParser.DEC, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(DEC);
			setState(208);
			((DecContext)_localctx).var = match(ID);
			setState(209);
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

	public static class JeContext extends ParserRuleContext {
		public LabContext labelName;
		public TerminalNode JE() { return getToken(syntaxParser.JE, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public LabContext lab() {
			return getRuleContext(LabContext.class,0);
		}
		public JeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_je; }
	}

	public final JeContext je() throws RecognitionException {
		JeContext _localctx = new JeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_je);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(JE);
			setState(212);
			((JeContext)_localctx).labelName = lab();
			setState(213);
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

	public static class JmpContext extends ParserRuleContext {
		public LabContext labelName;
		public TerminalNode JMP() { return getToken(syntaxParser.JMP, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public LabContext lab() {
			return getRuleContext(LabContext.class,0);
		}
		public JmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jmp; }
	}

	public final JmpContext jmp() throws RecognitionException {
		JmpContext _localctx = new JmpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(JMP);
			setState(216);
			((JmpContext)_localctx).labelName = lab();
			setState(217);
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

	public static class JgContext extends ParserRuleContext {
		public LabContext labelName;
		public TerminalNode JG() { return getToken(syntaxParser.JG, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public LabContext lab() {
			return getRuleContext(LabContext.class,0);
		}
		public JgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jg; }
	}

	public final JgContext jg() throws RecognitionException {
		JgContext _localctx = new JgContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_jg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(JG);
			setState(220);
			((JgContext)_localctx).labelName = lab();
			setState(221);
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

	public static class PrtContext extends ParserRuleContext {
		public Token a;
		public TerminalNode PRT() { return getToken(syntaxParser.PRT, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public TerminalNode ID() { return getToken(syntaxParser.ID, 0); }
		public TerminalNode INT() { return getToken(syntaxParser.INT, 0); }
		public PrtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prt; }
	}

	public final PrtContext prt() throws RecognitionException {
		PrtContext _localctx = new PrtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(PRT);
			setState(224);
			((PrtContext)_localctx).a = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
				((PrtContext)_localctx).a = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(225);
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

	public static class RetContext extends ParserRuleContext {
		public TerminalNode RET() { return getToken(syntaxParser.RET, 0); }
		public TerminalNode COL() { return getToken(syntaxParser.COL, 0); }
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(RET);
			setState(228);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\5\3*\n\3\3\4\6\4-\n\4\r\4\16\4.\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\5\6>\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7x\n\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\5\b\u00b2\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u00d0\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\2\3\3\2\20\21\2\u00f7\2\37\3\2\2\2\4)\3\2\2\2\6"+
		",\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\fw\3\2\2\2\16\u00b1\3\2\2\2\20\u00cf\3"+
		"\2\2\2\22\u00d1\3\2\2\2\24\u00d5\3\2\2\2\26\u00d9\3\2\2\2\30\u00dd\3\2"+
		"\2\2\32\u00e1\3\2\2\2\34\u00e5\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3\2"+
		"\2\2!\37\3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\7\2\2\3$\3\3\2\2\2%*\5\6\4\2"+
		"&\'\5\n\6\2\'(\5\6\4\2(*\3\2\2\2)%\3\2\2\2)&\3\2\2\2*\5\3\2\2\2+-\5\b"+
		"\5\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60:\5\f\7\2\61"+
		":\5\20\t\2\62:\5\16\b\2\63:\5\22\n\2\64:\5\24\13\2\65:\5\26\f\2\66:\5"+
		"\30\r\2\67:\5\32\16\28:\5\34\17\29\60\3\2\2\29\61\3\2\2\29\62\3\2\2\2"+
		"9\63\3\2\2\29\64\3\2\2\29\65\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2"+
		":\t\3\2\2\2;=\7\20\2\2<>\7\3\2\2=<\3\2\2\2=>\3\2\2\2>\13\3\2\2\2?@\7\7"+
		"\2\2@A\7\20\2\2AB\7\4\2\2BC\7\20\2\2Cx\7\23\2\2DE\7\7\2\2EF\7\20\2\2F"+
		"G\7\4\2\2GH\7\21\2\2Hx\7\23\2\2IJ\7\7\2\2JK\7\20\2\2KL\7\4\2\2LM\7\5\2"+
		"\2MN\7\20\2\2NO\7\6\2\2Ox\7\23\2\2PQ\7\7\2\2QR\7\20\2\2RS\7\4\2\2ST\7"+
		"\5\2\2TU\7\21\2\2UV\7\6\2\2Vx\7\23\2\2WX\7\7\2\2XY\7\5\2\2YZ\7\20\2\2"+
		"Z[\7\6\2\2[\\\7\4\2\2\\]\7\20\2\2]x\7\23\2\2^_\7\7\2\2_`\7\5\2\2`a\7\20"+
		"\2\2ab\7\6\2\2bc\7\4\2\2cd\7\21\2\2dx\7\23\2\2ef\7\7\2\2fg\7\5\2\2gh\7"+
		"\20\2\2hi\7\6\2\2ij\7\4\2\2jk\7\5\2\2kl\7\20\2\2lm\7\6\2\2mx\7\23\2\2"+
		"no\7\7\2\2op\7\5\2\2pq\7\20\2\2qr\7\6\2\2rs\7\4\2\2st\7\5\2\2tu\7\21\2"+
		"\2uv\7\6\2\2vx\7\23\2\2w?\3\2\2\2wD\3\2\2\2wI\3\2\2\2wP\3\2\2\2wW\3\2"+
		"\2\2w^\3\2\2\2we\3\2\2\2wn\3\2\2\2x\r\3\2\2\2yz\7\b\2\2z{\7\20\2\2{|\7"+
		"\4\2\2|}\7\20\2\2}\u00b2\7\23\2\2~\177\7\b\2\2\177\u0080\7\20\2\2\u0080"+
		"\u0081\7\4\2\2\u0081\u0082\7\21\2\2\u0082\u00b2\7\23\2\2\u0083\u0084\7"+
		"\b\2\2\u0084\u0085\7\20\2\2\u0085\u0086\7\4\2\2\u0086\u0087\7\5\2\2\u0087"+
		"\u0088\7\20\2\2\u0088\u0089\7\6\2\2\u0089\u00b2\7\23\2\2\u008a\u008b\7"+
		"\b\2\2\u008b\u008c\7\20\2\2\u008c\u008d\7\4\2\2\u008d\u008e\7\5\2\2\u008e"+
		"\u008f\7\21\2\2\u008f\u0090\7\6\2\2\u0090\u00b2\7\23\2\2\u0091\u0092\7"+
		"\b\2\2\u0092\u0093\7\5\2\2\u0093\u0094\7\20\2\2\u0094\u0095\7\6\2\2\u0095"+
		"\u0096\7\4\2\2\u0096\u0097\7\20\2\2\u0097\u00b2\7\23\2\2\u0098\u0099\7"+
		"\b\2\2\u0099\u009a\7\5\2\2\u009a\u009b\7\20\2\2\u009b\u009c\7\6\2\2\u009c"+
		"\u009d\7\4\2\2\u009d\u009e\7\21\2\2\u009e\u00b2\7\23\2\2\u009f\u00a0\7"+
		"\b\2\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\7\20\2\2\u00a2\u00a3\7\6\2\2\u00a3"+
		"\u00a4\7\4\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\7\20\2\2\u00a6\u00a7\7"+
		"\6\2\2\u00a7\u00b2\7\23\2\2\u00a8\u00a9\7\b\2\2\u00a9\u00aa\7\5\2\2\u00aa"+
		"\u00ab\7\20\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\7\4\2\2\u00ad\u00ae\7"+
		"\5\2\2\u00ae\u00af\7\21\2\2\u00af\u00b0\7\6\2\2\u00b0\u00b2\7\23\2\2\u00b1"+
		"y\3\2\2\2\u00b1~\3\2\2\2\u00b1\u0083\3\2\2\2\u00b1\u008a\3\2\2\2\u00b1"+
		"\u0091\3\2\2\2\u00b1\u0098\3\2\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a8\3\2"+
		"\2\2\u00b2\17\3\2\2\2\u00b3\u00b4\7\t\2\2\u00b4\u00b5\t\2\2\2\u00b5\u00b6"+
		"\7\4\2\2\u00b6\u00b7\t\2\2\2\u00b7\u00d0\7\23\2\2\u00b8\u00b9\7\t\2\2"+
		"\u00b9\u00ba\7\5\2\2\u00ba\u00bb\t\2\2\2\u00bb\u00bc\7\6\2\2\u00bc\u00bd"+
		"\7\4\2\2\u00bd\u00be\t\2\2\2\u00be\u00d0\7\23\2\2\u00bf\u00c0\7\t\2\2"+
		"\u00c0\u00c1\t\2\2\2\u00c1\u00c2\7\4\2\2\u00c2\u00c3\7\5\2\2\u00c3\u00c4"+
		"\t\2\2\2\u00c4\u00c5\7\6\2\2\u00c5\u00d0\7\23\2\2\u00c6\u00c7\7\t\2\2"+
		"\u00c7\u00c8\7\5\2\2\u00c8\u00c9\t\2\2\2\u00c9\u00ca\7\6\2\2\u00ca\u00cb"+
		"\7\4\2\2\u00cb\u00cc\7\5\2\2\u00cc\u00cd\t\2\2\2\u00cd\u00ce\7\6\2\2\u00ce"+
		"\u00d0\7\23\2\2\u00cf\u00b3\3\2\2\2\u00cf\u00b8\3\2\2\2\u00cf\u00bf\3"+
		"\2\2\2\u00cf\u00c6\3\2\2\2\u00d0\21\3\2\2\2\u00d1\u00d2\7\n\2\2\u00d2"+
		"\u00d3\7\20\2\2\u00d3\u00d4\7\23\2\2\u00d4\23\3\2\2\2\u00d5\u00d6\7\13"+
		"\2\2\u00d6\u00d7\5\n\6\2\u00d7\u00d8\7\23\2\2\u00d8\25\3\2\2\2\u00d9\u00da"+
		"\7\f\2\2\u00da\u00db\5\n\6\2\u00db\u00dc\7\23\2\2\u00dc\27\3\2\2\2\u00dd"+
		"\u00de\7\r\2\2\u00de\u00df\5\n\6\2\u00df\u00e0\7\23\2\2\u00e0\31\3\2\2"+
		"\2\u00e1\u00e2\7\16\2\2\u00e2\u00e3\t\2\2\2\u00e3\u00e4\7\23\2\2\u00e4"+
		"\33\3\2\2\2\u00e5\u00e6\7\17\2\2\u00e6\u00e7\7\23\2\2\u00e7\35\3\2\2\2"+
		"\n!).9=w\u00b1\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}