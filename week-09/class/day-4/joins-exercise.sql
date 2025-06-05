USE northwind;

-- 1. List the product id, product name, unit price and category name of all 
-- products.  Order by category name and within that, by product name. 

SELECT
	ProductID, 
    ProductName,
    UnitPrice,
    CategoryName
FROM 
	Products AS P
    JOIN Categories AS C ON P.CategoryID = C.CategoryID
ORDER BY CategoryName, ProductName;

SELECT * FROM Products;

SELECT * FROM Categories;


-- 2. List the product id, product name, unit price and supplier name of all 
-- products that cost more than $75.  Order by product name. 

SELECT 
	P.ProductID,
    P.ProductName,
    P.UnitPrice,
    S.CompanyName
FROM 
	Products P
    JOIN Suppliers S ON P.SupplierID = S.SupplierID
WHERE P.UnitPrice > 75
ORDER BY P.ProductName;

SELECT * FROM Suppliers;



-- 3. List the product id, product name, unit price, category name, and supplier 
-- name of every product.  Order by product name. 

SELECT 
	ProductID,
    ProductName,
    UnitPrice,
    CategoryName,
    CompanyName
FROM 
	Products P
    JOIN Categories C ON (P.CategoryID = C.CategoryID)
    JOIN Suppliers S ON (P.SupplierID = S.SupplierID)
ORDER BY ProductName;

SELECT * FROM Categories;

SELECT * FROM Suppliers;



-- 4. What is the product name(s) and categories of the most expensive 
-- products?  HINT:  Find the max price in a subquery and then use that in 
-- your more complex query that joins products with categories. 

SELECT
	ProductName,
    CategoryName
FROM
	Products AS P
    JOIN Categories AS C ON (P.CategoryID = C.CategoryID)
WHERE
	UnitPrice = (SELECT MAX(UnitPrice) FROM Products);
    
SELECT * FROM Products;

SELECT * FROM Categories;




-- 5. List the order id, ship name, ship address, and shipping company name of 
-- every order that shipped to Germany. 

SELECT 
	OrderID,
    ShipName,
    ShipAddress,
    CompanyName
FROM 
	Orders O
    JOIN Shippers S ON (O.ShipVia = S.ShipperID)
WHERE O.ShipCountry = "Germany";


SELECT * FROM Shippers;



-- 6. List the order id, order date, ship name, ship address of all orders that 
-- ordered "Sasquatch Ale"?


SELECT 
	O.OrderID,
    O.OrderDate,
    O.ShipName,
    O.ShipAddress
FROM
	Orders O
    JOIN `Order Details` OD ON (O.OrderID = OD.OrderID)
    JOIN Products P ON (P.ProductID = OD.ProductID)
WHERE ProductName = "Sasquatch Ale";
    

SELECT * FROM `Order Details`;

SELECT * FROM Products WHERE ProductName = "Sasquatch Ale";


    



