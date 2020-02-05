package com.profectus.interview.service.impl;

import com.profectus.interview.domain.entity.Sales;
import com.profectus.interview.repository.SalesRepo;
import com.profectus.interview.service.ReportService;
import com.profectus.interview.service.factory.ReportFactory;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ReportServiceImpl implements ReportService {

    private final SalesRepo salesRepo;

    public ReportServiceImpl(SalesRepo salesRepo) {
        this.salesRepo = salesRepo;
    }

    @Override
    public List<Sales> exportSalesReport(String reportFormat) throws JRException, FileNotFoundException {
        // in which path to generate report
        String path = "/Users/jackyzhu/Downloads";

        // get report data
        List<Sales> salesList = salesRepo.findAll();

        // load report file and compile it
        File file = ResourceUtils.getFile("classpath:report/sales.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(salesList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Jacky Zhu");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // report factory
        ReportFactory reportFactory = new ReportFactory(reportFormat);
        reportFactory.export(jasperPrint,path);

        return salesList;
    }

}
