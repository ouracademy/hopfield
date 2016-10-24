/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNetwork;

/**
 *
 * @author pc
 */
public class Pattern {
    Matrix data;
    public String identifier;

    public Pattern(Matrix data, String identifier) {
        this.data = data;
        this.identifier = identifier;
    }

    boolean hasThisData(Matrix data) {
        return this.data.eq(data);
    }
    
}
