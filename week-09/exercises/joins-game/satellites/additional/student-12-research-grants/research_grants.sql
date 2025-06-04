-- MySQL JOINs Game - Your Table

CREATE TABLE research_grants (
    grant_id INT PRIMARY KEY AUTO_INCREMENT,
    prof_id INT NOT NULL,
    grant_title VARCHAR(200) NOT NULL,
    funding_amount DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    FOREIGN KEY (prof_id) REFERENCES professors(prof_id)
);

INSERT INTO research_grants (prof_id, grant_title, funding_amount, start_date) VALUES
(1, 'Advanced Database Optimization Techniques', 125000.00, '2024-01-01'),
(2, 'Machine Learning Algorithm Development', 200000.00, '2023-09-01'),
(4, 'Sustainable Software Development Practices', 95000.00, '2024-02-15'),
(5, 'Network Security in IoT Devices', 150000.00, '2023-12-01');

-- Write your JOIN query here:
-- SELECT ...