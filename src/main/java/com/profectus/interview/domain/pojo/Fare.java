package com.profectus.interview.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    private float nightSurcharge;
    private float rideFare;

}
