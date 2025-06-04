Icebreaker: Write a query to obtain your favorite song, album, or artist

EX: 
SELECT                           
  album,
  year
FROM
  music_table
WHERE
  artist = "Grateful Dead"
  AND album = "Europe 72'"

or

SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  year BETWEEN 1980 AND 1987


1. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Naomi Sharon";
2. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Kendrick Lamar"
  AND album = "To Pimp a Butterfly";
3. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Miyagi"
  AND song_title = "Touch the Sky";
4. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "System of a Down"
  AND album = "Hypnotize";
5. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Morgan Wallen"
  AND album = "Dangerous";
6. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Coldplay"
  AND album = "Parachutes";
7. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Aurora"
  OR (artist = "Yellow House"
  AND album = "Flaws in our Design");
8. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Mindless Self Indulgence"
  OR (artist = "Rainbow Kitten Surprise"
  AND album = "How to Friend, Love, Freefall")
9. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Metallica";
10. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Bob Dylan"
  AND song_title = "Blowing in the wind";
11. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Cem Karaca"
  AND song_title IS "Bun Son Olsun"
  AND album = "45s"
  AND group = "Apaslar"
  AND year = 1969;
12.  SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Sezen Aksu"
  AND album = "Gülümse";
13.  SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Sertab Erener"
  AND song_title = "Every way that I can"
  AND year = 2004;
14.  SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Yiruma"
  AND song_title = "River Flows in You"
  AND album = "First Love"
  AND year = 2001;
15.  SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Marvin Gaye"
  AND album = "What's going on"
  AND song_title = "Mercy, Mercy Me";
16. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Daniel Caesar"
  AND album = "Never Enough";
17. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Rammstein"
  AND album = "Mutter"
  AND year = 2001
  AND song_title = "Sonne";
18. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Michael Jordan"
  AND song_title = "Balls and Baskets";
19. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Purna Rai"
  AND song_title = "Dajubhaiharu"
  AND year = 2024;
20. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  artist = "Misha Panfilov"
  AND album = "To the mesosphere and beyond";
21. SELECT
  artist,
  song_title,
  album,
  year
FROM
  music_table
WHERE
  song_title LIKE "%World%";

What did you learn yesterday?

1. SQL commands are conventionaly ALL CAPS
2. USE database; - define database to interact with
3. database - place that holds tables
4. table - rows and columns, organized data
5. data - information
6. MySQL is a RDBMS = Relational Database Management System
7. SQL is the language
8. MySQL is the server
9. MySQL Workbench - Allows interaction with the MySQL rdbms
10. Think in detail
   1. EX. ORDERBY is actually ORDER BY
11. SQL Commands
   1. SELECT
      1. * - selects all columns
      2. DISTINCT - selects unique values only once
   2. FROM - the table to select
   3. WHERE - checks condition to filter rows
      1. BETWEEN - check within range of values
      2. LIKE checks if values is like a value
         1. % wildcard symbol
            1. v LIKE "A%" - starts with A
            2. v LIKE "%A" - ends with A
            3. v LIKE "%A%" - contains A
         2. _ checks spaces with gaps between
      3. AND - both conditions must be true
      4. OR - one or more condition must be true
      5. IS NOT NULL - checks if field is null/empty
      6. NOT - filters records that don't match
   4. ORDER BY - sorting
      1. ASC - ascending order
      2. DESC - descending order
   5. LIMIT x 
      1. Limits rows to x value
12. -- comments
13. /* multi-line comments */
14. MIN()
15. MAX()

Today's Objectives

1. SELECT
2. FROM
3. WHERE
4. ORDER BY
5. Aggregate Functions
6. GROUP BY
7. HAVING
8. AS - aliases

Agenda Today 

1. Intro, Icebreaker, and Recap
2. Couple of the Exercise 2 problems
3. You do exercise 2
4. Break
5. We do exercise 2
6. Lunch
7. Group learn aggregates
8. We learn aggregates
9. Aggregates exercise
10. Break
11. A quick trip to the zoo
12. Recap and Q&A

What did you learn today?

1. CONCAT()
2. CEIL() - rounds up
3. ROUND(x, z) - rounds normal (x is value to round, z is decimal places)
4. FLOOR() - rounds down
5. FORMAT() - formats data, truncate decimal, turns to varchar
6. WHERE compare with alias doesn't work
7. GROUP BY
8. HAVING - aliases and aggregate condition
9. AS - alias column
10. CASE WHEN THEN ELSE END
11. Aggregate Functions
    1. SUM()
    2. MAX()
    3. MIN()
    4. AVG()
    5. COUNT()