-- Best practice MySQL as of 5.7.6
--
-- The Aquarium database must exist before running this script
-- and before running the fx_desktop_standard_project because the unit
-- test runs this script. Only the root user can create a MySQL database
-- but you do not want to use the root user and password in your code.
--
-- This script needs to run only once

DROP DATABASE IF EXISTS CURRENCY;
CREATE DATABASE CURRENCY;

USE CURRENCY;

DROP USER IF EXISTS currency@localhost;
CREATE USER currency@'localhost' IDENTIFIED BY 'moneybags';
GRANT ALL ON CURRENCY.* TO currency@'localhost';

-- This creates a user with access from any IP number except localhost
-- Use only if your MyQL database is on a different host from localhost
-- DROP USER IF EXISTS currency; -- % user
-- CREATE USER currency IDENTIFIED BY 'moneybags';
-- GRANT ALL ON CURRENCY TO currency@'%';

FLUSH PRIVILEGES;

DROP TABLE IF EXISTS CURRENCY;

CREATE TABLE CURRENCY (
  ID int(11) NOT NULL auto_increment,
  CURRENCYCODE varchar(45) NOT NULL default '',
  BUYPERCAD varchar(40) NOT NULL default '',
  SELLPERCAD varchar(12) NOT NULL default '',
  PRIMARY KEY  (ID)
) ENGINE=InnoDB;

INSERT INTO CURRENCY (CURRENCYCODE, BUYPERCAD, SELLPERCAD) values
("AUD","1.0047","0.9959"),
("BRL","0.4012","2.4826"),
("CNY","0.1939","5.1596"),
("EUR","1.4758","0.6781"),
("HKD","0.169487","5.8974"),
("INR","0.0205","48.7548"),
("IDR","0.000099","10054.4226"),
("JPY","0.01187","84.4795"),
("MYR","0.3091","3.2385"),
("MXN","0.07359","13.5932"),
("NZD","0.9571","1.0461"),
("NOK","0.156","6.4232"),
("PEN","0.4044","2.4665"),
("RUB","0.02264","44.1260"),
("SAR","0.3525","2.8362"),
("SGD","0.9539","1.0485"),
("ZAR","0.10182","9.8169"),
("KRW","0.001164","859.4468"),
("SEK","0.1514","6.6108"),
("CHF","1.3569","0.7376"),
("TWD","0.04352","22.9768"),
("THB","0.03893","25.6892"),
("TRY","0.3756","2.6632"),
("GBP","1.6853","0.5939"),
("USD","1.322","0.7562"),
("VND","0.000058","17183.0574")

