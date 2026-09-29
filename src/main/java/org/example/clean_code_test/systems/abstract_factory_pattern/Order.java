package org.example.clean_code_test.systems.abstract_factory_pattern;

import org.example.clean_code_test.systems.abstract_factory_pattern.factory.LineItemFactory;

public class Order {
    private final LineItemFactory factory;

    public Order(LineItemFactory factory) {
        this.factory = factory;
    }

    public void addProduct(String productName){
        LineItem item = factory.createLineItem(productName);
        System.out.println("Added to Order : "+item.getLineName());
    }

}
