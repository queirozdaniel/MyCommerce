insert into product (id, name, price, description) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');

insert into client (id, name) values (1, 'Daniel Queiroz');
insert into client (id, name) values (3, 'Luiz Ricardo');
insert into client (id, name) values (4, 'Sabrina Vaz');

insert into pedido (id, client_id, request_date, total, status) values (1, 1, sysdate(), 100.0, 'WAITING');

insert into item_pedido (id, order_id, product_id, price_product, amount) values (1, 1, 1, 5.0, 2);