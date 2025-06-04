-- MySQL JOINs Game - Your Table

CREATE TABLE buildings (
    building_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    construction_year INT NOT NULL,
    total_floors INT NOT NULL
);

INSERT INTO buildings (name, construction_year, total_floors) VALUES
('Science Hall', 1995, 4),
('Technology Center', 2010, 3),
('Student Union', 1985, 2),
('Library', 1970, 5),
('Engineering Building', 2005, 4),
('Athletic Center', 2000, 2);

-- Write your JOIN query here:
-- SELECT ...