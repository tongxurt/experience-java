package design.pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<IItem> items = new ArrayList<IItem>();

    public void addItem(IItem item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (IItem item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (IItem item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}