REM   Script: SQL Activity5
REM   ACTIVITY 5
In this activity we will be updating the data in the salesman table.

Update the grade score of salesmen from Rome to 200.
Update the grade score of James Hoog to 300.
Update the name McLyon to Pierre.

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

select * from salesman;

Alter table Salesman add grade int;

desc salesman


select * from salesman;

select * from salesman;

update salesman set grade=200 where salesman_city='Rome';

select * from salesman;

update salesman set grade=300 where salesman_name='James Hoong';

select * from salesman;

update salesman set salesman_name='Pierre' where salesman_name='Mc Lyon';

select * from salesman;

