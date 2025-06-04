-- MySQL JOINs Game - Your Table

CREATE TABLE classrooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT NOT NULL,
    room_number VARCHAR(10) NOT NULL,
    capacity INT NOT NULL,
    equipment VARCHAR(100),
    FOREIGN KEY (building_id) REFERENCES buildings(building_id)
);

INSERT INTO classrooms (building_id, room_number, capacity, equipment) VALUES
(1, '101', 40, 'Projector, Whiteboard, Computers'),
(1, '205', 35, 'Projector, Smart Board'),
(2, '150', 50, 'Lab Equipment, Projector'),
(3, '201', 25, 'Projector, Conference Setup'),
(4, '301', 100, 'Lecture Hall, Audio System'),
(5, '120', 30, 'Engineering Tools, Projector');

-- Write your JOIN query here:
-- SELECT ...