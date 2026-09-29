package org.example.clean_code_test.error_handling.dont_return_null.employee_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    // Don't Return null
    public List<Employee> getEmployees(){
        if(employees.isEmpty()){
            return Collections.emptyList();
        }
        return employees;
    }

    public void addEmployee(Employee... employees){
        this.employees.addAll(List.of(employees));
    }
}
