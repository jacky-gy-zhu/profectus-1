package com.profectus.interview.service;

import com.profectus.interview.domain.bean.Product;
import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.entity.Transaction;
import com.profectus.interview.service.factory.OrderClaim;
import com.profectus.interview.service.factory.ProductFactory;
import com.profectus.interview.service.impl.CalcServiceImpl;
import com.profectus.interview.utils.LabelConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcServiceImplMockTest {

    @InjectMocks
    CalcServiceImpl calcService;

    @Mock
    ProductFactory productFactory;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testProductClaim(){
        // pre-requisite productClaim
        ProductClaim productClaim = getProductClaim();

        // mock calcService
        OrderClaim orderClaim = new OrderClaim(productFactory,productClaim);
        List<Transaction> transactionList = orderClaim.findTransactionList();
        Mockito.when(transactionList).thenAnswer(invocationOnMock -> Arrays.asList(
                new Transaction() {
                    @Override
                    public String getProductCode() {
                        return "A";
                    }

                    @Override
                    public float getAmount() {
                        return 1000;
                    }
                },
                new Transaction() {
                    @Override
                    public String getProductCode() {
                        return "A";
                    }

                    @Override
                    public float getAmount() {
                        return 900;
                    }
                },
                new Transaction() {
                    @Override
                    public String getProductCode() {
                        return "A";
                    }

                    @Override
                    public float getAmount() {
                        return 1200;
                    }
                },
                new Transaction() {
                    @Override
                    public String getProductCode() {
                        return "B";
                    }

                    @Override
                    public float getAmount() {
                        return 1300;
                    }
                },
                new Transaction() {
                    @Override
                    public String getProductCode() {
                        return "C";
                    }

                    @Override
                    public float getAmount() {
                        return 4000;
                    }
                }
        ));

        final float claimTotal = calcService.calcProductClaim(productClaim);
        assertThat(claimTotal).isEqualTo(1770);
    }

    private ProductClaim getProductClaim() {
        ProductClaim productClaim = new ProductClaim();
        productClaim.setDataSource(LabelConstants.SALES.getValue());
        productClaim.setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)));
        productClaim.setToDate(Date.valueOf(LocalDate.of(2020, 1, 9)));
        productClaim.setProductList(Arrays.asList(
                new Product("A", 10),
                new Product("B", 20),
                new Product("C", 30)
        ));
        return productClaim;
    }

}
