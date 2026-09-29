package org.example.clean_code_test.functions.switch_session.exceptions;

import org.example.clean_code_test.functions.switch_session.enums.EmployeeType;

public class InvalidEmployeeType extends Exception{
    public InvalidEmployeeType(EmployeeType type) {
        super("Invalid Employee Type"+ type);
    }
}
