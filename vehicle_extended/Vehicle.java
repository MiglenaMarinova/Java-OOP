package vehicle_extended;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerOneKm;
    private double tankCapacity;

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public Vehicle(double fuelQuantity, double fuelConsumptionPerOneKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerOneKm = fuelConsumptionPerOneKm;
        this.tankCapacity = tankCapacity;
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
        if (litters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity + litters > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity +=litters;
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
