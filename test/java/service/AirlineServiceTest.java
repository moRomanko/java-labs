package service;

import entity.Airline;
import entity.CargoPlane;
import entity.PassengerPlane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AirlineServiceTest {

    private Airline airline;
    private AirlineService service;

    @BeforeEach
    void setUp() {

        airline = new Airline();

        airline.addAircraft(
                new PassengerPlane(
                        "B737",
                        180,
                        20,
                        3500,
                        2500,
                        18));

        airline.addAircraft(
                new CargoPlane(
                        "AN124",
                        10,
                        120,
                        4800,
                        7000,
                        1500));

        service = new AirlineService();
    }

    @Test
    void testTotalCapacity() {

        assertEquals(
                190,
                service.calculateTotalCapacity(
                        airline));
    }

    @Test
    void testCargoCapacity() {

        assertEquals(
                140,
                service.calculateTotalCargoCapacity(
                        airline));
    }

    @Test
    void testFindByFuelConsumption() {

        assertEquals(
                1,
                service.findByFuelConsumption(
                        airline,
                        2000,
                        3000).size());
    }
}