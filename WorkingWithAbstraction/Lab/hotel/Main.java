package WorkingWithAbstraction.Lab.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] splitedInput = input.split("\\s+");

        double pricePerDay = Double.parseDouble(splitedInput[0]);
        int days = Integer.parseInt(splitedInput[1]);
        Season season = Season.valueOf(splitedInput[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(splitedInput[3].toUpperCase());

        double holidayPrice = PriceCalculator.calculatePrice(pricePerDay, days, season, discountType);

        System.out.printf("%.2f", holidayPrice);

    }
}
