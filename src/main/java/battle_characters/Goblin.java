package battle_characters;

import basic_classes.GameCharacter;

public class Goblin extends GameCharacter {

    private int poison;

    public Goblin(String name, int maximumHealthPoint, int strength, int dexterity, int attackPower, int gold) {
        super(name, maximumHealthPoint, strength, dexterity, attackPower, gold);
    }

    public void poisonBlade(GameCharacter target) {

    }
}
