-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd_residente
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_residente
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_residente` DEFAULT CHARACTER SET utf8 ;
USE `bd_residente` ;

-- -----------------------------------------------------
-- Table `bd_residente`.`tb_asamblea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_asamblea` (
  `id_asamblea` VARCHAR(3) NOT NULL,
  `fecha_asamblea` DATETIME NOT NULL,
  `corum_asamblea` INT(11) NULL DEFAULT NULL,
  `duracion_asamblea` DATETIME NOT NULL,
  `fecha_inicio_votacion` DATETIME NOT NULL,
  `fecha_fin_votacion` DATETIME NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_asamblea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_conjunto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_conjunto` (
  `id_conjunto` VARCHAR(3) NOT NULL,
  `nombre_conjunto` VARCHAR(50) NOT NULL,
  `direccion_conjunto` VARCHAR(50) NOT NULL,
  `numero_apartamentos` VARCHAR(50) NULL DEFAULT NULL,
  `numero_parqueaderos` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NULL DEFAULT NULL,
  `usuario_creacion` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_modifcacion` DATETIME NULL DEFAULT NULL,
  `usuario_modificacion` VARCHAR(50) NULL DEFAULT NULL,
  `tb_administrador_tipo_id_administrador` VARCHAR(3) NOT NULL,
  `tb_asamblea_tipo_id_administrador` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_conjunto`),
  UNIQUE INDEX `id_conjunto_UNIQUE` (`id_conjunto` ASC),
  UNIQUE INDEX `tb_conjuntocol_UNIQUE` (`direccion_conjunto` ASC),
  INDEX `fk_tb_conjunto_tb_asamblea1_idx` (`tb_asamblea_tipo_id_administrador` ASC),
  CONSTRAINT `fk_tb_conjunto_tb_asamblea1`
    FOREIGN KEY (`tb_asamblea_tipo_id_administrador`)
    REFERENCES `bd_residente`.`tb_asamblea` (`id_asamblea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_archivo` (
  `id_archivo` INT(11) NOT NULL,
  `Nombre_archivo` VARCHAR(50) NOT NULL,
  `descripcion_archivo` VARCHAR(1000) NOT NULL,
  `archivo_archivo` TINYBLOB NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modifcacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id_archivo`),
  INDEX `fk_tb_archivo_tb_conjunto1_idx` (`tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_archivo_tb_conjunto1`
    FOREIGN KEY (`tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_conjunto` (`id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_catalogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_catalogo` (
  `id_catalogo` VARCHAR(50) NOT NULL,
  `descripcion_catalogo` VARCHAR(200) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_catalogo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'tabla para el manejo de las listas deplegables y parametricas del sistema';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_inmueble`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_inmueble` (
  `tipo_id_immueble` VARCHAR(3) NOT NULL,
  `id_inmueble` INT(11) NOT NULL,
  `nombre_residente*` VARCHAR(50) NOT NULL,
  `apellido_residente*` VARCHAR(50) NOT NULL,
  `nombre_acudiente` VARCHAR(50) NULL DEFAULT NULL,
  `tipo_id_acudiente` VARCHAR(3) NOT NULL,
  `id_acudiente` INT(11) NOT NULL,
  `tel_acudiente` VARCHAR(50) NOT NULL,
  `parentesco_acudiente` VARCHAR(3) NOT NULL,
  `tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modifcacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tipo_id_immueble`, `id_inmueble`, `tb_conjunto_id_conjunto`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_inmueble` ASC),
  UNIQUE INDEX `id_contacto_emergencia_UNIQUE` (`id_acudiente` ASC),
  INDEX `fk_tb_residente_tb_conjunto2_idx` (`tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_residente_tb_conjunto2`
    FOREIGN KEY (`tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_conjunto` (`id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_cuota` (
  `id_tipo_cuota` VARCHAR(3) NOT NULL,
  `numero_dias_pago` DATETIME NOT NULL,
  `fecha_pago_oportuno` DATETIME NOT NULL,
  `frecuencia_pago` VARCHAR(50) NOT NULL,
  `valor_cuota` DECIMAL(10,0) NOT NULL,
  `descripcion_cuota` VARCHAR(200) NULL DEFAULT NULL,
  `porcentaje_int_mora` DECIMAL(10,0) NOT NULL,
  `numero_cuotas` VARCHAR(45) NULL DEFAULT NULL,
  `porcentaje_pago_anticipado` DECIMAL(10,0) NULL DEFAULT NULL,
  `valor_cobro_juridico` DECIMAL(10,0) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_inmueble_tipo_id_immueble` VARCHAR(3) NOT NULL,
  `tb_inmueble_id_inmueble` INT(11) NOT NULL,
  `tb_inmueble_tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id_tipo_cuota`),
  INDEX `fk_tb_tipo_cuota_tb_inmueble1_idx` (`tb_inmueble_tipo_id_immueble` ASC, `tb_inmueble_id_inmueble` ASC, `tb_inmueble_tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_tipo_cuota_tb_inmueble1`
    FOREIGN KEY (`tb_inmueble_tipo_id_immueble` , `tb_inmueble_id_inmueble` , `tb_inmueble_tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_inmueble` (`tipo_id_immueble` , `id_inmueble` , `tb_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_propuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_propuesta` (
  `id_propuesta` INT(11) NOT NULL,
  `nombre_propuesta` VARCHAR(50) NOT NULL,
  `descripcion_propuesta` VARCHAR(200) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_asamblea_id_asamblea` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_propuesta`),
  INDEX `fk_tb_propuesta_tb_asamblea1_idx` (`tb_asamblea_id_asamblea` ASC),
  CONSTRAINT `fk_tb_propuesta_tb_asamblea1`
    FOREIGN KEY (`tb_asamblea_id_asamblea`)
    REFERENCES `bd_residente`.`tb_asamblea` (`id_asamblea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_eleccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_eleccion` (
  `opcion_seleccionado` INT(11) NOT NULL,
  `fecha_eleccion` DATETIME NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_votacion_cod_votacion` VARCHAR(3) NOT NULL,
  `tb_inmueble_tipo_id_immueble` VARCHAR(3) NOT NULL,
  `tb_inmueble_id_inmueble` INT(11) NOT NULL,
  `tb_inmueble_tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  `tb_propuesta_id_propuesta` INT(11) NOT NULL,
  PRIMARY KEY (`tb_votacion_cod_votacion`, `tb_propuesta_id_propuesta`),
  INDEX `fk_tb_eleccion_tb_inmueble1_idx` (`tb_inmueble_tipo_id_immueble` ASC, `tb_inmueble_id_inmueble` ASC, `tb_inmueble_tb_conjunto_id_conjunto` ASC),
  INDEX `fk_tb_eleccion_tb_propuesta1_idx` (`tb_propuesta_id_propuesta` ASC),
  CONSTRAINT `fk_tb_eleccion_tb_inmueble1`
    FOREIGN KEY (`tb_inmueble_tipo_id_immueble` , `tb_inmueble_id_inmueble` , `tb_inmueble_tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_inmueble` (`tipo_id_immueble` , `id_inmueble` , `tb_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_eleccion_tb_propuesta1`
    FOREIGN KEY (`tb_propuesta_id_propuesta`)
    REFERENCES `bd_residente`.`tb_propuesta` (`id_propuesta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_lista_catalogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_lista_catalogo` (
  `id_lista_catalogo` VARCHAR(5) NOT NULL,
  `tb_catalogo_id_catalogo` VARCHAR(50) NOT NULL,
  `nombre_lista_catalogo` VARCHAR(50) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_lista_catalogo`, `tb_catalogo_id_catalogo`),
  INDEX `fk_tb_lista_catalogo_tb_catalogo1_idx` (`tb_catalogo_id_catalogo` ASC),
  CONSTRAINT `fk_tb_lista_catalogo_tb_catalogo1`
    FOREIGN KEY (`tb_catalogo_id_catalogo`)
    REFERENCES `bd_residente`.`tb_catalogo` (`id_catalogo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'tabla para la gestion de los valores de los catalogos';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_modulo` (
  `id_modulo` VARCHAR(3) NOT NULL,
  `nombre_modulo` VARCHAR(50) NOT NULL,
  `descripcion_modulo` VARCHAR(200) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_modulo`),
  UNIQUE INDEX `nombre_modulo_UNIQUE` (`nombre_modulo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabla que gestiona los módulos del sistema';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_menu` (
  `id_menu` VARCHAR(3) NOT NULL,
  `nombre_menu` VARCHAR(50) NOT NULL,
  `descripcion_menu` VARCHAR(200) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_modulo_id_modulo` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_menu`),
  INDEX `fk_tb_menu_tb_modulo1_idx` (`tb_modulo_id_modulo` ASC),
  CONSTRAINT `fk_tb_menu_tb_modulo1`
    FOREIGN KEY (`tb_modulo_id_modulo`)
    REFERENCES `bd_residente`.`tb_modulo` (`id_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabla que gestiona las módulos y opciones de menú\n';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_perfil` (
  `id_perfil` VARCHAR(3) NOT NULL,
  `nombre_perfil` VARCHAR(50) NOT NULL,
  `descripción_perfil` VARCHAR(500) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_perfil`),
  UNIQUE INDEX `nombre_perfil_UNIQUE` (`nombre_perfil` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabla para la gestion de los perfiles del sistema, en fase de incio se identifican (administrador sistema,adminstrador conjunto, residente, guarda de seguridad\n)';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_modulo_perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_modulo_perfil` (
  `tb_modulo_id_modulo` VARCHAR(3) NOT NULL,
  `tb_perfil_id_perfil` VARCHAR(3) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tb_modulo_id_modulo`, `tb_perfil_id_perfil`, `fecha_creacion`, `usuario_creacion`, `fecha_modificacion`, `usuario_modificacion`),
  INDEX `fk_tb_modulo_has_tb_perfil_tb_perfil1_idx` (`tb_perfil_id_perfil` ASC),
  INDEX `fk_tb_modulo_has_tb_perfil_tb_modulo1_idx` (`tb_modulo_id_modulo` ASC),
  CONSTRAINT `fk_tb_modulo_has_tb_perfil_tb_modulo1`
    FOREIGN KEY (`tb_modulo_id_modulo`)
    REFERENCES `bd_residente`.`tb_modulo` (`id_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_modulo_has_tb_perfil_tb_perfil1`
    FOREIGN KEY (`tb_perfil_id_perfil`)
    REFERENCES `bd_residente`.`tb_perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Tabla gestiona la asignación de modulos por perfil';


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_opcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_opcion` (
  `id_respuesta` INT(11) NOT NULL,
  `descripcion_respuesta` VARCHAR(200) NOT NULL,
  `tb_propuesta_id_propuesta` INT(11) NOT NULL,
  PRIMARY KEY (`id_respuesta`, `tb_propuesta_id_propuesta`),
  INDEX `fk_tb_opcion_tb_propuesta1_idx` (`tb_propuesta_id_propuesta` ASC),
  CONSTRAINT `fk_tb_opcion_tb_propuesta1`
    FOREIGN KEY (`tb_propuesta_id_propuesta`)
    REFERENCES `bd_residente`.`tb_propuesta` (`id_propuesta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_pago` (
  `id_tipo_pago` VARCHAR(3) NOT NULL,
  `fecha_pago` DATETIME NOT NULL,
  `valor_pago` DECIMAL(10,0) NOT NULL,
  `id_estado_pago` VARCHAR(3) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_cuota_id_tipo_cuota` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_tipo_pago`, `tb_cuota_id_tipo_cuota`),
  INDEX `fk_tb_pago_tb_cuota1_idx` (`tb_cuota_id_tipo_cuota` ASC),
  CONSTRAINT `fk_tb_pago_tb_cuota1`
    FOREIGN KEY (`tb_cuota_id_tipo_cuota`)
    REFERENCES `bd_residente`.`tb_cuota` (`id_tipo_cuota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_parqueadero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_parqueadero` (
  `id_parqueadero` VARCHAR(3) NOT NULL,
  `numero_parqueadero` INT(11) NOT NULL,
  `valor_parqueadero` DECIMAL(10,0) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_inmueble_tipo_id_immueble` VARCHAR(3) NOT NULL,
  `tb_inmueble_id_inmueble` INT(11) NOT NULL,
  `tb_inmueble_tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id_parqueadero`),
  INDEX `fk_tb_parqueadero_tb_inmueble1_idx` (`tb_inmueble_tipo_id_immueble` ASC, `tb_inmueble_id_inmueble` ASC, `tb_inmueble_tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_parqueadero_tb_inmueble1`
    FOREIGN KEY (`tb_inmueble_tipo_id_immueble` , `tb_inmueble_id_inmueble` , `tb_inmueble_tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_inmueble` (`tipo_id_immueble` , `id_inmueble` , `tb_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_zona_comun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_zona_comun` (
  `tipo_zona_comun` VARCHAR(5) NOT NULL,
  `id_zona_comun` INT(11) NOT NULL,
  `numero_personas` INT(11) NULL DEFAULT NULL,
  `valor_zona_comun` DECIMAL(10,0) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  `dia_mant` DATETIME NULL DEFAULT NULL,
  `frec_mant` INT(11) NULL DEFAULT NULL,
  `hora_mant` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_zona_comun`, `tb_conjunto_id_conjunto`),
  INDEX `fk_tb_zona_comun_tb_conjunto1_idx` (`tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_zona_comun_tb_conjunto1`
    FOREIGN KEY (`tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_conjunto` (`id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_reserva` (
  `id_reserva` VARCHAR(3) NOT NULL,
  `fecha_reserva` DATETIME NOT NULL,
  `hora_reserva` DATETIME NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_zona_comun_tipo_zona_comun` VARCHAR(5) NOT NULL,
  `tb_zona_comun_tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  INDEX `fk_tb_reserva_tb_zona_comun1_idx` (`tb_zona_comun_tipo_zona_comun` ASC, `tb_zona_comun_tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_reserva_tb_zona_comun1`
    FOREIGN KEY (`tb_zona_comun_tipo_zona_comun` , `tb_zona_comun_tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_zona_comun` (`tipo_zona_comun` , `tb_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_solicitud` (
  `numero_radicado` VARCHAR(3) NOT NULL,
  `tipo_solicitud` VARCHAR(3) NOT NULL,
  `asunto_solicitud` VARCHAR(50) NOT NULL,
  `descripcion_solicitud` VARCHAR(200) NOT NULL,
  `estado_solicitud` VARCHAR(3) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_inmueble_tipo_id_immueble` VARCHAR(3) NOT NULL,
  `tb_inmueble_id_inmueble` INT(11) NOT NULL,
  `tb_inmueble_tb_conjunto_id_conjunto` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`numero_radicado`),
  INDEX `fk_tb_solicitud_tb_inmueble1_idx` (`tb_inmueble_tipo_id_immueble` ASC, `tb_inmueble_id_inmueble` ASC, `tb_inmueble_tb_conjunto_id_conjunto` ASC),
  CONSTRAINT `fk_tb_solicitud_tb_inmueble1`
    FOREIGN KEY (`tb_inmueble_tipo_id_immueble` , `tb_inmueble_id_inmueble` , `tb_inmueble_tb_conjunto_id_conjunto`)
    REFERENCES `bd_residente`.`tb_inmueble` (`tipo_id_immueble` , `id_inmueble` , `tb_conjunto_id_conjunto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_respuesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_respuesta` (
  `id_respuesta` INT NOT NULL,
  `estado_respuesta` VARCHAR(3) NULL DEFAULT NULL,
  `fecha_respuesta` DATETIME NOT NULL,
  `descripcion_respuesta` VARCHAR(200) NULL DEFAULT NULL,
  `id_usuario` INT(11) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NULL DEFAULT NULL,
  `usuario_creacion` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_modificacion` DATETIME NULL DEFAULT NULL,
  `usuario_modificacion` VARCHAR(50) NULL DEFAULT NULL,
  `tb_solicitud_numero_radicado` VARCHAR(3) NULL,
  INDEX `fk_tb_respuesta_tb_solicitud1_idx` (`tb_solicitud_numero_radicado` ASC),
  PRIMARY KEY (`id_respuesta`, `tb_solicitud_numero_radicado`),
  CONSTRAINT `fk_tb_respuesta_tb_solicitud1`
    FOREIGN KEY (`tb_solicitud_numero_radicado`)
    REFERENCES `bd_residente`.`tb_solicitud` (`numero_radicado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_ubicacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_ubicacion` (
  `codigo_nomenclatura` VARCHAR(3) NOT NULL,
  `valor_nomenclatura` INT(11) NOT NULL,
  `tb_residente_tipo_id_residente` VARCHAR(3) NOT NULL,
  `tb_residente_id_residente` INT(11) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tb_residente_tipo_id_residente`, `tb_residente_id_residente`),
  CONSTRAINT `fk_tb_ubicacion_tb_residente2`
    FOREIGN KEY (`tb_residente_tipo_id_residente` , `tb_residente_id_residente`)
    REFERENCES `bd_residente`.`tb_inmueble` (`tipo_id_immueble` , `id_inmueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_residente`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_residente`.`tb_usuario` (
  `tipo_id_usuario` VARCHAR(3) NOT NULL,
  `id_usuario` INT(11) NOT NULL,
  `nombre_usuario` VARCHAR(50) NOT NULL,
  `apellido_usuario` VARCHAR(100) NOT NULL,
  `usuario` VARCHAR(100) NOT NULL,
  `clave_usuario` VARCHAR(15) NOT NULL,
  `correo_usuario` VARCHAR(50) NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `usuario_creacion` VARCHAR(50) NOT NULL,
  `fecha_modificacion` DATETIME NOT NULL,
  `usuario_modificacion` VARCHAR(50) NOT NULL,
  `tb_perfil_id_perfil` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id_usuario`, `tipo_id_usuario`, `tb_perfil_id_perfil`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC),
  UNIQUE INDEX `correo_usuario_UNIQUE` (`correo_usuario` ASC),
  INDEX `IDX_ID_USUARIO` (`id_usuario` ASC),
  INDEX `fk_tb_usuario_tb_perfil1_idx` (`tb_perfil_id_perfil` ASC),
  CONSTRAINT `fk_tb_usuario_tb_perfil1`
    FOREIGN KEY (`tb_perfil_id_perfil`)
    REFERENCES `bd_residente`.`tb_perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'tabla donde almacena los usuarios a autenticar en el sistema';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
