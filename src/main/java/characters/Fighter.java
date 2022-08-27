package characters;

import characters.battle_characters.GameCharacter;

public interface Fighter {

    void attack(GameCharacter target);
    void blockAction();
    void healing();
}
