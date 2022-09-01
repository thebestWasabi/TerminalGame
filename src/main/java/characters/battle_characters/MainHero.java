package characters.battle_characters;

import characters.GameCharacter;

public class MainHero extends GameCharacter {

    public MainHero(String name, int maximumHealthPoint, int strength, int dexterity, int attackPower, int gold) {
        super(name, maximumHealthPoint, strength, dexterity, attackPower, gold);
    }

    public static MainHero createPlayer(String name) {
        return new MainHero(name, 80, 10, 10, 10, 0);
    }

}
