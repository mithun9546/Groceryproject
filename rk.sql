SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admin` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `admin` (
  `name` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `delivery` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `delivery` (
  `firstname` VARCHAR(34) NULL DEFAULT NULL ,
  `lastname` VARCHAR(45) NULL DEFAULT NULL ,
  `contact` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `feedback` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `feedback` (
  `descri` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  `rating` VARCHAR(45) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `groceryitem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `groceryitem` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `groceryitem` (
  `iname` VARCHAR(25) NOT NULL ,
  `idesci` VARCHAR(45) NULL DEFAULT NULL ,
  `iprice` INT(11) NULL DEFAULT NULL ,
  `itype` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`iname`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `register`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `register` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `register` (
  `firstname` VARCHAR(20) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `contact` VARCHAR(45) NOT NULL ,
  `dob` VARCHAR(45) NOT NULL ,
  `gender` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`email`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `shippping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shippping` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `shippping` (
  `firstname` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NULL DEFAULT NULL ,
  `Contactl` VARCHAR(45) NULL DEFAULT NULL ,
  `Email` VARCHAR(45) NULL DEFAULT NULL ,
  `house_no` VARCHAR(45) NULL DEFAULT NULL ,
  `street` VARCHAR(45) NULL DEFAULT NULL ,
  `city` VARCHAR(45) NULL DEFAULT NULL ,
  `zip` INT(11) NULL DEFAULT NULL ,
  `country` VARCHAR(45) NULL DEFAULT NULL ,
  `state` VARCHAR(15) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
