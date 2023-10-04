package WorkingWithAbstraction.Exercises.JadiGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimestions[0];
        int cols = dimestions[1];

        int[][] galaxy = new int[rows][cols];

        fillInGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long sumStarsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPositions = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilPositions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evilPositions[0];
            int colEvil = evilPositions[1];

            while (rowEvil >= 0 && colEvil >= 0) {
                if ( rowEvil < galaxy.length &&  colEvil < galaxy[0].length) {
                    galaxy[rowEvil][colEvil] = 0;
                }
                rowEvil--;
                colEvil--;
            }
            int rowJedi = jediPositions[0];
            int colJedi = jediPositions[1];

            while (rowJedi >= 0 && colJedi < galaxy[1].length) {
                if (rowJedi < galaxy.length && colJedi >= 0 && colJedi < galaxy[0].length) {
                    sumStarsCollected += galaxy[rowJedi][colJedi];
                }
                colJedi++;
                rowJedi--;
            }
            command = scanner.nextLine();
        }

        System.out.println(sumStarsCollected);


    }

    private static void fillInGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }
}
