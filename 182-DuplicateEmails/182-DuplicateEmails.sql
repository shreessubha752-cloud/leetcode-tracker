-- Last updated: 09/07/2026, 10:08:28
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;