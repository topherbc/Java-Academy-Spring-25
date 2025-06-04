-- MySQL JOINs Game - Your Table

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

-- Write your JOIN query here:
-- SELECT ...