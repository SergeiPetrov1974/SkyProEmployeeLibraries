package pro.sky.course2.homework2_10.skyproemployeelibraries.service;

import pro.sky.course2.homework2_10.skyproemployeelibraries.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMinSalary(int department);

    Employee getEmployeeWithMaxSalary(int department);

    Collection<Employee> getEmployeesFor(int department);

    Map<Integer, List<Employee>> getAllEmployeesByDepartment();

}
