CREATE DATABASE IF NOT EXISTS db_logistic;

USE db_logistic;

CREATE TABLE IF NOT EXISTS db_logistic.User(
    ID int(16) PRIMARY KEY AUTOINCREMENT,
    login VARCHAR(40) NOT NULL,
    password varchar(256),
    registration DATE,
    userType int(16)
    );
CREATE TABLE IF NOT EXISTS UserType