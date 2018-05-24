package pl.msliwczynski.employee.management.service;

import pl.msliwczynski.employee.management.model.Employee;

import java.util.Optional;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    void removeEmployee(String id);
    Iterable<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(String id);
}
