package multiplication;

import matrix.IMatrix;
import matrix.Matrix;
import matrixThread.MatrixThread;

public class Multiplication implements IMultiplication{
    public IMatrix multiply(IMatrix matrixA, IMatrix matrixB){

        IMatrix result = new Matrix(matrixA.rowCount(), matrixB.columnCount());
        int maxThreadNumber = Runtime.getRuntime().availableProcessors();
        Runnable[] tab = new Runnable[matrixA.rowCount()];
        Thread[] threads = new Thread[matrixA.rowCount()];

        int size = matrixA.rowCount()/maxThreadNumber;
        int startRow = 0;
        for(int i = 0; i < maxThreadNumber; i++){
            tab[i] = new MatrixThread(matrixA, matrixB, result, size, startRow);
            threads[i] = new Thread(tab[i]);
            threads[i].start();
            startRow += size;
        }

        for (int j = 0; j < maxThreadNumber; j++) {
            try {
                threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
