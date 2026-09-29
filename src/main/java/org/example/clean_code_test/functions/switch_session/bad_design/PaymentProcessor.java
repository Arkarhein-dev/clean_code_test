package org.example.clean_code_test.functions.switch_session.bad_design;

// PROBLEM: Naked switch statement directly in the business logic
public class PaymentProcessor {
    public void processPayment(String type, double amount) {
        // Core business logic is forced to know about every concrete implementation
        switch (type) {
            case "CREDIT_CARD":
                new CreditCardPayment().execute(amount);
                break;
            case "PAYPAL":
                new PayPalPayment().execute(amount);
                break;
            case "CRYPTO":
                new CryptoPayment().execute(amount);
                break;
            default:
                throw new IllegalArgumentException("Unknown payment type");
        }
    }
}

