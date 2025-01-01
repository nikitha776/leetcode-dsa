# Write your MySQL query statement below
SELECT  product_name , year , price
FROM Sales AS a
JOIN Product AS b
ON a.product_id = b.product_id;