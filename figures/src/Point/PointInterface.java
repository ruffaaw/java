package Point;

public interface PointInterface {
    void setX(double x);
    void setY(double y);
    void setPoint(double x, double y);
    void setPoint(Point pt);
    double getX();
    double getY();
    double[] getPoint();
    double distance(Point pt);
}
