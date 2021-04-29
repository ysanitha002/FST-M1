REM   Script: SQL Activity9
REM   Now write the queries for the following:

Write an SQL statement to know which salesman are working for which customer.
Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.

Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.

select c.customer_name, s.salesman_name from  
customers c  
inner join salesman s 
on c.salesman_id = s.salesman_id;

select c.customer_name, c.grade,c.city, s.salesman_name, s.salesman_city from 
customers c 
left outer join salesman s  
on c.salesman_id = s.salesman_id 
where c.grade<300 
order by c.customer_id;

select c.customer_name, c.city, s.salesman_name, s.commision from 
customers c 
inner join salesman s  
on c.salesman_id = s.salesman_id 
where s.commision>12 
order by c.customer_name;

select o.order_no, o.order_date,o.purchase_amount,c.customer_name as "Customer",s.salesman_name as "Salesman",s.commision  
from orders o 
inner join customers c 
on o.customer_id=c.customer_id 
inner join salesman s 
on o.salesman_id = s.salesman_id;

