package pl.msliwczynski.employee.management.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.msliwczynski.employee.management.model.ContactDetails;

public interface ContactDetailsRepository extends CrudRepository <ContactDetails, Long> {
}
