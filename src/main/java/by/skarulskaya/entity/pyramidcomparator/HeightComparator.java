package by.skarulskaya.entity.pyramidcomparator;

import by.skarulskaya.entity.Pyramid;

import java.util.Comparator;

public class HeightComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        if(o1 == null || o2 == null) {
            return 0;
        }
        double bottomHeight1 = o1.getBottomCenter().getZ();
        double topHeight1 = o1.getTop().getZ();
        double height1 = Math.abs(bottomHeight1 - topHeight1);
        double bottomHeight2 = o2.getBottomCenter().getZ();
        double topHeight2 = o2.getTop().getZ();
        double height2 = Math.abs(bottomHeight1 - topHeight1);
        return Double.compare(height1, height2);
    }
}