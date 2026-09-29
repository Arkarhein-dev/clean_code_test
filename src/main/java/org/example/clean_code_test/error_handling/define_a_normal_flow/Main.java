package org.example.clean_code_test.error_handling.define_a_normal_flow;

import org.example.clean_code_test.error_handling.define_a_normal_flow.service.OrderPricingService;

public class Main {
    public static void main(String[] args) {
        OrderPricingService orderPricingService = new OrderPricingService();

        double regularPrice = orderPricingService.calculateFinalPrice("REGULAR-101",300);
        double vipPrice = orderPricingService.calculateFinalPrice("VIP-999",2000);

        System.out.println("Regular Customer Price: "+regularPrice);
        System.out.println("VIP Customer Final Price: "+vipPrice);
    }
}
