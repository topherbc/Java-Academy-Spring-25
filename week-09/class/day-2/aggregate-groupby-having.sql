USE northwind;

-- 1. Aggregate Functions - AVG(), COUNT(), SUM(), MAX(), MIN()

-- AVG

SELECT
	CONCAT("$", ROUND(AVG(Salary), 2)) AS Employee_Salary
FROM 
	Employees;



-- COUNT

SELECT
	COUNT(*)
FROM
	Employees;


-- SUM

SELECT
	CONCAT('$', ROUND(SUM(UnitPrice * Quantity), 2)) AS Total_Sum
FROM
	`Order Details`;


-- MAX

SELECT
	CONCAT('$', ROUND(MAX(UnitPrice * Quantity), 2)) AS Maximum_Sale
FROM
	`Order Details`;


-- MIN

SELECT
	CONCAT('$', ROUND(MIN(UnitPrice * Quantity), 2)) AS Minimum_Sale
FROM
	`Order Details`;
    SELECT *
    FROM
	`Order Details`;

-- 2. GROUP BY

SELECT Title, Salary FROM Employees;

SELECT
	Title,
	CONCAT("$", ROUND(AVG(Salary), 2)) AS Average_Employee_Salary
FROM 
	Employees
GROUP BY Title;

SELECT
	COUNT(*) AS Total_Count,
    City
FROM
	Employees
GROUP BY City;



-- 3. HAVING

SELECT
	Title,
	CONCAT("$", ROUND(AVG(Salary), 2)) AS Average_Employee_Salary
FROM 
	Employees
GROUP BY Title
HAVING AVG(Salary) < 2000;

SELECT
	City,
    SUM(Salary) AS Total_Salary
FROM
	Employees
GROUP BY City
HAVING Total_Salary > 5000;













