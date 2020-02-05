package com.profectus.interview.service;

import com.profectus.interview.domain.entity.Sales;

import java.util.List;

public interface SalesService {

    Sales save(Sales sales);

    void doubleSave(Sales sales) throws Exception;

    Sales findById(int id);

    List<Sales> findAll();

}
