package com.profectus.interview.service;

import com.profectus.interview.domain.pojo.Fare;
import com.profectus.interview.domain.pojo.TaxiRide;
import org.springframework.stereotype.Service;

@Service
public interface TaxiFareCalculatorService {

    float calculateFare(TaxiRide taxiRide, Fare rideFare);

}
