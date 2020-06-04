// Generated from d:\Документы\Задания от ВУЗа\3 курс\1 семестр\ТАиФЯ\practice-antlr\java\syntax.g4 by ANTLR 4.7.1
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
		NOT=1, AND=2, OR=3, XOR=4, PRINT=5, ID=6, INT=7, WS=8, LPAR=9, RPAR=10, 
		ASSIGN=11, COL=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NOT", "AND", "OR", "XOR", "PRINT", "ID", "INT", "WS", "LPAR", "RPAR", 
		"ASSIGN", "COL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'('", "')'", "':='", 
		"';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NOT", "AND", "OR", "XOR", "PRINT", "ID", "INT", "WS", "LPAR", "RPAR", 
		"ASSIGN", "COL"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16e\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\5\4\60\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\58\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6J\n\6\3\7\6\7M\n\7\r\7\16\7N\3\b\6\bR\n\b\r\b\16\bS\3\t\6\tW\n\t"+
		"\r\t\16\tX\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\2\2\16\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\5\4\2C\\c|\3\2"+
		"\62;\5\2\13\f\17\17\"\"\2n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3!\3\2\2\2\5)\3\2\2\2\7/\3\2\2\2"+
		"\t\67\3\2\2\2\13I\3\2\2\2\rL\3\2\2\2\17Q\3\2\2\2\21V\3\2\2\2\23\\\3\2"+
		"\2\2\25^\3\2\2\2\27`\3\2\2\2\31c\3\2\2\2\33\34\7p\2\2\34\35\7q\2\2\35"+
		"\"\7v\2\2\36\37\7P\2\2\37 \7Q\2\2 \"\7V\2\2!\33\3\2\2\2!\36\3\2\2\2\""+
		"\4\3\2\2\2#$\7c\2\2$%\7p\2\2%*\7f\2\2&\'\7C\2\2\'(\7P\2\2(*\7F\2\2)#\3"+
		"\2\2\2)&\3\2\2\2*\6\3\2\2\2+,\7q\2\2,\60\7t\2\2-.\7Q\2\2.\60\7T\2\2/+"+
		"\3\2\2\2/-\3\2\2\2\60\b\3\2\2\2\61\62\7z\2\2\62\63\7q\2\2\638\7t\2\2\64"+
		"\65\7Z\2\2\65\66\7Q\2\2\668\7T\2\2\67\61\3\2\2\2\67\64\3\2\2\28\n\3\2"+
		"\2\29:\7R\2\2:;\7T\2\2;<\7K\2\2<=\7P\2\2=J\7V\2\2>?\7r\2\2?@\7t\2\2@A"+
		"\7k\2\2AB\7p\2\2BJ\7v\2\2CD\7R\2\2DE\7T\2\2EJ\7V\2\2FG\7r\2\2GH\7t\2\2"+
		"HJ\7v\2\2I9\3\2\2\2I>\3\2\2\2IC\3\2\2\2IF\3\2\2\2J\f\3\2\2\2KM\t\2\2\2"+
		"LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\16\3\2\2\2PR\t\3\2\2QP\3\2\2"+
		"\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\20\3\2\2\2UW\t\4\2\2VU\3\2\2\2WX\3\2"+
		"\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\t\2\2[\22\3\2\2\2\\]\7*\2\2]\24"+
		"\3\2\2\2^_\7+\2\2_\26\3\2\2\2`a\7<\2\2ab\7?\2\2b\30\3\2\2\2cd\7=\2\2d"+
		"\32\3\2\2\2\13\2!)/\67INSX\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}