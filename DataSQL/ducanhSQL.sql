# Customer:
select * from customer;
select * from customer where account = 'ducanh123' and password = 'ducanh123';
alter table customer add column status varchar(255) default 'ACTIVATE';
delete from customer where id = 12;
select * from customer where name like '%duc%';
insert into customer values (1,'bay',18,'Nam','HN','012345678','abcxyz@gmail.com','bay','123456','2000-08-12','ACTIVATE');
# Orders:

select * from orders;
insert into orders values (1,1,'2022-08-30');
insert into orders values (2,5,'2022-08-30');
# insert into orders values (3,2,'2022-08-30');
select * from ordersdetail;
insert into ordersdetail (orders_id, book_id, quantity) values (1,1,3);
insert into ordersdetail (orders_id, book_id, quantity) values (2,1,3);
insert into ordersdetail (orders_id, book_id, quantity) values (2,2,1);
insert into ordersdetail (orders_id, book_id, quantity) values (2,3,2);

select name,author,price,image,o.quantity,
from books
join ordersdetail o on books.id = o.book_id
join orders o2 on o2.id = o.orders_id
where customer_id = 5;
# Xử lý lại database;
drop table orders;
drop table ordersdetail;