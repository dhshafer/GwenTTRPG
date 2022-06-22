BEGIN TRANSACTION;
DROP TABLE IF EXISTS publisher_types, genres, mechanics, keywords, games_keywords, games;

CREATE TABLE publisher_types (
    id serial not null primary key,
    publisher_type varchar(50)
);

CREATE TABLE genres (
    id serial not null primary key,
    genre varchar(50)
);

CREATE TABLE mechanics (
    id serial not null primary key,
    mechanic varchar(50)
);

CREATE TABLE games (
    id serial not null PRIMARY KEY,
    name VARCHAR(50),
    source_url VARCHAR(500),
    publisher_id int,
    genre_id int,
    mechanic_id int,
    foreign key (publisher_id) references publisher_types (id),
    foreign key (genre_id) references genres (id),
    foreign key (mechanic_id) references mechanics (id)
);

CREATE TABLE keywords (
    id serial not null primary key,
    keyword varchar(50)
);

CREATE TABLE games_keywords (
    game_id int not null,
    keyword_id int not null,
    foreign key (game_id) references games (id),
    foreign key (keyword_id) references keywords (id)
);

DROP USER IF EXISTS gwenttrpg_appuser;

CREATE USER gwenttrpg_appuser
WITH PASSWORD 'gwenttrpg';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO gwenttrpg_appuser;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO gwenttrpg_appuser;

COMMIT TRANSACTION;