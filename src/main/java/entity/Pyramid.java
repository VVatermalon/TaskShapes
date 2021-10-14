package entity;

import service.impl.PyramidServiceImpl;

import java.util.Arrays;

public class Pyramid {
    private static int count = 0;
    private final int pyramidId;
    private Point[] points;
    private static final PyramidServiceImpl service = new PyramidServiceImpl();

    public Pyramid(Point[] points) {
        pyramidId = count++;
        if(points != null && service.isPyramid(points)) {
            this.points = points.clone();
        }
        else {
            this.points = new Point[]{new Point(-4, -4, 0), new Point(-4, 4, 0),
                    new Point(4, 4, 0), new Point(4, -4, 0), new Point(0, 0, 8)};
        }
    }

    public int getPyramidId() {
        return pyramidId;
    }

    public Point[] getPoints() {
        return points.clone();
    }

    public void setPoints(Point[] points) {
        if(points != null && service.isPyramid(points)) {
            this.points = points.clone();
        }
        else {
            this.points = new Point[]{new Point(-4, -4, 0), new Point(-4, 4, 0),
                    new Point(4, 4, 0), new Point(4, -4, 0), new Point(0, 0, 8)};
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        return string.append("Pyramid{pyramidId=").append(pyramidId)
                .append(", points=").append(Arrays.toString(points))
                .append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;
        Pyramid pyramid = (Pyramid) o;
        return pyramidId == pyramid.pyramidId && Arrays.equals(points, pyramid.points);
    }

    public boolean equalsIgnoreId(Object o) {
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
