grammar FunctionsWithOtherStuff;

@header{
        import java.util.HashMap;
}
@members{
        HashMap <String,String[]> QuantityMap=new HashMap <> ();
}
main: (expr '\n')* EOF;



expr:  quantity ';'

    | operation ';'

    | declaration ';'

    ;



expr_func: operation ';'

        | declaration ';'

        ;



 declaration: ID ID '=' operation

            | ID ID
            |   
            ;

            

operation: operation ('*'|'/') operation

         | operation ('+'|'-') operation

         | '(' operation ')'

         | INT

         | ID

         | functionUse

                 

         

         ;


<<<<<<< HEAD:SingleGrammar/General.g4
quantity: e1=ID ':' e2=type #quantity_decl
        | ID ':' ID ('/'|'*') ID #quantity_decl_complx
        ;

type returns[String res=""]:
        e1=value e2=unit

        ;
=======



quantity: ID ':' type

        | quantity ('/'|'*') quantity

        ;



type: value unit;
>>>>>>> b5012473bddae9a41c17e79bf03fb11effd0c445:Cycles/function/FunctionsWithOtherStuff.g4



functionUse:ID '(' arguments? ')' ;



funcDecl:ID ID '(' argumentsDecl? '){''\n'? funcBody '}';



funcBody:(expr_func';')*'\n'? ('return' ID)?;



arguments: operation (',' operation)*;



argumentsDecl: ID ID (',' ID ID)*;



value: 'real' | 'int';



unit: '[' ID ']';







ID: [a-zA-Z_]+;

INT:[0-9]+;

WS: [ \t\n\r]+ -> skip;

