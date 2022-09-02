package battle_characters;

import basic_classes.GameCharacter;

public interface Fighter {

    void attack(GameCharacter target);
    void blockAction();
    void healing();
}
