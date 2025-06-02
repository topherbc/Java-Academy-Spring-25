USE northwind;


-- 1. What categories of products does Northwind Traders sell?

SELECT * FROM Categories;


-- 2. What is the name of a product that sounds interesting to you?

SELECT ProductName, UnitsInStock FROM Products;

-- SQL Structure: SELECT column_name(s) FROM database.table



-- 3. What are some of the countries in which we have customers?

SELECT DISTINCT Country FROM Customers ORDER BY Country ASC;



-- 4. What date was our first order placed? How did you determine that?

SELECT * FROM Orders LIMIT 3;



-- 5. What date was our last order placed?


SELECT * FROM Orders ORDER BY OrderDate DESC LIMIT 1;


-- 6. How many customers do we currently have?

SELECT COUNT(*) FROM Customers;


-- 7. Do we have any suppliers in South America? Europe? Africa?

SELECT * FROM Suppliers WHERE Country = "UK";


-- 8. What products have less than 10 units in stock?


SELECT 
	ProductName, 
    UnitsInStock 
FROM 
	Products 
WHERE 
	ProductName < 10 
ORDER BY UnitsInStock DESC;


-- 9. What is our least expensive product?

SELECT * FROM Products ORDER BY UnitPrice DESC LIMIT 1;



-- 10. Addtional Question


SELECT * FROM Customers WHERE ContactName LIKE "%a%";

-- = when we would use .equals, .equalsIgnoreCase or ==

-- LIKE % when we would use contains, startsWith, or endsWith






-- 10. We have a customer named "The Big Cheese" if I wanted to get details
-- about their last order from us how would you find that information?
	-- a. What tables would you use?

	-- b. How would you link the data in the tables you are using
    
    
	-- c. What information might I want to know about their order?
		-- i. Order Date?
		-- ii. Sales Total?
		-- iii. Product Name?
		-- iv. Is there other information that you might find interesting