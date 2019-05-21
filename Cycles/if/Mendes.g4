grammar Mendes;

main: block EOF;

block: stat*;

stat: quantity SCOL
    | declaration SCOL
    | if_stat
    ;

quantity: ID COLON type
    | quantity (MULT | DIV) quantity
    ;

declaration: ID ID ASSIGN expr
    ;

if_stat
 : IF condition_block (ELSE IF condition_block)* (ELSE stat_block)?
 ;

condition_block
 : expr stat_block
 ;

stat_block
 : OBRACE block CBRACE
 | stat
 ;

expr: expr POW<assoc=right> expr            # powExpr
    | MINUS expr                            # unaryMinusExpr
    | NOT expr                              # negationExpr
    | expr op=(MULT | DIV | MOD) expr       # MultDivAndModExpr
    | expr op=(PLUS | MINUS) expr           # PlusMinusExpr
    | expr op=(LTEQ | GTEQ | LT | GT) expr  # relationalExpr
    | expr op=(EQ | NEQ) expr               # EqualOrNotEqualExpr
    | expr AND expr                         # intersectionExpr
    | expr OR expr                          # unionExpr
    | atom                                  # indivisibleExpr
    ;

atom
 : OPAR expr CPAR #parentesisExpr
 | (INT | FLOAT)  #numberAtom
 | (TRUE | FALSE) #booleanAtom
 | ID             #idAtom
 | STRING         #stringAtom
 ;

type: value unit
    ;

value: 'real' | 'int'
    ;

unit: '[' ID ']'
    ;

ASSIGN: '=';
COLON: ':';
SCOL: ';';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

POW: '^';
MULT: '*';
DIV: '/';
MOD: '%';
PLUS: '+';
MINUS: '-';

OR : '||';
AND : '&&';
EQ : '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
NOT : '!';

TRUE : 'true';
FALSE : 'false';
IF : 'if';
ELSE : 'else';

STRING: '"' (ESC | .) *? '"';
FLOAT: INT* '.' INT* | '.' INT*;
INT: [0-9]+;
ID: [a-zA-Z_]+;
ESC: '\\"' | '\\\\';
LINE_COMMENT: '//' .*? '\n' -> skip;
COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\n\r]+ -> skip;