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
        return ProductClaimBuilder.aProductClaimBuilder()
                .setDataSource(LabelConstants.SALES.getValue())
                .setFromDate(Date.valueOf(LocalDate.of(2019, 12, 17)))
                .setToDate(Date.valueOf(LocalDate.of(2020, 1, 9)))
                .addProductClaim(new Product("A", 10))
                .addProductClaim(new Product("B", 20))
                .addProductClaim(new Product("C", 30))
                .build();
    }

    public static class ProductClaimBuilder {

        private int dataSource;
        private Date fromDate;
        private Date toDate;
        private List<Product> products = new ArrayList<>();

        public static ProductClaimBuilder aProductClaimBuilder() {
            return new ProductClaimBuilder();
        }

        public ProductClaimBuilder setDataSource(int dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public ProductClaimBuilder setFromDate(Date fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public ProductClaimBuilder setToDate(Date toDate) {
            this.toDate = toDate;
            return this;
        }

        public ProductClaimBuilder addProductClaim(Product product) {
            products.add(product);
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
