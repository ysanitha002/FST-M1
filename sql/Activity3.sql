REM   Script: SQL Activity3
REM   ACTIVITY 3
In this activity, we will be writing different SELECT statements with WHERE clause.

Write SELECT statements for the following outputs:
Show data from the salesman_id and salesman_city columns
Show data of salesman from Paris
Show salesman_id and commission of Paul Adam

create table salesman (    
  salesman_id int not null,   
  salesman_name varchar2(20),    
  salesman_city varchar2(20),    
  commision int  
);

desc salesman


select * from salesman;

desc salesman


insert into Salesman values (5001,'James Hoong','New York',15);

select * from salesman;

insert all 
  into salesman values (5002,'Nail Kaite','Paris',13) 
  into salesman values (5005,'Pit Alex','London',11) 
  into salesman values (5006,'Mc Lyon','Paris',14) 
  into salesman values (5007,'Paul Adam','Rome',13) 
  into salesman values (5003,'Lauson Hen','San Jose',12) 
select 1 from dual;

select * from salesman;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city='Paris';

select salesman_id, salesman_city from salesman where salesman_name='Paul Adam';

