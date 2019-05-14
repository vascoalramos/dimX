grammar Quantities;

unit: velocity | distance | time;
velocity: distance '/' time;
distance: (REAL | INT) '[m]';
time: (REAL | INT) '[s]';

quantities:
	'velocitiy'
	| 'distance'
	| 'time'
	| 'mass'
	| 'temperature';

REAL: INT '.' INT | '.' INT;
INT: DIGIT+;
DIGIT: [0-9];
WS: [ \t\n\r]+ -> skip;