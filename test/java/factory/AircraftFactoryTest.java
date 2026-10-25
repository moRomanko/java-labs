package factory;

import entity.Aircraft;
import entity.BusinessJet;
import entity.CargoPlane;
import entity.PassengerPlane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftFactoryTest {

    private final AircraftFactory factory =
            new AircraftFactory();

    @Test
    void createPassengerAircraft() {

        String[] data = {
                "PASSENGER",
                "Boeing737",
                "180",
                "20",
                "3500",
                "2400",
                "18"
        };

        Aircraft aircraft =
                factory.createAircraft(data);

        assertInstanceOf(
                PassengerPlane.class,
                aircraft);

        assertEquals(
                "Boeing737",
                aircraft.getModel());
    }

    @Test
    void createCargoAircraft() {

        String[] data = {
                "CARGO",
                "An124",
                "10",
                "120",
                "5000",
                "7000",
                "1500"
        };

        Aircraft aircraft =
                factory.createAircraft(data);

        assertInstanceOf(
                CargoPlane.class,
                aircraft);
    }

    @Test
    void createBusinessAircraft() {

        String[] data = {
                "BUSINESS",
                "Gulfstream",
                "12",
                "5",
                "7000",
                "1400",
                "true"
        };

        Aircraft aircraft =
                factory.createAircraft(data);

        assertInstanceOf(
                BusinessJet.class,
                aircraft);
    }

}