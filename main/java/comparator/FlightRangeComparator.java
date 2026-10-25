package comparator;

import entity.Aircraft;

import java.util.Comparator;

public class FlightRangeComparator
        implements Comparator<Aircraft> {

    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        return Integer.compare(
                o1.getFlightRange(),
                o2.getFlightRange());
    }
}