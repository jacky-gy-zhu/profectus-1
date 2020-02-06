package com.profectus.interview.service.impl;

import com.profectus.interview.domain.pojo.Fare;
import com.profectus.interview.domain.pojo.TaxiRide;
import com.profectus.interview.service.TaxiFareCalculatorService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorServiceImpl implements TaxiFareCalculatorService {

    private final KieContainer kieContainer;

    public TaxiFareCalculatorServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public float calculateFare(TaxiRide taxiRide, Fare rideFare) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rideFare.getRideFare()+rideFare.getNightSurcharge();
    }

}
