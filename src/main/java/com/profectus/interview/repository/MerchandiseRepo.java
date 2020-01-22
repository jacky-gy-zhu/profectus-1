package com.profectus.interview.repository;

import com.profectus.interview.domain.entity.Merchandise;
import com.profectus.interview.domain.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface MerchandiseRepo extends CrudRepository<Merchandise,Integer> {

    /**
     * find Merchandise by list of product codes and date range
     * @param productCodeSet product codes which provided by the user from UI
     * @param fromDate get fromDate from data range which provided by the user from UI
     * @param toDate get toDate from data range which provided by the user from UI
     * @return Merchandise List that match the criteria
     */
    @Query("from Merchandise where productCode in (?1) and transactionDate >= ?2 and transactionDate <= ?3")
    List<Transaction> findByCodesAndDateRange(Set<String> productCodeSet, Date fromDate, Date toDate);

    /**
     * find Merchandise by date range
     * @param fromDate get fromDate from data range which provided by the user from UI
     * @param toDate get toDate from data range which provided by the user from UI
     * @return Merchandise List that match the criteria
     */
    @Query("from Merchandise where transactionDate >= ?1 and transactionDate <= ?2")
    List<Transaction> findByDateRange(Date fromDate, Date toDate);

}
