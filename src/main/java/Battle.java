import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {

    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void fight() throws IOException {

        MainHero hero = new MainHero("Лука", 10, 5, 5, 2, 0);
        Goblin monster = new Goblin("Гоблин", 10, 5, 5, 2, 2);

        System.out.printf(
                "%s начинает свое путешествие.\n" +
                        "Как только он заходит в лес, то сразу же попадает в засаду, которую устроил %s.",
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

                    System.out.printf(
                            "\n\n%s убил персонажа '%s' и выиграл бой",
                            hero.getName(),
                            monster.getName()
                    );
                    break;
                }

            } else if (input.equals("/блок")) {
                hero.blockAction();
            }

            System.out.printf(
                    "\n\nХод противника: %s\n",
                    monster.getName()
            );

            monster.attack(hero);

            if (hero.getHealthPoint() <= 0) {
                System.out.printf(
                        "\n\n'%s' убил персонажа %s и выиграл бой",
                        monster.getName(),
                        hero.getName()
                );
                break;
            }

        }
    }
}
