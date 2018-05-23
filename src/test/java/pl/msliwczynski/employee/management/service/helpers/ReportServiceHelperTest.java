package pl.msliwczynski.employee.management.service.helpers;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReportServiceHelperTest {
    private ReportServiceHelper reportServiceHelper = new ReportServiceHelper();

    @Test
    public void shouldReturnTrueIfWorkStartDateIsBeforeEndOfYear() {
        LocalDate workStartDate = LocalDate.of(2017, 12,30);
        assertTrue(reportServiceHelper.isWorkStartDateBeforeEndOfTheYear(workStartDate, "2017"));
    }

    @Test
    public void shouldReturnFalseIfWorkStartDateIsAfterEndOfYear() {
        LocalDate workStartDate = LocalDate.of(2018, 1,1);
        assertFalse(reportServiceHelper.isWorkStartDateBeforeEndOfTheYear(workStartDate, "2017"));
    }

    @Test
    public void shouldReturnTrueIfWorkEndDateIsNull() {
        assertTrue(reportServiceHelper.isWorkEndDateNullEqualsOrAfterEndOfYear(null, "2017"));
    }

    @Test
    public void shouldReturnTrueIfWorkEndDateIsEqualsEndOfYear() {
        LocalDate workEndDate = LocalDate.of(2017, 12,31);
        assertTrue(reportServiceHelper.isWorkEndDateNullEqualsOrAfterEndOfYear(workEndDate, "2017"));
    }

    @Test
    public void shouldReturnTrueIfWorkEndDateIsAfterEndOfYear() {
        LocalDate workEndDate = LocalDate.of(2018, 1,1);
        assertTrue(reportServiceHelper.isWorkEndDateNullEqualsOrAfterEndOfYear(workEndDate, "2017"));
    }

}
