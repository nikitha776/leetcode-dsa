# Write your MySQL query statement below
select mgr.employee_id, mgr.name, count(emp.employee_id) as reports_count, round(avg(emp.age)) as average_age
from Employees as mgr join Employees as emp 
on mgr.employee_id = emp.reports_to
group by mgr.employee_id
order by mgr.employee_id;