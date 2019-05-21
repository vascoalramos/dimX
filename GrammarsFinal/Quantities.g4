grammar Quantities;

////////////////////////LEXER RULES////////////////////////

quantity: ID ':' type
        | quantity ('/'|'*') quantity
        ;

type: value unit;

value: 'real' | 'int';

unit: '[' ID ']';


////////////////////////PARSER RULES////////////////////////

ID: [a-zA-Z]+;

WS: [ \t\n\r]+ -> skip;