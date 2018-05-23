package pl.msliwczynski.employee.management.service.impl;

import org.springframework.stereotype.Service;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;
import pl.msliwczynski.employee.management.service.ReportService;
import pl.msliwczynski.employee.management.service.helpers.ReportServiceHelper;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ReportServiceImpl implements ReportService {

    private EmployeeRepository employeeRepository;
    private ReportServiceHelper reportServiceHelper;

    public ReportServiceImpl(EmployeeRepository employeeRepository, ReportServiceHelper reportServiceHelper) {
        this.employeeRepository = employeeRepository;
        this.reportServiceHelper = reportServiceHelper;
    }

    @Override
    public Map<Integer, List<Double>> getReportByYear(String year) {
        Map<Integer, List<Double>> reportMap = new TreeMap<>();
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        LocalDate monthStartDate = LocalDate.of(Integer.valueOf(year), 1, 1);
        LocalDate today = LocalDate.now();
        Month stopMonth = Integer.valueOf(year).equals(today.getYear()) ? LocalDate.now().getMonth() : Month.JANUARY;

        do {
            List<Double> salaries = reportServiceHelper.getSalariesForMonth(year, monthStartDate.getMonth(), employeeIterable);
//            reportMap.put(monthStartDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH), salaries);
            reportMap.put(monthStartDate.getMonth().getValue(), salaries);
            monthStartDate = monthStartDate.plusMonths(1);
        } while (monthStartDate.getMonth() != stopMonth);


        return reportMap;
    }

    @Override
    public List<Double> getReportByMonth(String month, String year) {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        return reportServiceHelper.getSalariesForMonth(year, Month.of(Integer.valueOf(month)), employeeIterable);
    }

}
