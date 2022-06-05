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
public class VariableDeclaration extends Expression {
    public String id;
    public String type;
    public int value;
    
    public VariableDeclaration(String id,String type, int value){
     this.id=id;
     this.type=type;
     this.value=value;
    }
    
}
