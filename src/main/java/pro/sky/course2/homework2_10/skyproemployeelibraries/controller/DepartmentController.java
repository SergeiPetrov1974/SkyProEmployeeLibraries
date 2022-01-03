package pro.sky.course2.homework2_10.skyproemployeelibraries.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2.homework2_10.skyproemployeelibraries.data.Employee;
import pro.sky.course2.homework2_10.skyproemployeelibraries.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    public Employee getEmpWithMinSalaryByDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping("/max-salary")
    public Employee getEmpWithMaxSalaryByDepartment(@RequestParam int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping("all")
    Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }
}
