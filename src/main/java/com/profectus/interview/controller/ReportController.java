package com.profectus.interview.controller;

import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.entity.Sales;
import com.profectus.interview.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/report/v1")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/sales/{format}", produces = {"application/json"})
    public List<Sales> sales(@PathVariable String format) throws FileNotFoundException, JRException {

        return reportService.exportSalesReport(format);

    }

}
