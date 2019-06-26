grammar General;
import Quantities;



main: (stat TERM)* EOF;

stat: print
    | declaration
    | assignment
    ;

assignment: ID? ID ('=' assignment_type)?; // check if it's already declared; can't write only the var 

assignment_type: operation
                | number unit
                ;

content: operation
        | STRING
        ;

operation: e1=operation op=('*'|'/') e2=operation
         | e1=operation op=( '+' | '-' ) e2=operation
         |'(' operation ')'
         | number unit?
         | ID
         

         ; 

print: 'print' '(' content ')' ; 
declaration: quantity_declare
            |prefix_declare;

 


STRING: '"' .*? '"';
            






TERM: ';';