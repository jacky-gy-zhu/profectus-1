package com.profectus.interview.service;

import com.profectus.interview.domain.bean.Product;
import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.bean.TieredClaim;
import com.profectus.interview.utils.LabelConstants;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CalcServiceTest {

    @Autowired
    private CalcService calcService;

    @Before
    public void init() {
        // Nothing here so far since H2 database is set by memory level
    }

    /**
     * Test Sales from full range date
     */
    @Test
    public void calcProductClaimForSalesIncludeBothEdge() {
        ProductClaim productClaim = new ProductClaim();
        productClaim.setDataSource(LabelConstants.SALES.getValue());
        productClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        productClaim.setToDate(Date.valueOf(LocalDate.of(2020, 1, 9)));
        productClaim.setProductList(Arrays.asList(
                new Product("A", 10),
                new Product("B", 20),
                new Product("C", 30)
        ));
        final float claimTotal = calcService.calcProductClaim(productClaim);
        assertThat(claimTotal).isEqualTo(1770);
    }

    /**
     * Test Sales from particular range date only with A
     */
    @Test
    public void calcProductClaimForSalesWithA() {
        ProductClaim productClaim = new ProductClaim();
        productClaim.setDataSource(LabelConstants.SALES.getValue());
        productClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        productClaim.setToDate(Date.valueOf(LocalDate.of(2019, 12, 29)));
        productClaim.setProductList(Arrays.asList(
                new Product("A", 10),
                new Product("B", 10)
        ));
        final float claimTotal = calcService.calcProductClaim(productClaim);
        assertThat(claimTotal).isEqualTo(310);
    }

    /**
     * Test Merchandise from full range date
     */
    @Test
    public void calcProductClaimForMerchandiseIncludeBothEdge() {
        ProductClaim productClaim = new ProductClaim();
        productClaim.setDataSource(LabelConstants.MERCHANDISE.getValue());
        productClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        productClaim.setToDate(Date.valueOf(LocalDate.of(2020, 1, 19)));
        productClaim.setProductList(Arrays.asList(
                new Product("A", 10),
                new Product("B", 20),
                new Product("C", 30)
        ));
        final float claimTotal = calcService.calcProductClaim(productClaim);
        assertThat(claimTotal).isEqualTo(2070);
    }

    /**
     * Test Merchandise from particular range date only with B
     */
    @Test
    public void calcProductClaimForMerchandiseWithB() {
        ProductClaim productClaim = new ProductClaim();
        productClaim.setDataSource(LabelConstants.MERCHANDISE.getValue());
        productClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        productClaim.setToDate(Date.valueOf(LocalDate.of(2019, 12, 29)));
        productClaim.setProductList(Arrays.asList(
                new Product("B", 10),
                new Product("C", 10)
        ));
        final float claimTotal = calcService.calcProductClaim(productClaim);
        assertThat(claimTotal).isEqualTo(0);
    }

    /**
     * Test Sales from full range date
     */
    @Test
    void calcTierClaimForSalesIncludeBothEdge() {
        TieredClaim tieredClaim = new TieredClaim();
        tieredClaim.setDataSource(LabelConstants.SALES.getValue());
        tieredClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        tieredClaim.setToDate(Date.valueOf(LocalDate.of(2020, 1, 9)));
        final float claimTotal = calcService.calcTieredClaim(tieredClaim);
        assertThat(claimTotal).isEqualTo(475);
    }

    /**
     * Test Merchandise from full range date
     */
    @Test
    void calcTierClaimForMerchandiseIncludeBothEdge() {
        TieredClaim tieredClaim = new TieredClaim();
        tieredClaim.setDataSource(LabelConstants.MERCHANDISE.getValue());
        tieredClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        tieredClaim.setToDate(Date.valueOf(LocalDate.of(2020, 1, 9)));
        final float claimTotal = calcService.calcTieredClaim(tieredClaim);
        assertThat(claimTotal).isEqualTo(448.75f);
    }

    /**
     * Test Merchandise from particular range date
     */
    @Test
    void calcTierClaimForMerchandiseForParticularDateRange() {
        TieredClaim tieredClaim = new TieredClaim();
        tieredClaim.setDataSource(LabelConstants.MERCHANDISE.getValue());
        tieredClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        tieredClaim.setToDate(Date.valueOf(LocalDate.of(2019, 12, 27)));
        final float claimTotal = calcService.calcTieredClaim(tieredClaim);
        assertThat(claimTotal).isEqualTo(122.5f);
    }

}