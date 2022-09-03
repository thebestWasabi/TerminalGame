package inventory;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Weapon extends Item {

    private int weaponDamage;

    public Weapon(String name, int weaponDamage, int weight) {
        super(name, weight);
        this.weaponDamage = weaponDamage;
    }

    public void swordWeapon() {
        List<Weapon> swords = new ArrayList<>();
        swords.add(new Weapon("Стальной короткий меч", 5, 1));
        swords.add(new Weapon("Стальной длинный меч", 10, 2));
    }
}
