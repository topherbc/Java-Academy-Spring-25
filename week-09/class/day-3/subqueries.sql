-- Structured Query Language

-- Subqueries or Nested Queries

SELECT SupplierID FROM Suppliers WHERE CompanyName = "Specialty Biscuits, Ltd.";

SELECT * FROM Products WHERE SupplierID = 8;

SELECT * 
FROM Products 
WHERE SupplierID = (
		SELECT 
			SupplierID 
		FROM Suppliers 
        WHERE CompanyName LIKE "%Biscuits%"
);


SELECT SupplierID
FROM Suppliers WHERE ContactTitle = "Marketing Manager";

SELECT * FROM Products WHERE SupplierID = 8;

SELECT * 
FROM Products 
WHERE SupplierID IN (SELECT SupplierID
FROM Suppliers WHERE ContactTitle = "Marketing Manager");
