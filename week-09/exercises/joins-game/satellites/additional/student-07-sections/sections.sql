-- MySQL JOINs Game - Your Table

CREATE TABLE sections (
    section_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    instructor VARCHAR(100) NOT NULL,
    time_slot VARCHAR(50) NOT NULL,
    room VARCHAR(20) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO sections (course_id, instructor, time_slot, room) VALUES
(1, 'Dr. Sarah Chen', 'MWF 10:00-11:00', 'SCI 101'),
(2, 'Dr. Michael Roberts', 'TTh 2:00-3:30', 'SCI 205'),
(3, 'Dr. Lisa Wang', 'MWF 1:00-2:00', 'SCI 150'),
(4, 'Dr. John Davis', 'TTh 9:00-10:30', 'MATH 110'),
(5, 'Dr. Emily Johnson', 'MWF 11:00-12:00', 'PHYS 120');

-- Write your JOIN query here:
-- SELECT ...