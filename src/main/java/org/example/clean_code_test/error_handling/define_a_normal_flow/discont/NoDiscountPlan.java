package org.example.clean_code_test.error_handling.define_a_normal_flow.discont;

public class NoDiscountPlan implements DiscountPlan {
    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
