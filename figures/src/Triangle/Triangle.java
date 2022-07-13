package Triangle;

import Point.Point;

public class Triangle implements TriangleInterface{
    Point [] coords = new Point[3];

    public Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
        coords[0] = new Point(x1, y1);
        coords[1] = new Point(x2, y2);
        coords[2] = new Point(x3, y3);
    }

    @Override
    public void setCoords(double x, double y, int n){
        coords[n].setPoint(x,y);
    }

    @Override
    public Point getCoords(int n){
        return coords[n];
    }

    @Override
    public double perimeter(){
        return coords[0].distance(coords[1]) + coords[1].distance(coords[2]) + coords[2].distance(coords[0]);
    }

    @Override
    public double area(){
        double a = coords[0].distance(coords[1]);
        double b = coords[1].distance(coords[2]);
        double c = coords[2].distance(coords[0]);

        double p = (a+b+c)/2;
        return Math.sqrt( p*(p-a)*(p-b)*(p-c) );
    }

    public double height(int n){
        if (n == 0){
            return (2*area())/(coords[1].distance(coords[2]));
        }

        else if (n == 1){
            return (2*area())/(coords[0].distance(coords[2]));
        }

        else{
            return (2*area())/(coords[0].distance(coords[1]));
        }
    }

}
