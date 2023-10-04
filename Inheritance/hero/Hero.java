package Inheritance.hero;

public class Hero {
    private String username;
    private int level;

    public Hero(String name, int level) {
        this.username = name;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %d",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}