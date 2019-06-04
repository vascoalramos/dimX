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
	 * Visit a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantity_decl(QuantitiesParser.Quantity_declContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplx_quantity_decl(QuantitiesParser.Complx_quantity_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#prefix_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix_declare(QuantitiesParser.Prefix_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(QuantitiesParser.TypeContext ctx);
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
}