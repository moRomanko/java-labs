package entity;

public class BusinessJet extends Aircraft {

    private boolean vipLounge;

    public BusinessJet(String model,
                       int capacity,
                       double cargoCapacity,
                       int flightRange,
                       double fuelConsumption,
                       boolean vipLounge) {

        super(model,
                capacity,
                cargoCapacity,
                flightRange,
                fuelConsumption);

        this.vipLounge = vipLounge;
    }

    @Override
    public String toString() {

        String vip;
        if (vipLounge) {
            vip = "есть";
        } else {
            vip = "нет";
        }

        return "Самолёт {" + "бизнес-джет, " +
                "модель: '" + super.getModel() + '\'' +
                ", вместимость: " + super.getPassengerCapacity() +
                ", грузоподъемность: " + super.getCargoCapacity() +
                ", дальность полета: " + super.getFlightRange() +
                ", потребление горючего: " + super.getFuelConsumption() +
                ", VIP-лаунж: " + vip +
                '}';
    }
}
