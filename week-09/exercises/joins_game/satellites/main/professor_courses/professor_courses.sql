-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 10: professor_courses
CREATE TABLE professor_courses (
    pc_id INT PRIMARY KEY AUTO_INCREMENT,
    prof_id INT NOT NULL,
    course_taught VARCHAR(100) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    enrollment_count INT NOT NULL,
    FOREIGN KEY (prof_id) REFERENCES professors(prof_id)
);

INSERT INTO professor_courses (prof_id, course_taught, semester, enrollment_count) VALUES
(1, 'Database Systems', 'Spring 2024', 25),
(1, 'Advanced Databases', 'Spring 2024', 15),
(2, 'Data Structures', 'Spring 2024', 35),
(3, 'Operating Systems', 'Spring 2024', 28),
(4, 'Software Engineering', 'Spring 2024', 22),
(5, 'Computer Networks', 'Spring 2024', 30);