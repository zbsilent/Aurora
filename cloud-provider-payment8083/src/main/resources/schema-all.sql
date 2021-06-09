-- auto-generated definition
create table IF NOT EXISTS `payment`
(
    `id`     bigint(20) not null auto_increment comment 'id',
    `serial` varchar(200) default '',
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET =utf8;

-- auto-generated definition
create table IF NOT EXISTS bd_user
(
    user_id   bigint auto_increment
        primary key,
    birth_day datetime(6)  null,
    user_code varchar(255) null,
    user_name varchar(50)  null
);

