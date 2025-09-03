package pos.machine;

import java.util.ArrayList;
import java.util.List;

public class ItemsLoader {
    public static List<Item> loadAllItems() {
        Item item1 = new Item("ITEM000000", "Coca-Cola", 3);
        Item item2 = new Item("ITEM000001", "Sprite", 3);
        Item item3 = new Item("ITEM000004", "Battery", 2);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        return items;
    }
}
