package entity;

import java.util.Objects;

public class Point {
    private static int count = 0;
    private final int pointId;
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
        pointId = count++;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getPointId() {
        return pointId;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointId=" + pointId +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && z == point.z;
    }

    @Override
    public int hashCode() {
        return x*y*z;
    }
}
