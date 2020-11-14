package com.company;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket (StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "Shopping basket " + name + " contains " +
                list.size() + " items.  ";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s +="\n\t " + item.getKey() + " " + item.getValue() + " pieces purchased.";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return (s + " \t\t>> Total cost " + (df2.format(totalCost)));
    }
}
