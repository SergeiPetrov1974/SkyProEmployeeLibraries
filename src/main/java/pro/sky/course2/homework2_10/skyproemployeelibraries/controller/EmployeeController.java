package pro.sky.course2.homework2_10.skyproemployeelibraries.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.homework2_10.skyproemployeelibraries.data.Employee;
import pro.sky.course2.homework2_10.skyproemployeelibraries.service.EmployeeService;

import java.util.Map;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String showAdd(@RequestParam String firstName, @RequestParam String lastName) {

        employeeService.addEmployee(firstName, lastName);
        return " сотрудник " + StringUtils.capitalize(firstName ) + " " + StringUtils.capitalize(lastName) + " добавлен";

    }

    @GetMapping("/remove")
    public String showRemove(@RequestParam Integer id) {
        employeeService.removeEmployee(id);
        return "сотрудник ID " + id + " удален";
    }

    @GetMapping("/find")
    public String showFind(@RequestParam Integer id) {
        employeeService.getEmployee(id);
        return "сотрудник " + employeeService.getEmployee(id) + " найден";
    }

    @GetMapping("/printAll")
    public Map<Integer, Employee> printAll() {
        return employeeService.printAllEmployees();
    }
}
