-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 18: student_meal_accounts
CREATE TABLE student_meal_accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    plan_id INT NOT NULL,
    student_name VARCHAR(100) NOT NULL,
    balance DECIMAL(8,2) NOT NULL,
    last_used DATE,
    FOREIGN KEY (plan_id) REFERENCES meal_plans(plan_id)
);

INSERT INTO student_meal_accounts (plan_id, student_name, balance, last_used) VALUES
(2, 'Alice Johnson', 1650.00, '2024-03-19'),
(1, 'Bob Smith', 950.00, '2024-03-18'),
(3, 'Carol Davis', 2100.00, '2024-03-20'),
(4, 'David Wilson', 600.00, '2024-03-17'),
(2, 'Emma Brown', 1400.00, '2024-03-19'),
(5, 'Frank Miller', 1200.00, '2024-03-16');