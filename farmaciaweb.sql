-- MySQL Script generated by MySQL Workbench
-- dom 24 jun 2018 16:27:55 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema FarmaciaWEB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema FarmaciaWEB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `FarmaciaWEB` DEFAULT CHARACTER SET utf8 ;
USE `FarmaciaWEB` ;

-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`LOCALIZACAO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`LOCALIZACAO` (
  `id` BIGINT(20) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `cidade` VARCHAR(255) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`LOGIN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`LOGIN` (
  `id` BIGINT NOT NULL,
  `usuario` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`CLIENTE` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `dataNascimento` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `LOCALIZACAO_id` BIGINT(20) NOT NULL,
  `LOGIN_id` BIGINT(20) NOT NULL,
  `perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`, `LOCALIZACAO_id`, `LOGIN_id`),
  INDEX `fk_PESSOA_FISICA_LOCALIZACAO1_idx` (`LOCALIZACAO_id` ASC),
  INDEX `fk_PESSOA_FISICA_LOGIN1_idx` (`LOGIN_id` ASC),
  CONSTRAINT `fk_PESSOA_FISICA_LOCALIZACAO1`
    FOREIGN KEY (`LOCALIZACAO_id`)
    REFERENCES `FarmaciaWEB`.`LOCALIZACAO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PESSOA_FISICA_LOGIN1`
    FOREIGN KEY (`LOGIN_id`)
    REFERENCES `FarmaciaWEB`.`LOGIN` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`FARMACIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`FARMACIA` (
  `cnpj` VARCHAR(16) NOT NULL,
  `razao_social` VARCHAR(255) NOT NULL,
  `nome_fantasia` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `logo_path` VARCHAR(255) NOT NULL,
  `LOCALIZACAO_id` BIGINT(20) NOT NULL,
  `LOGIN_id` BIGINT(20) NOT NULL,
  `perfil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cnpj`, `LOCALIZACAO_id`, `LOGIN_id`),
  INDEX `fk_FARMACIA_LOCALIZACAO1_idx` (`LOCALIZACAO_id` ASC),
  INDEX `fk_FARMACIA_LOGIN1_idx` (`LOGIN_id` ASC),
  CONSTRAINT `fk_FARMACIA_LOCALIZACAO1`
    FOREIGN KEY (`LOCALIZACAO_id`)
    REFERENCES `FarmaciaWEB`.`LOCALIZACAO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FARMACIA_LOGIN1`
    FOREIGN KEY (`LOGIN_id`)
    REFERENCES `FarmaciaWEB`.`LOGIN` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`MEDICAMENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`MEDICAMENTO` (
  `id` BIGINT(20) NOT NULL,
  `preco` DOUBLE NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `validade` DATE NOT NULL,
  `descricao` LONGTEXT NOT NULL,
  `foto_path` VARCHAR(255) NOT NULL,
  `fabricante` VARCHAR(255) NOT NULL,
  `quantidade` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `identificador` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`INSERE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`INSERE` (
  `FARMACIA_cnpj` VARCHAR(16) NOT NULL,
  `MEDICAMENTO_id` BIGINT(20) NOT NULL,
  `dataInsercao` DATE NOT NULL,
  `quantidade` INT NOT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`FARMACIA_cnpj`, `MEDICAMENTO_id`, `id`),
  INDEX `fk_FARMACIA_has_MEDICAMENTO_MEDICAMENTO1_idx` (`MEDICAMENTO_id` ASC),
  INDEX `fk_FARMACIA_has_MEDICAMENTO_FARMACIA1_idx` (`FARMACIA_cnpj` ASC),
  CONSTRAINT `fk_FARMACIA_has_MEDICAMENTO_FARMACIA1`
    FOREIGN KEY (`FARMACIA_cnpj`)
    REFERENCES `FarmaciaWEB`.`FARMACIA` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FARMACIA_has_MEDICAMENTO_MEDICAMENTO1`
    FOREIGN KEY (`MEDICAMENTO_id`)
    REFERENCES `FarmaciaWEB`.`MEDICAMENTO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FarmaciaWEB`.`VENDA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FarmaciaWEB`.`VENDA` (
  `CLIENTE_cpf` VARCHAR(11) NOT NULL,
  `MEDICAMENTO_id` BIGINT(20) NOT NULL,
  `dataVenda` DATE NOT NULL,
  `tipo_pagamento` VARCHAR(45) NOT NULL,
  `quantidade` INT NOT NULL,
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`CLIENTE_cpf`, `MEDICAMENTO_id`, `id`),
  INDEX `fk_CLIENTE_has_MEDICAMENTO_MEDICAMENTO1_idx` (`MEDICAMENTO_id` ASC),
  INDEX `fk_CLIENTE_has_MEDICAMENTO_CLIENTE1_idx` (`CLIENTE_cpf` ASC),
  CONSTRAINT `fk_CLIENTE_has_MEDICAMENTO_CLIENTE1`
    FOREIGN KEY (`CLIENTE_cpf`)
    REFERENCES `FarmaciaWEB`.`CLIENTE` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CLIENTE_has_MEDICAMENTO_MEDICAMENTO1`
    FOREIGN KEY (`MEDICAMENTO_id`)
    REFERENCES `FarmaciaWEB`.`MEDICAMENTO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
