USE joins_game;

-- 1. Textbooks - Roman

SELECT 
	course_name 
FROM 
	textbooks AS a 
    JOIN courses AS b ON a.course_id=b.course_id 
GROUP BY course_name;

-- 2. Security Logs - Anna

SELECT DISTINCT name FROM buildings b JOIN security_logs s ON b.building_id = s.building_id;

-- 3. Students - Enoch

SELECT name FROM enrollments AS E JOIN students AS S ON E.enrollment_Id = S.student_id;

-- 4. Plan Changes - Viktoriia

SELECT plan_name FROM meal_plans m JOIN plan_changes p ON m.plan_id = p.plan_id;

-- 5. Transcripts - Samaria

SELECT s.name FROM transcripts as t JOIN students as s ON t.transcript_id = s.student_id;

-- 6. Enrollments - Andrei

SELECT s.name, s.email
FROM students AS s JOIN enrollments AS e ON s.student_id = e.enrollment_id;

-- 7. Courses - Kamron

SELECT 
	course_name 
FROM 
	courses c 
	JOIN prerequisites p ON c.course_id = p.course_id
WHERE prereq_id IS NOT null
    GROUP BY course_name;
    
    
-- 8. Student Meal Accounts - Ozan

SELECT s.student_name, m.plan_name, m.cost_per_semester FROM student_meal_accounts s JOIN meal_plans m ON s.plan_id = m.plan_id;

-- 9. Mainenance Requests - Abishek

SELECT name FROM buildings b JOIN maintenance_requests m on b.building_id =  m.building_id;

-- 10. Meal Plans - Vilayat

SELECT p.new_plan FROM plan_changes  AS p JOIN meal_plans AS m ON p.plan_id = m.plan_id;

-- 11. Prerequisites - Jameir

SELECT course_name 
FROM courses AS c JOIN prerequisites AS p ON  c.course_id = p.prereq_id;

-- 12. Classrooms - Maksim

SELECT b.name 
FROM buildings AS b JOIN classrooms AS c ON b.building_id = c.room_id;

-- 13. Advisors - Moni

SELECT s.name
FROM students AS s JOIN advisors AS a ON s.student_id = a.advisor_id;

-- 14. Office Assignments - Enes

SELECT P.name FROM professors AS P JOIN  office_assignments AS O ON O.prof_id=P.prof_id WHERE room_number IS NOT NULL ;

-- 15. Buildings - Ethan

SELECT DISTINCT b.name
FROM classrooms as c JOIN buildings AS b ON c.building_id = b.building_id;

-- 16. Sections - Isaiah

SELECT course_name FROM courses c JOIN sections s ON s.course_id = c.course_id GROUP BY course_name; 

-- 17. Dining Transactions

SELECT MAX(meals_per_week)
FROM meal_plans AS m JOIN dining_transactions AS d ON m.plan_id = d.plan_id;

-- 18. Professor Courses - Pinar

SELECT p.name, p.email FROM professors as p JOIN professor_courses as pc ON p.prof_id=pc.prof_id WHERE enrollment_count IS NOT NULL GROUP BY p.prof_id;

-- 19. Research Grants - Umut

SELECT P.name
FROM professors AS P 
JOIN research_grants  AS r ON P.prof_id=r.prof_id WHERE funding_amount IS NOT NULL;

-- 20. Professors - Berkcan

SELECT 
    p.name, pc.course_taught
FROM
    professors AS p
        JOIN
    professor_courses AS pc ON p.prof_id = pc.prof_id
WHERE
    pc.course_taught IS NOT NULL;






