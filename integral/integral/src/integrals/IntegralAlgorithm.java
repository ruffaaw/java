package integrals;

import functions.Function;

public abstract class IntegralAlgorithm {
    protected double a;
    protected double b;
    protected int n;
    protected double sum;
    protected double exactIntegral;
    protected double error;
    protected Function function;

    public double getIntegral(){
        return sum;
    }

    public double getExactIntegral() {
        return exactIntegral;
    }

    public double getError() {
        return error;
    }

    public void setN(int n) {this.n = n;}

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public abstract void calculateIntegral();

    public abstract void calculateExactIntegral();

    public abstract void calculateError();


}
