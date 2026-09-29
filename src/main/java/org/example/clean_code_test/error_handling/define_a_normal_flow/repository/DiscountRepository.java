package org.example.clean_code_test.error_handling.define_a_normal_flow.repository;

import org.example.clean_code_test.error_handling.define_a_normal_flow.discont.DiscountPlan;
import org.example.clean_code_test.error_handling.define_a_normal_flow.discont.NoDiscountPlan;
import org.example.clean_code_test.error_handling.define_a_normal_flow.discont.VipDiscountPlan;

import java.util.HashMap;
import java.util.Map;

public class DiscountRepository {
    private final Map<String, Double> vipDatabase = new HashMap<>();

    public void saveVipCustomer(String customerId, Double rate){
        vipDatabase.put(customerId,rate);
    }

    public DiscountPlan findDiscountByCustomer(String customerId){
        if (vipDatabase.containsKey(customerId)){
            return  new VipDiscountPlan(vipDatabase.get(customerId));
        }else{
            return new NoDiscountPlan();
        }
    }
}
