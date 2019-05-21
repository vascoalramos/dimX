grammar General;

main: (expr '\n')* EOF;

expr:  quantity ';'
    | operation ';'
    | declaration ';'
    ;

expr_func: operation ';'
        | declaration ';'
        ;

 declaration: ID ID '=' operation
            | ID ID
            | funcDecl
            ;
            
operation: operation ('*'|'/') operation
         | operation ('+'|'-') operation
         | '(' operation ')'
         | INT
         | ID
         | functionUse
                 
         
         ;


quantity: ID ':' type
        | quantity ('/'|'*') quantity
        ;

type: value unit;

functionUse:ID '(' arguments? ')' ;

funcDecl:ID ID '(' argumentsDecl? '){''\n'? funcBody '}';

funcBody:(expr_func';')*'\n'? ('return' ID)?;

arguments: operation (',' operation)*;

argumentsDecl: ID ID (',' ID ID)*;

value: 'real' | 'int';

unit: '[' ID ']';



ID: [a-zA-Z_]+;
INT:[0-9]+;
WS: [ \t\n\r]+ -> skip;