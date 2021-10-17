package entity;

import java.util.Objects;

public class Point extends Shape {
    private static int count = 0;
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        shapeId = count++;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getPointId() {
        return shapeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Point{pointId=").append(shapeId)
                .append(", x=").append(x)
                .append(", y=").append(y)
                .append(", z=").append(z)
                .append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return shapeId == point.shapeId && x == point.x && y == point.y && z == point.z;
    }

    public boolean equalsIgnoreId(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        return (int)Math.round(x * y * z * shapeId);
    }
}
