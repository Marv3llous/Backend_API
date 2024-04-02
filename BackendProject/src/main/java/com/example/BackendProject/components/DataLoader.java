package com.example.BackendProject.components;

import com.example.BackendProject.models.*;
import com.example.BackendProject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    SupermarketRepository supermarketRepository;

    @Autowired
    OrderedItemRepository orderedItemRepository;
    @Autowired
    OrderRepository orderRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception{

        // Items
        Item milk = new Item("Semi-skimmed milk", ProductType.DAIRY);
        itemRepository.save(milk);
        Item carrot = new Item("Carrot", ProductType.FRUITANDVEG);
        itemRepository.save(carrot);
        Item chocolate = new Item("Lindt Chocolate Bar", ProductType.DAIRY);
        itemRepository.save(chocolate);
        Item bread = new Item("Whole Wheat Bread", ProductType.BAKERY);
        itemRepository.save(bread);
        Item apple = new Item("Apple", ProductType.FRUITANDVEG);
        itemRepository.save(apple);
        Item chicken = new Item("Chicken Breast", ProductType.MEAT);
        itemRepository.save(chicken);
        Item rice = new Item("Ristorante Frozen Pizza", ProductType.FROZEN);
        itemRepository.save(rice);
        Item tomato = new Item("Tomato", ProductType.FRUITANDVEG);
        itemRepository.save(tomato);

        // Stock
        Stock stock1 = new Stock(milk, 50, "11/03/2024", 5);
        stockRepository.save(stock1);
        Stock stockmilk2 = new Stock(milk, 60, "14/03/2024", 5);
        stockRepository.save(stockmilk2);
        Stock stock2 = new Stock(carrot, 100, "15/03/2024", 4);
        stockRepository.save(stock2);
        Stock stock3 = new Stock(chocolate, 75, "30/09/2024", 20);
        stockRepository.save(stock3);
        Stock stock4 = new Stock(bread, 30, "20/04/2024", 10);
        stockRepository.save(stock4);
        Stock stock5 = new Stock(apple, 200, "05/04/2024", 15);
        stockRepository.save(stock5);
        Stock stock6 = new Stock(chicken, 80, "25/04/2024", 18);
        stockRepository.save(stock6);
        Stock stock7 = new Stock(rice, 40, "10/04/2024", 12);
        stockRepository.save(stock7);
        Stock stock8 = new Stock(tomato, 150, "22/04/2024", 6);
        stockRepository.save(stock8);

        // Supermarkets
        Supermarket tesco = new Supermarket("Tesco", "Portugal");
        supermarketRepository.save(tesco);
        Supermarket morrisons = new Supermarket("Morrisons", "London");
        supermarketRepository.save(morrisons);
        Supermarket sainsburys = new Supermarket("Sainsburys", "Bristol");
        supermarketRepository.save(sainsburys);
        Supermarket lidl = new Supermarket("Lidl", "Berlin");
        supermarketRepository.save(lidl);
        Supermarket waitrose = new Supermarket("Waitrose", "Glasgow");
        supermarketRepository.save(waitrose);

        // Orders
        Order order1 = new Order(OrderStatus.DELIVERED, tesco);
        OrderedItem item1 = new OrderedItem(order1, stock8, 25);
        OrderedItem item2 = new OrderedItem(order1, stock7, 10);
        OrderedItem item3 = new OrderedItem(order1, stock5, 30);

        List<OrderedItem> itemList1 = Arrays.asList(item1, item2, item3);
        order1.setOrderedItems(itemList1);
        orderRepository.save(order1);

        orderedItemRepository.save(item1);
        orderedItemRepository.save(item2);
        orderedItemRepository.save(item3);

        // Order 2
        Order order2 = new Order(OrderStatus.DELIVERED, morrisons);
        OrderedItem item4 = new OrderedItem(order2, stock2, 50);
        OrderedItem item5 = new OrderedItem(order2, stock4, 15);
        OrderedItem item6 = new OrderedItem(order2, stock6, 20);

        List<OrderedItem> itemList2 = Arrays.asList(item4, item5, item6);
        order2.setOrderedItems(itemList2);
        orderRepository.save(order2);

        orderedItemRepository.save(item4);
        orderedItemRepository.save(item5);
        orderedItemRepository.save(item6);

        // Order 3
        Order order3 = new Order(OrderStatus.DELIVERED, sainsburys);
        OrderedItem item7 = new OrderedItem(order3, stock1, 40);
        OrderedItem item8 = new OrderedItem(order3, stock3, 10);
        OrderedItem item9 = new OrderedItem(order3, stock5, 25);

        List<OrderedItem> itemList3 = Arrays.asList(item7, item8, item9);
        order3.setOrderedItems(itemList3);
        orderRepository.save(order3);

        orderedItemRepository.save(item7);
        orderedItemRepository.save(item8);
        orderedItemRepository.save(item9);

        // Order 4
        Order order4 = new Order(OrderStatus.OUT_FOR_DELIVERY, lidl);
        OrderedItem item10 = new OrderedItem(order4, stock5, 20);
        OrderedItem item11 = new OrderedItem(order4, stock6, 15);
        OrderedItem item12 = new OrderedItem(order4, stock8, 35);

        List<OrderedItem> itemList4 = Arrays.asList(item10, item11, item12);
        order4.setOrderedItems(itemList4);
        orderRepository.save(order4);

        orderedItemRepository.save(item10);
        orderedItemRepository.save(item11);
        orderedItemRepository.save(item12);
    }




}
