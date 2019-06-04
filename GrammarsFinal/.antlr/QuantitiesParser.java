// Generated from /home/tiagocm/Documents/Code/GitHub/compiladores-1819-g06/GrammarsFinal/Quantities.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuantitiesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, ID=9, 
		INT=10, FLOAT=11, SCF_NOTATION=12, WS=13;
	public static final int
		RULE_quantity = 0, RULE_prefix_declare = 1, RULE_type = 2, RULE_value = 3, 
		RULE_unit = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"quantity", "prefix_declare", "type", "value", "unit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'/'", "'*'", "'['", "']'", "'prefix '", "'real'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "ID", "INT", "FLOAT", 
			"SCF_NOTATION", "WS"
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
	public String getGrammarFileName() { return "Quantities.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuantitiesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class QuantityContext extends ParserRuleContext {
		public QuantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantity; }
	 
		public QuantityContext() { }
		public void copyFrom(QuantityContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Complx_quantity_declContext extends QuantityContext {
		public Token complex;
		public Token q1;
		public Token q2;
		public List<TerminalNode> ID() { return getTokens(QuantitiesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QuantitiesParser.ID, i);
		}
		public Complx_quantity_declContext(QuantityContext ctx) { copyFrom(ctx); }
	}
	public static class Quantity_declContext extends QuantityContext {
		public Token e1;
		public TypeContext e2;
		public TerminalNode ID() { return getToken(QuantitiesParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Quantity_declContext(QuantityContext ctx) { copyFrom(ctx); }
	}

	public final QuantityContext quantity() throws RecognitionException {
		QuantityContext _localctx = new QuantityContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_quantity);
		int _la;
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new Quantity_declContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				((Quantity_declContext)_localctx).e1 = match(ID);
				setState(11);
				match(T__0);
				setState(12);
				((Quantity_declContext)_localctx).e2 = type();
				}
				break;
			case 2:
				_localctx = new Complx_quantity_declContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(13);
				((Complx_quantity_declContext)_localctx).complex = match(ID);
				setState(14);
				match(T__0);
				setState(15);
				((Complx_quantity_declContext)_localctx).q1 = match(ID);
				setState(16);
				_la = _input.LA(1);
				if ( !(_la==T__1 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(17);
				((Complx_quantity_declContext)_localctx).q2 = match(ID);
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(18);
					match(T__3);
					setState(19);
					match(ID);
					setState(20);
					_la = _input.LA(1);
					if ( !(_la==T__1 || _la==T__2) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(21);
					match(ID);
					setState(22);
					match(T__4);
					}
				}

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

	public static class Prefix_declareContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuantitiesParser.ID, 0); }
		public TerminalNode INT() { return getToken(QuantitiesParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(QuantitiesParser.FLOAT, 0); }
		public TerminalNode SCF_NOTATION() { return getToken(QuantitiesParser.SCF_NOTATION, 0); }
		public Prefix_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_declare; }
	}

	public final Prefix_declareContext prefix_declare() throws RecognitionException {
		Prefix_declareContext _localctx = new Prefix_declareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prefix_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__5);
			setState(28);
			match(ID);
			setState(29);
			match(T__0);
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << SCF_NOTATION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class TypeContext extends ParserRuleContext {
		public ValueContext e3;
		public UnitContext e4;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((TypeContext)_localctx).e3 = value();
			setState(33);
			((TypeContext)_localctx).e4 = unit();
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class UnitContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QuantitiesParser.ID, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__3);
			setState(38);
			match(ID);
			setState(39);
			match(T__4);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\32\n\2\5\2\34\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\5\3\2\4\5\3\2\f\16\3\2\t\n\2(\2"+
		"\33\3\2\2\2\4\35\3\2\2\2\6\"\3\2\2\2\b%\3\2\2\2\n\'\3\2\2\2\f\r\7\13\2"+
		"\2\r\16\7\3\2\2\16\34\5\6\4\2\17\20\7\13\2\2\20\21\7\3\2\2\21\22\7\13"+
		"\2\2\22\23\t\2\2\2\23\31\7\13\2\2\24\25\7\6\2\2\25\26\7\13\2\2\26\27\t"+
		"\2\2\2\27\30\7\13\2\2\30\32\7\7\2\2\31\24\3\2\2\2\31\32\3\2\2\2\32\34"+
		"\3\2\2\2\33\f\3\2\2\2\33\17\3\2\2\2\34\3\3\2\2\2\35\36\7\b\2\2\36\37\7"+
		"\13\2\2\37 \7\3\2\2 !\t\3\2\2!\5\3\2\2\2\"#\5\b\5\2#$\5\n\6\2$\7\3\2\2"+
		"\2%&\t\4\2\2&\t\3\2\2\2\'(\7\6\2\2()\7\13\2\2)*\7\7\2\2*\13\3\2\2\2\4"+
		"\31\33";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}