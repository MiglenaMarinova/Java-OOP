package InterfacesAndAbstraktions.Exercises.birthdayCelebrations;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> withBirtday = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] inputParts = input.split("\\s+");
            String type = inputParts[0];
            switch (type) {
                case "Citizen":
                    String personName = inputParts[1];
                    int personAge = Integer.parseInt(inputParts[2]);
                    String personId = inputParts[3];
                    String personBDay = inputParts[4];
                    Citizen citizen = new Citizen(personName, personAge, personId, personBDay);
                    withBirtday.add(citizen);
                    break;
                case "Pet":
                    String petName = inputParts[1];
                    String petBday = inputParts[2];
                    Pet pet = new Pet(petName, petBday);
                    withBirtday.add(pet);
                case "Robot":
                    String model = inputParts[1];
                    String robotId = inputParts[2];
                    Robot robot = new Robot(robotId, model);
                    break;

            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean isExisting = false;

        for(Birthable birthable : withBirtday){
            if (birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
                isExisting = true;
            }
        }
        if (!isExisting){
            System.out.println("<no output>");
        }
    }

}
