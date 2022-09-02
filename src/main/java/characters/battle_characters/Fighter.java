package characters.battle_characters;

import characters.GameCharacter;

public interface Fighter {

    void attack(GameCharacter target);
    void blockAction();
    void healing();
}
