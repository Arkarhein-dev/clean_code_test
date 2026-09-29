package org.example.clean_code_test.functions.step_down_rule;

public class OrderProcessor {

    // =========================================================================
    // LEVEL 1: High-Level Business Policy
    // "TO process an order, we validate it, calculate pricing, and fulfill it."
    // =========================================================================
    public OrderReceipt processOrder(OrderRequest request) {
        validateOrder(request);
        OrderCalculation calc = calculateOrderTotals(request);
        return fulfillOrder(request, calc);
    }

    // =========================================================================
    // LEVEL 2: Step-by-Step Orchestration
    // =========================================================================
    private void validateOrder(OrderRequest request) {
        checkInventory(request.getItems());
        checkCustomerAccount(request.getCustomerId());
    }

    private OrderCalculation calculateOrderTotals(OrderRequest request) {
        double subtotal = computeSubtotal(request.getItems());
        double discount = applyDiscounts(subtotal, request.getCustomerId());
        double tax = computeTax(subtotal - discount);
        return new OrderCalculation(subtotal, discount, tax);
    }

    private OrderReceipt fulfillOrder(OrderRequest request, OrderCalculation calc) {
        chargeCustomer(request.getCustomerId(), calc.getGrandTotal());
        generateShippingLabel(request.getShippingAddress());
        return new OrderReceipt(request.getOrderId(), calc.getGrandTotal());
    }

    // =========================================================================
    // LEVEL 3: Mid-Level Logic & Rules
    // =========================================================================
    private void checkInventory(List<Item> items) {
        for (Item item : items) {
            if (!item.isInStock()) {
                throw new OutOfStockException(item.getName());
            }
        }
    }

    private double computeSubtotal(List<Item> items) {
        double sum = 0.0;
        for (Item item : items) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }

    private double applyDiscounts(double subtotal, String customerId) {
        boolean isVip = CustomerDatabase.isVip(customerId);
        return isVip ? subtotal * 0.15 : 0.0; // 15% VIP discount
    }

    // =========================================================================
    // LEVEL 4: Low-Level Technical Details & Calculations
    // =========================================================================
    private double computeTax(double taxableAmount) {
        double taxRate = 0.08; // 8% local tax
        return taxableAmount * taxRate;
    }

    private void chargeCustomer(String customerId, double amount) {
        PaymentGateway.charge(customerId, amount);
    }

    private void generateShippingLabel(Address address) {
        ShippingService.printLabel(address.getStreet(), address.getCity());
    }
}