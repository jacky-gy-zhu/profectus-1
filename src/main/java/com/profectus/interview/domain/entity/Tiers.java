package com.profectus.interview.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Tiers {

    @Id
    private int tid;
    private int minValue;
    private int maxValue;
    private float discountRate;

}
