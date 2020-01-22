package com.profectus.interview.service.calculator;

import com.profectus.interview.domain.entity.Transaction;

import java.util.List;

public class ClaimCalculator {

    private Calculator calculator;

    public ClaimCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public float calc(List<Transaction> transactionList){
        return calculator.calc(transactionList);
    }

}
