grammar General;
//Import Lexer

main: (expr '\n')* EOF;

expr: declaration ';'
    | operation ';'
    ;

declaration:  quantity ID '=' operation
            | quantity ID
            | ID '=' operation
            ;

operation: unit
         | '(' operation ')'
         | operation ('*'|'/') operation
         | operation ('+'|'-') operation
         ;

ID: [a-zA-Z_];
WS: [ \t\n\w] -> skip;
