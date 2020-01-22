package com.profectus.interview.service.calculator;

import com.profectus.interview.domain.entity.Tiers;
import com.profectus.interview.domain.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TieredClaimCalculator implements Calculator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private List<Tiers> tiers;

    public TieredClaimCalculator(List<Tiers> tiers){
        this.tiers = tiers;
    }

    @Override
    public float calc(List<Transaction> transactionList) {
        if (transactionList != null && tiers != null) {

            // get total amount from data range
            float totalAmount = transactionList.stream()
                    .reduce(0f, (total, t) -> {
                        float subTotal = Math.round(t.getAmount() * 100f) / 100f;
                        return total + subTotal;
                    }, Float::sum);

            // make the total amount to int in case it be 1000.xx which is not in the range of tiers
            // because tiers like 0 ~ 1000 ; 1001 ~ 5000; 5001 ~ MAXVALUE
            // if maxValue is -1 means it's MAXVALUE
            final float totalInt = (int) totalAmount;
            logger.info("------------Total Amount:" + totalInt + "---------------");

            // loop tiered to calc
            List<Double> subTotalList = new ArrayList<>();
            tiers.stream()
                    .filter(t -> t.getMinValue() <= totalInt) // exclude the tiers which not in totalInt scope in the first place
                    .reduce(null, (prev, curr) -> {
                        float discountRate = curr.getDiscountRate();
                        int maxValue = curr.getMaxValue();
                        int minValue = curr.getMinValue();
                        double subTotal;
                        if (maxValue < 0 // means it hits the max tier
                                || (totalAmount >= minValue && totalAmount <= maxValue)) {
                            // hit the tier
                            if (prev != null) {
                                subTotal = (totalInt - prev.getMaxValue()) * (discountRate / 100);
                            } else {
                                subTotal = totalInt * (discountRate / 100);
                            }
                        } else {
                            // still in the middle of the tiers, loop will go next level tier before long
                            // Now that totalInt over the curr tier, calc the curr tier discount
                            if (prev != null) {
                                subTotal = (maxValue - prev.getMaxValue()) * (discountRate / 100);
                            } else {
                                subTotal = maxValue * (discountRate / 100);
                            }
                        }
                        subTotal = Math.round(subTotal * 100f) / 100f;
                        subTotalList.add(subTotal);
                        return curr;
                    });
            double claimTotal = subTotalList.stream()
                    .peek(d -> {
                        // logger to record these details
                        logger.info("subTotal after discount: " + d);
                    })
                    .mapToDouble(Double::doubleValue)
                    .sum();
            claimTotal = Math.round(claimTotal * 100f) / 100f;
            logger.info("------------Tiered claim Total:" + claimTotal + "---------------");
            return (float) claimTotal;
        } else {
            return 0;
        }
    }

}
