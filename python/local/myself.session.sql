CREATE TABLE player (
    jersey INT PRIMARY KEY,
    name VARCHAR(20),
    team VARCHAR(5)
);




INSERT INTO player(jersey , name , team ) VALUES(6,'dhon','sk');

SELECT * FROM emp96;

DESCRIBE player;

DROP TABLE player;

ALTER TABLE player ADD centuries INT;
 