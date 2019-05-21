grammar Quantities;

////////////////////////LEXER RULES////////////////////////

quantity: e1=ID ':' e2=type             #quantity_decl
        | ID ':' ID ('/'|'*') ID        #complx_quantity_decl
        ;

type: value unit;

value: 'real' | 'int';

unit: '[' ID ']';


////////////////////////PARSER RULES////////////////////////

ID: [a-zA-Z]+;

WS: [ \t\n\r]+ -> skip;