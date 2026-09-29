package org.example.clean_code_test.functions.arguments.output_argument.clean_way_with_oo;

public class Order {
    private double total;

    public Order(double total) {
        this.total = total;
    }

    // Clean way using oop
    public void applyMemberDiscount(String memberStatus){
        if(memberStatus.equalsIgnoreCase("VIP")){
            this.total = this.total * 0.80;
        }
    }

    public double getTotal(){
        return this.total;
    }
}

class Main{
    public static void main(String[] args) {
        Order myOrder = new Order(200);
        myOrder.applyMemberDiscount("VIP");
        System.out.println("Total Value: "+myOrder.getTotal());
    }
}
