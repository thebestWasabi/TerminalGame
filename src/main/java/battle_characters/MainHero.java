package battle_characters;

import basic_classes.GameCharacter;
import inventory.Sword;

import java.util.ArrayList;
import java.util.List;

public class MainHero extends GameCharacter {


    protected MainHero(String name, int maxHealthPoint, int strength, int dexterity, int attackPower, List<Sword> swords, int gold) {
        super(name, maxHealthPoint, strength, dexterity, attackPower, swords, gold);
    }

    public static MainHero createPlayer(String name) {
        return new MainHero(name, 80, 10, 10, 10, new ArrayList<Sword>(), 10);
    }

}
