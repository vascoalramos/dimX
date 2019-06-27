grammar General;
<<<<<<< HEAD
import Quantities;
=======
>>>>>>> 19a5ef27c160e8b5e8fd8793dc2b029302cca27f

main: (stat TERM)* EOF;

stat: print
    | assign
    | input
    ;
print: 'print' '(' expr ')' ; 

assign: type? ID ('=' expr)?; //String ola = 1+1; String ola; ola=1+1;

input: 'input' '(' STRING ')';

type returns[Type res]:
     'Integer' {$res = new IntegerType();}
   | 'Real'    {$res = new RealType();}
   | 'Boolean' {$res = new BooleanType();}
   | 'String'
   ;

expr:expr op=('*'|':') expr #multDiv
    |expr op=('+'|'-') expr #addSun
    | '(' expr ')' #parentheses
    |number #numberValue
    |input #inputValue
    |ID #IDvalue
    |STRING #StringValue
    |BOOLEAN #BooleanValue
    ;

<<<<<<< HEAD
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
=======

number returns[Type res]:
	INT {$res = new IntegerType();}
	| FLOAT {$res = new RealType();}
    ;
BOOLEAN: 'true' | 'false';


SCF_NOTATION: '10^' [0-9]*;

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

INT: DIGIT+;
FLOAT: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;
>>>>>>> 19a5ef27c160e8b5e8fd8793dc2b029302cca27f

STRING: '"' .*? '"';
TERM: ';';