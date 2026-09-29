package org.example.clean_code_test.functions.switch_session.factory;

import org.example.clean_code_test.functions.switch_session.dto.EmployeeRecord;
import org.example.clean_code_test.functions.switch_session.domain.Employee;
import org.example.clean_code_test.functions.switch_session.exceptions.InvalidEmployeeType;

public interface EmployeeFactory {
    public Employee makeEmployee(EmployeeRecord record) throws InvalidEmployeeType;
}
