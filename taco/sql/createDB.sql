-- MySQL Script generated by MySQL Workbench
-- Sun Jun 26 16:53:23 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ingredient` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ingredient` (
  `id` varchar(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Taco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Taco` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Taco` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Taco_Ingredients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Taco_Ingredients` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Taco_Ingredients` (
  `taco_id` BIGINT NOT NULL,
  `ingredients_id` varchar(45) NOT NULL,
  INDEX `taco_idx` (`taco_id` ASC) VISIBLE,
  INDEX `ingredient_idx` (`ingredients_id` ASC) VISIBLE,
  CONSTRAINT `FK_taco_to_taco_ingr`
    FOREIGN KEY (`taco_id`)
    REFERENCES `mydb`.`Taco` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_ingr_to_taco_ingr`
    FOREIGN KEY (`ingredients_id`)
    REFERENCES `mydb`.`Ingredient` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Taco_Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Taco_Order` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Taco_Order` (
  `id` BIGINT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  `cc_number` VARCHAR(45) NULL,
  `cc_expiration` VARCHAR(45) NULL,
  `cccvv` VARCHAR(45) NULL,
  `placed_at` TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Taco_Order_Tacos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Taco_Order_Tacos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Taco_Order_Tacos` (
  `order_id` BIGINT NOT NULL,
  `tacos_id` BIGINT NOT NULL,
  INDEX `taco_idx` (`tacos_id` ASC) VISIBLE,
  INDEX `order_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `FK_taco_to_taco_order`
    FOREIGN KEY (`tacos_id`)
    REFERENCES `mydb`.`Taco` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_order_to_taco_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`Taco_Order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;