package WorkingWithAbstraction.Lab.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight ;

    public Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public Point getBottomLeft(){
        return bottomLeft;
    }
    public Point getTopRight(){
        return topRight;
    }
    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }
    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }
    public boolean contains (Point point){
        boolean isInsideX = point.getCoordinateX() >= bottomLeft.getCoordinateX() && point.getCoordinateX() <= topRight.getCoordinateX();
        boolean isInsideY = point.getCoordinateY() >= bottomLeft.getCoordinateY() && point.getCoordinateY() <= topRight.getCoordinateY();
        return isInsideX && isInsideY;
    }
}
