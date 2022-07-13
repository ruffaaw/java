package Triangle;

import Point.Point;

public interface TriangleInterface {
    double perimeter();
    double area();
    void setCoords(double x, double y, int n);
    Point getCoords(int n);
    double height(int n);
}
