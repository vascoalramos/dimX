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
	 * Enter a parse tree produced by {@link GeneralParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(GeneralParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(GeneralParser.StatListContext ctx);
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
	 * Enter a parse tree produced by {@link GeneralParser#var_declare}.
	 * @param ctx the parse tree
	 */
	void enterVar_declare(GeneralParser.Var_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#var_declare}.
	 * @param ctx the parse tree
	 */
	void exitVar_declare(GeneralParser.Var_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GeneralParser#var_assignment}.
	 * @param ctx the parse tree
	 */
	void enterVar_assignment(GeneralParser.Var_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GeneralParser#var_assignment}.
	 * @param ctx the parse tree
	 */
	void exitVar_assignment(GeneralParser.Var_assignmentContext ctx);
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
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void enterQuantity_decl(GeneralParser.Quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void exitQuantity_decl(GeneralParser.Quantity_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void enterComplx_quantity_decl(GeneralParser.Complx_quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void exitComplx_quantity_decl(GeneralParser.Complx_quantity_declContext ctx);
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