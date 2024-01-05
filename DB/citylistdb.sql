DROP DATABASE IF EXISTS citylistdb;
CREATE DATABASE IF NOT EXISTS citylistdb;

USE citylistdb;

CREATE TABLE city (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	city VARCHAR(100),
	state VARCHAR(100),
	shot_glass TINYINT

);

DROP USER IF EXISTS traveler@localhost;

CREATE USER IF NOT EXISTS traveler@localhost IDENTIFIED BY 'traveler';

GRANT SELECT, INSERT, UPDATE, DELETE ON citylistdb.* TO traveler@localhost;

START TRANSACTION;

INSERT INTO city (id, city, state, shot_glass)
VALUES (1, 'DENVER', 'COLORADO', 1); 

COMMIT;
