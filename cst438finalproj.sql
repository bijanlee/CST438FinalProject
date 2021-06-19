DROP DATABASE IF EXISTS travel_package;
CREATE DATABASE travel_package;
-- select the database
USE travel_package;
-- create the tables
CREATE TABLE packages
(
  package_id        INT            PRIMARY KEY AUTO_INCREMENT,
  itenary_number				INT  NOT NULL UNIQUE,
  user_id			INT	NOT NULL,
  hotel_id			INT NOT NULL,
  flight_id			varchar(255) NOT NULL,
  car_id			INT NOT NULL,
  hotel_reservation_id INT NOT NULL,
  flight_reservation_id INT NOT NULL,
  car_reservation_id INT NOT NULL
);
CREATE TABLE users
(
  user_id              INT            PRIMARY KEY   AUTO_INCREMENT,
  fname				VARCHAR(50) NOT NULL,
  lname				VARCHAR(50) NOT NULL,
  email					VARCHAR(255) NOT NULL UNIQUE,
  passwd				VARCHAR(255) NOT NULL
);