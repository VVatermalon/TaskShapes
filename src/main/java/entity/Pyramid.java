package entity;

import java.util.Arrays;

public class Pyramid {
    private static int count = 0;
    private final int pyramidId;
    private Point[] points;

    public Pyramid(Point[] points) {
        pyramidId = count++;
        if(points != null && points.length == 5) {
            this.points = points.clone();
        }
        else { // не хочу отсекать 5 элементов, если их больше, мало ли какая там вершина подразумевалась
            this.points = new Point[] {new Point(-10, 0, 0), new Point(10, 0, 0),
                    new Point(0, -10, 0), new Point(0, 10, 0), new Point(0, 0, 10)};
        }
    }

    public int getPyramidId() {
        return pyramidId;
    }

    public Point[] getPoints() {
        return points.clone();
    }

    public void setPoints(Point[] points) {
        if(points != null && points.length == 5) {
            this.points = points.clone();
        }
        else {
            this.points = new Point[] {new Point(-10, 0, 0), new Point(10, 0, 0),
                    new Point(0, -10, 0), new Point(0, 10, 0), new Point(0, 0, 10)};
        }
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pyramidId=" + pyramidId +
                ", points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;
        Pyramid pyramid = (Pyramid) o;
        return Arrays.equals(points, pyramid.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }
}
