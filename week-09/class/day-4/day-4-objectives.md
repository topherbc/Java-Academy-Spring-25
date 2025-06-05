What did you learn yesterday?

1. Nested queries or subquery
   1. Query that runs another query
2. LEFT JOIN - null on right
3. RIGHT JOIN - null on left
4. INNER JOIN - both must match
   1. JOIN by default is a INNER JOIN
5. Primary Key - unique identifier of data row
6. Foreign Key - primary key on another table


Today's Objectives
1. CRUD
2. INSERT
3. UPDATE
4. DELETE
5. CREATE TABLE
6. schemas

Agenda Today

1. Intro and Recap
2. We do JOIN exercises
3. Kahoot
4. Break
5. INSERT UPDATE DELETE
6. You do exercise
7. Break
8. CREATE TABLE
9. Lunch
10. We solve a murder
11. Break
12. Zoo, codewars, lost-at-sql, or other things
13. Recap and Q&A


Murder Mystery Notes:

SELECT * FROM crime_scene_report WHERE city = "SQL City" AND date = 20180115 AND type = "murder";

Security footage shows that there were 2 witnesses. The first witness lives at the last house on "Northwestern Dr". The second witness, named Annabel, lives somewhere on "Franklin Ave".

SELECT * FROM person WHERE name LIKE '%Annabel%';

16371	Annabel Miller	490173	103	Franklin Ave	318771143

INTERVIEW: I saw the murder happen, and I recognized the killer from my gym when I was working out last week on January the 9th.

SELECT * FROM person WHERE address_street_name = "Northwestern Dr" ORDER BY address_number DESC;

14887	Morty Schapiro	118009	4919	Northwestern Dr	111564949

INTERVIEW: I heard a gunshot and then saw a man run out. He had a "Get Fit Now Gym" bag. The membership number on the bag started with "48Z". Only gold members have those bags. The man got into a car with a plate that included "H42W".

Plate Number Search: 
51739	Tushar Chandra
67318	Jeremy Bowers
78193	Maxine Whitely

48Z55	67318	Jeremy Bowers	20160101	gold

JEREMY INTERVIEW: I was hired by a woman with a lot of money. I don't know her name but I know she's around 5'5" (65") or 5'7" (67"). She has red hair and she drives a Tesla Model S. I know that she attended the SQL Symphony Concert 3 times in December 2017.


What did you learn today?

1. CRUD
   1. CREATE
      1. INSERT INTO - adds data to table
         1. INSERT INTO (columns) VALUES (values)
      2. CREATE TABLE
      3. CREATE DATABASE
   2. READ
      1. SELECT
   3. UPDATE
      1. UPDATE .. SET
   4. DELETE
      1. DELETE
      2. DROP TABLE
      3. DROP DATABASE
2. SQL similar to google search
3. DONT UPDATE WITHOUT WHERE
4. Constraints - limitation, boundary
5. References - how it's conencted to something else, primary key to foreign key
6. AUTO_INCREMENT  - values will automatically update/increase in value
7. alias
   1. defining column in create table as NOT NULL - must have value
8. Review whitespace, not always whitespace
9. '' single quotes
10. `` back tics - wrapping values with spaces