package WorkingWithAbstraction.Exercises.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Card card = Card.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());
        int cardPower = card.getPower() + suit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d", card, suit, cardPower);

    }
}
