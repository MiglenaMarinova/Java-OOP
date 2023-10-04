package WorkingWithAbstraction.Exercises.GreedyTimes;

import java.util.*;

import static WorkingWithAbstraction.Exercises.GreedyTimes.Type.*;

public class Bag {

    private List<Item> items;

    long capacity;

    public Bag(long capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public long getAmountByType(Type type) {
        return items.stream()
                .filter(e -> e.getType().equals(type))
                .mapToLong(Item::getAmount)
                .sum();
    }

    public long getBagAmount() {
        return getAmountByType(GEM) + getAmountByType(CASH) + getAmountByType(GOLD);
    }

    public void addToBag(Item item) {
        long currentAmount = item.getAmount();
        if (currentAmount + getBagAmount() <= capacity) {
            Type type = item.getType();

            switch (type.toString()) {
                case "GOLD":
                    if (isValid(getAmountByType(GOLD) + currentAmount, getAmountByType(GEM), getAmountByType(CASH))) {
                        items.add(item);
                    }
                    break;
                case "GEM":
                    if (isValid(getAmountByType(GOLD), getAmountByType(GEM) + currentAmount, getAmountByType(CASH))){
                        items.add(item);
                    }

                    break;
                case "CASH":
                    if (isValid(getAmountByType(GOLD), getAmountByType(GEM), getAmountByType(CASH) + currentAmount)) {
                        items.add(item);
                    }
                    break;
            }
        }
    }

    public boolean isValid(long goldAmount, long gemAmount, long cashAmount) {
        return (goldAmount >= gemAmount && gemAmount >= cashAmount);
    }

    private void printByGroupType(Type type) {
        Map<String, Long> valueByName = new TreeMap<>();
        items.stream().filter(e -> e.getType().equals(type))
                .forEach(e -> {
                    String name = e.getItemName();
                    valueByName.putIfAbsent(name, 0L);
                    valueByName.put(name, valueByName.get(name) + e.getAmount());
                });
        Map<String, Long> sortetByAmount = new TreeMap<>(Collections.reverseOrder());
        valueByName.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> sortetByAmount.put(e.getKey(), e.getValue()));

        sortetByAmount.forEach((key, value) -> System.out.printf("##%s - %s%n", key, value));
    }

    public void printContent() {
        if (getAmountByType(GOLD) > 0) {
            System.out.printf("<Gold> $%s%n", getAmountByType(GOLD));
            printByGroupType(GOLD);
        }
        if (getAmountByType(GEM) > 0) {
            System.out.printf("<Gem> $%s%n", getAmountByType(GEM));
            printByGroupType(GEM);
        }
        if (getAmountByType(CASH) > 0) {
            System.out.printf("<Cash> $%s%n", getAmountByType(CASH));
            printByGroupType(CASH);
        }
    }
}
