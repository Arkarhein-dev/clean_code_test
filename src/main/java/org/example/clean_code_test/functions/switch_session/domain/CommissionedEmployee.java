package org.example.clean_code_test.functions.switch_session.domain;

import org.example.clean_code_test.functions.switch_session.dto.EmployeeRecord;
import org.example.clean_code_test.functions.switch_session.common.Money;

public class CommissionedEmployee extends Employee {
    private final EmployeeRecord record;

    public CommissionedEmployee(EmployeeRecord record) {
        this.record = record;
    }

    @Override
    public boolean isPayDay() {
        return true;
    }

    @Override
    public Money calculatePay() {
        return new Money(record.hoursWorked);
    }

    @Override
    public void deliverPay(Money pay) {
        System.out.println("Delivering Commission Pay "+ pay+" via Direct deposit.");
    }
}
