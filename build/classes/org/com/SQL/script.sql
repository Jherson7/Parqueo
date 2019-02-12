drop database if exists parqueo;
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



create TABLE INDICE_TICKET(
	corelativo int not null primary key auto_increment,
    idparqueo int not null,
	 foreign key (idparqueo) references parqueo(idparqueo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table DETALLE_PARQUEO(
	id_detalle int not null primary key auto_increment,
    idparqueo int not null,
    header varchar(300) not null,
    footer varchar(300) not null,
	 foreign key (idparqueo) references parqueo(idparqueo)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);




CREATE TABLE HORARIO_PARQUEO(
	id_horario int not null auto_increment primary key,
    hora_inicio time,
    hora_fin time,
    idparqueo int not null,
    foreign key (idparqueo) references parqueo(idparqueo)
    ON DELETE CASCADE
    ON UPDATE CASCADE

);


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
   tipo_descuento  INT NULL,-- 1 porcentaje 2 minutos 3 dinero
   valor  double  not null NULL,
   fecha  DATE NULL,
  PRIMARY KEY ( idDESCUENTO ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table   TARIFA 
-- -----------------------------------------------------
CREATE TABLE  TARIFA  (
   idTARIFA  INT NOT NULL AUTO_INCREMENT,
   Precio  DOUBLE NOT NULL,
   precio_media_hora double not null,
   tarifa_unica int default 0,
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
-- Table   dias_tarifa 
-- -----------------------------------------------------
create table dias_tarifa (
    id_dias int not null auto_increment,
    dia_cod  int not null,
    dia_nombre varchar(10),
    fk_tarifa int not null,
    primary key (id_dias,fk_tarifa),
    constraint fk_dia_tarifa foreign key (fk_tarifa)
    references TARIFA(id_tarifa)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

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
   idTICKET  	INT NOT NULL AUTO_INCREMENT,
   Codigo  		VARCHAR(6) NOT NULL,
   hora_ingreso datetime NOT NULL,
   hora_salida  datetime NULL,
   subtotal  	DOUBLE NULL,
   descuento  	DOUBLE NULL,
   total  		DOUBLE NULL,
   fTURNO  		INT NOT NULL,
   fDESCUENTO  	INT NULL,
   factura		varchar(100),
   fturno_cierre int null,
   -- agregar si el ticket ya fue cobrado no volverlo a cobrar
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

-- procedimiento para actualizar el ticket

delimiter //
create procedure actualizar_ticket(
id_ticket int, sub double, descu double,v_factura varchar(100),turno_cierre int) 
begin 
update ticket set fturno_cierre = turno_cierre,factura=v_factura, hora_salida =  NOW(), subtotal = sub,descuento=descu,total=(sub  - descu) where idTICKET = id_ticket;
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

-- drop procedure aperturar_turno;


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


delimiter //
create procedure get_total_por_turno(inicio date , fin date, parqueo int ) 
begin

select concat(u.nombres,concat(' ',u.apellidos)) as Empleado , DATE_FORMAT(tu.horario_apertura,"%d-%m-%Y - %H:%m") Apertura, DATE_FORMAT(tu.horario_cierre,"%d-%m-%Y - %H:%m") Cierre, 
sum(t.total) as Total,tu.idturno
from ticket t inner join turno tu on t.fturno = tu.idturno
inner join usuario u on u.idusuario = tu.fusuario
where date(tu.horario_apertura) between date(inicio) and date(fin) and u.fparqueo = parqueo
group by (t.fturno);

end//

delimiter //
create procedure get_total_por_turno_detallado(inicio date , fin date, parqueo int ) 
begin
Select u.usuario, date(tu.horario_apertura),tu.horario_apertura,tu.horario_cierre,ti.hora_ingreso,ti.hora_salida,ti.total from usuario u inner join turno tu on u.idusuario = tu.fusuario
Inner join ticket ti on ti.fturno = tu.idturno
where date(tu.horario_apertura) between date(inicio) and date(fin) and tu.fparqueo = parqueo;

end//

delimiter //
create procedure dias_de_diferncia(fecha1 date, fecha2 date) 
begin

SELECT DATEDIFF(fecha1,fecha2)  as dias;
end//


/*
idTARIFA  INT NOT NULL AUTO_INCREMENT,
   Precio  DOUBLE NOT NULL,
   precio_media_hora double not null,
   tarifa_unica int default 0,
   hora_inicio_tarifa  TIME NOT NULL,
   hora_fin_tarifa  TIME NULL,
   fPARQUEO  INT NOT NULL,*/



insert into PARQUEO (Nombre_parqueo,direccion) values('Master','Parking');
insert into detalle_parqueo (idparqueo,header,footer) values (1,'header','fooder');
insert into horario_parqueo (hora_inicio,hora_fin,idparqueo) values('7:00','2:00',1);
insert into rol (nombre_rol) values('admin'),('usuario');
insert into usuario(dpi,usuario,nombres,apellidos,password,fparqueo,frol) values(123456789,'Admin','Admin','Admin','capri3042',1,1);
insert into usuario(dpi,usuario,nombres,apellidos,password,fparqueo,frol) values(987654321,'Usuario','User','User','usuario',1,2);
insert into horario (hora_inicio,hora_fin,fusuario) values ('7:00','17:00',1);
insert into horario (hora_inicio,hora_fin,fusuario) values ('7:00','18:00',2);
insert into tarifa(precio,precio_media_hora,tarifa_unica,hora_inicio_tarifa,hora_fin_tarifa,fparqueo)
values(10,6,0,'7:00','17:00',1);
insert into tarifa(precio,precio_media_hora,tarifa_unica,hora_inicio_tarifa,hora_fin_tarifa,fparqueo)
values(30,0,1,'18:00','23:00',1);

select * from ticket;
























 -- 3 consultas
-- get_tickets_que_no_son_extraviados_y_no_tienen_descuento
-- get_tickets_extraviados_y_no_tienen_desc
-- get_tickets_con_descuento
-- por turno y que hayan sido  cobrados
-- despues los recorro para ver cuantos fueron de noche y de dia
