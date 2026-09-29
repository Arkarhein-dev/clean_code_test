package org.example.clean_code_test.error_handling.define_a_normal_flow.service;

import org.example.clean_code_test.error_handling.define_a_normal_flow.discont.DiscountPlan;
import org.example.clean_code_test.error_handling.define_a_normal_flow.repository.DiscountRepository;

public class OrderPricingService {
    private final DiscountRepository discountRepository = new DiscountRepository();

    public OrderPricingService() {
        discountRepository.saveVipCustomer("VIP-999",0.15);
    }

    public double calculateFinalPrice(String customerId, double originalPrice){
        // Clean flow: No try-catch blocks or null checks required
        DiscountPlan plan = discountRepository.findDiscountByCustomer(customerId);
        double discountRate = plan.getDiscountRate();
        return originalPrice - (originalPrice*discountRate);
    }
}
