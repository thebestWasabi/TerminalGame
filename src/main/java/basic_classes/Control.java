package basic_classes;

import battle_characters.MainHero;
import battle_characters.Monsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Control {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static GameCharacter player = null;

    public static void characterControl(String name) throws IOException {

        if (player == null) {
            player = MainHero.createPlayer(name);
        }

        String command;

        do {
            System.out.printf("""
                                        
                    ---%s стоит на городской площади---
                                        
                    Выберите что делать дальше и нажмите enter:
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
                default -> System.out.println("Введите корректное значение");
            }

        } while (!command.equals("3"));
    }

    private static void goToTheDarkWood() throws IOException {
        Battle.fight(player, Monsters.createMonster());
    }
}