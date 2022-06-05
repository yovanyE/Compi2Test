/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yovany Samines
 */
public class Program {
    public List<Expression> expresion;
    
    public Program(){
        this.expresion=new ArrayList<>();
    }
    public void addExpression(Expression expresion){
        this.expresion.add(expresion);
    }
}
