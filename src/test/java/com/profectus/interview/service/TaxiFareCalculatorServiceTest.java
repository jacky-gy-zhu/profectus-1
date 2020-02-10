package com.profectus.interview.service;

import com.profectus.interview.domain.pojo.TaxiRide;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxiFareCalculatorServiceTest {

    @Autowired
    TaxiFareCalculatorService taxiFareCalculatorService;

    @Test
    public void whenNightSurchargeFalseAndDistLessThan10() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(9);
        
        float totalCharge = taxiFareCalculatorService.calculateFare(taxiRide);

        assertEquals(70, totalCharge);
    }

    @Test
    public void whenNightSurchargeFalseAndDistMoreThan10() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(19);
        
        float totalCharge = taxiFareCalculatorService.calculateFare(taxiRide);

        assertEquals(97, totalCharge);
    }

    @Test
    public void whenNightSurchargeTrueAndDistLessThan10() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setNightSurcharge(true);
        taxiRide.setDistanceInMile(9);
        
        float totalCharge = taxiFareCalculatorService.calculateFare(taxiRide);

        assertEquals(88, totalCharge);
    }

    @Test
    public void whenNightSurchargeTrueAndDistMoreThan10() {
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setNightSurcharge(true);
        taxiRide.setDistanceInMile(19);
        
        float totalCharge = taxiFareCalculatorService.calculateFare(taxiRide);

        assertEquals(135, totalCharge);
    }

}
