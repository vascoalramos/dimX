// Generated from /home/ds/Desktop/Compiladores/compiladores-1819-g06/Cycles/if/Mendes.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MendesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ASSIGN=5, COLON=6, SCOL=7, OPAR=8, CPAR=9, 
		OBRACE=10, CBRACE=11, POW=12, MULT=13, DIV=14, MOD=15, PLUS=16, MINUS=17, 
		OR=18, AND=19, EQ=20, NEQ=21, GT=22, LT=23, GTEQ=24, LTEQ=25, NOT=26, 
		TRUE=27, FALSE=28, IF=29, ELSE=30, STRING=31, FLOAT=32, INT=33, ID=34, 
		ESC=35, LINE_COMMENT=36, COMMENT=37, WS=38;
	public static final int
		RULE_main = 0, RULE_block = 1, RULE_stat = 2, RULE_quantity = 3, RULE_declaration = 4, 
		RULE_if_stat = 5, RULE_condition_block = 6, RULE_stat_block = 7, RULE_expr = 8, 
		RULE_atom = 9, RULE_type = 10, RULE_value = 11, RULE_unit = 12;
	public static final String[] ruleNames = {
		"main", "block", "stat", "quantity", "declaration", "if_stat", "condition_block", 
		"stat_block", "expr", "atom", "type", "value", "unit"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'real'", "'int'", "'['", "']'", "'='", "':'", "';'", "'('", "')'", 
		"'{'", "'}'", "'^'", "'*'", "'/'", "'%'", "'+'", "'-'", "'||'", "'&&'", 
		"'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'!'", "'true'", "'false'", 
		"'if'", "'else'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "ASSIGN", "COLON", "SCOL", "OPAR", "CPAR", 
		"OBRACE", "CBRACE", "POW", "MULT", "DIV", "MOD", "PLUS", "MINUS", "OR", 
		"AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "NOT", "TRUE", "FALSE", 
		"IF", "ELSE", "STRING", "FLOAT", "INT", "ID", "ESC", "LINE_COMMENT", "COMMENT", 
		"WS"
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
	public String getGrammarFileName() { return "Mendes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MendesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MendesParser.EOF, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			block();
			setState(27);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF || _la==ID) {
				{
				{
				setState(29);
				stat();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatContext extends ParserRuleContext {
		public QuantityContext quantity() {
			return getRuleContext(QuantityContext.class,0);
		}
		public TerminalNode SCOL() { return getToken(MendesParser.SCOL, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				quantity(0);
				setState(36);
				match(SCOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				declaration();
				setState(39);
				match(SCOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				if_stat();
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

	public static class QuantityContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MendesParser.ID, 0); }
		public TerminalNode COLON() { return getToken(MendesParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<QuantityContext> quantity() {
			return getRuleContexts(QuantityContext.class);
		}
		public QuantityContext quantity(int i) {
			return getRuleContext(QuantityContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MendesParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MendesParser.DIV, 0); }
		public QuantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantity; }
	}

	public final QuantityContext quantity() throws RecognitionException {
		return quantity(0);
	}

	private QuantityContext quantity(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QuantityContext _localctx = new QuantityContext(_ctx, _parentState);
		QuantityContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_quantity, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(45);
			match(ID);
			setState(46);
			match(COLON);
			setState(47);
			type();
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new QuantityContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_quantity);
					setState(49);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(50);
					_la = _input.LA(1);
					if ( !(_la==MULT || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(51);
					quantity(2);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class DeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(MendesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MendesParser.ID, i);
		}
		public TerminalNode ASSIGN() { return getToken(MendesParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(ID);
			setState(59);
			match(ASSIGN);
			setState(60);
			expr(0);
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

	public static class If_statContext extends ParserRuleContext {
		public List<TerminalNode> IF() { return getTokens(MendesParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(MendesParser.IF, i);
		}
		public List<Condition_blockContext> condition_block() {
			return getRuleContexts(Condition_blockContext.class);
		}
		public Condition_blockContext condition_block(int i) {
			return getRuleContext(Condition_blockContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(MendesParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(MendesParser.ELSE, i);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_stat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(IF);
			setState(63);
			condition_block();
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					match(ELSE);
					setState(65);
					match(IF);
					setState(66);
					condition_block();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(72);
				match(ELSE);
				setState(73);
				stat_block();
				}
				break;
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

	public static class Condition_blockContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Stat_blockContext stat_block() {
			return getRuleContext(Stat_blockContext.class,0);
		}
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition_block; }
	}

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			expr(0);
			setState(77);
			stat_block();
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

	public static class Stat_blockContext extends ParserRuleContext {
		public TerminalNode OBRACE() { return getToken(MendesParser.OBRACE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode CBRACE() { return getToken(MendesParser.CBRACE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_block; }
	}

	public final Stat_blockContext stat_block() throws RecognitionException {
		Stat_blockContext _localctx = new Stat_blockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stat_block);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(OBRACE);
				setState(80);
				block();
				setState(81);
				match(CBRACE);
				}
				break;
			case IF:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				stat();
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualOrNotEqualExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(MendesParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MendesParser.NEQ, 0); }
		public EqualOrNotEqualExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NegationExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(MendesParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegationExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryMinusExprContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(MendesParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IndivisibleExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public IndivisibleExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MultDivAndModExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MendesParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MendesParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MendesParser.MOD, 0); }
		public MultDivAndModExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PlusMinusExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MendesParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MendesParser.MINUS, 0); }
		public PlusMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class IntersectionExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MendesParser.AND, 0); }
		public IntersectionExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnionExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(MendesParser.OR, 0); }
		public UnionExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PowExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(MendesParser.POW, 0); }
		public PowExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(MendesParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(MendesParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(MendesParser.LT, 0); }
		public TerminalNode GT() { return getToken(MendesParser.GT, 0); }
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new UnaryMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(87);
				match(MINUS);
				setState(88);
				expr(9);
				}
				break;
			case NOT:
				{
				_localctx = new NegationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(NOT);
				setState(90);
				expr(8);
				}
				break;
			case OPAR:
			case TRUE:
			case FALSE:
			case STRING:
			case FLOAT:
			case INT:
			case ID:
				{
				_localctx = new IndivisibleExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(115);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(95);
						match(POW);
						setState(96);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new MultDivAndModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(98);
						((MultDivAndModExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((MultDivAndModExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new PlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(101);
						((PlusMinusExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusMinusExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GTEQ) | (1L << LTEQ))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new EqualOrNotEqualExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(107);
						((EqualOrNotEqualExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((EqualOrNotEqualExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new IntersectionExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(110);
						match(AND);
						setState(111);
						expr(4);
						}
						break;
					case 7:
						{
						_localctx = new UnionExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(113);
						match(OR);
						setState(114);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanAtomContext extends AtomContext {
		public TerminalNode TRUE() { return getToken(MendesParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MendesParser.FALSE, 0); }
		public BooleanAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class IdAtomContext extends AtomContext {
		public TerminalNode ID() { return getToken(MendesParser.ID, 0); }
		public IdAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class StringAtomContext extends AtomContext {
		public TerminalNode STRING() { return getToken(MendesParser.STRING, 0); }
		public StringAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class ParentesisExprContext extends AtomContext {
		public TerminalNode OPAR() { return getToken(MendesParser.OPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CPAR() { return getToken(MendesParser.CPAR, 0); }
		public ParentesisExprContext(AtomContext ctx) { copyFrom(ctx); }
	}
	public static class NumberAtomContext extends AtomContext {
		public TerminalNode INT() { return getToken(MendesParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MendesParser.FLOAT, 0); }
		public NumberAtomContext(AtomContext ctx) { copyFrom(ctx); }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atom);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAR:
				_localctx = new ParentesisExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(OPAR);
				setState(121);
				expr(0);
				setState(122);
				match(CPAR);
				}
				break;
			case FLOAT:
			case INT:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==FLOAT || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new BooleanAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case ID:
				_localctx = new IdAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(ID);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				match(STRING);
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

	public static class TypeContext extends ParserRuleContext {
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
		enterRule(_localctx, 20, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			value();
			setState(131);
			unit();
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
		enterRule(_localctx, 22, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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
		public TerminalNode ID() { return getToken(MendesParser.ID, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__2);
			setState(136);
			match(ID);
			setState(137);
			match(T__3);
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
		case 3:
			return quantity_sempred((QuantityContext)_localctx, predIndex);
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean quantity_sempred(QuantityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u008e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\7\3!\n\3\f\3\16\3$\13\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\67\n\5\f\5\16\5:\13\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7"+
		"F\n\7\f\7\16\7I\13\7\3\7\3\7\5\7M\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\5\tW\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n_\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nv\n\n\f\n"+
		"\16\ny\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0083\n\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\2\4\b\22\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\n\3\2\17\20\3\2\17\21\3\2\22\23\3\2\30\33\3\2\26"+
		"\27\3\2\"#\3\2\35\36\3\2\3\4\2\u0094\2\34\3\2\2\2\4\"\3\2\2\2\6,\3\2\2"+
		"\2\b.\3\2\2\2\n;\3\2\2\2\f@\3\2\2\2\16N\3\2\2\2\20V\3\2\2\2\22^\3\2\2"+
		"\2\24\u0082\3\2\2\2\26\u0084\3\2\2\2\30\u0087\3\2\2\2\32\u0089\3\2\2\2"+
		"\34\35\5\4\3\2\35\36\7\2\2\3\36\3\3\2\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3"+
		"\2\2\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$\"\3\2\2\2%&\5\b\5\2&\'\7\t\2"+
		"\2\'-\3\2\2\2()\5\n\6\2)*\7\t\2\2*-\3\2\2\2+-\5\f\7\2,%\3\2\2\2,(\3\2"+
		"\2\2,+\3\2\2\2-\7\3\2\2\2./\b\5\1\2/\60\7$\2\2\60\61\7\b\2\2\61\62\5\26"+
		"\f\2\628\3\2\2\2\63\64\f\3\2\2\64\65\t\2\2\2\65\67\5\b\5\4\66\63\3\2\2"+
		"\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\t\3\2\2\2:8\3\2\2\2;<\7$\2\2<=\7"+
		"$\2\2=>\7\7\2\2>?\5\22\n\2?\13\3\2\2\2@A\7\37\2\2AG\5\16\b\2BC\7 \2\2"+
		"CD\7\37\2\2DF\5\16\b\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HL\3\2\2"+
		"\2IG\3\2\2\2JK\7 \2\2KM\5\20\t\2LJ\3\2\2\2LM\3\2\2\2M\r\3\2\2\2NO\5\22"+
		"\n\2OP\5\20\t\2P\17\3\2\2\2QR\7\f\2\2RS\5\4\3\2ST\7\r\2\2TW\3\2\2\2UW"+
		"\5\6\4\2VQ\3\2\2\2VU\3\2\2\2W\21\3\2\2\2XY\b\n\1\2YZ\7\23\2\2Z_\5\22\n"+
		"\13[\\\7\34\2\2\\_\5\22\n\n]_\5\24\13\2^X\3\2\2\2^[\3\2\2\2^]\3\2\2\2"+
		"_w\3\2\2\2`a\f\f\2\2ab\7\16\2\2bv\5\22\n\rcd\f\t\2\2de\t\3\2\2ev\5\22"+
		"\n\nfg\f\b\2\2gh\t\4\2\2hv\5\22\n\tij\f\7\2\2jk\t\5\2\2kv\5\22\n\blm\f"+
		"\6\2\2mn\t\6\2\2nv\5\22\n\7op\f\5\2\2pq\7\25\2\2qv\5\22\n\6rs\f\4\2\2"+
		"st\7\24\2\2tv\5\22\n\5u`\3\2\2\2uc\3\2\2\2uf\3\2\2\2ui\3\2\2\2ul\3\2\2"+
		"\2uo\3\2\2\2ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\23\3\2\2\2yw\3\2"+
		"\2\2z{\7\n\2\2{|\5\22\n\2|}\7\13\2\2}\u0083\3\2\2\2~\u0083\t\7\2\2\177"+
		"\u0083\t\b\2\2\u0080\u0083\7$\2\2\u0081\u0083\7!\2\2\u0082z\3\2\2\2\u0082"+
		"~\3\2\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\25\3\2\2\2\u0084\u0085\5\30\r\2\u0085\u0086\5\32\16\2\u0086\27\3\2\2"+
		"\2\u0087\u0088\t\t\2\2\u0088\31\3\2\2\2\u0089\u008a\7\5\2\2\u008a\u008b"+
		"\7$\2\2\u008b\u008c\7\6\2\2\u008c\33\3\2\2\2\f\",8GLV^uw\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}