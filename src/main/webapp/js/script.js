$(function(){
    var daterangepicker = function(selector){
        $(selector).each(function(){
            var obj = $(this);
            $(obj).daterangepicker({
                format: 'YYYY-MM-DD',
                separator: ' to ',
                startDate: moment().subtract('days', 29),
                endDate: moment(),
                //minDate: '01/01/2012',
                //maxDate: '12/31/2018',
            },function (start, end) {
                var val = start.format('YYYY-MM-DD') + ' ~ ' + end.format('YYYY-MM-DD');
                $('input',obj).val(val);
                if($(obj).data('app') == 'product') {
                    productApp.dateRange = val;
                }else if($(obj).data('app') == 'tiered') {
                    tieredApp.dateRange = val;
                }
            });
        });
    }
    daterangepicker('.daterange-picker');

    $('.nav-link').on('click', function (e) {
        e.preventDefault()
        let id = $(this).data('id')
        $('.nav-link').removeClass('active')
        $('.tab-pane').removeClass('active')
        $('#'+id).addClass('active')
        $(this).addClass('active')
    })

});

var productApp = new Vue({
    el: '#product-calc',
    data: {
        dataSource: 0,
        dateRange: '',
        products: []
    },
    methods: {
        addProduct: function () {
            this.products.push({})
        },
        submitCalc: function() {
            //validate
            if(this.dataSource === 0){
                alert('Please select a datasource')
                return;
            }
            if(this.dateRange.length === 0){
                alert('Please select a date range')
                return;
            }
            if(this.products.length === 0){
                alert('Please add a product at least')
                return;
            }

            //parse date range
            let dateArr = this.dateRange.split(' ~ ')

            //data
            let data = {
                dataSource: this.dataSource,
                fromDate: dateArr[0],
                toDate: dateArr[1],
                productList: this.products
            }

            // console.log(JSON.stringify(data))

            //submit
            $.ajax({
                url: $contextPath+'/calc/v1/claim/product',
                type: 'POST',
                contentType : 'application/json;charset=utf-8',
                dataType:"json",
                data: JSON.stringify(data),
                success: function(data){
                    // console.log(data)
                    $('.calc-product-result').text(`calc result: $${data}`)
                },
                error: function(res){
                    alert(res.responseText);
                }
            });

        }
    }
})

var tieredApp = new Vue({
    el: '#tiered-calc',
    data: {
        dataSource: 0,
        dateRange: '',
        products: []
    },
    methods: {
        addProduct: function () {
            this.products.push({})
        },
        submitCalc: function() {
            //validate
            if(this.dataSource === 0){
                alert('Please select a datasource')
                return;
            }
            if(this.dateRange.length === 0){
                alert('Please select a date range')
                return;
            }

            //parse date range
            let dateArr = this.dateRange.split(' ~ ')

            //data
            let data = {
                dataSource: this.dataSource,
                fromDate: dateArr[0],
                toDate: dateArr[1]
            }

            //submit
            $.ajax({
                url: $contextPath+'/calc/v1/claim/tiered',
                type: 'POST',
                contentType : 'application/json;charset=utf-8',
                dataType:"json",
                data: JSON.stringify(data),
                success: function(data){
                    // console.log(data)
                    $('.calc-tiered-result').text(`calc result: $${data}`)
                },
                error: function(res){
                    alert(res.responseText);
                }
            });

        }
    }
})
