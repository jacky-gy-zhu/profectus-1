package com.profectus.interview.service.factory;

import com.profectus.interview.domain.bean.ClaimSource;
import com.profectus.interview.domain.bean.Product;
import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.entity.Transaction;
import com.profectus.interview.repository.MerchandiseRepo;
import com.profectus.interview.repository.SalesRepo;
import com.profectus.interview.utils.DateUtil;
import com.profectus.interview.utils.LabelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductFactory extends ClaimFactory {

    private final SalesRepo salesRepo;
    private final MerchandiseRepo merchandiseRepo;

    @Autowired
    public ProductFactory(SalesRepo salesRepo, MerchandiseRepo merchandiseRepo) {
        this.salesRepo = salesRepo;
        this.merchandiseRepo = merchandiseRepo;
    }

    @Override
    public List<Transaction> createTransactionList(ClaimSource claimSource) {
        ProductClaim productClaim = (ProductClaim)claimSource;

        // get product codes
        Set<String> productCodeSet = productClaim.getProductList().stream()
                                     .map(Product::getCode)
                                     .collect(Collectors.toSet());

        // get date range from claim
        Date fromDate = DateUtil.convertToPureDate(productClaim.getFromDate());
        Date toDate = DateUtil.convertToPureDate(productClaim.getToDate());

        if (claimSource.getDataSource() == LabelConstants.SALES.getValue()) {
            return salesRepo.findByCodesAndDateRange(productCodeSet, fromDate, toDate);
        } else if (claimSource.getDataSource() == LabelConstants.MERCHANDISE.getValue()) {
            return merchandiseRepo.findByCodesAndDateRange(productCodeSet, fromDate, toDate);
        } else {
            return null;
        }
    }

}
