package entity;

public class CargoPlane extends Aircraft {

    private double cargoVolume;

    public CargoPlane(String model,
                      int passengerCapacity,
                      double cargoCapacity,
                      int flightRange,
                      double fuelConsumption,
                      double cargoVolume) {

        super(model,
                passengerCapacity,
                cargoCapacity,
                flightRange,
                fuelConsumption);

        this.cargoVolume = cargoVolume;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public String toString() {
        return "Самолёт {" + "грузовой, " +
                "модель: '" + super.getModel() + '\'' +
                ", вместимость: " + super.getPassengerCapacity() +
                ", грузоподъемность: " + super.getCargoCapacity() +
                ", дальность полета: " + super.getFlightRange() +
                ", потребление горючего: " + super.getFuelConsumption() +
                ", вместимость грузового отсека: " + getCargoVolume() +
                '}';
    }
}