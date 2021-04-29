REM   Script: SQL Activity4
REM   ACTIVITY 4
In this activity, we will be modifying the salesman table.

Add a new column - grade - to the salesman table. The grade will be integer values.
Set the value in the grade column for everyone to 100.
Use SELECT command to display the results.

select * from salesman;

Alter table Salesman add grade int;

desc salesman


select * from salesman;

update salesman set grade=100;

select * from salesman;

