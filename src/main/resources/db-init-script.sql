DROP DATABASE IF EXISTS vending_machine;
CREATE DATABASE vending_machine;

USE vending_machine;

CREATE TABLE items(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(3, 2),
    amount_in_stock INT DEFAULT 0
);

INSERT INTO items(name, price, amount_in_stock)
VALUES ('water', 1.00, 10),
('coke', 1.50, 10),
('pepsi', 1.50, 10),
('mars', 0.90, 10),
('snickers', 0.90, 10),
('walkers', 0.75, 10),
('mccoys', 0.75, 10),
('apple juice', 1.20, 10),
('orange juice', 1.20, 10);