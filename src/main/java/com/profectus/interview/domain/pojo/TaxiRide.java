package com.profectus.interview.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxiRide {

    private boolean nightSurcharge;
    private long distanceInMile;

}
