grammar Quantities;
@parser::members{
    public static final QuantityTable quantityTable = new QuantityTable();
}
main: (stat ';')* EOF;

stat: quantity_declare
	| prefix_declare
	;

quantity_declare: TYPE_ID ':' type;

type : value unit											#SimpleType
	| e1 = TYPE_ID op = ('/' | '*') e2 = TYPE_ID unit		#ComplexType
	;

value:
	   'int'
	 | 'real'
	 ;

//TODO make it so you can have multiple complex units (i.e m*m*m)
unit: '[' ID (op = ('/' | '*') ID)? ']';

prefix_declare: 'prefix' ID ':' number_type; //TODO especificar uma grandeza para estar associado o prefixo

number_type:  INT
			| FLOAT
			| SCF_NOTATION
			;

SCF_NOTATION: '10^' [0-9]*; //TODO: later date

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