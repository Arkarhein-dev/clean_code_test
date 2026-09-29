package org.example.clean_code_test.functions.arguments.argumentObject;

public class ArgumentObjectExample {
    // Argument Objects
    public Order placeOrder(Customer customer, ShippingAddress shippingAddress, PaymentDetails payment) {
        return new Order();
    }
}
