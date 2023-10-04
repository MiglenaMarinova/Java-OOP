package vehicle_extended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", getVehicle(scanner));
        vehicleMap.put("Truck", getVehicle(scanner));
        vehicleMap.put("Bus", getVehicle(scanner));

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];
            double argument = Double.parseDouble(commandParts[2]);

            switch (command) {
                case "DriveEmpty":
                    Bus bus = (Bus) vehicleMap.get(vehicleType);
                    System.out.println(bus.driveEmpty(argument));
                    break;
                case "Drive":
                    System.out.println(vehicleMap.get(vehicleType).drive(argument));
                    break;
                case "Refuel":
                    try{
                        vehicleMap.get(vehicleType).refuel(argument);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
        vehicleMap.values().forEach(System.out::println);

    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");
        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption,tankCapacity);
            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, tankCapacity);
            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }

    }
}
