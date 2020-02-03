<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.profectus.interview.utils.LabelConstants" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product productClaim calculator</title>

    <!-- JARS -->
    <link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="webjars/vue/2.6.11/vue.min.js"></script>

    <!-- CUSTOMIZED CSS -->
    <link href="${pageContext.request.contextPath}/css/daterangepicker.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

</head>
<body class="text-center">
    <div class="container">
        <h2>Calculators</h2>
        <nav class="nav nav-pills nav-justified">
            <a class="nav-item nav-link active" data-id="product" href="#">Product productClaim</a>
            <a class="nav-item nav-link" data-id="tiered" href="#">Tiered productClaim</a>
        </nav>

        <div class="tab-content">
            <div class="tab-pane active" id="product" role="tabpanel" aria-labelledby="product-tab">
                <h3>Product productClaim calculator</h3>
                <div class="form-calc" id="product-calc">

                    <div class="form-group data-source">
                        <div class="row">
                            <div class="col-md-12">
                                <select class="form-control" v-model="dataSource">
                                    <option value="<%=LabelConstants.NONE.getValue()%>">Please select a data source</option>
                                    <option value="<%=LabelConstants.SALES.getValue()%>"><%=LabelConstants.SALES.getName()%></option>
                                    <option value="<%=LabelConstants.MERCHANDISE.getValue()%>"><%=LabelConstants.MERCHANDISE.getName()%></option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group date-range">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="input-group input-large date-picker input-daterange daterange-picker" data-app="product">
                                    <input type="text" class="form-control" placeholder="Please select a range of dates" v-model="dateRange">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group" v-for="product in products">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" class="form-control productCode" placeholder="PRD Code" v-model="product.code">
                            </div>
                            <div class="col-md-6">
                                <input type="number" class="form-control discount" placeholder="discount rate" v-model="product.discount">
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <button class="btn btn-lg btn-warning btn-block" type="button" @click="addProduct">Add Prd</button>
                            </div>
                            <div class="col-md-6">
                                <button class="btn btn-lg btn-primary btn-block" type="button" @click="submitCalc">Calc Total</button>
                            </div>
                        </div>
                    </div>

                    <h2 class="calc-product-result"></h2>

                </div>
            </div>
            <div class="tab-pane" id="tiered" role="tabpanel" aria-labelledby="tiered-tab">
                <h3>Tiered productClaim calculator</h3>
                <div class="form-calc" id="tiered-calc">

                    <div class="form-group data-source">
                        <div class="row">
                            <div class="col-md-12">
                                <select class="form-control" v-model="dataSource">
                                    <option value="<%=LabelConstants.NONE.getValue()%>">Please select a data source</option>
                                    <option value="<%=LabelConstants.SALES.getValue()%>"><%=LabelConstants.SALES.getName()%></option>
                                    <option value="<%=LabelConstants.MERCHANDISE.getValue()%>"><%=LabelConstants.MERCHANDISE.getName()%></option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group date-range">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="input-group input-large date-picker input-daterange daterange-picker" data-app="tiered">
                                    <input type="text" class="form-control" placeholder="Please select a range of dates" v-model="dateRange">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <button class="btn btn-lg btn-primary btn-block" type="button" @click="submitCalc">Calc Total</button>
                            </div>
                        </div>
                    </div>

                    <h2 class="calc-tiered-result"></h2>

                </div>
            </div>
        </div>

        <p class="mt-5 mb-3 text-muted">
            @Author: Jacky Zhu<br>
            Email: <a href="mailto:jacky.gy.zhu@gmail.com" target="_blank">jacky.gy.zhu@gmail.com</a><br>
            Tel: <a href="tel:0414843009" target="_blank">0414843009</a>
        </p>

    </div>

    <!-- CUSTOMIZED JS -->
    <script src="${pageContext.servletContext.contextPath}/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/daterangepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>

</body>
</html>