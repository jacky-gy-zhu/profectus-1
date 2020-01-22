package com.profectus.interview.service.calculator;

import com.profectus.interview.domain.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ProductClaimCalculator implements Calculator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Float> productDiscountMap;

    public ProductClaimCalculator(Map<String, Float> productDiscountMap){
        this.productDiscountMap = productDiscountMap;
    }

    @Override
    public float calc(List<Transaction> transactionList) {
        if (transactionList != null) {
            float claimTotal = transactionList.stream()
                    .reduce(0f, (total, t) -> {
                        // product code
                        String productCode = t.getProductCode();

                        // saleAmount or purchaseAmount based on which datasource
                        float amount = t.getAmount();

                        // discount from prdMap which stored what user filled from UI
                        float discount = productDiscountMap.get(productCode);

                        // amount after discounted
                        float subTotal = amount * (discount / 100);
                        subTotal = Math.round(subTotal * 100f) / 100f;

                        // logger to record these details
                        logger.info("productCode: " + productCode + "\t$" + amount + "\t" + discount + "%\t==>\t" + subTotal);

                        // return total by reduce function
                        return total + subTotal;
                    }, Float::sum);
            logger.info("------------Product claim Total:" + claimTotal + "---------------");
            return claimTotal;
        } else {
            return 0;
        }
    }

}
