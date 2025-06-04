-- MySQL JOINs Game - Your Table

CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    credits INT NOT NULL,
    department VARCHAR(50) NOT NULL
);

INSERT INTO courses (course_name, credits, department) VALUES
('Database Systems', 3, 'Computer Science'),
('Data Structures', 4, 'Computer Science'),
('Operating Systems', 3, 'Computer Science'),
('Calculus I', 4, 'Mathematics'),
('Physics I', 4, 'Physics'),
('English Composition', 3, 'English');

-- Write your JOIN query here:
-- SELECT ...