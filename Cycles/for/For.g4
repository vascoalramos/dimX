grammar For;

main: (for_statement '\n')* EOF;

expr:'oi';

for_statement:
	'for' '(' for_init ';' expression ';' for_update '){ 'expr*'}'
	;

for_init:  ID ID '=' operation
        |  ID
        ;

operation: operation ('*'|'/') operation
         | operation ('+'|'-') operation
         | '(' operation ')'
         | INT
         | ID
         ;

expression: operation|ID ('<'|'<='|'>'|'>='|'=='|'!=') operation|ID;

for_update: ID '=' operation;

ID: [a-zA-Z_]+;
INT:[0-9]+;
WS: [ \t\n\r]+ -> skip;
