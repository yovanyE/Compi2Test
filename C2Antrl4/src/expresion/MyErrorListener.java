/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresion;

import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Yovany Samines
 */
public class MyErrorListener extends BaseErrorListener{
    public static boolean hasError=false;
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
    hasError=true;    
        List<String> stack=((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        System.out.println("Error sintaxys");
        System.out.println("Token "+"\""+((Token)offendingSymbol).getText()+"\""
        +
        "(Line "+line+", Column"+(charPositionInLine+1)+")"
        +
        ": "+msg);
        
        System.out.println("Regla Sintactica: "+stack);
    }
    
}
