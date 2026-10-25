package comparator;

import entity.Aircraft;
import entity.CargoPlane;
import entity.PassengerPlane;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightRangeComparatorTest {

    @Test
    void compareShouldSortByFlightRange() {

        Aircraft plane1 =
                new PassengerPlane(
                        "Boeing737",
                        180,
                        20,
                        3500,
                        2400,
                        18);

        Aircraft plane2 =
                new CargoPlane(
                        "An124",
                        10,
                        120,
                        5000,
                        7000,
                        1500);

        List<Aircraft> aircrafts =
                new ArrayList<>();

        aircrafts.add(plane2);
        aircrafts.add(plane1);

        aircrafts.sort(new FlightRangeComparator());

        assertEquals(3500,
                aircrafts.get(0).getFlightRange());

        assertEquals(5000,
                aircrafts.get(1).getFlightRange());
    }
}