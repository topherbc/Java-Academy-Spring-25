-- MySQL JOINs Game - Your Table

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

-- Write your JOIN query here:
-- SELECT ...