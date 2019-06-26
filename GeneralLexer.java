// Generated from General.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GeneralLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, STRING=15, BOOLEAN=16, 
		TERM=17, SCF_NOTATION=18, ID=19, INT=20, FLOAT=21, SINGLE_LINE_COMMENT=22, 
		MULTI_LINE_COMMENT=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "STRING", "BOOLEAN", "TERM", 
			"SCF_NOTATION", "ID", "LETTER", "INT", "FLOAT", "DIGIT", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "'print'", "':'", 
			"'int'", "'real'", "'['", "']'", "'prefix'", null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "STRING", "BOOLEAN", "TERM", "SCF_NOTATION", "ID", 
			"INT", "FLOAT", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "WS"
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


	public GeneralLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "General.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00c7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\7\20d\n\20\f\20\16\20g\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\5\21t\n\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\7\23}\n\23\f\23\16\23\u0080\13\23\3\24\3\24\3\24\7\24\u0085\n\24\f\24"+
		"\16\24\u0088\13\24\3\25\3\25\3\26\6\26\u008d\n\26\r\26\16\26\u008e\3\27"+
		"\6\27\u0092\n\27\r\27\16\27\u0093\3\27\3\27\6\27\u0098\n\27\r\27\16\27"+
		"\u0099\3\27\3\27\6\27\u009e\n\27\r\27\16\27\u009f\5\27\u00a2\n\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\7\31\u00aa\n\31\f\31\16\31\u00ad\13\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00b7\n\32\f\32\16\32\u00ba\13"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\6\33\u00c2\n\33\r\33\16\33\u00c3\3\33"+
		"\3\33\5e\u00ab\u00b8\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\26-\27/\2\61\30\63"+
		"\31\65\32\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\"\"\2\u00d1\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA"+
		"\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27Q\3\2\2\2\31"+
		"V\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37a\3\2\2\2!s\3\2\2\2#u\3\2\2\2%w\3"+
		"\2\2\2\'\u0081\3\2\2\2)\u0089\3\2\2\2+\u008c\3\2\2\2-\u00a1\3\2\2\2/\u00a3"+
		"\3\2\2\2\61\u00a5\3\2\2\2\63\u00b2\3\2\2\2\65\u00c1\3\2\2\2\678\7?\2\2"+
		"8\4\3\2\2\29:\7,\2\2:\6\3\2\2\2;<\7\61\2\2<\b\3\2\2\2=>\7-\2\2>\n\3\2"+
		"\2\2?@\7/\2\2@\f\3\2\2\2AB\7*\2\2B\16\3\2\2\2CD\7+\2\2D\20\3\2\2\2EF\7"+
		"r\2\2FG\7t\2\2GH\7k\2\2HI\7p\2\2IJ\7v\2\2J\22\3\2\2\2KL\7<\2\2L\24\3\2"+
		"\2\2MN\7k\2\2NO\7p\2\2OP\7v\2\2P\26\3\2\2\2QR\7t\2\2RS\7g\2\2ST\7c\2\2"+
		"TU\7n\2\2U\30\3\2\2\2VW\7]\2\2W\32\3\2\2\2XY\7_\2\2Y\34\3\2\2\2Z[\7r\2"+
		"\2[\\\7t\2\2\\]\7g\2\2]^\7h\2\2^_\7k\2\2_`\7z\2\2`\36\3\2\2\2ae\7$\2\2"+
		"bd\13\2\2\2cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2\2"+
		"\2hi\7$\2\2i \3\2\2\2jk\7v\2\2kl\7t\2\2lm\7w\2\2mt\7g\2\2no\7h\2\2op\7"+
		"c\2\2pq\7n\2\2qr\7u\2\2rt\7g\2\2sj\3\2\2\2sn\3\2\2\2t\"\3\2\2\2uv\7=\2"+
		"\2v$\3\2\2\2wx\7\63\2\2xy\7\62\2\2yz\7`\2\2z~\3\2\2\2{}\t\2\2\2|{\3\2"+
		"\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177&\3\2\2\2\u0080~\3\2\2\2"+
		"\u0081\u0086\5)\25\2\u0082\u0085\5)\25\2\u0083\u0085\5/\30\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087(\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\t\3\2\2"+
		"\u008a*\3\2\2\2\u008b\u008d\5/\30\2\u008c\u008b\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f,\3\2\2\2\u0090\u0092"+
		"\5/\30\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\7\60\2\2\u0096\u0098\5"+
		"/\30\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u00a2\3\2\2\2\u009b\u009d\7\60\2\2\u009c\u009e\5"+
		"/\30\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u0091\3\2\2\2\u00a1\u009b\3\2"+
		"\2\2\u00a2.\3\2\2\2\u00a3\u00a4\t\2\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7"+
		"\61\2\2\u00a6\u00a7\7\61\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00aa\13\2\2\2"+
		"\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\f\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\b\31\2\2\u00b1\62\3\2\2\2\u00b2\u00b3\7\61"+
		"\2\2\u00b3\u00b4\7,\2\2\u00b4\u00b8\3\2\2\2\u00b5\u00b7\13\2\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b8\u00b6\3\2"+
		"\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc"+
		"\u00bd\7\61\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\32\2\2\u00bf\64\3\2"+
		"\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\b\33"+
		"\2\2\u00c6\66\3\2\2\2\20\2es~\u0084\u0086\u008e\u0093\u0099\u009f\u00a1"+
		"\u00ab\u00b8\u00c3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}