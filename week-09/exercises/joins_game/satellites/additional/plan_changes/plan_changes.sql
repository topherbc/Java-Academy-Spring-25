-- MySQL JOINs Game Database

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- Table 20: plan_changes
CREATE TABLE plan_changes (
    change_id INT PRIMARY KEY AUTO_INCREMENT,
    plan_id INT NOT NULL,
    old_plan VARCHAR(50) NOT NULL,
    new_plan VARCHAR(50) NOT NULL,
    change_date DATE NOT NULL,
    reason VARCHAR(200),
    FOREIGN KEY (plan_id) REFERENCES meal_plans(plan_id)
);

INSERT INTO plan_changes (plan_id, old_plan, new_plan, change_date, reason) VALUES
(2, 'Basic Plan', 'Standard Plan', '2024-02-15', 'Needed more meals per week'),
(3, 'Standard Plan', 'Premium Plan', '2024-01-20', 'Upgraded for convenience'),
(1, 'Standard Plan', 'Basic Plan', '2024-03-01', 'Budget constraints'),
(4, 'Basic Plan', 'Commuter Plan', '2024-02-10', 'Moving off campus'),
(5, 'Standard Plan', 'Graduate Plan', '2024-01-15', 'Started graduate program');