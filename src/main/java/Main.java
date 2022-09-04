import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static basic_classes.Control.characterControl;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
}
