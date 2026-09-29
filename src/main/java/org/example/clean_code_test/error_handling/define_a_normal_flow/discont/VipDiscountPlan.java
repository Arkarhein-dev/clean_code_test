package org.example.clean_code_test.error_handling.define_a_normal_flow.discont;

public class VipDiscountPlan implements DiscountPlan {
    private final double rate;

    public VipDiscountPlan(double rate) {
        this.rate = rate;
    }

    @Override
    public double getDiscountRate() {
        return rate;
    }
}
