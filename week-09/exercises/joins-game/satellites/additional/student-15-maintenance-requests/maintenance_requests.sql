-- MySQL JOINs Game - Your Table

CREATE TABLE maintenance_requests (
    request_id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT NOT NULL,
    issue_type VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    date_reported DATE NOT NULL,
    FOREIGN KEY (building_id) REFERENCES buildings(building_id)
);

INSERT INTO maintenance_requests (building_id, issue_type, status, date_reported) VALUES
(1, 'HVAC System Malfunction', 'In Progress', '2024-03-10'),
(2, 'Broken Window', 'Completed', '2024-03-05'),
(3, 'Elevator Maintenance', 'Scheduled', '2024-03-15'),
(4, 'Roof Leak', 'In Progress', '2024-03-12'),
(5, 'Electrical Issues', 'Open', '2024-03-18');

-- Write your JOIN query here:
-- SELECT ...