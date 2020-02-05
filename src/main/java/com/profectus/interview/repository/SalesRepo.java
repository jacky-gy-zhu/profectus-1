package com.profectus.interview.repository;

import com.profectus.interview.domain.entity.Sales;
import com.profectus.interview.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface SalesRepo extends JpaRepository<Sales,Integer> {

    /**
     * find Sales by list of product codes and date range
     * @param productCodeSet product codes which provided by the user from UI
     * @param fromDate get fromDate from data range which provided by the user from UI
     * @param toDate get toDate from data range which provided by the user from UI
     * @return Sales List that match the criteria
     */
    @Query("from Sales where productCode in (?1) and transactionDate >= ?2 and transactionDate <= ?3")
    List<Transaction> findByCodesAndDateRange(Set<String> productCodeSet, Date fromDate, Date toDate);

    /**
     * find Sales by date range
     * @param fromDate get fromDate from data range which provided by the user from UI
     * @param toDate get toDate from data range which provided by the user from UI
     * @return Sales List that match the criteria
     */
    @Query("from Sales where transactionDate >= ?1 and transactionDate <= ?2")
    List<Transaction> findByDateRange(Date fromDate, Date toDate);

}
