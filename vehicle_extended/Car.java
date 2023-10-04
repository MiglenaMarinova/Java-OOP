package vehicle_extended;


public class Car extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumptionPerOneKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerOneKm, tankCapacity);
        setFuelConsumptionPerOneKm(getFuelConsumptionPerOneKm() + AC_ADDITIONAL_CONSUMPTION);
    }





}
