CREATE TABLE IF NOT EXISTS users
(
  id         VARCHAR(36)  NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  birthday   DATE         NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS stations
(
  id   VARCHAR(36)  NOT NULL,
  name VARCHAR(100) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS routes
(
  id                     VARCHAR(36) NOT NULL,
  origin_station_id      VARCHAR(36) NOT NULL,
  departure_date         TIMESTAMP    NOT NULL,
  destination_station_id VARCHAR(36) NOT NULL,
  arrival_date           TIMESTAMP    NOT NULL,

  FOREIGN KEY (origin_station_id) REFERENCES stations (id),
  FOREIGN KEY (destination_station_id) REFERENCES stations (id),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS wagons
(
  id                   VARCHAR(36)  NOT NULL,
  total_seats_number   INT          NOT NULL,
  occupied_seat_number INT          NOT NULL,
  type                 VARCHAR(10) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS trains
(
  id     VARCHAR(36) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS train_wagons
(
  train_id VARCHAR(36) NOT NULL,
  wagon_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (train_id) REFERENCES trains (id),
  FOREIGN KEY (wagon_id) REFERENCES wagons (id)
);

CREATE TABLE IF NOT EXISTS cruises
(
  id       VARCHAR(36) NOT NULL,
  route_id VARCHAR(36) NOT NULL,
  train_id VARCHAR(36) NOT NULL,

  FOREIGN KEY (train_id) REFERENCES trains (id),
  FOREIGN KEY (route_id) REFERENCES routes (id),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tickets
(
  id          VARCHAR(36)  NOT NULL,
  user_id     VARCHAR(36)  NOT NULL,
  cruise_id   VARCHAR(36)  NOT NULL,
  seat_type   VARCHAR(100) NOT NULL,
  price       FLOAT        NOT NULL,
  order_date  TIMESTAMP     NOT NULL,
  status      VARCHAR(10) NOT NULL,
  return_date TIMESTAMP,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (cruise_id) REFERENCES cruises (id),
  PRIMARY KEY (id)
);