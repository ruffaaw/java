package Quadrangle;

import Point.Point;

public interface QuadrangleInterface {
    void setCoords(double x, double y, int n);
    Point getCoords(int n);
    double perimeter();
    double area();
    double diagonal(int n);
}
