CREATE TABLE `flight_analyzer`.`currency` (
  `code` VARCHAR(20) NOT NULL,
  `symbol` VARCHAR(20) NULL,
  `thousandsSeparator` VARCHAR(2) NULL,
  `decimalSeparator` VARCHAR(2) NULL,
  `symbolOnLeft` TINYINT(1) NULL,
  `spaceBetweenAmountAndSymbol` TINYINT(1) NULL,
  `roundingCoefficient` INT NULL,
  `decimalDigits` INT NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
