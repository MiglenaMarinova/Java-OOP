package WorkingWithAbstraction.Lab.hotel;

public enum Season {
    SUMMER("Summer", 4),
    AUTUMN("Autumn", 1),
    WINTER ("Winter",3 ),
    SPRING("Spring", 2);

    private String name;
    private int value;

    Season(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
