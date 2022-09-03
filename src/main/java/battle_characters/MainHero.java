package battle_characters;

import basic_classes.GameCharacter;

public class MainHero extends GameCharacter {

    public MainHero(String name, int maxHealthPoint, int strength, int dexterity, int attackPower, int xp, int gold) {
        super(name, maxHealthPoint, strength, dexterity, attackPower, xp, gold);
    }

    public static MainHero createPlayer(String name) {
        return new MainHero(name, 80, 10, 10, 10, 0, 10);
    }

}
