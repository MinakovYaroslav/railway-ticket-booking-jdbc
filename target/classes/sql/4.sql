# Поиск пассажиров, которые выполняют поездку в период +-3 дня от своего дня рождения
SELECT u.*
FROM users u,
     tickets tct,
     cruises crs1,
     routes rt
WHERE u.id = tct.user_id
  AND tct.`status` = 'ACTIVE'
  AND crs1.id = tct.cruise_id
  AND crs1.route_id = rt.id
  AND rt.departure_date BETWEEN (
    STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(u.birthday), '-', DAY(u.birthday)), '%Y-%m-%d') -
    INTERVAL 3 DAY) AND (
    STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-', MONTH(u.birthday), '-', DAY(u.birthday)), '%Y-%m-%d') + INTERVAL 3 DAY)