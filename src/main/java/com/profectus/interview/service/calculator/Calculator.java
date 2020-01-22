package com.profectus.interview.service.calculator;

import com.profectus.interview.domain.entity.Transaction;

import java.util.List;

public interface Calculator {

    float calc(List<Transaction> transactionList);

}
