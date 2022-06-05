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
public class Number extends Expression{
    int num;
    public Number(int num){
        this.num=num;
    }

    @Override
    public String toString() {
        return new Integer(num).toString();
       // return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
