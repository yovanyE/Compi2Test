/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresion;

/**
 *
 * @author Yovany Samines
 */
public class Variable extends Expression {
    public String id;
    
    public Variable(String id){
        this.id=id;
    }

    @Override
    public String toString() {
    return id;
    }
    
}
