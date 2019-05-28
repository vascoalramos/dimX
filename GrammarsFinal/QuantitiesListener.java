// Generated from Quantities.g4 by ANTLR 4.7.2

        import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuantitiesParser}.
 */
public interface QuantitiesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterQuantity_decl(QuantitiesParser.Quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitQuantity_decl(QuantitiesParser.Quantity_declContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterComplx_quantity_decl(QuantitiesParser.Complx_quantity_declContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complx_quantity_decl}
	 * labeled alternative in {@link QuantitiesParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitComplx_quantity_decl(QuantitiesParser.Complx_quantity_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(QuantitiesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(QuantitiesParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(QuantitiesParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(QuantitiesParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(QuantitiesParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(QuantitiesParser.UnitContext ctx);
}