import characters.GameCharacter;
import characters.battle_characters.Goblin;
import characters.battle_characters.MainHero;
import characters.battle_characters.Scavenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static GameCharacter player = null;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.print("Введите имя своего персонажа: ");

        try {
            characterControl(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void characterControl(String name) throws IOException {

        if (player == null) {
            player = new MainHero(name, 80, 10, 10, 10, 0);
        }

        String command;

        do {
            System.out.printf("""
            \n---%s стоит на городской площади---
            \nВыберите что делать дальше и нажмите enter:
            1. Пойти к городскому торговцу
            2. Пойти в темный лес
            3. Пойти домой (выйти из игры)
            """, name);

            System.out.print("\nПишите свой выбор сюда: ");

            command = reader.readLine();

            switch (command) {
                case "1" -> System.out.println("\nВ городе пока что нет городского торговца");
                case "2" -> goToTheDarkWood();
                case "3" -> System.out.println("Exit");
            }

        } while (!command.equals("3"));
    }

    public static GameCharacter createMonster() {

        if (Math.random() <= 0.5) {
            return new Goblin("Гоблин" , 40, 10, 15, 10, 1);
        } else {
            return new Scavenger("Мародёр" , 60, 15, 10, 10, 2);
        }
    }

    private static void goToTheDarkWood() throws IOException {
        Battle.fight(player, createMonster());
    }
}
