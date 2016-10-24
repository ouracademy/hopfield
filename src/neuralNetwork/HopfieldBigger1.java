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
public class HopfieldBigger1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double input1[][] = {{1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1}};
        double input2[][] = {{1, 1,-1, -1, -1, -1, 1, -1, -1, -1, -1, -1}};
        Hopfield net = new Hopfield(2);
        net.addInput(input1, "A");
        net.addInput(input2, "B");
          double testI[][] = {{1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1}};
        Matrix testInput = new Matrix(testI);
        Pattern p = net.execute(testInput);
        System.out.println("Patron :" + p.identifier);
        //System.out.println(163/(160*Math.log(163)));
    }

}
