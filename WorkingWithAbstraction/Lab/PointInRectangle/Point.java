package WorkingWithAbstraction.Lab.PointInRectangle;

public class Point {
    private int coordinateX;
    private int coordinateY;

    public Point(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
    public int getCoordinateX(){
        return coordinateX;
    }
    public int getCoordinateY(){
        return coordinateY;
    }
    public void setCoordinateX(int x){
        this.coordinateX = x;
    }
    public void setCoordinateY(int y){
        this.coordinateY = y;
    }
}
