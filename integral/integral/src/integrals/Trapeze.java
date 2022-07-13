package integrals;

public class Trapeze extends IntegralAlgorithm{

    public Trapeze(){
        this.sum=0;
        this.exactIntegral = 0;
        this.error = 0;
    }

    @Override
    public void calculateIntegral(){
    double step, a_pom = a;
    step = (b - a)/n;
    sum = 0;

    for (int i = 0; i < n; i++){
        sum+= function.getValue(a_pom) + function.getValue(a_pom+step);
        a_pom += step;
    }
    sum*=0.5*step;
    }

    public void calculateExactIntegral(){
        exactIntegral = function.getExactIntegralValue(b) - function.getExactIntegralValue(a);
    }
    public void calculateError(){
        error = Math.abs(sum-exactIntegral);
    }
}
