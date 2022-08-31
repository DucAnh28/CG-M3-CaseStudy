create database casestudy3;
use casestudy3;

## Thể loại:
create table category
(
    id          int primary key auto_increment,
    type        varchar(255),
    description varchar(255)
);
## Tác giả:
create table author
(
    id          int auto_increment primary key,
    name        varchar(255) not null,
    yearBorn    date         not null,
    national    varchar(255),
    description varchar(255)
);
## Sách
create table books
(
    id          int primary key auto_increment,
    code        varchar(255) not null,
    name        varchar(255) not null,
    author_id   int          not null,
    foreign key (author_id) references author (id),
    price       double       not null,
    category_id int          not null,
    foreign key (category_id) references category (id),
    imgage      varchar(255),
    description nvarchar(255)
);
# Danh mục sách cùng thể loại:
create table book_category
(
    book_id     int not null,
    category_id int not null,
    foreign key (book_id) references books (id),
    foreign key (category_id) references books (id)
);
## Kho:
        create table stock
        (
        id int primary key auto_increment,
        book_id int not null,
        foreign key (book_id) references books (id),
        quantity int
        );
## Khách hàng:
create table customer
(
    id        int primary key,
    name      varchar(255) not null,
    age       int          not null,
    gender    varchar(255) not null,
    address   varchar(255),
    phone     varchar(255) not null,
    email     varchar(255) not null,
    account   varchar(255) not null,
    password  varchar(255) not null,
    startdate date         not null
);
## Đơn hàng:
create table orderS
(
    id          int primary key auto_increment,
    customer_id int,
    foreign key (customer_id) references customer (id),
    dateBuy     date
);
## Đơn hàng chi tiết:
create table ordersdetail
(
    id        int primary key auto_increment,
    orders_id int,
    foreign key (orders_id) references orderS (id),
    book_id   int,
    foreign key (book_id) references books (id),
    quantity  int not null
);


