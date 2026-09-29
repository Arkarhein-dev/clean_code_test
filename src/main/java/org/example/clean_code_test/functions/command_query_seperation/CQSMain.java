package org.example.clean_code_test.functions.command_query_seperation;

public class CQSMain {
    public static void main(String[] args) {
        CQS cqs = new CQS();
        cqs.changeName("Arkar Hein", "Orion");
        System.out.println("name: "+ cqs.getUserName());
    }
}
