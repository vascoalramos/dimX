// Generated from Quantities.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuantitiesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuantitiesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(QuantitiesParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(QuantitiesParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantity_declare(QuantitiesParser.Quantity_declareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(QuantitiesParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(QuantitiesParser.ComplexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(QuantitiesParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(QuantitiesParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#prefix_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_declare(QuantitiesParser.Prefix_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#number_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_type(QuantitiesParser.Number_typeContext ctx);
}