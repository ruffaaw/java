package view;

import matrix.IMatrix;
import matrix.generators.DefaultGenerator;
import multiplication.Multiplication;

import java.util.Date;
import java.util.Scanner;

public class View implements IView{
    protected Scanner sc = new Scanner(System.in);

    protected int parseWithMessageInt(String message) {
        System.out.println(message);
        String line;
        int res;

        try {
            line = sc.nextLine();
            res = Integer.parseUnsignedInt(line);
        } catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane");
            res = parseWithMessageInt(message);
        }

        return res;
    }

    public void menu(){
        int choice = 0;
        boolean bool = true;

        while (bool){
            System.out.println("Prosze wybrac dzialanie:\n1)Mnozenie macierzy\n2)Wyjscie");
            choice = parseWithMessageInt("Wybor: ");

            if (choice == 1){
                main();
            }
            else if (choice == 2){
                bool = false;
            }
            else{
                System.out.println("Wprowadz prawidlowe dane");
            }
        }
    }

    public void main(){
        IMatrix a;
        IMatrix b;
        IMatrix c;
        IMatrix d;
        int rowA =1000;
        int rowB = 1000;
        int columnA = 1000;
        int columnB = 1000;

        if(columnA == rowB) {
            System.out.println("Generuję macierze...");
            a = DefaultGenerator.generateRandomMatrix(rowA, columnA, 0, 3);
            b = DefaultGenerator.generateRandomMatrix(rowB, columnB, 0, 3);
            System.out.println(" "+a.rowCount()+" "+a.columnCount());
            System.out.println("Mnożę macierze klasycznie...");
            Date start = new Date();
            c = IMatrix.multiply(a, b);
            Date end = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end.getTime() - start.getTime()));
        /*
        Kod wykorzystujący klasę mnożenia współbieżnego
         */
            System.out.println("Mnożę macierze przy uzyciu watkow...");
            Multiplication multiplication = new Multiplication();
            Date start2 = new Date();
            d = multiplication.multiply(a,b);
            Date end2 = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end2.getTime() - start2.getTime()));
        }
        else{
            System.out.println("Nieprawidłowe dane macierzy");
            menu();
        }
    }
}


