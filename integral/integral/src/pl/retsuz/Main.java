package pl.retsuz;

import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapeze;
import view.IntegralAlgorithmConsoleView;
import view.IntegralAlgorithmView;

public class Main {
    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithm;
    protected static IntegralAlgorithmView view;
    public static void main(String[] args) {
        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();
        algorithm = new Trapeze();
        algorithm.setFunction(givenExample);
        view = new IntegralAlgorithmConsoleView();
        view.Init(algorithm);
        view.View();

    }
}
