grammar Quantities;

main: (stat ';')* EOF;

stat: quantity_declare
	| prefix_declare
	;

quantity_declare: ID ':' type;

type : value unit									#SimpleType
	| e1 = ID op = ('/' | '*') e2 = ID unit		#ComplexType
	;

value:
	   'int'
	 | 'real'
	 ;

//TODO make it so you can have multiple complex units (i.e m*m*m)
unit: '[' ID (op = ('/' | '*') ID)? ']';

prefix_declare: 'prefix' ID ':' number_type;

number_type:  INT
			| FLOAT
			| SCF_NOTATION
			;

SCF_NOTATION: '10^' [0-9]*; //TODO: later date

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z];

INT: DIGIT+;
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;