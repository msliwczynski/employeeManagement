package pl.msliwczynski.employee.management.service.helpers;

import org.springframework.stereotype.Component;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.utils.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

@Component
public class ReportServiceHelper {

    public List<Double> getSalariesForMonth(String year, Month month, Iterable<Employee> employeeList) {
        LocalDate endDate = LocalDate.of(Integer.valueOf(year), month, month.length(Year.of(Integer.valueOf(year)).isLeap()));
        Double salarySum = 0.0;
        int employeeCounter = 0;
        for (Employee employee : employeeList) {
            if (shouldIncludeInMonthSalary(employee, endDate)) {
                salarySum += employee.getSalary();
                employeeCounter++;
            }
        }
        return employeeCounter > 0 ? Arrays.asList(salarySum, salarySum / employeeCounter) : Arrays.asList(0.0, 0.0);
    }

    private boolean shouldIncludeInMonthSalary(Employee employee, LocalDate monthEndDate) {
        if (employee.getWorkStartDate().isAfter(monthEndDate) || (employee.getWorkEndDate() != null && !employee.getWorkEndDate().isAfter(monthEndDate))) {
            return false;
        }
        return true;
    }
}
