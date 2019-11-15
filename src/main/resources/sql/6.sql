# Поиск дат, в которые более, чем у 5 пассажиров день рождения
SELECT birthday
FROM users
GROUP BY birthday
HAVING COUNT(birthday) > 5