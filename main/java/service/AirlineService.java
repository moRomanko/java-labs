package service;

import entity.Aircraft;
import entity.Airline;

import java.util.List;

public class AirlineService {

    public int calculateTotalCapacity(Airline airline) {

        return airline.getAircrafts()
                .stream()
                .mapToInt(Aircraft::getPassengerCapacity)
                .sum();
    }

    public double calculateTotalCargoCapacity(
            Airline airline) {

        return airline.getAircrafts()
                .stream()
                .mapToDouble(Aircraft::getCargoCapacity)
                .sum();
    }

    public List<Aircraft> findByFuelConsumption(
            Airline airline,
            double min,
            double max) {

        return airline.getAircrafts()
                .stream()
                .filter(a ->
                        a.getFuelConsumption() >= min
                                && a.getFuelConsumption() <= max)
                .toList();
    }
}