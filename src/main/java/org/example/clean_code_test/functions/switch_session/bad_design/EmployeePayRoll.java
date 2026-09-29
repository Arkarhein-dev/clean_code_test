package org.example.clean_code_test.functions.switch_session.bad_design;

import org.example.clean_code_test.functions.switch_session.dto.EmployeeRecord;

// bad design employee payroll =>
//   high level business logic depends on switch case (deviate from single responsibility principle)
//   and low level concrete details
public class EmployeePayRoll {
    public double calculatePay(EmployeeRecord record){
        switch (record.employeeType){
            case COMMISSIONED -> {
                return record.hoursWorked * 20;
            }
            case HOURLY -> {
                return record.hoursWorked * 50;
            }
            case SALARIED -> {
                return record.hoursWorked * 100;
            }
            default -> {
                throw  new IllegalArgumentException("Invalid Employee Type");
            }
        }
    }
}
