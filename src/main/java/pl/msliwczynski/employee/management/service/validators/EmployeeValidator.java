package pl.msliwczynski.employee.management.service.validators;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.msliwczynski.employee.management.model.ContactDetails;
import pl.msliwczynski.employee.management.model.Employee;

import java.time.LocalDate;

@Component
public class EmployeeValidator implements Validator<Employee> {

    @Override
    public boolean validate(Employee employee) {
        return employee != null
                && (!StringUtils.isEmpty(employee.getFirstName()) && !StringUtils.isEmpty(employee.getLastName()))
                && isWorkStartDayValid(employee.getWorkStartDate())
                && isSalaryValid(employee.getSalary())
                && isContactDetailsValid(employee.getContactDetails());
    }

    private boolean isSalaryValid(final Double salary) {
        return salary != null && salary > 0.0;
    }

    private boolean isWorkStartDayValid(final LocalDate workStartDate) {
        return workStartDate != null && !workStartDate.isAfter(LocalDate.now());
    }

    private boolean isContactDetailsValid(final ContactDetails contactDetails) {
        return contactDetails != null
                && !StringUtils.isEmpty(contactDetails.getCity())
                && !StringUtils.isEmpty(contactDetails.getStreet())
                && !StringUtils.isEmpty(contactDetails.getPhone());
    }

}
