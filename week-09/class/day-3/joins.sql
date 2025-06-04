-- JOINS


-- PRIMARY KEY

-- ProductID

SELECT * FROM Products;

-- FOREIGN KEY

SELECT * FROM Shippers;

SELECT * FROM Orders;

SELECT 
	O.ShipName, 
	O.ShipAddress, 
    S.CompanyName
FROM
	Orders O
	INNER JOIN Shippers S ON (O.ShipVia = S.ShipperID);
    
    
    
-- INNER JOIN

-- LEFT JOIN -- allows connecting null values on left tables

-- RIGHT JOIN -- allows connecting null values on right tables