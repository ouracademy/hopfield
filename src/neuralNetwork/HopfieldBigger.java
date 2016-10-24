package neuralNetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class HopfieldBigger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double input1[][] = {{1.0, -1.0, -1.0, -1.0, -1.0, -1.0,1.0,1.0}};
        double input2[][] = {{1.0, -1.0, 1.0, -1.0, -1.0, -1.0,1.0,1.0}};
        double input3[][] = {{1.0, 1.0, -1.0, -1.0, -1.0, -1.0,1.0,1.0}};
        Hopfield net = new Hopfield(3);
        net.addInput(input1, "A");
        net.addInput(input2, "B");
        net.addInput(input3, "C");
        double testI[][] = {{1.0, 1.0, -1.0, -1.0, -1.0, -1.0,1.0,1.0}};
        Matrix testInput = new Matrix(input1);
        Pattern p = net.execute(testInput);
        System.out.println("Patron :" + p.identifier);
    }

}
