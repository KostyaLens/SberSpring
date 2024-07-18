create schema if not exists my_schema;

create table if not exists my_schema.products
(
    id_product       serial primary key,
    name_product     varchar(255) not null,
    price_product    integer      not null,
    quantity         integer      not null
);

create table if not exists my_schema.basket
(
    id_cart        serial primary key,
    promocode varchar(255)

);

create table if not exists my_schema.clients
(
    id_clients       serial primary key,
    name_clients     varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    email    varchar(255),
    basket_id  integer not null
     constraint client_basket_id_fk
            references my_schema.basket
);

create table if not exists my_schema.products_carts
(
    id_products_carts    serial primary key,
    id_product integer not null,
    quantity      integer not null,
    id_cart    integer not null,
    constraint product_client_products_id_fk foreign key (id_product) references my_schema.products (id_product),
    constraint product_client_basket_id_fk foreign key (id_cart) references my_schema.basket (id_cart)
);