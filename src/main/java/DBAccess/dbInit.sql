DROP DATABASE IF EXISTS LegoHouse;
CREATE DATABASE LegoHouse;
USE LegoHouse;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` INT NOT NULL AUTO_INCREMENT, 
`email` VARCHAR(25) unique, 
`password` VARCHAR(25),
`role` VARCHAR(25),
PRIMARY KEY(`id`)
);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
`id` INT NOT NULL AUTO_INCREMENT,
`length` INT,
`width` INT,
`height` INT,
`shipped` BOOLEAN,
`fk_userid` INT NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY(`fk_userid`) REFERENCES `user`(`id`)
);

INSERT INTO `user`
VALUES
(null, 'hanne@hanne.dk', '1234', 'customer'),
(null, 'simon@simon.dk', '1234', 'employee');