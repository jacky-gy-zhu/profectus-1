package com.profectus.interview.controller;

import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.bean.TieredClaim;
import com.profectus.interview.service.CalcService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calc")
public class CalcController {

    private CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @PostMapping(path = "/claim/product", consumes = {"application/json"}, produces = {"application/json"})
    public float claimProduct(@RequestBody ProductClaim productClaim) {

        return calcService.calcProductClaim(productClaim);

    }

    @PostMapping(path = "/claim/tiered", consumes = {"application/json"}, produces = {"application/json"})
    public float claimTiered(@RequestBody TieredClaim tieredClaim) {

        return calcService.calcTieredClaim(tieredClaim);

    }

}


