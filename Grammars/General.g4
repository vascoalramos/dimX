grammar General;
import Quantities;

main: (expr '\n')* EOF;

 expr: quantity ';'
     | declaration ';'
     | operation ';'
    ;
 declaration: ID VARID '=' operation
            | ID VARID
            | VARID '=' operation
            ;
            
 operation: INT
          | '(' operation ')'
          | operation ('*'|'/') operation
          | operation ('+'|'-') operation
          ;

VARID: [a-zA-Z_]+;
INT:[0-9]+;
