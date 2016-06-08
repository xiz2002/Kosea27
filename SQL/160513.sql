select * from tab

select * from departments;

select * from employees;

select Employee_id from employees;

select EMPLOYEE_id, Job_ID from employees;

select e.first_name || ' ' || e.last_name as "이름"
	from EMPLOYEES e
	WHERE e.first_name = 'Steven';


desc employees;