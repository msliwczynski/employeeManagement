package pl.msliwczynski.employee.management.model;

import java.io.Serializable;

public class ReportYear implements Serializable {
    private String year;
    private String newYear;

    public ReportYear() {
    }

    public ReportYear(String year, String newYear) {
        this.year = year;
        this.newYear = newYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNewYear() {
        return newYear;
    }

    public void setNewYear(String newYear) {
        this.newYear = newYear;
    }

    @Override
    public String toString() {
        return "ReportYear{" +
                "year='" + year + '\'' +
                ", newYear='" + newYear + '\'' +
                '}';
    }
}
