create table if not exists professions (
    id serial not null,
    name varchar(50) not null,

    constraint pk_profession primary key(id)
);