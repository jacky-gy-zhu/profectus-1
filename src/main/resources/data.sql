insert into sales(pid, product_code, transaction_date, sale_amount) values (1, 'A', '2019-12-17', 1000);
insert into sales(pid, product_code, transaction_date, sale_amount) values (2, 'A', '2019-12-18', 900);
insert into sales(pid, product_code, transaction_date, sale_amount) values (3, 'A', '2019-12-27', 1200);
insert into sales(pid, product_code, transaction_date, sale_amount) values (4, 'B', '2020-01-07', 1300);
insert into sales(pid, product_code, transaction_date, sale_amount) values (5, 'C', '2020-01-09', 4000);

insert into merchandise(pid, product_code, transaction_date, purchase_amount) values (1, 'A', '2019-12-17', 50);
insert into merchandise(pid, product_code, transaction_date, purchase_amount) values (2, 'A', '2019-12-18', 1000);
insert into merchandise(pid, product_code, transaction_date, purchase_amount) values (3, 'A', '2019-12-27', 2000);
insert into merchandise(pid, product_code, transaction_date, purchase_amount) values (4, 'B', '2020-01-07', 5000);
insert into merchandise(pid, product_code, transaction_date, purchase_amount) values (5, 'C', '2020-01-19', 2550);

insert into tiers(tid, min_value, max_value, discount_rate) values (1, 0, 1000, 2);
insert into tiers(tid, min_value, max_value, discount_rate) values (2, 1001, 5000, 5);
insert into tiers(tid, min_value, max_value, discount_rate) values (3, 5001, -1, 7.5);