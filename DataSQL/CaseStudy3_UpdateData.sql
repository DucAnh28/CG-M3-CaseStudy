use casestudy3;
select * from author;
select * from category;
select * from books;
select * from customer;
select * from orders;
select * from ordersdetail;
# Chạy dòng lệnh này để đổi tên cột imgage
alter table books rename column imgage to image;

insert into books values (1,'SGK','Học cùng bé',1,123,1,'','');
insert into books values (2,'SGK1','Học cùng bé 1',2,1234,1,'','');

insert into author values (1,'yolo','2000-08-12','Viet Nam','');
insert into author values (2,'yolo2','2000-08-12','Viet Nam','');

insert into category values (1,'Khoa học viễn tưởng','Thể loại hành động không có thực');

insert into customer values (1,'bay',18,'Nam','HN','012345678','abcxyz@gmail.com','bay','123456','2000-08-12');

insert into orders values (1,1,'2022-08-30');

select books.name ,a.name
from books join author a on a.id = books.author_id;


select * from books;
