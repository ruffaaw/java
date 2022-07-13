package matrixThread;

import matrix.IMatrix;

public class MatrixThread extends Thread{
    private IMatrix result;
    private IMatrix matrixA;
    private IMatrix matrixB;
    private int row;
    private int rowStart;

    public MatrixThread(IMatrix matrixA, IMatrix matrixB, IMatrix result, int row, int rowStart) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.result = result;
        this.row = row;
        this.rowStart = rowStart;
    }

    @Override
    public void run() {
        int i, j, k;
        for (i = rowStart; i < row + rowStart; i++) {
            for (j = 0; j < matrixB.columnCount(); j++) {
                result.getData()[i][j] = 0;
                for (k = 0; k < matrixA.columnCount(); k++)
                    result.getData()[i][j] += matrixA.getData()[i][k] * matrixA.getData()[k][j];
            }

        }
    }
}
