SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema research_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `research_db` ;

-- -----------------------------------------------------
-- Schema research_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `research_db` DEFAULT CHARACTER SET latin1 ;
USE `research_db` ;
------------------------------------------
-- Table structure for table `text_password`------
--------------------------------------------

DROP TABLE IF EXISTS `text_password`;

CREATE TABLE `text_password` (
  `user_name` varchar(200) NOT NULL,
  `password` varchar(2000) NOT NULL,
  `salt` varchar(255) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB ;
