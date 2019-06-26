grammar Quantities;

quantity_declare: ID ':' expr;
expr: value unit | e1 = ID op = ('/' | '*') e2 = ID unit?;

value: 'real' | 'int';
unit: '[' ID (op=('/'|'*') ID)? ']'; //TODO make it so you can have multiple complex units (i.e m*m*m)


prefix_declare: 'prefix' ID ':' number_type;
number_type: number | SCF_NOTATION;
number: INT | FLOAT;

SCF_NOTATION: '10^' [0-9]*;

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

INT: DIGIT+;
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;