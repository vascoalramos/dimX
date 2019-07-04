grammar Quantities;

@parser::members {
    public static final QuantityTable quantityTable = new QuantityTable();
}

main: (stat ';')* EOF;

stat: quantity_declare
	;

quantity_declare: TYPE_ID ':' type;

type : value unit											#SimpleType
	| e1 = TYPE_ID op = ('/' | '*') e2 = TYPE_ID unit		#ComplexType
	;

value:
	   'int'
	 | 'real'
	 ;

unit: '[' ID (op = ('/' | '*') ID)? ']';

TYPE_ID: [A-Z]LETTER+;
ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z];

INT: DIGIT+;
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;
ERROR: .;