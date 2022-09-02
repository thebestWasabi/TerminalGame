package inventory;

public class Wallet extends Item {

    private int gold;
    private int silver;
    private int cooper;


    public Wallet(String name, int weight, int gold, int silver, int cooper) {
        super(name, weight);
        this.gold = gold;
        this.silver = silver;
        this.cooper = cooper;
    }
}
