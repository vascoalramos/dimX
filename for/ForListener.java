// Generated from For.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ForParser}.
 */
public interface ForListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ForParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ForParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ForParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ForParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(ForParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(ForParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ForParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterFor_init(ForParser.For_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitFor_init(ForParser.For_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link ForParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ForParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ForParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ForParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ForParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ForParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ForParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterFor_update(ForParser.For_updateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ForParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitFor_update(ForParser.For_updateContext ctx);
}