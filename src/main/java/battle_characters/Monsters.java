package battle_characters;

import basic_classes.GameCharacter;

public class Monsters {

    private Monsters() {
        throw new IllegalStateException("Utility class");
    }

    public static GameCharacter createMonster() {

        if (Math.random() <= 0.5) {
            return new Goblin("Гоблин", 25, 4, 6, 5, 50, 1);
        } else {
            return new Scavenger("Мародёр", 28, 6, 4, 5, 60, 2);
        }
    }

}
