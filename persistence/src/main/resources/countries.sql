CREATE TABLE `flight_analyzer`.`country` (
  `code` VARCHAR(20) BINARY NOT NULL,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC));
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;