insert into product (id, name, price, creation_date, description) values (1, 'Kindle', 350.0, date_sub(sysdate(), interval 1 day ), 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');

insert into client (id, name) values (1, 'Daniel Queiroz');
insert into client (id, name) values (3, 'Luiz Ricardo');
insert into client (id, name) values (4, 'Sabrina Vaz');

insert into `order` (id, client_id, request_date, total, status) values (1, 1, sysdate(), 700.0, 'WAITING');
insert into `order` (id, client_id, request_date, total, status) values (2, 1, sysdate(), 350.0, 'WAITING');

insert into ordered_item (order_id, product_id, price_product, amount) values (1, 1, 350.0, 2);
insert into ordered_item (order_id, product_id, price_product, amount) values (2, 1, 350.0, 1);

insert into category (id, name) values ('1', 'Eletronicos');

insert into payment (order_id, status, card_number, dtype) values (2, 'PROCESSING', '11212121', 'PaymentCard');