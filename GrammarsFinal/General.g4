grammar General;
import Quantities;

////////////////////////LEXER RULES////////////////////////

main: (expr '\n')* EOF;

expr: quantity ';'
     | declaration ';'
     | operation ';'
    ;
declaration: ID ID ('=' operation)?
            | ID '=' operation
            ;
            
operation:| operation ('*'|'/') operation
          | operation ('+'|'-') operation
          |'(' operation ')'
          | INT
          | ID
          ;


////////////////////////PARSER RULES////////////////////////

INT:[0-9]+;
