// Generated from d:\Документы\Задания от ВУЗа\3 курс\1 семестр\ТАиФЯ\assembler-emulator-antlr\syntax.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class syntaxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, MOV=5, ADD=6, CMP=7, DEC=8, JE=9, JMP=10, 
		JG=11, PRT=12, RET=13, ID=14, INT=15, WS=16, COL=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "MOV", "ADD", "CMP", "DEC", "JE", "JMP", 
		"JG", "PRT", "RET", "ID", "INT", "WS", "COL"
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


	public syntaxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "syntax.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23\u008e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\64\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7<\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bD\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\tL\n\t\3\n\3\n\3\n\3\n\5\nR\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13Z\n\13\3\f\3\f\3\f\3\f\5\f`\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rr\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16z\n\16\3\17\6\17}\n\17\r\17\16\17~\3\20\6\20\u0082"+
		"\n\20\r\20\16\20\u0083\3\21\6\21\u0087\n\21\r\21\16\21\u0088\3\21\3\21"+
		"\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17\""+
		"\"\2\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13\63\3\2\2"+
		"\2\r;\3\2\2\2\17C\3\2\2\2\21K\3\2\2\2\23Q\3\2\2\2\25Y\3\2\2\2\27_\3\2"+
		"\2\2\31q\3\2\2\2\33y\3\2\2\2\35|\3\2\2\2\37\u0081\3\2\2\2!\u0086\3\2\2"+
		"\2#\u008c\3\2\2\2%&\7<\2\2&\4\3\2\2\2\'(\7.\2\2(\6\3\2\2\2)*\7]\2\2*\b"+
		"\3\2\2\2+,\7_\2\2,\n\3\2\2\2-.\7O\2\2./\7Q\2\2/\64\7X\2\2\60\61\7o\2\2"+
		"\61\62\7q\2\2\62\64\7x\2\2\63-\3\2\2\2\63\60\3\2\2\2\64\f\3\2\2\2\65\66"+
		"\7C\2\2\66\67\7F\2\2\67<\7F\2\289\7c\2\29:\7f\2\2:<\7f\2\2;\65\3\2\2\2"+
		";8\3\2\2\2<\16\3\2\2\2=>\7E\2\2>?\7O\2\2?D\7R\2\2@A\7e\2\2AB\7o\2\2BD"+
		"\7r\2\2C=\3\2\2\2C@\3\2\2\2D\20\3\2\2\2EF\7F\2\2FG\7G\2\2GL\7E\2\2HI\7"+
		"f\2\2IJ\7g\2\2JL\7e\2\2KE\3\2\2\2KH\3\2\2\2L\22\3\2\2\2MN\7L\2\2NR\7G"+
		"\2\2OP\7l\2\2PR\7g\2\2QM\3\2\2\2QO\3\2\2\2R\24\3\2\2\2ST\7L\2\2TU\7O\2"+
		"\2UZ\7R\2\2VW\7l\2\2WX\7o\2\2XZ\7r\2\2YS\3\2\2\2YV\3\2\2\2Z\26\3\2\2\2"+
		"[\\\7L\2\2\\`\7I\2\2]^\7l\2\2^`\7i\2\2_[\3\2\2\2_]\3\2\2\2`\30\3\2\2\2"+
		"ab\7R\2\2bc\7T\2\2cd\7K\2\2de\7P\2\2er\7V\2\2fg\7r\2\2gh\7t\2\2hi\7k\2"+
		"\2ij\7p\2\2jr\7v\2\2kl\7R\2\2lm\7T\2\2mr\7V\2\2no\7r\2\2op\7t\2\2pr\7"+
		"v\2\2qa\3\2\2\2qf\3\2\2\2qk\3\2\2\2qn\3\2\2\2r\32\3\2\2\2st\7t\2\2tu\7"+
		"g\2\2uz\7v\2\2vw\7T\2\2wx\7G\2\2xz\7V\2\2ys\3\2\2\2yv\3\2\2\2z\34\3\2"+
		"\2\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\36\3\2\2"+
		"\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084 \3\2\2\2\u0085\u0087\t\4\2\2\u0086"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\21\2\2\u008b\"\3\2\2\2\u008c\u008d"+
		"\7=\2\2\u008d$\3\2\2\2\17\2\63;CKQY_qy~\u0083\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}