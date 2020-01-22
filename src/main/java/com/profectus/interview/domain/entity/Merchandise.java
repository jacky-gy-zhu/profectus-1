package com.profectus.interview.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Merchandise implements Transaction {

    @Id
    @GeneratedValue
    private int pid;
    private String productCode;
    private Date transactionDate;
    @Column(name="purchase_amount")
    private float amount;

}
