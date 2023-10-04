package vehicle_extended;

public class Truck extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 1.6;
    public static final double FUEL_AFTER_REDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumptionPerOneKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerOneKm, tankCapacity);
        setFuelConsumptionPerOneKm(getFuelConsumptionPerOneKm() + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters * FUEL_AFTER_REDUCTION);

    }
}



