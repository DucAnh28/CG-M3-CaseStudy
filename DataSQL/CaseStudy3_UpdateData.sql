use casestudy3;
# Chạy dòng lệnh này để đổi tên cột imgage
## alter table books rename column imgage to image;
alter table books rename column author_id to author;
alter table books modify column author varchar(255);
# Book:
select * from books;

insert into books values (1,'SGK','Học cùng bé',1,123,1,'','');
insert into books values (2,'SGK1','Học cùng bé 1',2,1234,1,'','');
# Author:
select * from author;
insert into author values (1,'yolo','2000-08-12','Viet Nam','');
insert into author values (2,'yolo2','2000-08-12','Viet Nam','');
# Category:
select * from category;
insert into category values (1,'Khoa học viễn tưởng','Thể loại hành động không có thực');
# Customer:
select * from customer;
select * from customer where name like '%duc%';
insert into customer values (1,'bay',18,'Nam','HN','012345678','abcxyz@gmail.com','bay','123456','2000-08-12');
# Orders:
select * from orders;
insert into orders values (1,1,'2022-08-30');
select * from ordersdetail;
alter table books drop constraint books_ibfk_1;
alter table books drop constraint books_ibfk_2;
alter table books drop column category_id;

select * from books;

