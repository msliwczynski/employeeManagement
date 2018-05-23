package pl.msliwczynski.employee.management.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtil {
    /**
     *
     * @param date
     * @param startDate - inclusive
     * @param endDate - inclusive
     * @return true when is between range or false when is not
     */
    public static boolean isBetween(LocalDate date, LocalDate startDate, LocalDate endDate) {
        if (date == null || startDate == null || endDate == null) {
            return false;
        }
        return (date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate));
    }
}
