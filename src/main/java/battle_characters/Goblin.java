package battle_characters;

import basic_classes.GameCharacter;

public class Goblin extends GameCharacter {

    private int poison;

    public Goblin(String name, int maxHealthPoint, int strength, int dexterity, int attackPower, int xp, int gold) {
        super(name, maxHealthPoint, strength, dexterity, attackPower, xp, gold);
    }

    public void poisonBlade(GameCharacter target) {

    }
}
