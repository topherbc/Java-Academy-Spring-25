-- MySQL JOINs Game - Your Table

CREATE TABLE security_logs (
    log_id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT NOT NULL,
    entry_time DATETIME NOT NULL,
    badge_id VARCHAR(20) NOT NULL,
    access_granted BOOLEAN NOT NULL,
    FOREIGN KEY (building_id) REFERENCES buildings(building_id)
);

INSERT INTO security_logs (building_id, entry_time, badge_id, access_granted) VALUES
(1, '2024-03-20 08:30:00', 'STUD001', TRUE),
(1, '2024-03-20 08:45:00', 'PROF001', TRUE),
(2, '2024-03-20 09:15:00', 'STUD002', TRUE),
(3, '2024-03-20 12:30:00', 'STUD003', FALSE),
(4, '2024-03-20 14:20:00', 'STAFF001', TRUE),
(5, '2024-03-20 16:45:00', 'PROF002', TRUE);

-- Write your JOIN query here:
-- SELECT ...