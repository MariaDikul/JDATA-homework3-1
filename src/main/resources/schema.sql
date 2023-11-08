create table customers
(
    id           serial primary key ,
    name         varchar(25) not null,
    surname      varchar(25) not null,
    age          int         not null,
    phone_number varchar(15) not null

);

create table orders
(
    id           serial primary key,
    date         varchar(50)  not null,
    customer_id  integer      not null,
    product_name varchar(255) not null,
    amount       integer      not null,
    foreign key (customer_id) references customers (id)
);