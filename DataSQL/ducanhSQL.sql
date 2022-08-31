# Customer:
select * from customer;
alter table customer add column status varchar(255) default 'ACTIVATE';
delete from customer where id = 1;
select * from customer where name like '%duc%';
insert into customer values (1,'bay',18,'Nam','HN','012345678','abcxyz@gmail.com','bay','123456','2000-08-12','ACTIVATE');
# Orders:
select * from orders;
insert into orders values (1,1,'2022-08-30');
select * from ordersdetail;