create database bgss;
use bgss;

CREATE TABLE `bgss`.`login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`loginId`));

INSERT INTO `bgss`.`login` (`userName`, `password`, `role`) VALUES ('admin', 'admin', 'ADMIN');

CREATE TABLE `bgss`.`gasbooking` (
  `bookingId` INT NOT NULL AUTO_INCREMENT,
  `customerNumber` VARCHAR(45) NULL,
  `gasType` VARCHAR(45) NULL,
  `serviceProvider` VARCHAR(45) NULL,
  `address1` VARCHAR(255) NULL,
  `address2` VARCHAR(255) NULL,
  `city` VARCHAR(45) NULL,
  `pincode` VARCHAR(45) NULL,
  `contactNo` VARCHAR(45) NULL,
  PRIMARY KEY (`bookingId`));
  
  -- new
  ALTER TABLE `bgss`.`login` 
ADD COLUMN `email` VARCHAR(45) NULL AFTER `role`,
ADD COLUMN `mobileNo` VARCHAR(45) NULL AFTER `email`,
ADD COLUMN `address` VARCHAR(45) NULL AFTER `mobileNo`;