grammar General;

main: (expr '\n')* EOF;

expr:  quantity ';'
    | operation ';'
    | declaration ';'
    ;

 declaration: ID ID '=' operation
            | ID ID
            | ID ID '=' operation
            | funcDecl
            ;
            
operation: operation ('*'|'/') operation
         | operation ('+'|'-') operation
         | '(' operation ')'
         | INT
         | ID
         | functionUse{
                 
         }
         ;


quantity: ID ':' type
        | quantity ('/'|'*') quantity
        ;

type: value unit;

functionUse:ID '(' arguments? ')' ;

funcDecl:ID ID '(' argumentsDecl? '){' funcBody '}';

funcBody:operation*;

arguments: operation (',' operation)*;

argumentsDecl: ID operation (',' ID operation)*;

value: 'real' | 'int';

unit: '[' ID ']';



ID: [a-zA-Z_]+;
INT:[0-9]+;
WS: [ \t\n\r]+ -> skip;