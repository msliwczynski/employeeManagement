package pl.msliwczynski.employee.management.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.ContactDetailsRepository;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;
import pl.msliwczynski.employee.management.service.EmployeeService;
import pl.msliwczynski.employee.management.service.validators.EmployeeValidator;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;
    private ContactDetailsRepository contactDetailsRepository;
    private EmployeeValidator employeeValidator;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ContactDetailsRepository contactDetailsRepository, EmployeeValidator employeeValidator) {
        this.employeeRepository = employeeRepository;
        this.contactDetailsRepository = contactDetailsRepository;
        this.employeeValidator = employeeValidator;
    }

    @Override
    public void saveEmployee(Employee employee) throws IllegalArgumentException {
        if (!employeeValidator.validate(employee)) {
            LOGGER.error("Employee object to save is invalid, throwing IllegalArgumentException");
            throw new IllegalArgumentException("Employee object is invalid");
        }
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
