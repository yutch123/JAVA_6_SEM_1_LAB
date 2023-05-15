CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists country
(
    name        varchar     not null,
    capital     varchar,
    population  bigint,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
create table if not exists capital
(
    name        varchar     not null,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
create table if not exists city
(
    name        varchar not null,
    population  bigint,
    capital     varchar,
    UNIQUE      (name),
    PRIMARY KEY (name)
);
ALTER TABLE city ADD CONSTRAINT fk_roles FOREIGN KEY (capital) references capital(name);