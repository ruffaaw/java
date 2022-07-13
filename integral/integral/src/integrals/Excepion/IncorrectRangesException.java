package integrals.Excepion;

public class IncorrectRangesException extends SolverException{
    public IncorrectRangesException(){
        super("Nieprawidłowe przedziały! Początek przedziału -> a musi być mniejszy od końca przedziału -> b!");
    }
}
