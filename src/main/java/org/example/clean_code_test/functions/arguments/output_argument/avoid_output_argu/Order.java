package org.example.clean_code_test.functions.arguments.output_argument.avoid_output_argu;


// The Order class is reduced to just a data holder (Anemic Domain Model)
class Order {
    private double total;

    public Order(double total) {
        this.total = total;
    }

    public double getTotal() {
        return this.total;
    }

    // A setter is now required so an outside function can change it
    public void setTotal(double total) {
        this.total = total;
    }
}

class Main {
    public static void main(String[] args) {
        Order myOrder = new Order(200);

        // 🚫 BAD: 'myOrder' is used as an OUTPUT ARGUMENT here.
        //        // Looking at this line, it looks like you are just passing data into a function.
        //        // It is not immediately obvious that 'myOrder' is going to be mutated inside.
        applyMemberDiscount(myOrder, "VIP");

        System.out.println("Total Value: " + myOrder.getTotal());
    }

    // 🚫 This is the problematic function with the output argument
    public static void applyMemberDiscount(Order order, String memberStatus) {
        if (memberStatus.equalsIgnoreCase("VIP")) {
            // Reaching into the passed object to change its state from the outside
            double currentTotal = order.getTotal();
            order.setTotal(currentTotal * 0.80);
        }
    }
}
