package Encapsulation.Exercises.pizzaCalaries;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int numOfTopping = Integer.parseInt(pizzaInput[2]);

        Pizza pizza;
        try{
            pizza = new Pizza(pizzaName, numOfTopping);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        String[] doughInput = scanner.nextLine().split("\\s+");
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double weightInGrams = Double.parseDouble(doughInput[3]);

        try {
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!command.equals("END")){
            String toppingType = command.split("\\s+")[1];
            double weightInGramsTopping = Double.parseDouble(command.split("\\s+")[2]);

            try{
                Topping topping = new Topping(toppingType, weightInGramsTopping);
                pizza.addTopping(topping);
                numOfTopping --;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            if (numOfTopping > 0){
                command = scanner.nextLine();
            }else{
                break;
            }

        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
