package inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}
