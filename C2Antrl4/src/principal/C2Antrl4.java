/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import antlr.ExprLexer;
import antlr.ExprParser;
import expresion.ExpressionProcessor;
import expresion.MyErrorListener;
import expresion.Program;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 *
 * @author Yovany Samines
 */
public class C2Antrl4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CharStream charStream=CharStreams.fromFileName("C:\\Users\\Yovany Samines\\Documents\\NetBeansProjects\\C2Antrl4\\src\\ejemplo.txt");
            ExprLexer exprLexer=new ExprLexer(charStream);
            CommonTokenStream commonTokenStream=new CommonTokenStream(exprLexer);
            ExprParser exprParser=new ExprParser(commonTokenStream);
            ///manehar error sintaxys
            exprParser.removeErrorListeners();
            exprParser.addErrorListener(new MyErrorListener());
            
           ParseTree parseTre=exprParser.prog();
           
           if(!MyErrorListener.hasError) //Si encuentra error sintancto no ingresa a producciones 
           {
                  //  AntlrToProgram progVisitor=new AntlrToProgram();
            Program prog=exprParser.program;
            
            if(exprParser.semanticErrors.isEmpty()){
                ExpressionProcessor ep=new ExpressionProcessor(prog.expresion);
                for(String evaluation: ep.getEvaluationResults()){
                    System.out.println(evaluation);
                }
                
            }else{
                for(String Err: exprParser.semanticErrors){
                    System.out.println(Err);
                }
            }   
           }
     
            System.out.println("exito!!");
        } catch (IOException ex) {
            Logger.getLogger(C2Antrl4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
