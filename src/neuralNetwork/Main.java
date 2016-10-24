/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralNetwork;

import Util.ImageProcess;
import java.awt.image.BufferedImage;

/**
 *
 * @author pc
 */
public class Main {

    public static double[] getInputDataFromPath(String path) {
        BufferedImage image = new ImageProcess().getImageFromPath(path);
        double inputImage1[][] = new ImageProcess().getImageAsPixels(image);
        double newArray[] = new double[inputImage1.length * inputImage1[0].length];
        for (int i = 0; i < inputImage1.length; i++) {
            double[] row = inputImage1[i];
            for (int j = 0; j < row.length; j++) {
                double number = inputImage1[i][j];
                newArray[i * row.length + j] = number;
            }
        }
        return newArray;
    }

    public static double[] getInputDataFromBufferImage(BufferedImage image) {
        double inputImage1[][] = new ImageProcess().getImageAsPixels(image);
        double newArray[] = new double[inputImage1.length * inputImage1[0].length];
        for (int i = 0; i < inputImage1.length; i++) {
            double[] row = inputImage1[i];
            for (int j = 0; j < row.length; j++) {
                double number = inputImage1[i][j];
                newArray[i * row.length + j] = number;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        double[] data = getInputDataFromPath("src/images/Braille_A1.png");
        double[] data1 = getInputDataFromPath("src/images/Braille_B2.png");
        double[] data2 = getInputDataFromPath("src/images/Braille_C3.png");
        double[] data3 = getInputDataFromPath("src/images/Braille_D4.png");
        double[] data4 = getInputDataFromPath("src/images/Braille_E5.png");
        double[] data5 = getInputDataFromPath("src/images/Braille_F6.png");
        double[] data6 = getInputDataFromPath("src/images/Braille_G7.png");
        double[] data7 = getInputDataFromPath("src/images/test/trans.png");
        double input[][] = {data};
        double input1[][] = {data1};
        double input2[][] = {data2};
        double input3[][] = {data3};
        double input4[][] = {data4};
        double input5[][] = {data5};
        double input6[][] = {data6};
        double test[][] = {data7};
        Hopfield net = new Hopfield(7);
        net.addInput(input6, "g");
        net.addInput(input1, "b");
        net.addInput(input2, "b");
        net.addInput(input3, "d");
        net.addInput(input4, "e");
        net.addInput(input5, "f");
        net.addInput(input, "a");
        Matrix testInput = new Matrix(test);
        Pattern p = net.execute(testInput);
        //System.out.println("Patron :" + p.identifier);
    }

}
