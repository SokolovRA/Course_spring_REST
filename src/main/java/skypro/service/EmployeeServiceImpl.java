package skypro.service;

import org.springframework.stereotype.Service;
import skypro.dao.EmployeeDAO;
import skypro.entity.Employee;
import skypro.exceptions.EmployeeException;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Transactional
    public List<Employee> getEmployee() {
        return employeeDAO.getEmployee();
    }
    @Transactional
    public Employee getEmployeeById(int id) {
        Employee employee= employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("Employee with id = " + id + " doesn't exist");
        }

        return employee;
    }
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
    @Transactional
    public void deleteEmployee(int id) {
       Employee employee = employeeDAO.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeException("Person with id = " + id + " doesn't exist");
        }
       employeeDAO.deleteEmployee(id);
    }
}
