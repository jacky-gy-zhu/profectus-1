package com.profectus.interview.service.impl;

import com.profectus.interview.domain.bean.Product;
import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.bean.TieredClaim;
import com.profectus.interview.domain.entity.Transaction;
import com.profectus.interview.service.CalcService;
import com.profectus.interview.service.calculator.*;
import com.profectus.interview.service.factory.OrderClaim;
import com.profectus.interview.service.factory.ProductFactory;
import com.profectus.interview.service.factory.TieredFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalcServiceImpl implements CalcService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProductFactory productFactory;
    private final TieredFactory tieredFactory;
    private final TierConfig tierConfig;

    @Autowired
    public CalcServiceImpl(ProductFactory productFactory, TieredFactory tieredFactory, TierConfig tierConfig) {
        this.productFactory = productFactory;
        this.tieredFactory = tieredFactory;
        this.tierConfig = tierConfig;
    }

    @Override
    public float calcProductClaim(ProductClaim productClaim) {
        safeDebug("ready to calc product claim for : " + productClaim.toString());

        // build a Map for key -> productCode : value -> discount
        Map<String, Float> prdMap = productClaim.getProductList().stream()
            .collect(Collectors.toMap(Product::getCode, Product::getDiscount));

        // find transaction data from database accordingly
        OrderClaim orderClaim = new OrderClaim(productFactory,productClaim);
        List<Transaction> transactionList = orderClaim.findTransactionList();

        safeDebug("product transactionList found: " + transactionList.toString());

        // do calc
        Calculator calculator = new ProductClaimCalculator(prdMap);
        ClaimCalculator claimCalculator = new ClaimCalculator(calculator);
        return claimCalculator.calc(transactionList);
    }

    private void safeDebug(String message){
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public float calcTieredClaim(TieredClaim tieredClaim) {
        safeDebug("ready to calc tiered claim for : " + tieredClaim.toString());

        // find transaction data from database accordingly
        OrderClaim orderClaim = new OrderClaim(tieredFactory,tieredClaim);
        List<Transaction> transactionList = orderClaim.findTransactionList();

        safeDebug("tiered transactionList found: " + transactionList.toString());

        // do calc
        Calculator calculator = new TieredClaimCalculator(tierConfig.list());
        ClaimCalculator claimCalculator = new ClaimCalculator(calculator);
        return claimCalculator.calc(transactionList);
    }

}