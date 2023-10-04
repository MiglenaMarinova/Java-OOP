package Encapsulation.Exercises.ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double calculateSurfaceArea() {
        double area = 2 * length * width + 2 * length * height + 2 * width * height;
        return area;
    }

    public double calculateLateralSurfaceArea() {
        double lateralArea = 2 * length * height + 2 * width * height;
        return lateralArea;
    }

    public double calculateVolume() {
        double volume = length * width * height;
        return volume;
    }


}
