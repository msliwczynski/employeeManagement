package pl.msliwczynski.employee.management.service;

import java.util.List;
import java.util.Map;

public interface ReportService {
    Map<Integer, List<Double>> getReportByYear(String year);
    List<Double> getReportByMonth(String month, String year);
}
