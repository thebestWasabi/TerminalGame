package battle_characters;

import basic_classes.GameCharacter;

public class MainHero extends GameCharacter {

    protected MainHero(String name, int maxHealthPoint, int strength, int dexterity, int attackPower, int gold) {
        super(name, maxHealthPoint, strength, dexterity, attackPower, gold);
    }

    public static MainHero createPlayer(String name) {
        return new MainHero(name, 80, 10, 10, 10, 10);
    }

}
