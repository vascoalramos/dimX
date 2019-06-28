grammar General;

@parser::members{
    public static final SymbolTable map = new SymbolTable();
}

main: statList EOF;
statList : (stat TERM)*;

stat: print | assign | declaration | input;
print: 'print' '(' expr ')';

assign: declaration '=' expr #declareAndAssign
	  | ID '=' expr			 #justAssign
	  ;

input: 'input' '(' STRING ')';

declaration: type ID;

type returns[Type res]:
	  'Integer'			#intType
	| 'Real'			#realType
	| 'Boolean'			#boolType
	| 'String'			#strType
	| TYPE_ID			#customType
	;

expr returns[Type exprType, String varName, String dimension, String unit]
	: <assoc=right> e1=expr '^' e2=expr						# Pow
	| e1 = expr op = ('*' | '/') e2 = expr					# multDiv //TODO - Add Resto e Modulo
	| e1 = expr op = ('+' | '-') e2 = expr					# addSub
	| e1=expr op=('or' | 'and') e2=expr						# conditionalAndOr
	| 'not' expr											# conditionalNegation
	| e1=expr op=('==' | '!=' | '===' | '!==') e2=expr		# conditionalEquality
	| e1=expr op=('<' | '>' | '<=' | '>=') e2=expr 			# conditionalRelational
	| '(' expr ')'											# parentheses
	| input													# inputValue
	| ID													# IDvalue
	| STRING												# StringValue
	| BOOLEAN												# BooleanValue
	| INT unitID?													# IntValue
	| REAL unitID?													# RealValue
	;


conditional: 'if' expr '{' trueStats=statList '}'('else' '{' falseStats= statList '}')? ;

BOOLEAN: 'true' | 'false';

unitID: '[' ID (op = ('/' | '*') ID)? ']';


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