package com.profectus.interview.service.factory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportFactory {

    public ReportFactory(String format) {
        this.format = format;
    }

    private String format;

    public void export(JasperPrint jasperPrint, String path) throws JRException {
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "/sales.html");
        } else if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "/sales.pdf");
        }
    }

}
