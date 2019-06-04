// Generated from General.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GeneralParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GeneralVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GeneralParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(GeneralParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(GeneralParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(GeneralParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GeneralParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GeneralParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#var_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declare(GeneralParser.Var_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#var_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_assignment(GeneralParser.Var_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(GeneralParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantity_decl(GeneralParser.Quantity_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplx_quantity_decl(GeneralParser.Complx_quantity_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#prefix_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_declare(GeneralParser.Prefix_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GeneralParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(GeneralParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(GeneralParser.UnitContext ctx);
}