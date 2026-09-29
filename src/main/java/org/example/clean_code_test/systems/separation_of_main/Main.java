package org.example.clean_code_test.systems.separation_of_main;

// Separation of main Example
public class Main {
    public static void main(String[] args) {
        // Construction/Startup phase
        Logger logger = new ConsoleLogger();
        ShoppingCart shoppingCart = new ShoppingCart(logger);

        // Runtime Phase (Use)
        shoppingCart.addItem("Apple");
    }
}
