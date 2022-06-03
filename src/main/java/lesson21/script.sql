CREATE DATABASE hillel_db;

USE hillel_db;

CREATE TABLE wallet
(
     wallet_id INT PRIMARY KEY AUTO_INCREMENT,
     currency VARCHAR(3) NOT NULL,
     amount INT,
     user_id INT,
     created DATE
);

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    surname VARCHAR(100),
    date_of_registration DATE
);

ALTER TABLE wallet
ADD FOREIGN KEY (user_id)  REFERENCES user (user_id);

INSERT INTO user (name, surname, date_of_registration)
VALUES ('Andrii', 'Vedmid', '2022-05-31');

INSERT INTO wallet(currency, amount, user_id, created)
VALUES
(
    'UAH',
    50000,
    (SELECT user_id from user WHERE surname='Vedmid' AND name='Andrii'),
    '2022-05-31'
),
(
    'USD',
    1000,
    (SELECT user_id from user WHERE surname='Vedmid' AND name='Andrii'),
    '2022-05-31'
);

SELECT u.name, w.currency, w.amount
FROM wallet AS w
JOIN user AS u
WHERE u.surname='Vedmid' AND w.currency='USD';