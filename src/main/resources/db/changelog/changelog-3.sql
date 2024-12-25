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
    ('admin', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTczNTE2MzEyMiwiaWF0IjoxNzM1MTI3MTIyfQ.GGv9RP93j9L-_-jtNJQM0C440iww5mAVO9mn9PLtAEU');

--rollback drop table users;