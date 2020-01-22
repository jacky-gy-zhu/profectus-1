package com.profectus.interview.service.factory;

import com.profectus.interview.domain.bean.ClaimSource;
import com.profectus.interview.domain.entity.Transaction;

import java.util.List;

public abstract class ClaimFactory {

    public abstract List<Transaction> createTransactionList(ClaimSource claimSource);

}
