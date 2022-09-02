package inventory;

public abstract class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    Weapon sword1 = new Weapon("Стальной короткий меч", 5, 1);
    Weapon sword2 = new Weapon("Стальной длинный меч", 10, 2);
}
