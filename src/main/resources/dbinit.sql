CREATE DATABASE IF NOT EXISTS db_logistic;


USE db_logistic;


SELECT 'Creating User table, which storing user data for authentication in application.\n';
CREATE TABLE IF NOT EXISTS User(
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(256),
    registration DATE,
    role INT(16)
);

SELECT 'Creating UserData Table.\n';
CREATE TABLE IF NOT EXISTS Role(
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(40) UNIQUE NOT NULL
);

SELECT 'Creating Van Table.\n';
CREATE TABLE IF NOT EXISTS Van (
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    reg_num CHAR(7) UNIQUE NOT NULL,
    team_size INT(4),
    capacity DECIMAL(7,2),
    status TINYINT(1),
    current_city INT(16)
);

SELECT 'Creating Driver Table.\n';
CREATE TABLE IF NOT EXISTS Driver(
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40),
    surname VARCHAR(40),
    num INT(16) UNIQUE NOT NULL,
    current_hours INT(4),
    current_city INT(16),
    current_van INT(16)
);

SELECT 'Creating DriverList Table.\n';
CREATE TABLE IF NOT EXISTS DriverList(
    id INT(16) ,
    driver INT(16),
    PRIMARY KEY (ID, driver)
);

SELECT 'Creating City Table\n';
CREATE TABLE IF NOT EXISTS City(
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) UNIQUE NOT NULL,
);

SELECT 'Creating City Mapping table\n';
SELECT 'Reading from this database in graph inctance. All relations are not commutative.\n';
CREATE TABLE IF NOT EXISTS Map(
    city_id INT(16) NOT NULL,
    near_city_id INT(16) NOT NULL,
    range_to INT(16),
    PRIMARY KEY (city_id, near_city_id)
);

SELECT 'Creating Route Table.\n';
CREATE TABLE IF NOT EXISTS Route(
    id INT(16) PRIMARY KEY,
    city_id INT(16),
    item_id INT(16)
);


SELECT 'Creating Item Table.\n';
CREATE TABLE IF NOT EXISTS Item (
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) UNIQUE NOT NULL,
    capacity DECIMAL(7,2),
    status ENUM('prepared','unload','delivered')
);


SELECT 'Creating Order Table.\n';
CREATE TABLE IF NOT EXISTS LogisticOrder(
    id INT(16) PRIMARY KEY AUTO_INCREMENT,
    status TINYINT(1) NOT NULL,
    route_id INT(16) NOT NULL,
    van_id INT(16) NOT NULL,
    team INT(16) NOT NULL
);

