-- MySQL JOINs Game - Your Table

CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    grade CHAR(2),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO enrollments (student_id, course_name, semester, grade) VALUES
(1, 'Database Systems', 'Spring 2024', 'A'),
(1, 'Web Development', 'Spring 2024', 'B+'),
(2, 'Data Structures', 'Spring 2024', 'A-'),
(3, 'Operating Systems', 'Spring 2024', 'B'),
(4, 'Computer Networks', 'Spring 2024', 'A'),
(5, 'Software Engineering', 'Spring 2024', 'B+');

-- Write your JOIN query here:
-- SELECT ...