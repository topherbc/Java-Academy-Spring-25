-- MySQL JOINs Game - Your Table

CREATE TABLE meal_plans (
    plan_id INT PRIMARY KEY AUTO_INCREMENT,
    plan_name VARCHAR(50) NOT NULL,
    cost_per_semester DECIMAL(8,2) NOT NULL,
    meals_per_week INT NOT NULL
);

INSERT INTO meal_plans (plan_name, cost_per_semester, meals_per_week) VALUES
('Basic Plan', 1200.00, 10),
('Standard Plan', 1800.00, 15),
('Premium Plan', 2400.00, 21),
('Commuter Plan', 800.00, 5),
('Graduate Plan', 1500.00, 12);

-- Write your JOIN query here:
-- SELECT ...