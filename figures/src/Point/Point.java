package Point;

public class Point implements PointInterface {
    protected double [] point = new double[2];

    public Point(double x, double y){
       point[0] = x;
       point[1] = y;
    }

    public void setX(double x){
        point[0] = x;
    }

    public void setY(double y){
        point[1] = y;
    }

    @Override
    public void setPoint(double x, double y){
        setX(x);
        setY(y);
    }

    @Override
    public void setPoint(Point pt){
        pt.setX(point[0]);
        pt.setY(point[1]);
    }

    public double getX(){
        return point[0];
    }

    public double getY(){
        return point[1];
    }

    @Override
    public double[] getPoint(){
        return point;
    }

    public double distance(Point pt){
        return Math.sqrt((point[0] - pt.point[0])*(point[0] - pt.point[0]) + (point[1] - pt.point[1])*(point[1] - pt.point[1]));
    }

}

