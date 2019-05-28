// Generated from General.g4 by ANTLR 4.7.2

        import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GeneralParser}.
 */
public interface GeneralListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GeneralParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(GeneralParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(GeneralParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GeneralParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GeneralParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GeneralParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GeneralParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(GeneralParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(GeneralParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterQuantity_decl(GeneralParser.Quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitQuantity_decl(GeneralParser.Quantity_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterComplx_quantity_decl(GeneralParser.Complx_quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitComplx_quantity_decl(GeneralParser.Complx_quantity_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GeneralParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GeneralParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(GeneralParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(GeneralParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(GeneralParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(GeneralParser.UnitContext ctx);
}