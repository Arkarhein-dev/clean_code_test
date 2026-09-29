package org.example.clean_code_test.formatting.step_down_rule;

public class Testing {

    public void makeTestResponse(){
        System.out.println("/////");
        includeSetupPage();
    }

    private void includeSetupPage() {
        System.out.println("logic goes here");
        getWikiPage();
    }

    private void getWikiPage() {
        System.out.println("Get wiki Page...");
    }
}
