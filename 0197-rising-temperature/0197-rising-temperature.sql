SELECT w.id
FROM Weather w
JOIN Weather w2
ON w.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
WHERE w.temperature > w2.temperature;
