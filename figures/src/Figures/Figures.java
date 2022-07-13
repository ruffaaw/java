package Figures;

import Point.Point;
import Triangle.Triangle;
import Quadrangle.Quadrangle;
import Sort.Sort;

import java.util.Arrays;

public class Figures {
    public static void main(String[] args) {
    //Points
    Point pt1 = new Point(1,2);
    Point pt2 = new Point(2,-3);
    System.out.println("Points:\nP1 = "+Arrays.toString(pt1.getPoint())+"\tP2 = "+Arrays.toString(pt2.getPoint()));
    System.out.println("Coordinate y of the point P1: "+pt1.getY());
    System.out.println("The distance between P1 and P2: "+pt1.distance(pt2));
    pt2.setPoint(pt1);
    System.out.println("P1 after update to P2: "+Arrays.toString(pt1.getPoint()));

    //Triangles
    System.out.println("\n");
    Triangle [] tr = new Triangle[3];
    Triangle tr1 = new Triangle(0,0,4,0,4,3);
    Triangle tr2 = new Triangle(-1,0,1,-1,10,4);
    Triangle tr3 = new Triangle(1,2,0,4,-3,-3);
    tr[0] = tr1;
    tr[1] = tr2;
    tr[2] = tr3;
    System.out.println("Triangle:\nA: "+Arrays.toString(tr1.getCoords(0).getPoint())+ "\tB: "+Arrays.toString(tr1.getCoords(1).getPoint())+"\tC: "+Arrays.toString(tr1.getCoords(2).getPoint()));
    System.out.println("B = "+Arrays.toString(tr1.getCoords(1).getPoint()));
    System.out.println("Perimeter = "+tr1.perimeter()+"\tArea = "+ tr1.area()+"\tHeight from coordinate A"+tr1.height(0));
    tr1.setCoords(2,-3,0);
    System.out.println("Triangle after uptade: "+Arrays.toString(tr1.getCoords(0).getPoint())+Arrays.toString(tr1.getCoords(1).getPoint())+Arrays.toString(tr1.getCoords(2).getPoint()));
    Sort.sortTriangles(tr);
    System.out.println("Triangles after sorting according to area:");
    System.out.println("A: "+Arrays.toString(tr[0].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(tr[0].getCoords(1).getPoint())+"\tC: "+Arrays.toString(tr[0].getCoords(2).getPoint()) + "\tArea = " + tr[0].area());
    System.out.println("A: "+Arrays.toString(tr[1].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(tr[1].getCoords(1).getPoint())+"\tC: "+Arrays.toString(tr[1].getCoords(2).getPoint()) + "\tArea = " + tr[1].area());
    System.out.println("A: "+Arrays.toString(tr[2].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(tr[2].getCoords(1).getPoint())+"\tC: "+Arrays.toString(tr[2].getCoords(2).getPoint()) + "\tArea = " + tr[2].area());

    //Quadrangles
    System.out.println("\n");
    Quadrangle [] qr = new Quadrangle[3];
    Quadrangle qr1 = new Quadrangle(0,0,4,0,4,3,0,5);
    Quadrangle qr2 = new Quadrangle(-8,-3,0,-3,-3,0,5,0);
    Quadrangle qr3 = new Quadrangle(-1,-2,3,-3,3,4,-1,2);
    qr[0] = qr1;
    qr[1] = qr2;
    qr[2] = qr3;
    System.out.println("Quadrangle\nA: "+Arrays.toString(qr1.getCoords(0).getPoint())+ "\tB: "+Arrays.toString(qr1.getCoords(1).getPoint())+"\tC: "+Arrays.toString(qr1.getCoords(2).getPoint())+"\tD: "+Arrays.toString(qr1.getCoords(3).getPoint()));
    System.out.println("B = "+Arrays.toString(qr1.getCoords(1).getPoint()));
    System.out.println("Perimeter = "+qr1.perimeter()+"\tArea = "+ qr1.area()+"\tDiagonal form coordinate A to C: "+qr1.diagonal(0));
    qr1.setCoords(2,-3,0);
    System.out.println("Quadrangle after update: A: "+Arrays.toString(qr1.getCoords(0).getPoint())+ "\tB: "+Arrays.toString(qr1.getCoords(1).getPoint())+"\tC: "+Arrays.toString(qr1.getCoords(2).getPoint())+"\tD: "+Arrays.toString(qr1.getCoords(3).getPoint()));
    Sort.sortQuadrangles(qr);
    System.out.println("Quadrangles after sorting according to area:");
    System.out.println("A: "+Arrays.toString(qr[0].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(qr[0].getCoords(1).getPoint())+"\tC: "+Arrays.toString(qr[0].getCoords(2).getPoint()) + "\tD:"+Arrays.toString(qr[0].getCoords(3).getPoint())+"\tArea = " + qr[0].area());
    System.out.println("A: "+Arrays.toString(qr[1].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(qr[1].getCoords(1).getPoint())+"\tC: "+Arrays.toString(qr[1].getCoords(2).getPoint()) + "\tD:"+Arrays.toString(qr[1].getCoords(3).getPoint())+"\tArea = " + qr[1].area());
    System.out.println("A: "+Arrays.toString(qr[2].getCoords(0).getPoint())+ "\tB: "+Arrays.toString(qr[2].getCoords(1).getPoint())+"\tC: "+Arrays.toString(qr[2].getCoords(2).getPoint()) + "\tD:"+Arrays.toString(qr[2].getCoords(3).getPoint())+"\tArea = " + qr[2].area());

    }
}
