package pl.msliwczynski.employee.management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.ContactDetailsRepository;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeRepository employeeRepository;
    private ContactDetailsRepository contactDetailsRepository;

    public EmployeeController(EmployeeRepository employeeRepository, ContactDetailsRepository contactDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.contactDetailsRepository = contactDetailsRepository;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());

        return "employees";
    }

    @GetMapping("/addemployee")
    public String getEmployeeForm(Model model) {
        logger.info("Getting adding employee form");
        model.addAttribute("employee", new Employee());

        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String addEmployee(@ModelAttribute Employee employee) {
        logger.info("Saving employee {}", employee);
        contactDetailsRepository.save(employee.getContactDetails());
        employeeRepository.save(employee);
        logger.debug("saving completed");

        return "result";
    }

    @GetMapping("/delete_employee")
    public String deleteEmployee(@RequestParam(name="id")String employeeId) {
        logger.info("Deleting employee id= {}", employeeId);
        employeeRepository.deleteById(Long.valueOf(employeeId));
        logger.debug("deleting completed");

        return "result";
    }

    @GetMapping("/edit_employee")
    public String editEmployee(@RequestParam(name="id")String employeeId, Model model) {
        logger.info("Getting adding employee form");
        Optional<Employee> employee = employeeRepository.findById(Long.valueOf(employeeId));
        model.addAttribute("employee", employee);
        logger.info("sending entity {}", employee);

        return "addemployee";
    }

}
