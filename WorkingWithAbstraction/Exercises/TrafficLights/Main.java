package WorkingWithAbstraction.Exercises.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("\\s+");
        int signalCount = Integer.parseInt(scanner.nextLine());
        int commandLength = command.length;
        List<TrafficLights> trafficLightsList = new ArrayList<>();

//        List<WorkingWithAbstraction.Exercises.TrafficLights> trafficLights = Arrays.stream(command)
//                .map(Color::valueOf)
//                .map(WorkingWithAbstraction.Exercises.TrafficLights::new)
//                .collect(Collectors.toList());

        for (String signal : command){
            Color color = Color.valueOf(signal);
            TrafficLights trafficLights = new TrafficLights(color);
            trafficLightsList.add(trafficLights);
        }
        for (int i = 1; i <= signalCount ; i++) {
            for (TrafficLights trafficLights : trafficLightsList){
                trafficLights.changeColor();
                System.out.print(trafficLights.getColor() + " ");
            }
            System.out.println();
        }



    }
}
