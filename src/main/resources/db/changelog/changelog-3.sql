--liquibase formatted sql

--changeset TatsianaKobets:3
--comment first migration
create table users
(
    id       serial primary key,
    username varchar(255) not null,
    password varchar(255) not null
);

insert into users (username, password)
values ('admin', 'password');

--rollback drop table users;