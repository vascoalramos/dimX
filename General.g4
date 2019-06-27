grammar General;
@parser::members{
    public static final SymbolTable map = new SymbolTable();
}

main: (stat TERM)* EOF;

stat: print | assign | declaration | input;
print: 'print' '(' expr ')';

assign: declaration '=' expr #declareAndAssign
	  | ID '=' expr			 #justAssign
	  ;

input: 'input' '(' STRING ')';

declaration: type ID;

type returns[Type res]:
	  'Integer' { $res = new IntegerType(); }
	| 'Real' { $res = new RealType(); }
	| 'Boolean' { $res = new BooleanType(); }
	| 'String' { $res = new StringType(); };

expr returns[Type exprType, String varName]:
	expr op = ('*' | ':') expr		# multDiv
	| expr op = ('+' | '-') expr	# addSun
	| '(' expr ')'					# parentheses
	| input							# inputValue
	| ID							# IDvalue
	| STRING						# StringValue
	| BOOLEAN						# BooleanValue
	| INT							# IntValue
	| REAL							# RealValue
	;


BOOLEAN: 'true' | 'false';

SCF_NOTATION: '10^' [0-9]*;

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];

INT: DIGIT+;
REAL: DIGIT+ '.' DIGIT+ | '.' DIGIT+;
fragment DIGIT: [0-9];

SINGLE_LINE_COMMENT: '//' .*? '\n' -> skip;
MULTI_LINE_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \r\n\t]+ -> skip;

STRING: '"' .*? '"';
TERM: ';';