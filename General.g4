grammar General;

@parser::members{
    public static final SymbolTable map = new SymbolTable();
}

main: (stat TERM)* EOF;

stat: print | assign | declaration | input;
print: 'print' '(' expr ')';

assign: declaration '=' expr 								# declareAndAssign
	  | ID '=' expr			 											# justAssign
	  ;

input: 'input' '(' STRING ')';

declaration: type ID;

type returns[Type res]:
	  'Integer' 	{ $res = new IntegerType(); }
	| 'Real' 			{ $res = new RealType(); }
	| 'Boolean' 	{ $res = new BooleanType(); }
	| 'String' 		{ $res = new StringType(); }
	| TYPE_ID 		{ $res = new Quantity($TYPE_ID.text); }
	;

expr returns[Type exprType, String varName]:
	  <assoc=right> e1=expr '^' e2=expr				# Pow
	| e1 = expr op = ('*' | '/') e2 = expr		# multDiv
	| e1 = expr op = ('+' | '-') e2 = expr		# addSub
	| '(' expr ')'														# parentheses
	| input																		# inputValue
	| ID																			# IDvalue
	| STRING																	# StringValue
	| BOOLEAN																# BooleanValue
	| INT  unit? 																	# IntValue
	| REAL unit?																	# RealValue
	;


BOOLEAN: 'true' | 'false';

unit: '[' ID (op = ('/' | '*') ID)? ']';


TYPE_ID: [A-Z]LETTER+;
ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

INT: DIGIT+;
REAL: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;

STRING: '"' .*? '"';
TERM: ';';
ERROR: .;