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
public class Addition extends Expression {
    Expression left;
    Expression right;

    public Addition(Expression left, Expression right) {
    this.left=left;
    this.right=right;
    }

    @Override
    public String toString() {
    return left.toString()+"+"+right.toString();
    }
}
