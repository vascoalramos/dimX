grammar Quantities;

quantity_declare: ID ':' expr;
expr: value unit | e1 = ID op = ('/' | '*') e2 = ID;

value: 'real' | 'int';
unit: '[' ID ']';

prefix_declare: 'prefix' ID ':' number_type;
number_type: INT | FLOAT | SCF_NOTATION;

SCF_NOTATION: '10^' [0-9]*;

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

INT: DIGIT+;
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;