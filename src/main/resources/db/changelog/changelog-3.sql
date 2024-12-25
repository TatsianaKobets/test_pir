--liquibase formatted sql

--changeset TatsianaKobets:3
--comment create users table
create table users
(
    id       serial primary key,
    username varchar(255) not null,
    password varchar(255) not null
);
insert into users (username, password)
values
    ('admin', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTczNTE1NDU4NSwiaWF0IjoxNzM1MTE4NTg1fQ.tT9Ng_oSU3N35wO9MYm48FKfX6-Ir1cQipsO6c2E4hU');

--rollback drop table users;