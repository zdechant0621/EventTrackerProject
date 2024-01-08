DROP DATABASE IF EXISTS citylistdb;
CREATE DATABASE IF NOT EXISTS citylistdb;

USE citylistdb;

CREATE TABLE city (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	city VARCHAR(100),
	state_country VARCHAR(100),
	description TEXT,
	arrival_date DATE,
	departure_date DATE,
	shot_glass_bought TINYINT,
	enabled TINYINT

);

DROP USER IF EXISTS traveler@localhost;

CREATE USER IF NOT EXISTS traveler@localhost IDENTIFIED BY 'traveler';

GRANT SELECT, INSERT, UPDATE, DELETE ON citylistdb.* TO traveler@localhost;

START TRANSACTION;

INSERT INTO city (id, city, state_country, description, arrival_date, departure_date, shot_glass_bought, enabled)
VALUES (1, 'Chicago', 'Illinois', 'Lots of fun!', '2023-12-27', '2023-12-23', 1, 1),
	   (2, 'Grand Lake', 'Colorado', 'Meh, not a lot to do', '2023-08-27', '2023-08-29', 1, 1),
	   (3, 'Belfast', 'Northern Ireland', 'One of the cleanest cities', '2023-08-02', '2023-08-02', 1, 1),
	   (4, 'Dublin', 'Ireland', 'One of the best vacations. Would love to go back', '2023-07-31', '2023-08-05', 1, 1),
	   (5, 'Glenwood Springs', 'Colorado', 'Had a blast, Maroon Bells were beautiful', '2023-06-02', '2023-06-05', 1, 1),
	   (6, 'Helena', 'Montana', 'Had a blast. Fun little city.', '2023-05-21', '2023-05-25', 1, 1),
	   (7, 'Salt Lake City', 'Utah', 'Amazing scenery. Got to see the lake this time', '2023-05-08', '2023-05-12', 1, 1),
	   (8, 'Kansas City', 'Missouri', 'Overnight. Will go back', '2023-01-30', '2023-01-31', 1, 1),
	   (9, 'Nashville', 'Tennessee', 'Honky Tonk Row was wild', '2023-01-29', '2023-01-30', 1, 1);
	   


COMMIT;
