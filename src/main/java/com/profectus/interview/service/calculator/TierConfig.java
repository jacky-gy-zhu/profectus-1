package com.profectus.interview.service.calculator;

import com.profectus.interview.domain.entity.Tiers;
import com.profectus.interview.repository.TiersRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TierConfig {

    private TiersRepo tiersRepo;
    private List<Tiers> tiers;

    public TierConfig(TiersRepo tiersRepo) {
        this.tiersRepo = tiersRepo;
        init();
    }

    private void init() {
        if (tiers == null) {
            tiers = tiersRepo.findAllByOrderByTidAsc();
        }
    }

    public List<Tiers> list(){
        return tiers;
    }

}
