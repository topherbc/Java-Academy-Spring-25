-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 11: office_assignments
CREATE TABLE office_assignments (
    office_id INT PRIMARY KEY AUTO_INCREMENT,
    prof_id INT NOT NULL,
    building VARCHAR(50) NOT NULL,
    room_number VARCHAR(10) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    FOREIGN KEY (prof_id) REFERENCES professors(prof_id)
);

INSERT INTO office_assignments (prof_id, building, room_number, phone) VALUES
(1, 'Science Hall', '301A', '555-0101'),
(2, 'Science Hall', '302B', '555-0102'),
(3, 'Technology Center', '205', '555-0103'),
(4, 'Engineering Building', '150', '555-0104'),
(5, 'Science Hall', '310', '555-0105');