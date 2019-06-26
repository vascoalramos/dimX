// Generated from Quantities.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuantitiesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		SCF_NOTATION=10, ID=11, INT=12, FLOAT=13, SINGLE_LINE_COMMENT=14, MULTI_LINE_COMMENT=15, 
		WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"SCF_NOTATION", "ID", "LETTER", "INT", "FLOAT", "DIGIT", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\n'", "':'", "'/'", "'*'", "'real'", "'int'", "'['", "']'", "'prefix'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "SCF_NOTATION", 
			"ID", "INT", "FLOAT", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "WS"
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


	public QuantitiesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Quantities.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\7\13I\n\13\f\13\16\13L\13\13\3\f\3\f\3\f\7\fQ\n\f\f\f\16"+
		"\fT\13\f\3\r\3\r\3\16\6\16Y\n\16\r\16\16\16Z\3\17\6\17^\n\17\r\17\16\17"+
		"_\3\17\3\17\6\17d\n\17\r\17\16\17e\3\17\3\17\6\17j\n\17\r\17\16\17k\5"+
		"\17n\n\17\3\20\3\20\3\21\3\21\3\21\3\21\7\21v\n\21\f\21\16\21y\13\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22\u0083\n\22\f\22\16\22\u0086"+
		"\13\22\3\22\3\22\3\22\3\22\3\22\3\23\6\23\u008e\n\23\r\23\16\23\u008f"+
		"\3\23\3\23\4w\u0084\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\2\33\16\35\17\37\2!\20#\21%\22\3\2\5\3\2\62;\5\2C\\aac|\5\2\13"+
		"\f\17\17\"\"\2\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r\64"+
		"\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25C\3\2\2\2\27M\3\2\2\2\31"+
		"U\3\2\2\2\33X\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!q\3\2\2\2#~\3\2\2\2%\u008d"+
		"\3\2\2\2\'(\7\f\2\2(\4\3\2\2\2)*\7<\2\2*\6\3\2\2\2+,\7\61\2\2,\b\3\2\2"+
		"\2-.\7,\2\2.\n\3\2\2\2/\60\7t\2\2\60\61\7g\2\2\61\62\7c\2\2\62\63\7n\2"+
		"\2\63\f\3\2\2\2\64\65\7k\2\2\65\66\7p\2\2\66\67\7v\2\2\67\16\3\2\2\28"+
		"9\7]\2\29\20\3\2\2\2:;\7_\2\2;\22\3\2\2\2<=\7r\2\2=>\7t\2\2>?\7g\2\2?"+
		"@\7h\2\2@A\7k\2\2AB\7z\2\2B\24\3\2\2\2CD\7\63\2\2DE\7\62\2\2EF\7`\2\2"+
		"FJ\3\2\2\2GI\t\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\26\3\2\2"+
		"\2LJ\3\2\2\2MR\5\31\r\2NQ\5\31\r\2OQ\5\37\20\2PN\3\2\2\2PO\3\2\2\2QT\3"+
		"\2\2\2RP\3\2\2\2RS\3\2\2\2S\30\3\2\2\2TR\3\2\2\2UV\t\3\2\2V\32\3\2\2\2"+
		"WY\5\37\20\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\34\3\2\2\2\\^\5"+
		"\37\20\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ac\7\60\2\2"+
		"bd\5\37\20\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fn\3\2\2\2gi\7\60"+
		"\2\2hj\5\37\20\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2m]\3"+
		"\2\2\2mg\3\2\2\2n\36\3\2\2\2op\t\2\2\2p \3\2\2\2qr\7\61\2\2rs\7\61\2\2"+
		"sw\3\2\2\2tv\13\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz\3\2\2"+
		"\2yw\3\2\2\2z{\7\f\2\2{|\3\2\2\2|}\b\21\2\2}\"\3\2\2\2~\177\7\61\2\2\177"+
		"\u0080\7,\2\2\u0080\u0084\3\2\2\2\u0081\u0083\13\2\2\2\u0082\u0081\3\2"+
		"\2\2\u0083\u0086\3\2\2\2\u0084\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7,\2\2\u0088\u0089\7\61"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\22\2\2\u008b$\3\2\2\2\u008c\u008e"+
		"\t\4\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\b\23\2\2\u0092&\3\2\2\2"+
		"\16\2JPRZ_ekmw\u0084\u008f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}