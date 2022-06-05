grammar Expr;


/*Gramatica de ejemplo*/

@header{
    package antlr;
    import org.antlr.v4.runtime.*;
    import java.io.*;
    import java.util.*;
    //importar clases generadas
    import expresion.*;
}

//funciones para menajo semantico 
@members{
    public List<String> vars=new ArrayList<>();
    public List<String> semanticErrors=new ArrayList<>();
    public Program program;
                
 }
//iniciar gramatica

prog returns [Program p] 
@init{
    //ejecutado antes de que la producción tenga efecto
    $p=new Program();

    program=$p;

}
    : (
        d=decl {
            $p.addExpression($d.d);

        }
        | 
        e=expr {
          $p.addExpression($e.e);  
        }
        )+
    EOF # Program
    ;

decl returns [Expression d] 
    : name=ID ':' type=INT_TYPE '=' val=NUM {
        int line=$name.getLine();
        int column=$name.getCharPositionInLine()+1;
        String id=$name.text;

        if(vars.contains(id)){
            semanticErrors.add("Error: variable "+id+" ya declarado ("+ line+", "+column+")");
         }else{
             vars.add(id);
         }
         String type=$type.getText();
         int val=$val.int;
         $d=new VariableDeclaration(id,type,val);

    } # Declaration
;

expr returns [Expression e]
    : left=expr '*' right=expr {
        $e=new Multiplication($left.e,$right.e);

    }   # Multiplication
    | left=expr '+' right=expr {
        $e=new Addition($left.e,$right.e);

    }   # Addition
    | id=ID {
        int line=$id.getLine();
        int column=$id.getCharPositionInLine()+1;
        if(!vars.contains($id.text)){
            semanticErrors.add("Error: variable"+$id.text+" no declarado ("+ line+", "+column+")");
         }
         $e=new Variable($id.text);  
    }             # Variable
    | n=NUM  { // Mientras construimos el subárbol de un nodo expr que contiene NUM como el primer hijo, también construimos el objeto Expression
        $e=new expresion.Number($n.int);
    }           # Number
    ;

/*Definir los tokens*/
ID: [a-z][a-zA-Z0-9_]*; //identificadores

NUM: '0' | '-'?[1-9][0-9]*;

INT_TYPE: 'INT';

COMMENT: '--' ~[\r\n]* ->skip;

WS: [ \t\r\n]+ ->skip;

