insert into category (name)
values ('Мужское'),
       ('Женское'),
       ('Детское');

insert into seller (first_name, last_name, patronymic_name, username, password, phone, email)
values ('Артем', 'Кашапов', 'Ильясович', 'arkas_s', 'test', '+77777777777', 'arkas@mail.ru');

insert into orders (seller_id, status, goods_total, create_dt)
values (1, 'Delivered', 5000, '2022.05.25');

insert into product (name, description, price, count, image, seller_id, category_id)
values ('Футболка', '100% хлопок', 1000, 10, 'https://storage.yandexcloud.net/txt-shop/test_image.jpg', 1, 1);

insert into item (product_id, order_id, count)
values (1, 1, 15);






