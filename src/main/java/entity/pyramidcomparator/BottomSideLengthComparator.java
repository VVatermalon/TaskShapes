package entity.pyramidcomparator;

import entity.Pyramid;

import java.util.Comparator;

public class BottomSideLengthComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        if(o1 == null || o2 == null) {
            return 0;
        }
        double sideLength1 = o1.getSideLength();
        double sideLength2 = o2.getSideLength();
        return Double.compare(sideLength1, sideLength2);
    }
}
