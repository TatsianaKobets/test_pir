--liquibase formatted sql

--changeset TatsianaKobets:1
--comment first migration
create table project
(
    id          serial primary key,
    title       varchar(255) not null,
    code        varchar(50) not null unique,
    start_date  date not null,
    end_date    date not null,
    status      varchar(50) not null
);

insert into project (title, code, start_date, end_date, status)
values
    ('Project Alpha', 'PA-001', '2023-01-01', '2023-12-31', 'IN_PROGRESS'),
    ('Project Beta', 'PB-002', '2023-02-01', '2023-11-30', 'DELETED');

--rollback drop table project;