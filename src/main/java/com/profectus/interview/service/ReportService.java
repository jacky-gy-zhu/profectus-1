package com.profectus.interview.service;

import com.profectus.interview.domain.entity.Sales;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public interface ReportService {

    List<Sales> exportSalesReport(String reportFormat) throws JRException, FileNotFoundException;

}
