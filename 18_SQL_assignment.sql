create table department(dept_no int primary key, dept_name text, dept_location text);

create table employee(emp_no int primary key, emp_name text, emp_age int, emp_gender char(1), dept_no int,  foreign key(dept_no) references department(dept_no) on delete cascade, check(emp_age>=18), check(emp_gender in('M','F')));

create table course(course_code int, course_name text, course_duration int);
create table course_copy as select * from course;

alter table course add(course_strength int, course_faculty text);
alter table course drop column course_duration, drop column course_strength;
alter table course rename column course_code to course_id;
