-- MySQL JOINs Game - Your Table

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

-- Write your JOIN query here:
-- SELECT ...