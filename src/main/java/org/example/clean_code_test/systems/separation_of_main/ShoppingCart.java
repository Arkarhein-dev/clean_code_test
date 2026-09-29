package org.example.clean_code_test.systems.separation_of_main;

public class ShoppingCart {
    private final Logger logger;

    public ShoppingCart(Logger logger) {
        this.logger = logger;
    }

    public void addItem(String item){
        // Add item logic goes here.
        logger.log("Item added : "+item);
    }
}
