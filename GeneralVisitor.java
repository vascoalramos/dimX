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
	 * Visit a parse tree produced by {@link GeneralParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(GeneralParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GeneralParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GeneralParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GeneralParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GeneralParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantity_declare(GeneralParser.Quantity_declareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(GeneralParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link GeneralParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(GeneralParser.ComplexTypeContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link GeneralParser#prefix_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_declare(GeneralParser.Prefix_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GeneralParser#number_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_type(GeneralParser.Number_typeContext ctx);
}