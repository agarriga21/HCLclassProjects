MYSQL:

create database db_example_security_001;

create table db_example_security_001.album_genre (
    `id` int unsigned auto_increment primary key,
    `name` varchar(255),
    `artist` varchar(255),
    `price` decimal(19, 2) default null,
    `release_date` datetime(6) default null,
    `genre_name` varchar(255)
);


create table users(
	`user_id` int unsigned auto_increment primary key,
    `active` boolean default true,
    `billing` varchar(255) default null,
    `card_num` varchar(255),
    `cart` varchar(255) default null,
    `email` varchar(255) default null,
    `last_name` varchar(255) default null,
    `name` varchar(255) default null,
    `password` varchar(255),
    `privilege` varchar(255) default null,
    `user_name` varchar(255)
);

Insert into album_genre(artist, genre_name, name, price, release_date)
Values ('moe town', 'rock', 'thunder times', '19.95', '1976-02-12');

Insert into album_genre(artist, genre_name, name, price, release_date)
Values ('moe records', 'rap', 'wiizer', '12.95', '2009-02-12');

Insert into users(user_id, active, billing, card_num, cart, email, last_name, name, password, privilege, user_name)
Values (1, true, '2232 tree', '123454667', '', 'moss1@lopez', 'lopez', 'moss', '$2a$10$NnS/58hw6gi34qdug3kloewl6piGIKR8uBVMEVurC.m5vFiNOtV9q', 'USER', 'mossie');

Insert into users(user_id, active, billing, card_num, cart, email, last_name, name, password, privilege, user_name)
Values (3, true, '2232 tree circle', '12344454667', '', 'moss123@lopez', 'lop', 'mossie', '$2a$10$NnS/58hw6gi34qdug3kloewl6piGIKR8uBVMEVurC.m5vFiNOtV9q', 'ADMIN', 'moss');

Insert into db_example_security_001.roles(role_id,role)
Values (0,'ADMIN');
Insert into db_example_security_001.roles(role_id,role)
Values (1,'USER');