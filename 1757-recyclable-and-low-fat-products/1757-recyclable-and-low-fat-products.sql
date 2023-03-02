# Write your MySQL query statement below
Select product_id 
FROM Products
WHERE (Products.low_fats='Y'
AND Products.recyclable='Y');