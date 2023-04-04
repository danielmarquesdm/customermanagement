create table management.customer
(
    id            bigint auto_increment
        primary key,
    federal_id    varchar(255) null,
    ie            varchar(255) null,
    name          varchar(255) null,
    register_date date         null,
    rg            varchar(255) null,
    situation     smallint     null,
    type          smallint     null,
    constraint UK_q99k4pa19xlgcyxnq6hfw2o7p
        unique (federal_id)
);