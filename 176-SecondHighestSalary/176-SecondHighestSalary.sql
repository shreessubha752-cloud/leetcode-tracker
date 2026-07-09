-- Last updated: 09/07/2026, 10:08:38
SELECT
    MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (
    SELECT MAX(salary)
    FROM Employee
);
