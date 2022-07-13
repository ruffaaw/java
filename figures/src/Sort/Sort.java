package Sort;

import Quadrangle.Quadrangle;
import Triangle.Triangle;

public class Sort {
    public static void sortTriangles(Triangle[] triangles){
        int n = triangles.length;
        double [] array = new double[n];
        for (int i = 0; i< n; i++){
            array[i] = triangles[i].area();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++){
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    Triangle tempTriangle = triangles[j];
                    triangles[j] = triangles[j + 1];
                    triangles[j + 1] = tempTriangle;
                }
            }
        }
    }
    public static void sortQuadrangles(Quadrangle[] quadrangles){
        int n = quadrangles.length;
        double [] array = new double[n];
        for (int i = 0; i< n; i++){
            array[i] = quadrangles[i].area();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    Quadrangle tempQuadrangle = quadrangles[j];
                    quadrangles[j] = quadrangles[j + 1];
                    quadrangles[j + 1] = tempQuadrangle;
                }
            }
        }
    }
}



