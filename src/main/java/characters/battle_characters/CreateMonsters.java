package characters.battle_characters;

import characters.GameCharacter;

public class CreateMonsters {

    public GameCharacter createMonster() {

        if (Math.random() <= 0.5) {
            return new Goblin("Молодой гоблин", 6, 2, 4, 2, 3);
        } else {
            return new Skeleton("Скелет воин", 8, 6, 4, 2, 4);
        }
    }
}
