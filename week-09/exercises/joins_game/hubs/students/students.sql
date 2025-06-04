-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 1: students (HUB)
CREATE TABLE students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    graduation_year INT NOT NULL
);

INSERT INTO students (name, email, graduation_year) VALUES
('Alice Johnson', 'alice.johnson@university.edu', 2025),
('Bob Smith', 'bob.smith@university.edu', 2024),
('Carol Davis', 'carol.davis@university.edu', 2026),
('David Wilson', 'david.wilson@university.edu', 2025),
('Emma Brown', 'emma.brown@university.edu', 2024),
('Frank Miller', 'frank.miller@university.edu', 2026);