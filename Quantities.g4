grammar Quantities;

quantity_declare: ID ':' expr;
expr: e1=ID op=('*'|'/') e2=ID;

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS : [ \r\n\t]+ -> skip;