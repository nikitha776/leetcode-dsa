# Write your MySQL query statement below
SELECT m1.machine_id , ROUND(AVG(m2.timestamp - m1.timestamp),3) AS processing_time
FROM Activity AS m1 , Activity AS m2
WHERE m1.process_id = m2.process_id AND m1.activity_type = "start" AND m2.activity_type = "end" AND m1.machine_id = m2.machine_id
GROUP BY m1.machine_id;