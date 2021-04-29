REM   Script: SQL Activity1
REM   SQL Activity1
create a table in SQL using the CREATE command named salesman:
To see the datatype properties of the columns in the table, you can use the DESCRIBE command:

create table salesman (   
  salesman_id int not null,  
  salesman_name varchar2(20),   
  salesman_city varchar2(20),   
  commision int 
);;

desc salesman;


