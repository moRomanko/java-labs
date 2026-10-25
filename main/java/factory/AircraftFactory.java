package factory;

import entity.Aircraft;
import entity.BusinessJet;
import entity.CargoPlane;
import entity.PassengerPlane;

public class AircraftFactory{

    public Aircraft createAircraft(String[] data) {

        String type = data[0];

        return switch (type.toUpperCase()) {

            case "PASSENGER" ->
                    new PassengerPlane(
                            data[1],
                            Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]),
                            Integer.parseInt(data[4]),
                            Double.parseDouble(data[5]),
                            Integer.parseInt(data[6]));

            case "CARGO" ->
                    new CargoPlane(
                            data[1],
                            Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]),
                            Integer.parseInt(data[4]),
                            Double.parseDouble(data[5]),
                            Double.parseDouble(data[6]));

            case "BUSINESS" ->
                    new BusinessJet(
                            data[1],
                            Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]),
                            Integer.parseInt(data[4]),
                            Double.parseDouble(data[5]),
                            Boolean.parseBoolean(data[6]));

            default ->
                    throw new IllegalArgumentException(
                            "Неизвестный тип: " + type);
        };
    }
}