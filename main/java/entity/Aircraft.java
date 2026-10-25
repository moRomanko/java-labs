package entity;

public abstract class Aircraft {

    private String model;
    private int passengerCapacity;
    private double cargoCapacity;
    private int flightRange;
    private double fuelConsumption;

    public Aircraft(String model,
                    int passengerCapacity,
                    double cargoCapacity,
                    int flightRange,
                    double fuelConsumption) {

        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(int flightRange) {
        this.flightRange = flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Самолёт {" +
                "модель: '" + model + '\'' +
                ", вместимость: " + passengerCapacity +
                ", грузоподъемность: " + cargoCapacity +
                ", дальность полета: " + flightRange +
                ", потребление горючего: " + fuelConsumption +
                '}';
    }

}
