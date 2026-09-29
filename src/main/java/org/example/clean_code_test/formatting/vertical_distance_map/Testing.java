package org.example.clean_code_test.formatting.vertical_distance_map;

public class Testing {
    public String test1;
    public String test2;

    void caller(){
        //local variable
        String var = "";
        callee(var);
    }

    private void callee(String var) {
        // logic goes here.
        System.out.println(var);
    }
}
