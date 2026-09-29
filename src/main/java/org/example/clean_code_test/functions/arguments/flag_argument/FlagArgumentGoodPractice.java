package org.example.clean_code_test.functions.arguments.flag_argument;

import org.example.clean_code_test.functions.arguments.argumentObject.Order;

public class FlagArgumentGoodPractice {

//    ✅ Good Example (Split into two functions):
    public void processExpressPayment(Order order) {
        // Clean, dedicated express logic
    }

    public void processStandardPayment(Order order) {
        // Clean, dedicated standard logic
    }
}
