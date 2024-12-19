--liquibase formatted sql

--changeset TatsianaKobets:2
--comment create project_section table
create table project_section
(
    id          serial primary key,
    project_id  integer not null,
    name        varchar(255) not null,
    type        varchar(50) not null,
    constraint fk_project_section_project foreign key (project_id) references project (id) on delete cascade
);

insert into project_section (project_id, name, type)
values
    (1, 'Section 1', 'AR'),
    (1, 'Section 2', 'KR'),
    (2, 'Section 3', 'IOS1');

--rollback drop table project_section;