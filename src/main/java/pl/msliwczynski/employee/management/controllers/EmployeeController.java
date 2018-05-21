package pl.msliwczynski.employee.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;

@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());

        return "employees";
    }
}
