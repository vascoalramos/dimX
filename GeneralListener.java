// Generated from General.g4 by ANTLR 4.7.2
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
	 * Enter a parse tree produced by {@link GeneralParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(GeneralParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(GeneralParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GeneralParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GeneralParser.AssignmentContext ctx);
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
	 * Enter a parse tree produced by {@link GeneralParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GeneralParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GeneralParser.PrintContext ctx);
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
	 * Enter a parse tree produced by {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void enterQuantity_declare(GeneralParser.Quantity_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void exitQuantity_declare(GeneralParser.Quantity_declareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(GeneralParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(GeneralParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void enterComplexType(GeneralParser.ComplexTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 */
	void exitComplexType(GeneralParser.ComplexTypeContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link GeneralParser#prefix_declare}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_declare(GeneralParser.Prefix_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#prefix_declare}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_declare(GeneralParser.Prefix_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#number_type}.
	 * @param ctx the parse tree
	 */
	void enterNumber_type(GeneralParser.Number_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#number_type}.
	 * @param ctx the parse tree
	 */
	void exitNumber_type(GeneralParser.Number_typeContext ctx);
}