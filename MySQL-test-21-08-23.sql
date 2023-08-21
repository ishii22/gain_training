create table department(deptno int, dept_name text, dept_manager text, address_id int);
create table address(address_id int, city text, state text);
create table employee(emp_no int, emp_name text, emp_sal int, deptno int);
select emp_no,emp_name,emp_sal,d.deptno,dept_name,dept_manager,city,state from employee e join department d on e.deptno=d.deptno join address a on d.address_id=a.address_id;

create table bankaccount(acc_no int primary key, acc_opened_date date, status text, balance double);
create table transaction(acc_no int, tans_type char(1), trans_date date, trans_amount double, foreign key(acc_no) references bankaccount(acc_no) on delete cascade);

create table employee(emp_no int, emp_name text, emp_sal double, department text, manager_name text);
select manager_name,sum(emp_sal) from employee group by manager_name;
select min(emp_sal) from employee order by emp_sal desc limit 4;
select min(emp_sal) from (select distinct(emp_sal) from employee order by emp_sal desc limit 4) as sal;
