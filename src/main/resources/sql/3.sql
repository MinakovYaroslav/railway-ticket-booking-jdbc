# Поиск пассажира, который совершал более 10 поездок в текущем квартале
SELECT u.*
FROM users u,
     tickets tct,
     cruises crs1
WHERE u.id = tct.user_id
  AND tct.`status` = 'ACTIVE'
  AND crs1.id = tct.cruise_id
  AND crs1.id IN
      (SELECT crs2.id
       FROM cruises crs2,
            routes rt
       GROUP BY crs2.route_id, rt.id, rt.departure_date
       HAVING crs2.route_id = rt.id
          AND rt.departure_date BETWEEN (MAKEDATE(YEAR(CURDATE()), 1) + INTERVAL QUARTER(CURDATE()) QUARTER -
                                         INTERVAL 1 QUARTER) AND (
           MAKEDATE(YEAR(CURDATE()), 1) + INTERVAL QUARTER(CURDATE()) QUARTER - INTERVAL 1 DAY)
          AND COUNT(DISTINCT rt.departure_date) >= 10)
LIMIT 1