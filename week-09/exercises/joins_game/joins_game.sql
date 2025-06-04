-- MySQL JOINs Game Database
-- Complete seed with all 20 tables and sample data

DROP DATABASE IF EXISTS joins_game;
CREATE DATABASE joins_game;
USE joins_game;

-- ===========================================
-- GROUP 1: Student Academic Records
-- ===========================================

-- Table 1: students (HUB)
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

-- Table 2: enrollments
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_name VARCHAR(100) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    grade CHAR(2),
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO enrollments (student_id, course_name, semester, grade) VALUES
(1, 'Database Systems', 'Spring 2024', 'A'),
(1, 'Web Development', 'Spring 2024', 'B+'),
(2, 'Data Structures', 'Spring 2024', 'A-'),
(3, 'Operating Systems', 'Spring 2024', 'B'),
(4, 'Computer Networks', 'Spring 2024', 'A'),
(5, 'Software Engineering', 'Spring 2024', 'B+');

-- Table 3: transcripts
CREATE TABLE transcripts (
    transcript_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    gpa DECIMAL(3,2) NOT NULL,
    total_credits INT NOT NULL,
    degree_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO transcripts (student_id, gpa, total_credits, degree_status) VALUES
(1, 3.75, 90, 'Senior'),
(2, 3.50, 120, 'Graduate'),
(3, 3.25, 60, 'Junior'),
(4, 3.85, 95, 'Senior'),
(5, 3.60, 125, 'Graduate'),
(6, 3.40, 30, 'Sophomore');

-- Table 4: advisors
CREATE TABLE advisors (
    advisor_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    advisor_name VARCHAR(100) NOT NULL,
    meeting_date DATE NOT NULL,
    notes TEXT,
    FOREIGN KEY (student_id) REFERENCES students(student_id)
);

INSERT INTO advisors (student_id, advisor_name, meeting_date, notes) VALUES
(1, 'Dr. Sarah Chen', '2024-03-15', 'Discussed thesis topic options'),
(2, 'Dr. Michael Roberts', '2024-03-10', 'Graduation requirements review'),
(3, 'Dr. Lisa Wang', '2024-03-20', 'Course selection for fall semester'),
(4, 'Dr. James Taylor', '2024-03-12', 'Internship opportunities discussion'),
(5, 'Dr. Sarah Chen', '2024-03-18', 'Research project planning');

-- ===========================================
-- GROUP 2: Course Management
-- ===========================================

-- Table 5: courses (HUB)
CREATE TABLE courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    credits INT NOT NULL,
    department VARCHAR(50) NOT NULL
);

INSERT INTO courses (course_name, credits, department) VALUES
('Database Systems', 3, 'Computer Science'),
('Data Structures', 4, 'Computer Science'),
('Operating Systems', 3, 'Computer Science'),
('Calculus I', 4, 'Mathematics'),
('Physics I', 4, 'Physics'),
('English Composition', 3, 'English');

-- Table 6: prerequisites
CREATE TABLE prerequisites (
    prereq_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    required_course VARCHAR(100) NOT NULL,
    min_grade CHAR(2) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO prerequisites (course_id, required_course, min_grade) VALUES
(1, 'Data Structures', 'C+'),
(2, 'Programming Fundamentals', 'C'),
(3, 'Computer Architecture', 'C+'),
(4, 'Pre-Calculus', 'B-'),
(5, 'College Algebra', 'C+');

-- Table 7: sections
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

-- Table 8: textbooks
CREATE TABLE textbooks (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    course_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    price DECIMAL(6,2) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO textbooks (course_id, title, author, isbn, price) VALUES
(1, 'Database System Concepts', 'Silberschatz, Korth, Sudarshan', '978-0073523323', 299.99),
(2, 'Introduction to Algorithms', 'Cormen, Leiserson, Rivest, Stein', '978-0262033848', 279.95),
(3, 'Operating System Concepts', 'Silberschatz, Galvin, Gagne', '978-1118063330', 324.95),
(4, 'Calculus: Early Transcendentals', 'Stewart', '978-1285741550', 399.95),
(5, 'University Physics', 'Young, Freedman', '978-0321973610', 449.99);

-- ===========================================
-- GROUP 3: Faculty & Departments
-- ===========================================

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

-- Table 10: professor_courses
CREATE TABLE professor_courses (
    pc_id INT PRIMARY KEY AUTO_INCREMENT,
    prof_id INT NOT NULL,
    course_taught VARCHAR(100) NOT NULL,
    semester VARCHAR(20) NOT NULL,
    enrollment_count INT NOT NULL,
    FOREIGN KEY (prof_id) REFERENCES professors(prof_id)
);

INSERT INTO professor_courses (prof_id, course_taught, semester, enrollment_count) VALUES
(1, 'Database Systems', 'Spring 2024', 25),
(1, 'Advanced Databases', 'Spring 2024', 15),
(2, 'Data Structures', 'Spring 2024', 35),
(3, 'Operating Systems', 'Spring 2024', 28),
(4, 'Software Engineering', 'Spring 2024', 22),
(5, 'Computer Networks', 'Spring 2024', 30);

-- Table 11: office_assignments
CREATE TABLE office_assignments (
    office_id INT PRIMARY KEY AUTO_INCREMENT,
    prof_id INT NOT NULL,
    building VARCHAR(50) NOT NULL,
    room_number VARCHAR(10) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    FOREIGN KEY (prof_id) REFERENCES professors(prof_id)
);

INSERT INTO office_assignments (prof_id, building, room_number, phone) VALUES
(1, 'Science Hall', '301A', '555-0101'),
(2, 'Science Hall', '302B', '555-0102'),
(3, 'Technology Center', '205', '555-0103'),
(4, 'Engineering Building', '150', '555-0104'),
(5, 'Science Hall', '310', '555-0105');

-- Table 12: research_grants
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

-- ===========================================
-- GROUP 4: Campus Facilities
-- ===========================================

-- Table 13: buildings (HUB)
CREATE TABLE buildings (
    building_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    construction_year INT NOT NULL,
    total_floors INT NOT NULL
);

INSERT INTO buildings (name, construction_year, total_floors) VALUES
('Science Hall', 1995, 4),
('Technology Center', 2010, 3),
('Student Union', 1985, 2),
('Library', 1970, 5),
('Engineering Building', 2005, 4),
('Athletic Center', 2000, 2);

-- Table 14: classrooms
CREATE TABLE classrooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    building_id INT NOT NULL,
    room_number VARCHAR(10) NOT NULL,
    capacity INT NOT NULL,
    equipment VARCHAR(100),
    FOREIGN KEY (building_id) REFERENCES buildings(building_id)
);

INSERT INTO classrooms (building_id, room_number, capacity, equipment) VALUES
(1, '101', 40, 'Projector, Whiteboard, Computers'),
(1, '205', 35, 'Projector, Smart Board'),
(2, '150', 50, 'Lab Equipment, Projector'),
(3, '201', 25, 'Projector, Conference Setup'),
(4, '301', 100, 'Lecture Hall, Audio System'),
(5, '120', 30, 'Engineering Tools, Projector');

-- Table 15: maintenance_requests
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

-- Table 16: security_logs
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

-- ===========================================
-- GROUP 5: Student Services
-- ===========================================

-- Table 17: meal_plans (HUB)
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

-- Table 19: dining_transactions
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

-- ===========================================
-- VERIFICATION QUERIES
-- ===========================================

-- Show table counts
SELECT 
    'students' as table_name, COUNT(*) as row_count FROM students
UNION ALL SELECT 'enrollments', COUNT(*) FROM enrollments
UNION ALL SELECT 'transcripts', COUNT(*) FROM transcripts
UNION ALL SELECT 'advisors', COUNT(*) FROM advisors
UNION ALL SELECT 'courses', COUNT(*) FROM courses
UNION ALL SELECT 'prerequisites', COUNT(*) FROM prerequisites
UNION ALL SELECT 'sections', COUNT(*) FROM sections
UNION ALL SELECT 'textbooks', COUNT(*) FROM textbooks
UNION ALL SELECT 'professors', COUNT(*) FROM professors
UNION ALL SELECT 'professor_courses', COUNT(*) FROM professor_courses
UNION ALL SELECT 'office_assignments', COUNT(*) FROM office_assignments
UNION ALL SELECT 'research_grants', COUNT(*) FROM research_grants
UNION ALL SELECT 'buildings', COUNT(*) FROM buildings
UNION ALL SELECT 'classrooms', COUNT(*) FROM classrooms
UNION ALL SELECT 'maintenance_requests', COUNT(*) FROM maintenance_requests
UNION ALL SELECT 'security_logs', COUNT(*) FROM security_logs
UNION ALL SELECT 'meal_plans', COUNT(*) FROM meal_plans
UNION ALL SELECT 'student_meal_accounts', COUNT(*) FROM student_meal_accounts
UNION ALL SELECT 'dining_transactions', COUNT(*) FROM dining_transactions
UNION ALL SELECT 'plan_changes', COUNT(*) FROM plan_changes;