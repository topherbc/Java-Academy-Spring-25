-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 6: prerequisites
CREATE TABLE prerequisites (
    prereq_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    required_course VARCHAR(100) NOT NULL,
    min_grade CHAR(2) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO prerequisites (course_id, required_course, min_grade) VALUES
(1, 'Data Structures', 'C+'),
(2, 'Programming Fundamentals', 'C'),
(3, 'Computer Architecture', 'C+'),
(4, 'Pre-Calculus', 'B-'),
(5, 'College Algebra', 'C+');