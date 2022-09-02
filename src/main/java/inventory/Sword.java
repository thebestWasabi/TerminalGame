package inventory;

public class Sword {

    private String name;
    private int damage;

    public Sword(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
