package com.profectus.interview.service;

import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.bean.TieredClaim;
import org.springframework.stereotype.Service;

@Service
public interface CalcService {

    float calcProductClaim(ProductClaim productClaim);

    float calcTieredClaim(TieredClaim tieredClaim);

}
