package pl.msliwczynski.employee.management.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.msliwczynski.employee.management.model.ReportYear;
import pl.msliwczynski.employee.management.service.ReportService;

import java.time.LocalDate;

@Controller
public class ReportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/user/report")
    public String getAnnualReport(Model model) {
        LOGGER.info("Generating report");
        String currentYear = String.valueOf(LocalDate.now().getYear());
        ReportYear reportYear = new ReportYear(currentYear, "");
        model.addAttribute("reportYear", reportYear);
        model.addAttribute("report", reportService.getReportByYear(currentYear));

        return "report";
    }

    @PostMapping("/user/setYear")
    public String setYear(@ModelAttribute ReportYear reportYear, Model model) {
        LOGGER.info("ReportYear: {}", reportYear);
        model.addAttribute("report", reportService.getReportByYear(reportYear.getNewYear()));
        model.addAttribute("reportYear", new ReportYear(reportYear.getNewYear(), ""));

        return "report";
    }
}
