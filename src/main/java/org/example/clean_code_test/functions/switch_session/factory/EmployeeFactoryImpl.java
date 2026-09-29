package org.example.clean_code_test.functions.switch_session.factory;

import org.example.clean_code_test.functions.switch_session.dto.EmployeeRecord;
import org.example.clean_code_test.functions.switch_session.domain.CommissionedEmployee;
import org.example.clean_code_test.functions.switch_session.domain.Employee;
import org.example.clean_code_test.functions.switch_session.domain.HourlyEmployee;
import org.example.clean_code_test.functions.switch_session.domain.SalariedEmployee;
import org.example.clean_code_test.functions.switch_session.exceptions.InvalidEmployeeType;

public class EmployeeFactoryImpl implements EmployeeFactory{

    @Override
    public Employee makeEmployee(EmployeeRecord record) throws InvalidEmployeeType {
        switch (record.employeeType){
            case COMMISSIONED -> {
                return new CommissionedEmployee(record);
            }
            case HOURLY -> {
                return new HourlyEmployee(record);
            }
            case SALARIED ->{
                return new SalariedEmployee(record);
            }
            default -> {
                throw new InvalidEmployeeType(record.employeeType);
            }
        }
    }
}
