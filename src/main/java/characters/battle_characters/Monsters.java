package characters.battle_characters;

import characters.GameCharacter;

public class Monsters {

    public static GameCharacter createMonster() {

        if (Math.random() <= 0.5) {
            return new Goblin("Гоблин" , 40, 10, 15, 10, 1);
        } else {
            return new Scavenger("Мародёр" , 60, 15, 10, 10, 2);
        }
    }

    private Monsters() {
        throw new IllegalStateException("Utility class");
    }
}
