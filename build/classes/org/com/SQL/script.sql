drop database parqueo;
create database parqueo DEFAULT CHARACTER SET utf8 ;
USE  parqueo;

-- -----------------------------------------------------
-- Table   PARQUEO 
-- -----------------------------------------------------
CREATE TABLE  PARQUEO  (
   idPARQUEO  INT NOT NULL auto_increment,
   Nombre_parqueo  VARCHAR(300) NOT NULL,
   Direccion  VARCHAR(300) NULL,
  PRIMARY KEY ( idPARQUEO ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   ROL 
-- -----------------------------------------------------
CREATE TABLE  ROL  (
   idROL  INT NOT NULL AUTO_INCREMENT,
   nombre_rol  VARCHAR(100) NOT NULL,
  PRIMARY KEY ( idROL ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   USUARIO 
-- -----------------------------------------------------
CREATE TABLE  USUARIO  (
   idUSUARIO  INT NOT NULL auto_increment,
   usuario varchar(100) not null,
   DPI  DECIMAL(13,0) NOT NULL unique,
   Nombres  VARCHAR(100) NOT NULL,
   Apellidos  VARCHAR(100) NOT NULL,
   Password  varchar(200) NOT NULL,
   fPARQUEO  INT NOT NULL,
   fRol  INT NOT NULL,
  PRIMARY KEY ( idUSUARIO ),
  INDEX  fk_USUARIO_PARQUEO1_idx  ( fPARQUEO  ASC),
  INDEX  fk_USUARIO_ROL1_idx  ( fRol  ASC),
  CONSTRAINT  fk_USUARIO_PARQUEO1 
    FOREIGN KEY ( fPARQUEO )
    REFERENCES   PARQUEO  ( idPARQUEO )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT  fk_USUARIO_ROL1 
    FOREIGN KEY ( fRol )
    REFERENCES   ROL  ( idROL )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   DESCUENTO 
-- -----------------------------------------------------
CREATE TABLE  DESCUENTO  (
   idDESCUENTO  INT NOT NULL AUTO_INCREMENT,
   nombre_descuento varchar(200) not null,
   porcentaje  INT NULL,
   fecha  DATE NULL,
   minutos_de_descuento  INT NULL,
  PRIMARY KEY ( idDESCUENTO ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   TARIFA 
-- -----------------------------------------------------
CREATE TABLE  TARIFA  (
   idTARIFA  INT NOT NULL AUTO_INCREMENT,
   Precio  DOUBLE NOT NULL,
   hora_inicio_tarifa  TIME NOT NULL,
   hora_fin_tarifa  TIME NULL,
   fPARQUEO  INT NOT NULL,
  PRIMARY KEY ( idTARIFA ),
  INDEX  fk_TARIFA_PARQUEO1_idx  ( fPARQUEO  ASC),
  CONSTRAINT  fk_TARIFA_PARQUEO1 
    FOREIGN KEY ( fPARQUEO )
    REFERENCES   PARQUEO  ( idPARQUEO )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   HORARIO 
-- -----------------------------------------------------
CREATE TABLE  HORARIO  (
   idHORARIO  INT NOT NULL AUTO_INCREMENT,
   hora_inicio  TIME NOT NULL,
   hora_fin  TIME NOT NULL,
   fUSUARIO  INT NOT NULL,
  PRIMARY KEY ( idHORARIO ),
  INDEX  fk_HORARIO_USUARIO1_idx  ( fUSUARIO  ASC),
  CONSTRAINT  fk_HORARIO_USUARIO1 
    FOREIGN KEY ( fUSUARIO )
    REFERENCES   USUARIO  ( idUSUARIO )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   TURNO 
-- -----------------------------------------------------
CREATE TABLE  TURNO  (
   idTURNO  INT NOT NULL AUTO_INCREMENT,
   horario_apertura  DATETIME NOT NULL,
   horario_cierre  DATETIME NULL,
   fPARQUEO  INT NOT NULL,
   fUSUARIO  INT NOT NULL,
  PRIMARY KEY ( idTURNO ),
  
  CONSTRAINT  fk_TURNO_PARQUEO1 
    FOREIGN KEY ( fPARQUEO )
    REFERENCES   PARQUEO  ( idPARQUEO )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT  fk_TURNO_USUARIO1 
    FOREIGN KEY ( fUSUARIO )
    REFERENCES   USUARIO  ( idUSUARIO )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   TICKET 
-- -----------------------------------------------------
CREATE TABLE  TICKET  (
   idTICKET  INT NOT NULL AUTO_INCREMENT,
   Codigo  VARCHAR(6) NOT NULL,
   hora_ingreso  datetime NOT NULL,
   hora_salida  datetime NULL,
   subtotal  DOUBLE NULL,
   descuento  DOUBLE NULL,
   total  DOUBLE NULL,
   fTURNO  INT NOT NULL,
   fDESCUENTO  INT NULL,
  PRIMARY KEY ( idTICKET ),
  INDEX  fk_TICKET_TURNO1_idx  ( fTURNO  ASC),
  INDEX  fk_TICKET_DESCUENTO1_idx  ( fDESCUENTO  ASC),
  CONSTRAINT  fk_TICKET_TURNO1 
    FOREIGN KEY ( fTURNO )
    REFERENCES   TURNO  ( idTURNO )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT  fk_TICKET_DESCUENTO1 
    FOREIGN KEY ( fDESCUENTO )
    REFERENCES   DESCUENTO  ( idDESCUENTO )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   BITACORA 
-- -----------------------------------------------------
CREATE TABLE  BITACORA  (
   idBITACORA  INT NOT NULL AUTO_INCREMENT,
   usuario  INT NOT NULL,
   fecha  DATE NOT NULL,
   hora  TIME NOT NULL,
   descripcion  VARCHAR(400) NOT NULL,
  PRIMARY KEY ( idBITACORA ))
ENGINE = InnoDB;



-- inserciones de rol
insert into rol (nombre_rol) values('admin'),('usuario');

-- procedimientos 

-- procedimiento para actualizar el ticket
delimiter //
create procedure actualizar_ticket(
id_ticket int, sub double, descu double) 
begin 
update ticket set hora_salida =  NOW(), subtotal = sub,descuento=descu,total=(sub  - descu) where idTICKET = id_ticket;
end//


-- procedimiento para hacer la apertura del curso
delimiter //
create procedure aperturar_turno(
usuario int, parqueo int) 
begin

insert into turno (horario_apertura,fparqueo,fusuario)values(NOW(),parqueo,usuario);
set @maxid = (select max(idturno) from turno);
select * from turno where idturno = @maxid;
end//


delimiter //
create procedure consultar_turno(parqueo int) 
begin
set @maxid = (select max(idturno) from turno where fPARQUEO= parqueo);
select * from turno where idturno = @maxid;
end//


delimiter //
create procedure cerrar_turno(parqueo int, turno int) 
begin

update turno set horario_cierre=CURRENT_TIME() where idturno = turno and fparqueo = parqueo;
select sum(total) as total from ticket where fturno = turno;

end//


