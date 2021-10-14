package entity;

import java.util.Objects;

public class Point {
    private static int count = 0;
    private final int pointId;
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        pointId = count++;
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
        return pointId;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        return string.append("Point{pointId=").append(pointId)
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
        return pointId == point.pointId && x == point.x && y == point.y && z == point.z;
    }

    public boolean equalsIgnoreId(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        return (int)Math.round(x * y * z);
    }
}
