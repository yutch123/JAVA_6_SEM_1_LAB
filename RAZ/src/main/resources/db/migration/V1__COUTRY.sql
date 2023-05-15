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

ALTER TABLE users
    ADD email varchar(25)  NOT NULL UNIQUE,
    ADD password varchar(120) NOT NULL;

ALTER TABLE users
    ADD enabled boolean default true;

create table if not exists tokens(
                                     user_id uuid not null,
                                     value varchar(255) not null,
                                     killed bool,
                                     primary key(user_id),
                                     unique (user_id),
                                     unique (value)
);
alter table tokens add foreign key (user_id) references users(id);