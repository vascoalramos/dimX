// Generated from Quantities.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuantitiesParser}.
 */
public interface QuantitiesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(QuantitiesParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(QuantitiesParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(QuantitiesParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(QuantitiesParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void enterQuantity_declare(QuantitiesParser.Quantity_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#quantity_declare}.
	 * @param ctx the parse tree
	 */
	void exitQuantity_declare(QuantitiesParser.Quantity_declareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(QuantitiesParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(QuantitiesParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterComplexType(QuantitiesParser.ComplexTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComplexType}
	 * labeled alternative in {@link QuantitiesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitComplexType(QuantitiesParser.ComplexTypeContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#prefix_declare}.
	 * @param ctx the parse tree
	 */
	void enterPrefix_declare(QuantitiesParser.Prefix_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#prefix_declare}.
	 * @param ctx the parse tree
	 */
	void exitPrefix_declare(QuantitiesParser.Prefix_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuantitiesParser#number_type}.
	 * @param ctx the parse tree
	 */
	void enterNumber_type(QuantitiesParser.Number_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuantitiesParser#number_type}.
	 * @param ctx the parse tree
	 */
	void exitNumber_type(QuantitiesParser.Number_typeContext ctx);
}