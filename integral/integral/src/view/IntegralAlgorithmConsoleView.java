package view;

import integrals.Excepion.IncorrectNumberOfSubintervalsException;
import integrals.Excepion.IncorrectRangesException;
import integrals.IntegralAlgorithm;
import java.util.Scanner;

public class IntegralAlgorithmConsoleView implements IntegralAlgorithmView{
    private IntegralAlgorithm solver;
    private Scanner sc;

    protected double parseWithMessage(String message){
        System.out.println(message);
        String line;
        double res;
        try{
            line = sc.nextLine();
            res = Double.parseDouble(line);
        }catch(Exception ex){
            System.err.println("Wprowadzono niepoprawne dane!");
            res = parseWithMessage(message);
        }
        return res;
    }

    protected void parseFactors(){
        double a = 0, b = 0;
        int n;
        a = parseWithMessage("Wprowadź początek przedziału: ");
        b = parseWithMessage("Wprowadź koniec przedziału: ");
        if(a >= b){
            try{
                throw new IncorrectRangesException();
            } catch (IncorrectRangesException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }
        n = (int) parseWithMessage("Wprowadź liczbę podprzedziałów: ");
        if(n < 1){
            try{
                throw new IncorrectNumberOfSubintervalsException();
            } catch (IncorrectNumberOfSubintervalsException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }
        }
        this.solver.setA(a);
        this.solver.setB(b);
        this.solver.setN(n);
    }

    protected void displaySolution(double trapezeIntegral, double exactIntegral, double error){
        String label = "Numeryczna\t"+trapezeIntegral+"\n";
        label += "Dokładna\t"+exactIntegral+"\n";
        label+= "Błąd\t"+error+"\n";
        System.out.println(label);
    }

    protected void getSolution(){
        solver.calculateIntegral();
        solver.calculateExactIntegral();
        solver.calculateError();
        double trapezeIntegral = solver.getIntegral();
        double exactIntegral = solver.getExactIntegral();
        double error = solver.getError();
        displaySolution(trapezeIntegral, exactIntegral, error);
    }

    @Override
    public void View(){
        while(true){
            parseFactors();
            getSolution();
        }
    }

    @Override
    public void Init(IntegralAlgorithm solver){
        this.solver = solver;
        this.sc = new Scanner(System.in);
    }


}
