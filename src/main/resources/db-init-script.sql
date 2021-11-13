DROP DATABASE IF EXISTS vending-machine;
CREATE DATABASE vending-machine;

USE vending-machine;

CREATE TABLE items(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(3, 2),
    amount_in_stock INT DEFAULT 0
);

INSERT INTO items(name, pric, amount_in_stock)
VALUES (water, 1.00, 8),
(coke, 1.50, 10),
(pepsi, 1.50, 10),
(mars, 0.90, 10),
(snickers, 0.90, 10),
(walkers, 0.75, 10),
(mccoys, 0.75, 10),
(apple  juice,1. 20,10),
(orange  juice,1. 20,10);