create database casestudy3;
use casestudy3;

create table books(
id int primary key auto_increment,
code varchar(255) not null,
name varchar(255) not null,
author varchar(255) not null,
price double not null,
bookType varchar(255) not null,
description nvarchar(255) );

create table customer(
id int primary key ,
name varchar(255) not null,
age int not null,
gender varchar(255) not null, 
address varchar(255) ,
phone varchar(255) not null,
email varchar(255) not null,
account varchar(255) not null,
password varchar(255) not null,
startdate date not null );


