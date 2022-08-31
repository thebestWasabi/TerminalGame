import characters.GameCharacter;
import characters.battle_characters.MainHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void fight(GameCharacter hero, GameCharacter enemy) throws IOException {

        System.out.printf("""
                        \n%s начинает свое путешествие.
                        Как только он заходит в лес, то сразу же попадает в засаду, которую устроил %s.
                        """, hero.getName(), enemy.getName());

        while (true) {

            System.out.printf("\n---Ход героя: %s---\n", hero.getName());
            hero.blockReset();  // сразу, на всякий случай, скидываю блок с предидущего хода (даже если его не было)

            String input = reader.readLine();

            if (input.equals("/атака")) {
                hero.attack(enemy);

                if (enemy.getHealthPoint() <= 0) {
                    System.out.printf("\n\n%s убил персонажа '%s' и выиграл бой\n",
                            hero.getName(),
                            enemy.getName()
                    );
                    break;
                }

            } else if (input.equals("/блок")) {
                hero.blockAction();
            } else if (input.equals("/зелье")) {
                hero.healing();
            }

            System.out.printf("\n\n---Ход противника: %s---\n", enemy.getName());
            enemy.blockReset();   // монстр тоже сбрасывает блок в начале каждого хода

            if (Math.random() < 0.7) {
                System.out.println("/атака");
                enemy.attack(hero);

                if (hero.getHealthPoint() <= 0) {
                    System.out.printf("\n\n%s убил персонажа '%s' и выиграл бой\n",
                            enemy.getName(),
                            hero.getName()
                    );
                    break;
                }

            } else {
                System.out.println("/блок");
                enemy.blockAction();
            }

        }
    }
}
