package integrals.Excepion;

public class IncorrectNumberOfSubintervalsException extends SolverException{
    public IncorrectNumberOfSubintervalsException(){
        super("Nieprawidłowa liczba podprzedziałów! Liczba podprzedziałów musi być większa lub równa 1!");
    }
}
