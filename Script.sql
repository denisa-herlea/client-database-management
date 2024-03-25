drop table orders;
drop table stocks;
drop table products;
drop table clients;

create table clients(
idc int(2), 
nume varchar(20),
adresa varchar(25)
);

create table products(
idp int(2),
nume varchar(15),
price float(4)
);

create table orders(
ido int(2),
idc int(2),
idp int(2),
quantity int(2),
price float(3)
);

create table stocks(
ids int(2),
idp int(2),
quantity int(2)
);

ALTER TABLE clients
ADD CONSTRAINT clients_idc_pk PRIMARY KEY(idc);

ALTER TABLE products
ADD CONSTRAINT products_idp_pk PRIMARY KEY(idp);

ALTER TABLE orders
ADD CONSTRAINT orders_ido_pk PRIMARY KEY(ido);

ALTER TABLE stocks
ADD CONSTRAINT stocks_ids_pk PRIMARY KEY(ids);

ALTER TABLE orders ADD CONSTRAINT orders_idc_fk FOREIGN KEY (idc)
REFERENCES clients(idc);

ALTER TABLE orders ADD CONSTRAINT orders_idp_fk FOREIGN KEY (idp)
REFERENCES products(idp);

ALTER TABLE stocks ADD CONSTRAINT stocks_idp_fk FOREIGN KEY (idp)
REFERENCES products(idp);



insert into clients(idc,nume,adresa) 
values (1,'Pop Alex','str 1 decembrie, nr 5');

insert into clients(idc,nume,adresa) 
values (2,'Popa Matei','str 2 ianuarie, nr 6');

insert into clients(idc,nume,adresa) 
values (3,'Matei Ana','str 3 iunie, nr 7');

insert into clients(idc,nume,adresa) 
values (4,'Popescu Ioana','str 4 aprilie, nr 8');

insert into clients(idc,nume,adresa) 
values (5,'Lazar Andrei','str 5 mai, nr 9');

insert into clients(idc,nume,adresa) 
values (6,'Lazar Alina','str 5 mai, nr 9');

insert into clients(idc,nume,adresa) 
values (7,'Chis Ariana','str 6 martie, nr 10');

insert into clients(idc,nume,adresa) 
values (8,'Dima Tudor','str 7 mai, nr 11');

insert into clients(idc,nume,adresa) 
values (9,'Florea Stefan','str 8 august, nr 12');

insert into clients(idc,nume,adresa) 
values (10,'Popovici Maria','str 9 septembrie, nr 13');




insert into products(idp,nume,price)
values(1,'matura',10);

insert into products(idp,nume,price)
values(2,'pasta de dinti',5);

insert into products(idp,nume,price)
values(3,'servetele',8);

insert into products(idp,nume,price)
values(4,'sapun',7);

insert into products(idp,nume,price)
values(5,'cereale',13);

insert into products(idp,nume,price)
values(6,'banane',9);

insert into products(idp,nume,price)
values(7,'morcovi',8);

insert into products(idp,nume,price)
values(8,'creioane colorate',20);

insert into products(idp,nume,price)
values(9,'caiet',3);

insert into products(idp,nume,price)
values(10,'foarfeca',10);




insert into orders(ido,idc,idp,quantity,price)
values(1,1,2,2,10);

insert into orders(ido,idc,idp,quantity,price)
values(2,4,6,5,45);


insert into orders(ido,idc,idp,quantity,price)
values(3,6,5,1,13);


insert into orders(ido,idc,idp,quantity,price)
values(4,2,10,2,20);


insert into orders(ido,idc,idp,quantity,price)
values(5,9,7,6,48);


insert into orders(ido,idc,idp,quantity,price)
values(6,10,9,3,9);



insert into stock(ids,idp,quantity)
values(1,1,15);

insert into stock(ids,idp,quantity)
values(2,2,20);

insert into stock(ids,idp,quantity)
values(3,3,30);

insert into stock(ids,idp,quantity)
values(4,4,15);

insert into stock(ids,idp,quantity)
values(5,5,8);

insert into stock(ids,idp,quantity)
values(6,6,24);

insert into stock(ids,idp,quantity)
values(7,7,20);

insert into stock(ids,idp,quantity)
values(8,8,15);

insert into stock(ids,idp,quantity)
values(9,9,10);

insert into stock(ids,idp,quantity)
values(10,10,9);