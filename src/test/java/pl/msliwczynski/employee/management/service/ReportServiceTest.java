package pl.msliwczynski.employee.management.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.msliwczynski.employee.management.model.ContactDetails;
import pl.msliwczynski.employee.management.model.Employee;
import pl.msliwczynski.employee.management.repositories.EmployeeRepository;
import pl.msliwczynski.employee.management.service.helpers.ReportServiceHelper;
import pl.msliwczynski.employee.management.service.impl.ReportServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ReportServiceTest {

    @Mock
    private ReportServiceHelper reportServiceHelper = new ReportServiceHelper();
    @Mock
    private EmployeeRepository employeeRepository;

    private ReportService reportService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reportService = new ReportServiceImpl(employeeRepository, reportServiceHelper);
    }

    @Test
    public void shouldReturnAvarageSalaryForDecember2017() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), any(Month.class), anyIterable())).thenReturn(Arrays.asList(0.0, 0.0));
        List<Double> actual = reportService.getReportByMonth("12", "2017");
        assertEquals(Double.valueOf(0.0), actual.get(0));
        assertEquals(Double.valueOf(0.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForFebruary() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), any(Month.class), anyIterable())).thenReturn(Arrays.asList(3000.0, 3000.0));
        List<Double> actual = reportService.getReportByMonth("2", "2018");
        assertEquals(Double.valueOf(3000.0), actual.get(0));
        assertEquals(Double.valueOf(3000.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForMay() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), any(Month.class), anyIterable())).thenReturn(Arrays.asList(8000.0, 4000.0));
        List<Double> actual = reportService.getReportByMonth("5", "2018");
        assertEquals(Double.valueOf(8000.0), actual.get(0));
        assertEquals(Double.valueOf(4000.0), actual.get(1));
    }

    @Test
    public void shouldReturnAvarageSalaryForJuly() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), any(Month.class), anyIterable())).thenReturn(Arrays.asList(3000.0, 3000.0));
        List<Double> actual = reportService.getReportByMonth("7", "2018");
        assertEquals(Double.valueOf(3000.0), actual.get(0));
        assertEquals(Double.valueOf(3000.0), actual.get(1));
    }

    @Test
    public void shouldReturnYearReportWith4Months() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), eq(Month.JANUARY), anyIterable())).thenReturn(Arrays.asList(3000.0, 3000.0));
        when(reportServiceHelper.getSalariesForMonth(anyString(), eq(Month.FEBRUARY), anyIterable())).thenReturn(Arrays.asList(3000.0, 3000.0));
        when(reportServiceHelper.getSalariesForMonth(anyString(), eq(Month.MARCH), anyIterable())).thenReturn(Arrays.asList(3000.0, 3000.0));
        when(reportServiceHelper.getSalariesForMonth(anyString(), eq(Month.APRIL), anyIterable())).thenReturn(Arrays.asList(8000.0, 4000.0));
        when(reportServiceHelper.getSalariesForMonth(anyString(), eq(Month.MAY), anyIterable())).thenReturn(Arrays.asList(8000.0, 4000.0));

        Map<String, List<Double>> actual= reportService.getReportByYear("2018");
        assertEquals(4, actual.keySet().size());
    }

    @Test
    public void shouldReturnYearReportWith12Months() {
        when(employeeRepository.findAll()).thenReturn(getMockEmployees());
        when(reportServiceHelper.getSalariesForMonth(anyString(), any(Month.class), anyIterable())).thenReturn(Arrays.asList(0.0, 0.0));

        Map<String, List<Double>> actual= reportService.getReportByYear("2017");
        assertEquals(12, actual.keySet().size());
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
