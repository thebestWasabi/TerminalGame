import characters.GameCharacter;
import characters.battle_characters.Goblin;
import characters.battle_characters.MainHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void fight(GameCharacter hero, GameCharacter monster) throws IOException {

        System.out.printf("""
                                                
                        %s начинает свое путешествие.
                        Как только он заходит в лес, то сразу же попадает в засаду, которую устроил %s.
                        """,
                hero.getName(),
                monster.getName()
        );

        while (true) {

            hero.blockReset(); // сразу, на всякий случай, скидываю блок с предидущего хода (даже если его не было)

            System.out.printf("\n\nХод героя: %s\n", hero.getName());

            String input = READER.readLine();

            if (input.equals("/атака")) {
                hero.attack(monster);
                if (monster.getHealthPoint() <= 0) {

                    System.out.printf("""
                                                                        
                                    \n%s убил персонажа '%s' и выиграл бой
                                                                        
                                    """,
                            hero.getName(),
                            monster.getName()
                    );
                    break;
                }

            } else if (input.equals("/блок")) {
                hero.blockAction();
            }

            System.out.printf("\n\nХод противника: %s\n", monster.getName());
            monster.blockReset(); // монстр тоже сбрасывает блок в начале каждого хода

            if (Math.random() < 0.5) {
                monster.attack(hero);
                if (hero.getHealthPoint() <= 0) {

                    System.out.printf("""
                                                                        
                                    \n'%s' убил персонажа %s и выиграл бой
                                                                        
                                    """,
                            monster.getName(),
                            hero.getName()
                    );
                    break;
                }
            } else {
                monster.blockAction();
            }

        }
    }
}
