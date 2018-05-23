package pl.msliwczynski.employee.management.utils;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateUtilTest {


    @Test
    public void shouldReturnTrueIfDateIsEqualStartDate() {
        LocalDate date = LocalDate.of(2018, 03,01);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertTrue(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnTrueIfDateIsEqualEndDate() {
        LocalDate date = LocalDate.of(2018, 03,31);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertTrue(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnTrueIfDateIsBetweenStartAndEndDate() {
        LocalDate date = LocalDate.of(2018, 03,15);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertTrue(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnFalseIfDateIsBeforeStartDate() {
        LocalDate date = LocalDate.of(2018, 02,15);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertFalse(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnFalseIfDateIsAfterEndDate() {
        LocalDate date = LocalDate.of(2018, 04,01);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertFalse(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnFalseIfStartDateIsNull() {
        LocalDate date = LocalDate.of(2018, 04,01);
        LocalDate startDate = null;
        LocalDate endDate = LocalDate.of(2018, 03,31);;

        assertFalse(DateUtil.isBetween(date, startDate, endDate));
    }

    @Test
    public void shouldReturnFalseIfEndDateIsNull() {
        LocalDate date = LocalDate.of(2018, 04,01);
        LocalDate startDate = LocalDate.of(2018, 03,01);;
        LocalDate endDate = null;

        assertFalse(DateUtil.isBetween(date, startDate, endDate));
    }


}
