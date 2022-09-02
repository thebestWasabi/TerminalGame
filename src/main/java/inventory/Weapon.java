package inventory;

public class Weapon extends Item {

    private int weaponDamage;


    public Weapon(String name, int weaponDamage, int weight) {
        super(name, weight);
        this.weaponDamage = weaponDamage;
    }
}
