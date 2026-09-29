package org.example.clean_code_test.functions.switch_session.dto;

import org.example.clean_code_test.functions.switch_session.enums.EmployeeType;

public class EmployeeRecord {
    public EmployeeType employeeType;
    public double salary;
    public double hoursWorked;

    public EmployeeRecord(EmployeeType employeeType, double salary, double hoursWorked) {
        this.employeeType = employeeType;
        this.salary = salary;
        this.hoursWorked = hoursWorked;
    }

}
