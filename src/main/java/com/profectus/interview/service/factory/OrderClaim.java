package com.profectus.interview.service.factory;

import com.profectus.interview.domain.bean.ClaimSource;
import com.profectus.interview.domain.entity.Transaction;

import java.util.List;

public class OrderClaim {

    private ClaimFactory claimFactory;
    private ClaimSource claimSource;

    public OrderClaim(ClaimFactory claimFactory, ClaimSource claimSource) {
        this.claimFactory = claimFactory;
        this.claimSource = claimSource;
    }

    public List<Transaction> findTransactionList(){
        return claimFactory.createTransactionList(claimSource);
    }

}
