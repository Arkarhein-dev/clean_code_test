package org.example.clean_code_test.functions.arguments.flag_argument;

import org.example.clean_code_test.functions.arguments.argumentObject.Order;

public class FlagArgumentBadPractice {

    // BAad Code => Don't do that in production
    public void processPayment(Order order, boolean isExpress) {
        if (isExpress) {
            // Express shipping logic & higher fee
        } else {
            // Standard shipping logic
        }
    }
// Caller: processPayment(order, true); -> What does true mean? Very confusing!
}
