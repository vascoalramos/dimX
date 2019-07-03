grammar General;

@parser::members{
    public static final SymbolTable map = new SymbolTable();
}

/**** SYNTACTIC RULES ****/

/**
	* General grammar main rule
*/
main: (importQuantities)* statList EOF;

/**
	* List of zero or more statements.
	* All statements should end with a semi-colon.
*/
statList : (stat TERM)*;

/**
	* Import of a file with all quantities defined by the programmer.
 */
importQuantities: 'import' ID TERM;

/**
	* Different variations of a statement.
 */
stat: print | assign | declaration | conditionalExpr | dimCheck;

/**
	* Declaration of a variable using a primitive type and identifier.	
*/
declaration: type ID;

/**
	* Rule for the assignement of a value to a variable.
	* It can also declare the variable.
*/
assign: declaration '=' expr 	#declareAndAssign
		| ID '=' expr			 #justAssign
		;

/**
	* Prints out the value of an expression to the console.
 */
print: 'print' '(' expr ')';

/**
	* Input rule for a dynamic interaction with the user.
*/
input: 'input' '(' STRING ')';

/** 
	* Different primitive types accepted by our language.
*/
type returns[Type res]:
	  'Integer'			#intType
	| 'Real'			#realType
	| 'Boolean'			#boolType
	| 'String'			#strType
	| TYPE_ID			#customType
	;


/** 
	* Rule for all the expressions accepted by our language.
	* It returns the type of the expression, (completem o resto sff)
	* Meaning of the expressions from top-down order:
	* - Pow expression
	* - Absolute value expression
	* - Binary operator expression
	* - Multiplication, division and remainder expressions
	* - Addition and subtraction expressions
	* - Conditional negation expression
	* - Conditional equality expression 
	* - Conditional relational expression
	* - Conditional 'and/or' expression
	* - Parenthesis expression
	* - Input expression
	* - Identifier expression
	* - String expression
	* - Boolean expression
	* - Integer expression
	* - Real expression
*/
expr returns[Type exprType, String varName, String dimension, String unit]
	: <assoc=right> e1=expr '^' e2=expr						# Pow
	| 'abs' '(' expr ')'									# AbsoluteValue
	| sign = ('+'|'-') expr									# binaryOperator
	| e1 = expr op = ('*' | '/' | '%') e2 = expr			# multDiv
	| e1 = expr op = ('+' | '-') e2 = expr					# addSub
	| 'not' expr											# conditionalNegation
	| e1=expr op=('==' | '!=' | '===' | '!==') e2=expr		# conditionalEquality
	| e1=expr op=('<' | '>' | '<=' | '>=') e2=expr 			# conditionalRelational
	| e1=expr op=('or' | 'and') e2=expr						# conditionalAndOr
	| '(' expr ')'											# parentheses
	| input													# inputValue
	| ID													# IDvalue
	| STRING												# StringValue
	| BOOLEAN												# BooleanValue
	| INT unitID?											# IntValue
	| REAL unitID?											# RealValue
	;

dimCheck: dimensionCheck
		 | unitCheck
		 ;

/** 
	* Check the dimension of a customized type.
*/
dimensionCheck : '(' expr ').dimension';

/** 
	* Check the unit of a customized type.
*/
unitCheck : '(' expr ').unit';

conditionalExpr: conditional
			   | whileConditional
			   | forConditional
			   ;

/**
	* Conditional 'if' statement, with 'else if' and 'else' options
 */
conditional: 'if' expr '{' trueStats=statList '}'('else' falseStats = elseConditon)? ; 
elseConditon: conditional | '{' statList '}';

/**
	* Conditional 'while' statement
 */
whileConditional: 'while' expr '{' trueStats=statList '}'; //Semantic Check whether expr is boolean

/**
	* Conditional 'for' statement
 */
forConditional: 'for' incVarDec=assign ',' breakCond=expr ',' incCond=expr   '{' trueStats=statList '}'; //Semantic Check whether breakCond is boolean AND incCond is NOT boolean

/**
	* Declaration of a new unit.
 */
unitID: '[' ID (op = ('/' | '*') ID)? ']';


/**** LEXICAL RULES ****/

/**
	* Boolean type options.
 */
BOOLEAN: 'true' | 'false';

/**
	* Identifiers definition.
 */
TYPE_ID: [A-Z]LETTER+;
ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

/**
	* Numbers definition.
 */
INT: DIGIT+;
REAL: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

/**
	* Comment and white-spaces definition.
 */
SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;

/**
	* String definition.
 */
STRING: '"' .*? '"';


TERM: ';';
ERROR: .;