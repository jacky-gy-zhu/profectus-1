package com.profectus.interview.domain.entity;

/**
 * Defining the method signature that will be invoked in ProductClaimCalculator
 */
public interface Transaction {

    String getProductCode();

    float getAmount();

}
