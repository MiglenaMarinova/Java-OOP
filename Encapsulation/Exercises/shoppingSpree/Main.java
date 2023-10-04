package Encapsulation.Exercises.shoppingSpree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] people = scanner.nextLine().split(";");
        Map<String, Person> personMap = new LinkedHashMap<>();

        for (String personInput : people) {
            String[] personData = personInput.split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(personName, personMoney);
                personMap.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] products = scanner.nextLine().split(";");
        Map<String, Product> productMap = new LinkedHashMap<>();

        for (String productInput : products) {
            String[] productData = productInput.split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(productName, productCost);
                productMap.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String[] commandParts = command.split("\\s+");
            String personName = commandParts[0];
            String productName = commandParts[1];

            Person bayer = personMap.get(personName);
            Product product = productMap.get(productName);

            try {
                bayer.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        personMap.values().forEach(System.out::println);

    }
}
