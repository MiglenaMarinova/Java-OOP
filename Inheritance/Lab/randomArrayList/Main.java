package Inheritance.Lab.randomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();

        randomArrayList.add(11);
        randomArrayList.add(8);
        randomArrayList.add(7);
        randomArrayList.add(9);
        randomArrayList.add(19);

        System.out.println(randomArrayList.getRandomElement());
    }
}
