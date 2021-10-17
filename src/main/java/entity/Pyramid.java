package entity;

import service.impl.PyramidServiceImpl;

import java.util.Arrays;
import java.util.Objects;

public class Pyramid extends Shape {
    private static int count = 0;
    private Point bottomCenter;
    private Point top;
    private int sideLength;

    public Pyramid(Point bottomCenter, Point top, int sideLength) {
        shapeId = count++;
        this.bottomCenter = bottomCenter;
        this.top = top;
        this.sideLength = sideLength;
    }

    public int getPyramidId() {
        return shapeId;
    }

    public Point getBottomCenter() {
        return bottomCenter;
    }

    public void setBottomCenter(Point bottomCenter) {
        if (bottomCenter != null) {
            this.bottomCenter = bottomCenter;
        }
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        if(top!= null) {
            this.top = top;
        }
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pyramid{");
        sb.append("bottomCenter=").append(bottomCenter);
        sb.append(", top=").append(top);
        sb.append(", sideLength=").append(sideLength);
        sb.append(", shapeId=").append(shapeId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;
        Pyramid pyramid = (Pyramid) o;
        return pyramid.shapeId == shapeId
                && pyramid.sideLength == sideLength
                && bottomCenter.equals(pyramid.bottomCenter)
                && top.equals(pyramid.top);
    }

    public boolean equalsIgnoreId(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pyramid)) return false;
        Pyramid pyramid = (Pyramid) o;
        return pyramid.sideLength == sideLength
                && bottomCenter.equalsIgnoreId(pyramid.bottomCenter)
                && top.equalsIgnoreId(pyramid.top);
    }

    @Override
    public int hashCode() {
        return (bottomCenter.hashCode() + top.hashCode() + sideLength) * shapeId;
    }
}
