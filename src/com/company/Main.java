package com.company;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("plane toy", 3.85, 3);
        stockList.addStock(temp);
        temp = new StockItem("spoon", 0.02, 16);
        stockList.addStock(temp);
        temp = new StockItem("spoon", 0.7, 100);
        stockList.addStock(temp);
        temp = new StockItem("phone", 55.10, 1);
        stockList.addStock(temp);
        temp = new StockItem("vase", 6.72, 7);
        stockList.addStock(temp);

//        System.out.println(stockList);
//        for (String s : stockList.Items().keySet() ) {
//            System.out.println(s);
//     }

        System.out.println(stockList + "\n\n");

        Basket adisBasket = new Basket("Adrian");
        sellItem(adisBasket, "spoon", 30);
        System.out.println(adisBasket);

        sellItem(adisBasket, "plane toy", 1);
        sellItem(adisBasket, "asdasd", 100);
        sellItem(adisBasket, "vase", 2);
        sellItem(adisBasket, "phone", 1);
        System.out.println(adisBasket);

        // access objects from collections
        stockList.Items().get("spoon").adjustStock(3000);
        stockList.get("spoon").adjustStock(-1500);

        System.out.println("\n\n" + stockList + "\n\n");

        for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }


    }

    public static int sellItem (Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
