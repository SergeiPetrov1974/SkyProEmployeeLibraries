package pro.sky.course2.homework2_10.skyproemployeelibraries.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.course2.homework2_10.skyproemployeelibraries.data.Employee;
import pro.sky.course2.homework2_10.skyproemployeelibraries.exceptions.ErrorInLine;
import pro.sky.course2.homework2_10.skyproemployeelibraries.exceptions.EmployeeNotFoundException;
import pro.sky.course2.homework2_10.skyproemployeelibraries.service.DepartmentService;
import pro.sky.course2.homework2_10.skyproemployeelibraries.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.springframework.util.StringUtils.*;

@Service
public class EmployeeServiceImpl implements DepartmentService, EmployeeService {
    Map<Integer, Employee> employees;

    private Integer id = 0;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    private Integer getId() {
        Integer result = id;
        id = id + 1;
        return result;
    }

    @Override
    public void removeEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getEmployee(Integer id) {
        if (employees.containsKey(id)) {
            return employees.get(id);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public boolean isStringDigit(String str) {
        if (isAlpha(str)) {
            return true;
        } else {
            throw new ErrorInLine();
        }
    }

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (isStringDigit(firstName) && isStringDigit(lastName)) {
            employees.put(getId(), new Employee(capitalize(firstName), capitalize(lastName)));
        }
    }

    @Override
    public HashMap<Integer, Employee> printAllEmployees() {
        return (HashMap<Integer, Employee>) employees;
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employees.values().stream()
                .filter(e -> e.isDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
