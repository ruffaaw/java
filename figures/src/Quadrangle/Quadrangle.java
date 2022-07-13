package Quadrangle;

import Point.Point;

public class Quadrangle implements QuadrangleInterface{
    Point[] coords = new Point[4];

    public Quadrangle(double x1,double y1,double x2,double y2,double x3,double y3,double x4,double y4){
        coords[0] = new Point(x1, y1);
        coords[1] = new Point(x2, y2);
        coords[2] = new Point(x3, y3);
        coords[3] = new Point(x4, y4);
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
        return coords[0].distance(coords[1]) + coords[1].distance(coords[2]) + coords[2].distance(coords[3]) + coords[3].distance(coords[0]);
    }

    @Override
    public double area(){
        double a = coords[0].distance(coords[1]);
        double b = coords[1].distance(coords[2]);
        double c = coords[2].distance(coords[3]);
        double d = coords[3].distance(coords[0]);
        double e = coords[0].distance(coords[2]);

        double p1 = (a+b+e)/2;
        double abc = Math.sqrt( p1*(p1-a)*(p1-b)*(p1-e) );

        double p2 = (c+d+e)/2;
        double adc = Math.sqrt( p2*(p2-c)*(p2-d)*(p2-e) );
        return abc+adc;

    }

    public double diagonal(int n){
        if (n == 0 || n ==2){
            return coords[0].distance(coords[2]);
        }
        else {
            return coords[1].distance(coords[3]);
        }
    }
}
