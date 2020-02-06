package com.profectus.interview.service;

import com.profectus.interview.domain.bean.Product;
import com.profectus.interview.domain.bean.ProductClaim;
import com.profectus.interview.domain.entity.Transaction;
import com.profectus.interview.service.factory.OrderClaim;
import com.profectus.interview.service.factory.ProductFactory;
import com.profectus.interview.service.impl.CalcServiceImpl;
import com.profectus.interview.utils.LabelConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CalcServiceImplMockTest {

    @InjectMocks
    CalcServiceImpl calcService;

    @Mock
    ProductFactory productFactory;

    @Test
    public void testProductClaim() {
        // pre-requisite productClaim
        ProductClaim productClaim = getProductClaim();

        // mock calcService
        OrderClaim orderClaim = new OrderClaim(productFactory, productClaim);
        List<Transaction> transactionList = orderClaim.findTransactionList();
        Mockito.when(transactionList).thenReturn(Arrays.asList(
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

        // verify productFactory be invoked
        Mockito.verify(productFactory).createTransactionList(productClaim);

        assertThat(claimTotal).isEqualTo(1770);
    }

    private ProductClaim getProductClaim() {
        ProductClaim productClaim = ProductClaimBuilder.aProductClaimBuilder()
                .dataSource(LabelConstants.SALES.getValue())
                .fromDate(Date.valueOf(LocalDate.of(2019, 12, 17)))
                .toDate(Date.valueOf(LocalDate.of(2020, 1, 9)))
                .withProductClaim(
                        new Product("A", 10),
                        new Product("B", 20),
                        new Product("C", 30))
                .build();
        return productClaim;
    }

    public static class ProductClaimBuilder {

        private int dataSource;
        private Date fromDate;
        private Date toDate;
        private Product[] products = new Product[]{};

        public static ProductClaimBuilder aProductClaimBuilder() {
            return new ProductClaimBuilder();
        }

        public ProductClaimBuilder dataSource(int dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public ProductClaimBuilder fromDate(Date fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public ProductClaimBuilder toDate(Date toDate) {
            this.toDate = toDate;
            return this;
        }

        public ProductClaimBuilder withProductClaim(Product... products) {
            this.products = products;
            return this;
        }

        public ProductClaim build() {
            ProductClaim productClaim = new ProductClaim();
            addDataSourceTo(productClaim);
            addFromDateTo(productClaim);
            addToDateTo(productClaim);
            addProductsTo(productClaim);
            return productClaim;
        }

        private void addToDateTo(ProductClaim productClaim) {
            productClaim.setToDate(toDate);
        }

        private void addFromDateTo(ProductClaim productClaim) {
            productClaim.setFromDate(fromDate);
        }

        private void addDataSourceTo(ProductClaim productClaim) {
            productClaim.setDataSource(dataSource);
        }

        private void addProductsTo(ProductClaim productClaim) {
            for (Product product : products) {
                if (productClaim.getProductList() == null) {
                    productClaim.setProductList(new ArrayList<>());
                }
                productClaim.getProductList().add(product);
            }
        }

    }

}
