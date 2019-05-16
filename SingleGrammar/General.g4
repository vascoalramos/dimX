grammar General;

main: (expr '\n')* EOF;

expr:  quantity ';'
    | operation ';'
    | declaration ';'
    ;

 declaration: ID ID '=' operation
            | ID ID
            | ID ID '=' operation
            ;
            
operation: operation ('*'|'/') operation
         | operation ('+'|'-') operation
         | '(' operation ')'
         | INT
         | ID
         ;


quantity: ID ':' type
        | quantity ('/'|'*') quantity
        ;

type: value unit;

value: 'real' | 'int';

unit: '[' ID ']';



ID: [a-zA-Z_]+;
INT:[0-9]+;
WS: [ \t\n\r]+ -> skip;