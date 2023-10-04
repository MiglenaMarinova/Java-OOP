package Encapsulation.Exercises.shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct (Product product){
        if (money < product.getCost()){
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }else {
            products.add(product);
            money -= product.getCost();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name).append(" - ");
        if (products.isEmpty()){
            output.append("Nothing bought");
        }else {
            output.append(String.join(", ", products.stream().map(Product::getName).collect(Collectors.toList())));
        }
        return output.toString();
    }
}
