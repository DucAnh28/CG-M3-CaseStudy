use casestudy3;
# # Chạy dòng lệnh này để đổi tên cột imgage
# alter table books rename column imgage to image;
# alter table books rename column author_id to author;

# Book:
select * from books;
insert into books(id, code, name, author, price, image, description) VALUE (1, 'AA1', 'Khong gia dinh(tai ban nam 2022)', 'Hector Malot', 127.500, 'https://bookbuy.vn/Res/Images/Product/khong-gia-dinh-tai-ban-2022-_118548_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (2, 'AA2', 'Dao giau vang(tai ban nam 2022)', 'R.L.Stevenson', 38.500, 'https://bookbuy.vn/Res/Images/Product/dao-giau-vang-tac-pham-chon-loc-van-hoc-scotland-tai-ban-2022-_118540_1.jpg', 'Sach cho nguoi lon');
insert into books(id, code, name, author, price, image, description) VALUE (3, 'AA3', 'Ty quay - nhung truyen sieu buon cuoi(tai ban 2022)', 'Dao Hai', 102.000, 'https://bookbuy.vn/Res/Images/Product/ty-quay-nhung-truyen-sieu-buon-cuoi-tai-ban-2022-_118525_1.jpg', 'Sach tre em duoi 18 tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (4, 'AA4', 'Tranh truyen lich su Viet Nam', 'Nguyen Huy Thang & Le Minh Hai', 12.500, 'https://bookbuy.vn/Res/Images/Product/tranh-truyen-lich-su-viet-nam-thanh-thai_117869_1.jpg', 'Sach cho moi nguoi Viet Nam nen doc');
insert into books(id, code, name, author, price, image, description) VALUE (5, 'AA5', 'Chu tiem banh chien binh va co phuc vu nguoi may', 'Sow', 109.500, 'https://bookbuy.vn/Res/Images/Product/chu-tiem-banh-chien-binh-va-co-phuc-vu-nguoi-may-tap-5-_117009_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (6, 'AA6', 'Khong sao dau con, chap nhan loi tu choi', 'Tran Hong Tuan', 28.500, 'https://bookbuy.vn/Res/Images/Product/khong-sao-dau-con-chap-nhan-loi-tu-choi_116732_1.PNG', 'Sach cho moi lua tuoi');
insert into books(id, code, name, author, price, image, description) VALUE (7, 'AA7', 'Chuyen ve chu tho cool nhat Ha Lan', 'Guido Van Genechten', 44.500, 'https://bookbuy.vn/Res/Images/Product/chuyen-ve-chu-tho-cool-nhat-ha-lan-riki-gan-da_115849_1.jpg', 'Sach kha hay va doc dao');
insert into books(id, code, name, author, price, image, description) VALUE (8, 'AA8', 'Chuyen nay chuyen kia', 'Dom Dom', 89.500, 'https://bookbuy.vn/Res/Images/Product/115376_chuyen-nay-chuyen-kia-2-ban-dac-biet_115375_2.png', 'Sach cho tre em');
alter table books drop constraint books_ibfk_1;
alter table books drop constraint books_ibfk_2;
alter table books drop column category_id;
alter table books modify column author varchar(255);
# # Author: (Đã bỏ bảng tác giả)
# drop table author;
# select * from author;
# insert into author values (1,'yolo','2000-08-12','Viet Nam','');
# insert into author values (2,'yolo2','2000-08-12','Viet Nam','')


# Category:
select * from category;
insert into category values (1,'Khoa học viễn tưởng','Thể loại hành động không có thực');
delete from category where id = 1;
insert into category(id, type, description) VALUE (1, 'Chinh tri - phap luat', 'danh cho nhung chinh tri gia');
insert into category(id, type, description) VALUE (2, 'Khoa hoc cong nghe - Kinh te', 'danh cho hoc sinh, sinh vien, ...');
insert into category(id, type, description) VALUE (3, 'Van hoc nghe thuat', 'danh cho nhung nguoi dam me nghe thuat');
insert into category(id, type, description) VALUE (4, 'Van hoa hoi - lich su', 'danh cho nhung nguoi yeu lich su');
insert into category(id, type, description) VALUE (5, 'Giao trinh', 'danh cho hoc sinh, sinh vien');
insert into category(id, type, description) VALUE (6, 'Truyen, tieu thuyet', 'danh cho nhung nguoi dam me truyen');
insert into category(id, type, description) VALUE (7, 'Tam ly, tam linh, ton giao', 'danh cho nhung nguoi yeu tim');
insert into category(id, type, description) VALUE (8, 'Thieu nhi', 'danh cho tre con');






