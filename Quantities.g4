grammar Quantities;

quantity: ID ':' type;
type: value unit;
value: REAL | INT;
unit: '[' ID ']';

ID: [a-zA-Z]+;
REAL: INT '.' INT | '.' INT;
INT: DIGIT+;
DIGIT: [0-9];
WS: [ \t\n\r]+ -> skip;