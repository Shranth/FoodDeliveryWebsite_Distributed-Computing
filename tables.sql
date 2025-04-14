create database quickbite;
use quickbite;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address TEXT,
    password VARCHAR(255)  -- Store hashed passwords
);


CREATE DATABASE quickbite;
USE quickbite;

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),  
    total_amount DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE server_load (
    server_id INT PRIMARY KEY,
    order_count INT DEFAULT 0
);
INSERT INTO server_load (server_id, order_count) VALUES (1, 0), (2, 4);


select * from users;
select * from orders;
SELECT * FROM orders;
SELECT * FROM server_load;

drop table server_load;
