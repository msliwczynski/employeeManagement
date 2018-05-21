package pl.msliwczynski.employee.management.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.msliwczynski.employee.management.model.ContactDetails;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.ContactDetailsRepository;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;

import java.time.LocalDate;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeRepository employeeRepository;
    private ContactDetailsRepository contactDetailsRepository;

    public DevBootstrap(EmployeeRepository employeeRepository, ContactDetailsRepository contactDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        ContactDetails johnContactDetails = new ContactDetails("7123456789","5th Avenue, 123", "New York");
        Employee john = new Employee("John", "Smith", LocalDate.of(2018, 1, 1), LocalDate.of(9999,12,31), 3000.00, johnContactDetails);

        ContactDetails adamContactDetails = new ContactDetails("123456789","Bracka 2", "Warszawa");
        Employee adam = new Employee("Adam", "Kowalski", LocalDate.of(2018, 4, 1), LocalDate.of(9999,12,31), 5000.00, adamContactDetails);

        contactDetailsRepository.save(johnContactDetails);
        employeeRepository.save(john);

        contactDetailsRepository.save(adamContactDetails);
        employeeRepository.save(adam);
    }
}
