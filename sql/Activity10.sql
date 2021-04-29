REM   Script: SQL Activity10
REM   ACTIVITY 10
In this activity we will using the salesman, orders, and the customers table to perform Subquery operations on both tables.

Write queries for the following:

Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
Write a query to find all orders attributed to a salesman in New York.
Write a query to count the customers with grades above New York's average.
Write a query to extract the data from the orders table for those salesman who earned the maximum commission

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commision=( SELECT MAX(commision) FROM salesman));

