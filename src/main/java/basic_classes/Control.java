package basic_classes;

import battle_characters.MainHero;
import battle_characters.Monsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Control {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static GameCharacter player = null;


    private static void navigationMenu() {
        System.out.printf("""
                \n---%s стоит на городской площади---
                \nВыберите что делать дальше и нажмите enter:
                1. Пойти к городскому торговцу
                2. Пойти в темный лес
                3. Пойти домой (выйти из игры)
                """, player.getName());
    }


    public static void characterControl(String name) throws IOException {
        if (player == null) {
            player = MainHero.createPlayer(name);
        }

        String command;
        do {
            navigationMenu();
            System.out.print("\nПишите свой выбор сюда: ");

            command = reader.readLine();
            switch (command) {
                case "1" -> System.out.println("\nВ городе пока что нет городского торговца");
                case "2", "да" -> goToTheDarkWood();
                case "3" -> System.out.println("Exit");
                case "нет" -> navigationMenu();
                default -> System.out.println("Введите корректное значение");
            }
        } while (!command.equals("3"));
    }


    private static void goToTheDarkWood() throws IOException {
        Battle.fight(player, Monsters.createMonster());
    }
}
