import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {

        try {
            Battle.fight();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
