package pl.msliwczynski.employee.management.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.msliwczynski.employee.management.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
