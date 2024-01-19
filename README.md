README

Use following settings when creating the user in MySQL:

username=pojisteni

password=test

With all permission

For creating table Uzivatel:

CREATE TABLE uzivatel (

id INT AUTO_INCREMENT PRIMARY KEY,

jmeno VARCHAR(255) NOT NULL,

prijmeni VARCHAR(255) NOT NULL,

pohlavi VARCHAR(255),

email VARCHAR(255),

telefon VARCHAR(255) NOT NULL,

ulice VARCHAR(255) NOT NULL,

mesto VARCHAR(255) NOT NULL,

psc INT NOT NULL

);

For creating table Pojisteni:

CREATE TABLE pojisteni (

id INT AUTO_INCREMENT PRIMARY KEY,

uzivatel_id INT,

FOREIGN KEY (uzivatel_id) REFERENCES uzivatel(id),

typ VARCHAR(255),

castka INT,

predmet VARCHAR(255),

platnost_od DATE,

platnost_do DATE

);
