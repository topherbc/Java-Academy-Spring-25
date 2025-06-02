Retrospective Last Week

What went well?

1. Pre-planning
2. Encapsulation
3. Diagramming relationships
4. Pseudocoding
5. Making mistakes and correcting, lessons to be had


What didn't go well?

1. Increasing code interactions increases complexity
2. Readme.md
3. Breaking classes down further, better separation of concerns
4. Prepare more


What do we want to continue?

1. Finding new ways to diagram
2. Pre-planning
3. Making project docs


Today's Objectives

1. Intro to SQL
2. MySQL
3. RDBMS
4. MySQL Workbench
5. Querying Data

Agenda Today

1. Intro and Retro
2. Lets make sure you have MySQL Workbench
3. Yu Meeting
4. 5 Minute Break
5. Intro to SQL
6. Intro to MySQL Workbench
7. Exercise 1 - No Querying
8. SELECT statement
9. ORDER BY
10. WHERE
11. LIKE
12. BETWEEN
13. Lunch
14. Exercise 1 and 2
15. Break
16. We do exercise
17. Codewars or maybe a visit to the zoo
18. Recap and Q&A

What did you learn today?

1. SQL - Structured Query Language
   1. S Q L or sequel NOT SQUEEL
2. SQL is Declarative Programming
3. Establishing usage of a database
   1. USE database
4. RDBMS - Relational Database Management System
5. MySQL server - RDMBS
6. MySQL Workbench - Interacting with MySQL server
   1. Analogous to Intellij
7. SQL commands are writtin IN ALL CAPS
8. ; semicolon ends query statement
9. SQL Commands
   1. SELECT - selects columns to be queried
      1. * - all columns
      2. SELECT column, column2 - select specific column
      3. DISTINCT - reduces to distinct values
   2. FROM - where data is extract, tables
   3. WHERE - conditions to be met
      1. AND - All conditions must be true
      2. OR - Either condition must be true
      3. Numerical Data Comparisons
         1. BETWEEN
         2. > >=
         3. < <=
      4. String Data Comparisons
         1. LIKE 
            1. % - wildcard
               1. Represents any character
            2. EX. Value LIKE "A%" - looking for A to start with
            3. EX. Value LIKE "%A%" - A within Value
            4. EX. Value LIKE "%A" - Ends with A
            5. _ 
         2. = - compares if the same
      5. IN
   4. ORDER BY
      1. ASC - sorts ascending by default
      2. DESC
      3. EX: ORDER BY Value DESC
   5. LIMIT - limits results by number
10. MIN()
11. MAX()
12. -- Comments
13. /* */ multi line comment