package com.profectus.interview.service.impl;

import com.profectus.interview.domain.entity.Sales;
import com.profectus.interview.domain.exception.BusinessException;
import com.profectus.interview.repository.SalesRepo;
import com.profectus.interview.service.SalesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepo salesRepo;

    public SalesServiceImpl(SalesRepo salesRepo) {
        this.salesRepo = salesRepo;
    }

    @Override
    public Sales save(Sales sales) {
        return salesRepo.save(sales);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void doubleSave(Sales sales) throws Exception {
        saveFirstSales(sales);
        saveSecondSales(sales);
        throw new BusinessException("Test");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveFirstSales(Sales sales) throws Exception {
        try {
            salesRepo.save(sales);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSecondSales(Sales sales) throws Exception {
        try {
            Sales s2 = sales.clone();
            s2.setPid(0);
            s2.setAmount(sales.getAmount()*2);
            s2.setProductCode("-----"+sales.getProductCode());
            s2.setTransactionDate(new Date());
            salesRepo.save(s2);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(e);
        }
    }

    @Override
    public Sales findById(int id) {
        return salesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Sales> findAll() {
        return salesRepo.findAll();
    }

}
