package com.profectus.interview.controller;

import com.profectus.interview.domain.entity.Sales;
import com.profectus.interview.service.SalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction/v1")
public class TransactionController {

    private final SalesService salesService;

    public TransactionController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping(path = "/sales", produces = {"application/json"})
    public Sales sales(Sales sales) {
        return salesService.save(sales);
    }

    @PostMapping(path = "/doubleSales", produces = {"application/json"})
    public String doubleSales(Sales sales) throws Exception {
        salesService.doubleSave(sales);
        return "success";
    }

    @GetMapping(path = "/sales", produces = {"application/json"})
    public List<Sales> sales() {
        return salesService.findAll();
    }

}
