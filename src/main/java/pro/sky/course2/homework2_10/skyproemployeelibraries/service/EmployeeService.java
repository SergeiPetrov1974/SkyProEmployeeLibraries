package pro.sky.course2.homework2_10.skyproemployeelibraries.service;

import pro.sky.course2.homework2_10.skyproemployeelibraries.data.Employee;

import java.util.HashMap;

public interface EmployeeService {
    void removeEmployee(Integer id);

    boolean isStringDigit(String str);

    void addEmployee(String firstName, String lastName);

    HashMap<Integer, Employee> printAllEmployees();

    Employee getEmployee(Integer id);
}
