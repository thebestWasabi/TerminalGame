package inventory;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

    public void swords() {
        Sword sword1 = new Sword("Стальной меч", 4);
        Sword sword2 = new Sword("Стальной меч +1", 6);


        List<Sword> swords = new ArrayList<>();
        swords.add(sword1);
        swords.add(sword2);
    }

}
