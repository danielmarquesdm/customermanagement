create table management.phone_number
(
    id                bigint auto_increment
        primary key,
    main_phone_number bit          not null,
    phone_number      varchar(255) null,
    phone_number_id   bigint       null,
    constraint FKfmuq8gej0rop9fkxxviyrc4yv
        foreign key (phone_number_id) references management.customer (id)
);

