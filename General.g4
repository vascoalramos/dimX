grammar General;
import Quantities;

main: (stat TERM)* EOF;

stat: print
    | declaration
    | assignment
    ;

assignment: ID? ID ('=' expr)?; // check if it's already declared; can't write only the var 

expr: e1=expr op=('*'|'/') e2=expr
         | e1=expr op=( '+' | '-' ) e2=expr
         |'(' expr ')'
         | number_type unit?
         | ID
         | STRING
         | BOOLEAN
         ; 

print: 'print' '(' expr ')';

declaration: quantity_declare
           | prefix_declare
           ;

STRING: '"' .*? '"';
BOOLEAN: 'true' | 'false';
TERM: ';';