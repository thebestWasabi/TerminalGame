import characters.GameCharacter;
import characters.battle_characters.Goblin;
import characters.battle_characters.MainHero;
import characters.battle_characters.Skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader;
    static GameCharacter player = null;
    static Battle battle = null;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите имя своего персонажа: ");

        try {
            characterControl(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void characterControl(String string) throws IOException {

        if (player == null) {
            player = new MainHero(string, 10, 2, 2, 2, 0);
        }

        do {
            System.out.print("""
                    Лука стоит на городской площади.
                                        
                    Выберите что делать дальше и нажмите enter:
                    1. Пойти к городскому торговцу
                    2. Пойти в темный лес
                    3. Пойти домой (выйти из игры)
                                        
                    Пишите свой выбор сюда:""");

            String command = reader.readLine();

            switch (command) {
                case "1" -> System.out.println("\nВ городе пока что нет городского торговца\n");
                case "2" -> goToTheDarkWood();
                case "3" -> System.out.println("Exit");
            }

        } while (!string.equals("3"));
    }

    public static GameCharacter createMonster() {

        if (Math.random() <= 0.5) {
            return new Goblin("Молодой гоблин", 6, 2, 4, 2, 3);
        } else {
            return new Skeleton("Скелет воин", 8, 2, 4, 2, 4);
        }
    }

    private static void goToTheDarkWood() throws IOException {
        battle.fight(player, createMonster());
    }


}
