package com.profectus.interview.service.factory;

import com.profectus.interview.domain.bean.ClaimSource;
import com.profectus.interview.domain.bean.TieredClaim;
import com.profectus.interview.domain.entity.Transaction;
import com.profectus.interview.repository.MerchandiseRepo;
import com.profectus.interview.repository.SalesRepo;
import com.profectus.interview.utils.DateUtil;
import com.profectus.interview.utils.LabelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class TieredFactory extends ClaimFactory {

    private final SalesRepo salesRepo;
    private final MerchandiseRepo merchandiseRepo;

    @Autowired
    public TieredFactory(SalesRepo salesRepo, MerchandiseRepo merchandiseRepo) {
        this.salesRepo = salesRepo;
        this.merchandiseRepo = merchandiseRepo;
    }

    @Override
    public List<Transaction> createTransactionList(ClaimSource claimSource) {
        TieredClaim tieredClaim = (TieredClaim)claimSource;

        // get date range from claim
        Date fromDate = DateUtil.convertToPureDate(tieredClaim.getFromDate());
        Date toDate = DateUtil.convertToPureDate(tieredClaim.getToDate());

        if (claimSource.getDataSource() == LabelConstants.SALES.getValue()) {
            return salesRepo.findByDateRange(fromDate, toDate);
        } else if (claimSource.getDataSource() == LabelConstants.MERCHANDISE.getValue()) {
            return merchandiseRepo.findByDateRange(fromDate, toDate);
        } else {
            return null;
        }
    }

}
