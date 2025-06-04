-- MySQL JOINs Game - Your Table

CREATE TABLE dining_transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    plan_id INT NOT NULL,
    location VARCHAR(50) NOT NULL,
    item_purchased VARCHAR(100) NOT NULL,
    cost DECIMAL(6,2) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (plan_id) REFERENCES meal_plans(plan_id)
);

INSERT INTO dining_transactions (plan_id, location, item_purchased, cost, date) VALUES
(2, 'Main Cafeteria', 'Lunch Combo', 12.50, '2024-03-19'),
(1, 'Coffee Shop', 'Sandwich and Coffee', 8.75, '2024-03-18'),
(3, 'Main Cafeteria', 'Dinner Buffet', 15.00, '2024-03-20'),
(4, 'Snack Bar', 'Pizza Slice', 4.50, '2024-03-17'),
(2, 'Coffee Shop', 'Breakfast Burrito', 7.25, '2024-03-19');

-- Write your JOIN query here:
-- SELECT ...