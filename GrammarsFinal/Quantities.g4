grammar Quantities;

////////////////////////LEXER RULES////////////////////////

///Base Declarations///

quantity_declare: e1=ID ':' e2=type     #quantity_decl
                | complex=ID ':' q1=ID ('/'|'*') q2=ID ('['ID ('/'|'*') ID']')?     #complx_quantity_decl //Gotta verify whether the quantities exist
                ;       

prefix_declare: 'prefix ' ID ':' (INT | FLOAT | SCF_NOTATION);  //Verify whether the prefix has been previously declared && add it to map


////////Other//////////

type: e3=value e4=unit;

value: 'real' | 'int';

unit: '[' ID ']'; //If we specify a prefix we gotta verify if the suffix has been declared already (i.e u cant define that km = 1000 m if u havent defined m first...duh)


////////////////////////PARSER RULES////////////////////////

ID: [a-zA-Z]+;

INT: [0-9]+;

FLOAT: INT? '.' INT+ ;

SCF_NOTATION: '10^'[0-9]*;

WS: [ \t\n\r]+ -> skip;