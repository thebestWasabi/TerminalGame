import characters.GameCharacter;
import characters.battle_characters.CreateMonsters;
import characters.battle_characters.MainHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static BufferedReader reader;
    static Battle battle = null;

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {

        try {
            characterControl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void characterControl() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String command;



        do {
            System.out.print("""
                    Лука стоит на городской площади.
                    
                    Выберите что делать дальше и нажмите enter:
                    1. Пойти к городскому торговцу
                    2. Пойти в темный лес
                    3. Пойти домой (выйти из игры)
                    
                    Пишите свой выбор сюда:""");

            command = reader.readLine();

            switch (command) {
                case "1" -> System.out.println("\nВ городе пока что нет городского торговца\n");
                case "2" -> goToTheDarkWood();
                case "3" -> System.out.println("Exit");
            }

        } while (!command.equals("3"));
    }

    private static void goToTheDarkWood() throws IOException {
        battle.fight();
    }
}
