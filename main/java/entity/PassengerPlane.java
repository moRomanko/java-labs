package entity;

public class PassengerPlane extends Aircraft {

    private final int businessClassSeats;

    public PassengerPlane(String model,
                          int passengerCapacity,
                          double cargoCapacity,
                          int flightRange,
                          double fuelConsumption,
                          int businessClassSeats) {

        super(model,
                passengerCapacity,
                cargoCapacity,
                flightRange,
                fuelConsumption);

        this.businessClassSeats = businessClassSeats;
    }

    public int getBusinessClassSeats() {
        return businessClassSeats;
    }

    @Override
    public String toString() {
        return "Самолёт {" + "пассажирский, " +
                "модель: '" + super.getModel() + '\'' +
                ", вместимость: " + super.getPassengerCapacity() +
                ", грузоподъемность: " + super.getCargoCapacity() +
                ", дальность полета: " + super.getFlightRange() +
                ", потребление горючего: " + super.getFuelConsumption() +
                ", сидений бизнес-класса: " + getBusinessClassSeats() +
                '}';
    }
}
