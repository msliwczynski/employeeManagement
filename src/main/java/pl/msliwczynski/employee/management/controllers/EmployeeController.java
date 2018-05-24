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
import pl.msliwczynski.employee.management.service.EmployeeService;

import java.util.Optional;

@Controller
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/admin/employees")
    public String getEmployeesForAdmin(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "admin_employees";
    }

    @GetMapping("/user/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "employees";
    }

    @GetMapping("/user/addemployee")
    public String getEmployeeForm(Model model) {
        LOGGER.info("Getting adding employee form");
        model.addAttribute("employee", new Employee());

        return "addemployee";
    }

    @PostMapping("/user/addemployee")
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        LOGGER.info("Saving employee {}", employee);
        try {
            employeeService.saveEmployee(employee);
            LOGGER.debug("saving completed");
        } catch (IllegalArgumentException e) {
            model.addAttribute("employee", employee);
            model.addAttribute("error", "Saving error: one of field value is invalid");
            return "addemployee";
        }

        return "result";
    }

    @GetMapping("/user/delete_employee")
    public String deleteEmployee(@RequestParam(name="id")String employeeId) {
        LOGGER.info("Deleting employee id= {}", employeeId);
        employeeService.removeEmployee(employeeId);
        LOGGER.debug("deleting completed");

        return "result";
    }

    @GetMapping("/user/edit_employee")
    public String editEmployee(@RequestParam(name="id")String employeeId, Model model) {
        LOGGER.info("Getting adding employee form");
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        LOGGER.info("sending entity {}", employee);

        return "addemployee";
    }

}
