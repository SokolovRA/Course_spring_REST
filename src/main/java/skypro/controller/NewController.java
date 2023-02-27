package skypro.controller;

import org.springframework.web.bind.annotation.*;
import skypro.entity.Employee;
import skypro.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/skypro")
public class NewController {
    private EmployeeService employeeService;

    public NewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Person with id = " + id + " was deleted";
    }
}