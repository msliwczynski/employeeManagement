package pl.msliwczynski.employee.management.service.impl;

import org.springframework.stereotype.Service;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.ContactDetailsRepository;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;
import pl.msliwczynski.employee.management.service.EmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    ContactDetailsRepository contactDetailsRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ContactDetailsRepository contactDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        contactDetailsRepository.save(employee.getContactDetails());
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployee(String id) {
        employeeRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(Long.valueOf(id));
    }
}
