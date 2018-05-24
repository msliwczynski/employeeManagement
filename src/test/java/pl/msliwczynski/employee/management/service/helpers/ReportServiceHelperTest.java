package pl.msliwczynski.employee.management.service.helpers;

import org.junit.Test;
import pl.msliwczynski.employee.management.model.ContactDetails;
import pl.msliwczynski.employee.management.model.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportServiceHelperTest {
    private ReportServiceHelper reportServiceHelper = new ReportServiceHelper();
    private Iterable<Employee> employees = getMockEmployees();

    @Test
    public void shouldReturnAvarageSalaryForDecember2017() {
        List<Double> actual = reportServiceHelper.getSalariesForMonth("2017", Month.of(12), employees);
        assertEquals(Double.valueOf(0.0), actual.get(0));
        assertEquals(Double.valueOf(0.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForFebruary() {
        List<Double> actual = reportServiceHelper.getSalariesForMonth("2018", Month.of(2), employees);
        assertEquals(Double.valueOf(3000.0), actual.get(0));
        assertEquals(Double.valueOf(3000.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForMay() {
        List<Double> actual = reportServiceHelper.getSalariesForMonth("2018", Month.of(5), employees);
        assertEquals(Double.valueOf(8000.0), actual.get(0));
        assertEquals(Double.valueOf(4000.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForJuly() {
        List<Double> actual = reportServiceHelper.getSalariesForMonth("2018", Month.of(7), employees);
        assertEquals(Double.valueOf(3000.0), actual.get(0));
        assertEquals(Double.valueOf(3000.0), actual.get(1));
    }

    private Iterable<Employee> getMockEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        ContactDetails johnContactDetails = new ContactDetails("7123456789","5th Avenue, 123", "New York");
        Employee john = new Employee("John", "Smith", LocalDate.of(2018, 1, 1), LocalDate.of(9999,12,31), 3000.00, johnContactDetails);

        ContactDetails adamContactDetails = new ContactDetails("123456789","Bracka 2", "Warszawa");
        Employee adam = new Employee("Adam", "Kowalski", LocalDate.of(2018, 4, 1), LocalDate.of(2018,7,31), 5000.00, adamContactDetails);

        employeeList.add(john);
        employeeList.add(adam);

        return employeeList;
    }

}
