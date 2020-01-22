package com.profectus.interview.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Sales implements Transaction {

    @Id
    @GeneratedValue
    private int pid;
    private String productCode;
    private Date transactionDate;
    @Column(name="sale_amount")
    private float amount;

}
