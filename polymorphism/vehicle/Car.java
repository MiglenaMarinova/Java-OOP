package polymorphism.vehicle;


public class Car extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumptionPerOneKm) {
        super(fuelQuantity, fuelConsumptionPerOneKm);
        setFuelConsumptionPerOneKm(getFuelConsumptionPerOneKm() + AC_ADDITIONAL_CONSUMPTION);
    }





}
