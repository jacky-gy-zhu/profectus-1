package com.profectus.interview.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Sales implements Transaction,Cloneable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int pid;
    private String productCode;
    private Date transactionDate;
    @Column(name="sale_amount")
    private float amount;

    public Sales clone() throws CloneNotSupportedException {
        return (Sales)super.clone();
    }

}
