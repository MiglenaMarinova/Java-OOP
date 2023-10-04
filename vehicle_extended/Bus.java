package vehicle_extended;

public class Bus extends  Vehicle{

    public static final double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerOneKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerOneKm, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        setFuelConsumptionPerOneKm(getFuelConsumptionPerOneKm() + AC_ADDITIONAL_CONSUMPTION);
        String driveResult = super.drive(distance);
        setFuelConsumptionPerOneKm(getFuelConsumptionPerOneKm() - AC_ADDITIONAL_CONSUMPTION);
        return driveResult;
    }
    public String driveEmpty( double distance){
        return super.drive(distance);
    }
}
