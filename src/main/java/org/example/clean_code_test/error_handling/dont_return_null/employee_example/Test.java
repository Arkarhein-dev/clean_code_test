package org.example.clean_code_test.error_handling.dont_return_null.employee_example;

import java.util.List;

public class Test {
    public static final EmployeeRepository employeeRepository = new EmployeeRepository();

//    public Test(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    public static void main(String[] args) {
        Employee employee = new Employee("Arkar Hein",23);
        Employee employee2 = new Employee("Orion",23);
        employeeRepository.addEmployee(employee,employee2);

        // Do no need to check null value here
        List<Employee> employees = employeeRepository.getEmployees();
        List<String> names = employees.stream().map(e -> e.name).toList();
        names.forEach(System.out::println);
    }



}
