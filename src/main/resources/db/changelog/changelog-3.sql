--liquibase formatted sql

--changeset TatsianaKobets:3
--comment create users table
create table users
(
    id       serial primary key,
    username varchar(255) not null,
    password varchar(255) not null
);

--rollback drop table users;