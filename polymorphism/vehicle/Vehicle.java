package polymorphism.vehicle;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerOneKm;

    public Vehicle(double fuelQuantity, double fuelConsumptionPerOneKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerOneKm = fuelConsumptionPerOneKm;
    }

    public String drive(double distance) {
        double neededFuel = distance * getFuelConsumptionPerOneKm();
        if (neededFuel > getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - neededFuel);
        DecimalFormat df = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",this.getClass().getSimpleName(), df.format(distance));
    }
    public void refuel(double litters){
        this.setFuelQuantity(this.getFuelQuantity() + litters );
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionPerOneKm() {
        return fuelConsumptionPerOneKm;
    }

    public void setFuelConsumptionPerOneKm(double fuelConsumptionPerOneKm) {
        this.fuelConsumptionPerOneKm = fuelConsumptionPerOneKm;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
