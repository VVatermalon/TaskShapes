package entity;

import observer.Observable;
import observer.Observer;
import observer.PyramidEvent;
import observer.impl.PyramidObserver;
import service.impl.PyramidServiceImpl;
import warehouse.WareHouse;

import java.util.Arrays;
import java.util.Objects;

public class Pyramid extends Shape implements Observable {
    private Point bottomCenter;
    private Point top;
    private int sideLength;
    private Observer observer;

    public Pyramid(int shapeId, Point bottomCenter, Point top, int sideLength) {
        this.shapeId = shapeId;
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
            notifyObservers();
        }
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        if(top!= null) {
            this.top = top;
            notifyObservers();
        }
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength > 0) {
            this.sideLength = sideLength;
            notifyObservers();
        }
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

    @Override
    public void attach() {
        if(observer == null) {
            observer = new PyramidObserver();
            //WareHouse.getInstance().putParameters(shapeId, );
        }
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            PyramidEvent event = new PyramidEvent(this);
            observer.parameterChanged(event);
        }
    }
}
