grammar General;
import Quantities;

////////////////////////LEXER RULES////////////////////////

///Main Stuff///

main: statList EOF;

statList: (stat ';' '\n'?)*;

stat: operation
	| declaration
	| assignment
	//| conditional
	;

declaration:  quantity_declare
			| prefix_declare
			| var_declare
			;

assignment: var_assignment;


///Other Stuff///

var_declare: ID ID ('=' operation)?;	//Variable Declaration
			 

var_assignment:  ID '=' operation;		//Variable Assignment

operation:		//Operations
	operation ('*' | '/') operation
	| operation ('+' | '-') operation
	| '(' operation ')'
	| INT
	| ID;


////////////////////////PARSER RULES////////////////////////

