// Generated from /home/tiagocm/Documents/Code/GitHub/compiladores-1819-g06/Cycles/if/If.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IfLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ASSIGN=5, COLON=6, SCOL=7, OPAR=8, CPAR=9, 
		OBRACE=10, CBRACE=11, POW=12, MULT=13, DIV=14, MOD=15, PLUS=16, MINUS=17, 
		OR=18, AND=19, EQ=20, NEQ=21, GT=22, LT=23, GTEQ=24, LTEQ=25, NOT=26, 
		TRUE=27, FALSE=28, IF=29, ELSE=30, STRING=31, FLOAT=32, INT=33, ID=34, 
		ESC=35, LINE_COMMENT=36, COMMENT=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ASSIGN", "COLON", "SCOL", "OPAR", "CPAR", 
			"OBRACE", "CBRACE", "POW", "MULT", "DIV", "MOD", "PLUS", "MINUS", "OR", 
			"AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", 
			"IF", "ELSE", "STRING", "FLOAT", "INT", "ID", "ESC", "LINE_COMMENT", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'real'", "'int'", "'['", "']'", "'='", "':'", "';'", "'('", "')'", 
			"'{'", "'}'", "'^'", "'*'", "'/'", "'%'", "'+'", "'-'", "'||'", "'&&'", 
			"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'!'", "'true'", "'false'", 
			"'if'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ASSIGN", "COLON", "SCOL", "OPAR", "CPAR", 
			"OBRACE", "CBRACE", "POW", "MULT", "DIV", "MOD", "PLUS", "MINUS", "OR", 
			"AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", 
			"IF", "ELSE", "STRING", "FLOAT", "INT", "ID", "ESC", "LINE_COMMENT", 
			"COMMENT", "WS"
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


	public IfLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "If.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u00f3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \7 \u00a5\n \f \16 \u00a8\13 \3 \3 \3!\7!\u00ad\n!\f!\16"+
		"!\u00b0\13!\3!\3!\7!\u00b4\n!\f!\16!\u00b7\13!\3!\3!\7!\u00bb\n!\f!\16"+
		"!\u00be\13!\5!\u00c0\n!\3\"\6\"\u00c3\n\"\r\"\16\"\u00c4\3#\6#\u00c8\n"+
		"#\r#\16#\u00c9\3$\3$\3$\3$\5$\u00d0\n$\3%\3%\3%\3%\7%\u00d6\n%\f%\16%"+
		"\u00d9\13%\3%\3%\3%\3%\3&\3&\3&\3&\7&\u00e3\n&\f&\16&\u00e6\13&\3&\3&"+
		"\3&\3&\3&\3\'\6\'\u00ee\n\'\r\'\16\'\u00ef\3\'\3\'\5\u00a6\u00d7\u00e4"+
		"\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(\3\2\5\3\2\62;\5\2C\\aac|\5\2\13\f\17\17\"\"\2"+
		"\u00fe\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5T\3\2\2\2\7X\3"+
		"\2\2\2\tZ\3\2\2\2\13\\\3\2\2\2\r^\3\2\2\2\17`\3\2\2\2\21b\3\2\2\2\23d"+
		"\3\2\2\2\25f\3\2\2\2\27h\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35n\3\2\2\2\37"+
		"p\3\2\2\2!r\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'y\3\2\2\2)|\3\2\2\2+\177\3\2"+
		"\2\2-\u0082\3\2\2\2/\u0084\3\2\2\2\61\u0086\3\2\2\2\63\u0089\3\2\2\2\65"+
		"\u008c\3\2\2\2\67\u008e\3\2\2\29\u0093\3\2\2\2;\u0099\3\2\2\2=\u009c\3"+
		"\2\2\2?\u00a1\3\2\2\2A\u00bf\3\2\2\2C\u00c2\3\2\2\2E\u00c7\3\2\2\2G\u00cf"+
		"\3\2\2\2I\u00d1\3\2\2\2K\u00de\3\2\2\2M\u00ed\3\2\2\2OP\7t\2\2PQ\7g\2"+
		"\2QR\7c\2\2RS\7n\2\2S\4\3\2\2\2TU\7k\2\2UV\7p\2\2VW\7v\2\2W\6\3\2\2\2"+
		"XY\7]\2\2Y\b\3\2\2\2Z[\7_\2\2[\n\3\2\2\2\\]\7?\2\2]\f\3\2\2\2^_\7<\2\2"+
		"_\16\3\2\2\2`a\7=\2\2a\20\3\2\2\2bc\7*\2\2c\22\3\2\2\2de\7+\2\2e\24\3"+
		"\2\2\2fg\7}\2\2g\26\3\2\2\2hi\7\177\2\2i\30\3\2\2\2jk\7`\2\2k\32\3\2\2"+
		"\2lm\7,\2\2m\34\3\2\2\2no\7\61\2\2o\36\3\2\2\2pq\7\'\2\2q \3\2\2\2rs\7"+
		"-\2\2s\"\3\2\2\2tu\7/\2\2u$\3\2\2\2vw\7~\2\2wx\7~\2\2x&\3\2\2\2yz\7(\2"+
		"\2z{\7(\2\2{(\3\2\2\2|}\7?\2\2}~\7?\2\2~*\3\2\2\2\177\u0080\7#\2\2\u0080"+
		"\u0081\7?\2\2\u0081,\3\2\2\2\u0082\u0083\7@\2\2\u0083.\3\2\2\2\u0084\u0085"+
		"\7>\2\2\u0085\60\3\2\2\2\u0086\u0087\7@\2\2\u0087\u0088\7?\2\2\u0088\62"+
		"\3\2\2\2\u0089\u008a\7>\2\2\u008a\u008b\7?\2\2\u008b\64\3\2\2\2\u008c"+
		"\u008d\7#\2\2\u008d\66\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7t\2\2\u0090"+
		"\u0091\7w\2\2\u0091\u0092\7g\2\2\u00928\3\2\2\2\u0093\u0094\7h\2\2\u0094"+
		"\u0095\7c\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2"+
		"\u0098:\3\2\2\2\u0099\u009a\7k\2\2\u009a\u009b\7h\2\2\u009b<\3\2\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7n\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7g\2\2"+
		"\u00a0>\3\2\2\2\u00a1\u00a6\7$\2\2\u00a2\u00a5\5G$\2\u00a3\u00a5\13\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a9\u00aa\7$\2\2\u00aa@\3\2\2\2\u00ab\u00ad\5C\"\2\u00ac\u00ab"+
		"\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b5\7\60\2\2\u00b2\u00b4\5"+
		"C\"\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00c0\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00bc\7\60"+
		"\2\2\u00b9\u00bb\5C\"\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00ae\3\2\2\2\u00bf\u00b8\3\2\2\2\u00c0B\3\2\2\2\u00c1\u00c3"+
		"\t\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5D\3\2\2\2\u00c6\u00c8\t\3\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00caF\3"+
		"\2\2\2\u00cb\u00cc\7^\2\2\u00cc\u00d0\7$\2\2\u00cd\u00ce\7^\2\2\u00ce"+
		"\u00d0\7^\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0H\3\2\2\2\u00d1"+
		"\u00d2\7\61\2\2\u00d2\u00d3\7\61\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d6\13"+
		"\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\f"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b%\2\2\u00ddJ\3\2\2\2\u00de\u00df"+
		"\7\61\2\2\u00df\u00e0\7,\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00e3\13\2\2\2"+
		"\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b&\2\2\u00ebL\3\2\2\2"+
		"\u00ec\u00ee\t\4\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\'\2\2\u00f2"+
		"N\3\2\2\2\17\2\u00a4\u00a6\u00ae\u00b5\u00bc\u00bf\u00c4\u00c9\u00cf\u00d7"+
		"\u00e4\u00ef\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}