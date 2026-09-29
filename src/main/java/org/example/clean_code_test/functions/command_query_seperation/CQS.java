package org.example.clean_code_test.functions.command_query_seperation;

public class CQS {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Bad Code mixing command + query
     * command => set name if not exists name
     * Query => return true if success
     */
    public boolean set(String name, String value){
        if(name != null){
            this.userName = value;
            return true;
        }
        return false;
    }

    /**
     * Clean Code design
     * Separate Command and Query
     */
    public boolean attributeExists(String name){
        return userName != null && userName.equalsIgnoreCase(name);
    }

    public void changeName(String name, String value){
        if(attributeExists(name)){
            this.userName = value;
        }
    }
}
