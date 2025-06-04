-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 9: professors (HUB)
CREATE TABLE professors (
    prof_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    hire_date DATE NOT NULL,
    salary DECIMAL(10,2) NOT NULL
);

INSERT INTO professors (name, email, hire_date, salary) VALUES
('Dr. Sarah Chen', 'sarah.chen@university.edu', '2018-08-15', 85000.00),
('Dr. Michael Roberts', 'michael.roberts@university.edu', '2015-01-10', 92000.00),
('Dr. Lisa Wang', 'lisa.wang@university.edu', '2020-08-20', 78000.00),
('Dr. James Taylor', 'james.taylor@university.edu', '2012-09-01', 105000.00),
('Dr. Emily Johnson', 'emily.johnson@university.edu', '2019-01-15', 82000.00);