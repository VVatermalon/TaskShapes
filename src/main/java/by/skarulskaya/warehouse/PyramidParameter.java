package by.skarulskaya.warehouse;

public class PyramidParameter {
    private double area;
    private double volume;

    public PyramidParameter(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PyramidParameter{");
        sb.append("area=").append(area);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PyramidParameter)) return false;

        PyramidParameter that = (PyramidParameter) o;

        if (Double.compare(that.area, area) != 0) return false;
        return Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
