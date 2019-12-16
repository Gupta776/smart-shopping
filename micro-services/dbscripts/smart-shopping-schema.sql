-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema smart_shopping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema smart_shopping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smart_shopping` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema smart_shop
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------
USE `smart_shopping` ;

-- -----------------------------------------------------
-- Table `smart_shopping`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_shopping`.`product` (
  `pr_id` INT NOT NULL AUTO_INCREMENT,
  `pr_product_name` VARCHAR(50) NOT NULL,
  `pr_product_type` INT(2) NOT NULL,
  `pr_brand` VARCHAR(20) NOT NULL,
  `pr_quantity_type` BIGINT(10) NULL,
  `pr_rate_per_quantity` INT NOT NULL,
  `pr_stock_count` INT NOT NULL,
  `pr_add_date` DATE NOT NULL,
  `pr_aisle` VARCHAR(15) NOT NULL,
  `pr_shelf` VARCHAR(15) NOT NULL,
  `pr_date_of_manufacture` DATE NOT NULL,
  `pr_date_of_expiry` DATE NOT NULL,
  `pr_product_image` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`pr_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smart_shopping`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_shopping`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_first_name` VARCHAR(50) NOT NULL,
  `us_last_name` VARCHAR(50) NOT NULL,
  `us_age` INT(2) NOT NULL,
  `us_gender` VARCHAR(6) NOT NULL,
  `us_contact_number` BIGINT(10) UNIQUE NOT NULL,
  `us_user_id` VARCHAR(15) NOT NULL,
  `us_password` VARCHAR(200) NOT NULL,
  `us_user_type` VARCHAR(1) NOT NULL,
  `us_status` VARCHAR(1) NOT NULL,
  `us_secret_question_1` VARCHAR(50) NOT NULL,
  `us_secret_answer_1` VARCHAR(50) NOT NULL,
  `us_secret_question_2` VARCHAR(50) NOT NULL,
  `us_secret_answer_2` VARCHAR(50) NOT NULL,
  `us_secret_question_3` VARCHAR(50) NOT NULL,
  `us_secret_answer_3` VARCHAR(50) NOT NULL,
  `us_reward_points` INT NOT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smart_shopping`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smart_shopping`.`bill` (
  `b_id` INT NOT NULL AUTO_INCREMENT,
  `b_purchase_date` DATE NOT NULL,
  `b_total_amount` DECIMAL(8,2) NOT NULL,
  `b_reward_points` INT NOT NULL,
  `user_us_id` INT(11) NOT NULL,
  `b_original_amount` DECIMAL(8,2) NOT NULL,
  `b_final_reward_points` INT NOT NULL,
  PRIMARY KEY (`b_id`),
  INDEX `fk_bill_user1_idx` (`user_us_id` ASC),
  CONSTRAINT `fk_bill_user1`
    FOREIGN KEY (`user_us_id`)
    REFERENCES `smart_shopping`.`user` (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `smart_shopping`.`bill_details`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `smart_shopping`.`bill_details` (
  `product_pr_id` INT(11) NOT NULL,
  `bill_b_id` INT(11) NOT NULL,
  `b_d_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  INDEX `fk_product_has_bill_bill1_idx` (`bill_b_id` ASC),
  INDEX `fk_product_has_bill_product1_idx` (`product_pr_id` ASC),
  PRIMARY KEY (`b_d_id`),
  CONSTRAINT `fk_product_has_bill_product1`
    FOREIGN KEY (`product_pr_id`)
    REFERENCES `smart_shopping`.`product` (`pr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_bill_bill1`
    FOREIGN KEY (`bill_b_id`)
    REFERENCES `smart_shopping`.`bill` (`b_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `smart_shopping`.`offer` (
  `of_id` INT(11) NOT NULL AUTO_INCREMENT,
  `of_date` DATE NOT NULL,
  `of_discount_percentage` INT(11) NOT NULL,
  `of_offer` VARCHAR(100) NOT NULL,
  `product_pr_id` INT(11) NOT NULL,
  PRIMARY KEY (`of_id`, `product_pr_id`),
  INDEX `fk_offer_product1_idx` (`product_pr_id` ASC),
  CONSTRAINT `fk_offer_product1`
    FOREIGN KEY (`product_pr_id`)
    REFERENCES `smart_shopping`.`product` (`pr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('1', 'Admin', 'Admin', '30', 'Male', '8888888888', 'admin', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'O', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');

insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('2', 'customer', 'customer', '30', 'Male', '9999999999', 'c1', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'U', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');


insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('3', 'JOhn', 'Stephean', '30', 'Male', '1111111113', 'a1', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'A', 'P', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');

insert into user(us_id,us_first_name,us_last_name,us_age,us_gender,us_contact_number,us_user_id,us_password,us_user_type,us_status,us_secret_question_1,us_secret_answer_1,us_secret_question_2,us_secret_answer_2,us_secret_question_3,us_secret_answer_3,us_reward_points)
 values('4', 'Raju', 'Rao', '30', 'Male', '1121111113', 'a2', '$2a$10$iRI4oISXx8APJNlj7i9/JO5oaGtKNztI3cuXOvtSs7jhHOJ/nlSOS', 'A', 'A', 'What is your favorite book', 'Robotics', 'What is your lucky item', 'Cake', 'What is your favorite movie', 'kingkong','0');


INSERT into `smart_shopping`.`product` values (1,'Spoon',1,'Milton','2','40','50','2019-03-15','1','1','2017-05-24','2020-4-9','https://images.unsplash.com/photo-1567807951157-76af61943dfe?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (2,'Plate',1,'Milton','1','80','50','2019-03-15','1','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1499028203764-8669cfd05719?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (3,'Bottle',1,'Milton','1','200','200','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1544003484-3cd181d17917?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (4,'Tumbler',1,'Milton','1','70','100','2019-03-15','2','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1549124785-1c1c62a24388?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (5,'Pressure Cooker',1,'Milton','1','1000','50','2019-03-15','3','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1544233726-9f1d2b27be8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (6,'Garlic Bread',2,'Bakers Fresh','2','70','20','2019-03-15','3','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1573140401552-3fab0b24306f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (7,'Fruit Jam',2,'Bakers Fresh','1','50','30','2019-03-15','4','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1471943311424-646960669fbc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (8,'Cupcakes',2,'Bakers Fresh','2','30','100','2019-03-15','4','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1465254596705-1ef61f93878c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (9,'Cookies',2,'Bakers Fresh','2','50','50','2019-03-15','5','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1558961363-fa8fdf82db35?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (10,'Homemade chocolate',2,'Bakers Fresh','1','120','10','2019-03-15','5','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1551529674-48920e9b835b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (11,'Orange',3,'Farm Fresh','3','90','100','2019-03-15','6','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1547514701-42782101795e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (12,'Apple',3,'Farm Fresh','3','150','100','2019-03-15','6','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (13,'Potato',3,'Farm Fresh','3','45','100','2019-03-15','7','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1518977676601-b53f82aba655?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (14,'Dragon Fruit',3,'Farm Fresh','3','150','100','2019-03-15','7','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1527325678964-54921661f888?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (15,'Papaya',3,'Farm Fresh','3','70','100','2019-03-15','8','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1526318472351-c75fcf070305?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (16,'Popcorn',4,'ActII','1','20','100','2019-03-15','8','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1572177191856-3cde618dee1f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (17,'Lays',4,'ActII','1','150','60','2019-03-15','9','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1566478989037-eec170784d0b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (18,'Doritos',4,'Doritos','1','100','100','2019-03-15','9','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1567838080002-b388fbd228ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (19,'Nabati',4,'Nabati','1','20','100','2019-03-15','10','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1542843137-144e10cc010b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smart_shopping`.`product` values (20,'Oreo',4,'Cadbury','1','30','100','2019-03-15','10','2','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1531257243018-c547a2e35767?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
