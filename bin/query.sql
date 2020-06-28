show databases;
use hb_student_tracker;
show tables;

Create table employee (
	id INT Primary Key Auto_increment,
    empname varchar(45) default null
);

desc employee;

select * from employee;

<!-- It will automatically generate another table which is hibernate_sequence -->

desc hibernate_sequence;

select * from hibernate_sequence;

<!-- For any property of hbm2ddl.auto, use MySQL5Dialect and connection.pool_size = 2 -->