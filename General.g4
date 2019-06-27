grammar General;

main: (stat TERM)* EOF;

stat: print
    | assign
    | input
    ;
print: 'print' '(' expr ')' ; 

assign: type? ID ('=' expr)?; //String ola = 1+1; String ola; ola=1+1;

input: 'input' '(' STRING ')';

type returns[Type res]:
     'Integer' 
   | 'Real'    
   | 'Boolean'
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


number returns[Type res]:
	INT
	| FLOAT 
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

STRING: '"' .*? '"';
TERM: ';';