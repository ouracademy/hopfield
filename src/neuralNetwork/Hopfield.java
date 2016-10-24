package neuralNetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diana Quintanilla
 */
public class Hopfield {

    Pattern[] inputs;
    int numberInputs = 0;

    public Hopfield(Pattern... inputs) {
        this.inputs = inputs;

    }

    public Hopfield(int numberOfInputs) {
        this.inputs = new Pattern[numberOfInputs];
    }

    public void addInput(double[][] input, String identifier) {
        Pattern p = new Pattern(new Matrix(input), identifier);
        this.inputs[this.numberInputs] = p;
        this.numberInputs++;
    }

    public Pattern execute(Matrix testInput) {
        Matrix value = testInput;
        Matrix current = null;
        Pattern recognized = null;
        Matrix next = null;
        System.out.println("weight :" + this.weight());
        int count = 0;
        do{
            current = value;
            value = (current.multiply(this.weight())).function();
            count++;
        } while (!current.equals(value));
        System.out.println("s" + count + " " + current);
        //System.out.println("Current matrixs ");
        //current.show();
        for (Pattern p : inputs) {
            if (p.hasThisData(current)) {
                recognized = p;
            }
        }
        return recognized;

    }

    public Matrix weight() {
        Matrix sumTotal = inputs[0].data.transpose().multiply(inputs[0].data).minus(Matrix.identity(this.length()));
        for (int i = 1; i < inputs.length; i++) {
            Matrix sumando = inputs[i].data.transpose().multiply(inputs[i].data).minus(Matrix.identity(this.length()));
            sumTotal = sumTotal.plus(sumando);
        }
        return sumTotal;

    }

    public int length() {
        return inputs[0].data.M * inputs[0].data.N;
    }
}
