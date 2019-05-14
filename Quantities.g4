grammar Quantities;

quantity: ID ':' type
        | quantity ('/'|'*') quantity
        ;
type: value unit;
value: 'real' | 'int';
unit: '[' ID ']';

ID: [a-zA-Z]+;
WS: [ \t\n\r]+ -> skip;