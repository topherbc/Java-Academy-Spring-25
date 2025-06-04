-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 3: transcripts
CREATE TABLE transcripts (
    transcript_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    gpa DECIMAL(3,2) NOT NULL,
    total_credits INT NOT NULL,
    degree_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO transcripts (student_id, gpa, total_credits, degree_status) VALUES
(1, 3.75, 90, 'Senior'),
(2, 3.50, 120, 'Graduate'),
(3, 3.25, 60, 'Junior'),
(4, 3.85, 95, 'Senior'),
(5, 3.60, 125, 'Graduate'),
(6, 3.40, 30, 'Sophomore');