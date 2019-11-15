# Поиск пассажиров, купивших билеты в указанный пункт назначения, на сумму, больше указанной в запросе, в указанный период времени
SELECT users.*
FROM users,
     tickets
GROUP BY tickets.price, users.id, tickets.user_id, tickets.order_date, tickets.cruise_id
HAVING users.id = tickets.user_id
   AND SUM(tickets.price) > 190
   AND tickets.order_date BETWEEN STR_TO_DATE('2019-01-01', '%Y-%m-%d') AND STR_TO_DATE('2019-12-31', '%Y-%m-%d')
   AND tickets.cruise_id =
       (SELECT cruises1.id
        FROM cruises cruises1,
             routes,
             stations
        WHERE cruises1.route_id = routes.id
          AND routes.destination_station_id = stations.id
          AND stations.`name` = 'Saint Petersburg')