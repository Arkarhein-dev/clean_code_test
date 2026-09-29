package org.example.clean_code_test.functions.switch_session;

import org.example.clean_code_test.functions.switch_session.domain.Employee;
import org.example.clean_code_test.functions.switch_session.enums.EmployeeType;
import org.example.clean_code_test.functions.switch_session.exceptions.InvalidEmployeeType;
import org.example.clean_code_test.functions.switch_session.factory.EmployeeFactory;
import org.example.clean_code_test.functions.switch_session.factory.EmployeeFactoryImpl;
import org.example.clean_code_test.functions.switch_session.dto.EmployeeRecord;
import org.example.clean_code_test.functions.switch_session.common.Money;

public class Main {
    public static void main(String[] args) {
        System.out.println("Switch with polymorphic way");
        // Create Emp Factory
        EmployeeFactory factory = new EmployeeFactoryImpl();

        EmployeeRecord record1 = new EmployeeRecord(EmployeeType.COMMISSIONED,2000,20);
        EmployeeRecord record2 = new EmployeeRecord(EmployeeType.SALARIED,20000,50);

        try {
            createEmployeeAndProcessPayRoll(factory,record1);
            createEmployeeAndProcessPayRoll(factory,record2);
        } catch (InvalidEmployeeType e) {
            throw new RuntimeException(e);
        }
    }

    public static void createEmployeeAndProcessPayRoll(EmployeeFactory factory, EmployeeRecord record) throws InvalidEmployeeType{
        Employee employee = factory.makeEmployee(record);
        processPayroll(employee);
    }

    public static void processPayroll(Employee e){
        if(e.isPayDay()){
            Money pay = e.calculatePay();
            e.deliverPay(pay);
        }
    }
}
