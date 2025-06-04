-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 4: advisors
CREATE TABLE advisors (
    advisor_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    advisor_name VARCHAR(100) NOT NULL,
    meeting_date DATE NOT NULL,
    notes TEXT,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO advisors (student_id, advisor_name, meeting_date, notes) VALUES
(1, 'Dr. Sarah Chen', '2024-03-15', 'Discussed thesis topic options'),
(2, 'Dr. Michael Roberts', '2024-03-10', 'Graduation requirements review'),
(3, 'Dr. Lisa Wang', '2024-03-20', 'Course selection for fall semester'),
(4, 'Dr. James Taylor', '2024-03-12', 'Internship opportunities discussion'),
(5, 'Dr. Sarah Chen', '2024-03-18', 'Research project planning');