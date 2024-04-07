create database appveterinariaEverpets;
use appveterinariaEverpets;

-- creando tabla ROLES
create table ROLES(
idRol int primary key,
descripcion varchar(20) not null,
esActivo int -- 1 (activo) 2 (no activo)
); 

insert into ROLES (idRol,descripcion,esActivo) values
(1,'administrador',1),
(2,'supervisor',1),
(3,'empleado',1);

select * from ROLES;

-- creando tabla USUARIOS
create table USUARIOS(
idUsuario int auto_increment primary key,
apellidos varchar(50) not null,
nombres varchar(50) not null,
correo varchar(50) not null,
clave varchar(10) not null,
idRol int references ROLES(idRol),
esActivo int -- 1 (activo) 2 (no activo)
);

select * from usuarios;

insert into USUARIOS (apellidos,nombres,correo,clave,idRol,esActivo) values
('urcia','fabian','fabian@gmail.com','321',2,1),
('urcia','julio','julio@gmail.com','1234',3,1),
('mendives','israel','israel@gmail.com','123',1,1);

-- creando tabla EMPRESA
create table EMPRESA(
RUC varchar(11) not null primary key,
Nombre varchar(100) not null,
Telefono varchar(9) not null,
Direccion varchar(100) not null,
imagen blob,
ruta varchar(100)
);
select * from EMPRESA;

-- creando tabla TIPO_MASCOTA
create table TIPO_MASCOTA(
idTipoMascota int auto_increment primary key,
Nombre_TipoMascota varchar(40)
);

insert into TIPO_MASCOTA values
(1,'Perro'),
(2,'Gato');

insert into TIPO_MASCOTA (Nombre_TipoMascota) values('Conejo');
delete from TIPO_MASCOTA where idTipoMascota=4;

-- mostrar todos los tipos de mascota
select t.idTipoMascota, t.Nombre_TipoMascota
from TIPO_MASCOTA t;

-- mostrar el tipo de mascota segun id
select t.idTipoMascota, t.Nombre_TipoMascota
from TIPO_MASCOTA t
where t.idTipoMascota=2;

-- mostrar nombre del tipo de mascotas para combox
select t.idTipoMascota, t.Nombre_TipoMascota
from TIPO_MASCOTA t
order by 1;

-- mostrar el id del tipo de mascota
select t.idTipoMascota from TIPO_MASCOTA t where t.Nombre_TipoMascota='Gato';


-- tabla de los dueños de las mascotas
create table PROPIETARIO(
DNI varchar(8) not null primary key,
Nombres varchar(40),
Apellidos varchar(40),
Direccion varchar(40),
Telefono varchar(9),
Correo varchar(40)
);

-- insertando en la tabla PROPIETARIO
insert into PROPIETARIO values
('72724534','Fabian Israel','Urcia Mendives','Callao','967637050','fabian.israel.07@gmail.com'),
('77093218','Mixie Brighit','Bocanegra Chero','Independencia','977386709','mixie.brighit01@gmail.com'),
('42027952','Miluska Mercedes','Mendives Vilchez','Callao','947826248','miluskamercedezv@gmail.com'),
('25566430','Julio Cesar','Urcia Vilchez','Callao','960551530','julio23.a56@gmail.com');

-- mostrar datos de PROPIETARIO por DNI
select * from PROPIETARIO p where p.DNI='77093218';

-- recuperar nombre PROPIETARIO por DNI
select p.Nombres,p.Apellidos from PROPIETARIO p where p.DNI='72724534';

delete from PROPPIETARIO WHERE DNI=null; 

-- creando la tabla MASCOTA
create table MASCOTA(
idMascota varchar(8) not null primary key,
Nombre_mascota varchar(40),
Sexo_mascota varchar(1) not null,
TipoMascota int not null references TIPO_MASCOTA(idTipoMascota), -- referencia a la tabla TIPO_MASCOTA
Edad_mascota int(2),
Peso_mascota double,
DNI varchar(8) not null references PROPIETARIO(DNI) -- referencia a la tabla propietario
);

delimiter $
create trigger GenerarCodigo_mascota before insert on MASCOTA for each row
begin
	declare siguiente_codigo int;
	set siguiente_codigo=(select ifnull(max(convert(substring(IdMascota,7),signed integer)),0)from MASCOTA) +1;
	set new.IdMascota=concat('PET-',LPAD(siguiente_codigo,4,'0'));
end $

-- drop trigger GenerarCodigo_mascota
select * from MASCOTA;
insert into MASCOTA (Nombre_mascota,Sexo_mascota,TipoMascota,Edad_mascota,Peso_mascota,DNI) values
('Chester','M',1,2,25.3,'72724534');
select Nombre_TipoMascota from TIPO_MASCOTA where idTipoMascota=2;
select * from MASCOTA p where p.IdMascota='PET-0001';

-- traer datos de todas las mascotas relacionadas a un DNI
select m.IdMascota, m.Nombre_mascota, m.TipoMascota
from MASCOTA m
where m.DNI='72724534'
order by 1;

select m.IdMascota,p.Nombres,p.Apellidos,p.dni,m.Nombre_mascota,tm.Nombre_TipoMascota,
m.Sexo_mascota,p.direccion,p.telefono
from MASCOTA m
inner join propietario p on m.DNI=p.DNI 
inner join tipo_mascota tm on m.TipoMascota=tm.idTipoMascota
where m.IdMascota='PET-0001'


-- creando tabla SERVICIOS
create table SERVICIOS(
idServicios int auto_increment primary key,
NombreServicio varchar(40) not null,
TipoMascota int references TIPO_MASCOTA(idTipoMascota), -- referencia a la tabla TIPO_MASCOTA
precioServicio double not null
);

select * from TIPO_MASCOTA;
select * from SERVICIOS;

insert into SERVICIOS values
(1,'Baño y corte de pelo',1,34.50),
(2,'Desparacitacion',1,49.10),
(3,'Adiestramiento',1,40),
(4,'Operacion',1,120);
insert into SERVICIOS (NombreServicio,TipoMascota,precioServicio)
values('Desparacitacion',2,34.50);

select * from SERVICIOS p where p.idServicios=1;

-- recuperar un combo servicios
select s.NombreServicio,s.idServicios
from SERVICIOS s
where TipoMascota=1
order by 1;
 -- recuperar Id Servicio
select s.idServicios from SERVICIOS s where s.NombreServicio='Adiestramiento';
 -- recuperar nombre del servicio
select NombreServicio from SERVICIOS where idServicios=1;
 -- recuperar precio del servicio
select precioServicio from SERVICIOS where idServicios=2;
 
 -- recuperar id del tipo de mascota
select s.idServicios from SERVICIOS s where s.NombreServicio='Desparacitacion' and s.TipoMascota=2;
 
 
 -- creando tabla VETERINARIO
 create table VETERINARIO(
 idVeterinario varchar(8) not null primary key,
 NombresVeterinario varchar(40),
 ApellidosVeterinario varchar(40),
 Sueldo double,
 estado int, -- activo(1) inactivo (0)
 idTipoMascota int references TIPO_MASCOTA(idTipoMascota), -- referencia tabla TIPO_MASCOTA
 idServicios int references SERVICIOS(idServicios) -- referencia tabla SERVICIOS
);

delimiter $
create trigger GenerarCodigo_veterinario before insert on VETERINARIO for each row
begin
	declare siguiente_codigo int;
	set siguiente_codigo=(select ifnull(max(convert(substring(IdVeterinario,7),signed integer)),0)from VETERINARIO) +1;
	set new.IdVeterinario=concat('VET-',LPAD(siguiente_codigo,4,'0'));
end $

insert into VETERINARIO (NombresVeterinario,ApellidosVeterinario,Sueldo,estado,idTipoMascota,idServicios) values
('Alonso','Belaunde',1400.00,1,1,1);

select * from VETERINARIO where estado=1;

select v.idVeterinario,v.NombresVeterinario,v.ApellidosVeterinario,v.idTipoMascota,v.idServicios
from VETERINARIO v
where v.estado=1 and v.idServicios=1
order by 1;

select * from VETERINARIO where NombresVeterinario='Juani';
delete from VETERINARIO where idVeterinario='VET-0005';
-- creando tabla TURNO
create table TURNO(
idTurno int auto_increment primary key,
hora time,
estado int, -- inactivo (0) activo (1)
descripcion varchar(40)
);

insert into TURNO(hora,estado,descripcion) values
('08:00',1,'2 horas y 30 min'),
('11:00',1,'30 min');
select * from TURNO;

-- mostrar turnos en tabla
select t.idTurno,t.hora,t.descripcion
from TURNO t
where t.estado=1
order by 1;

-- mostrar turno disponible
select hora from TURNO where estado=1 and idTurno=2;


-- creando tabla ESTADO de CITAS
create table ESTADO_CITA(
idEstado int auto_increment primary key,
TipoEstado varchar(40)
);

insert into ESTADO_CITA(TipoEstado)  values
('Pendiente'),
('Terminado'),
('Cancelado');
select * from ESTADO_CITA;


-- creando tabla CITAS
create table CITA(
IdCita varchar(9) not null primary key,

DNI varchar(8) references PROPIETARIO(DNI),
idMascota varchar(8) references MASCOTA(idMascota),

FechaCita date,
idTurno int references TURNO(idTurno),

idServicios int references SERVICIOS(idServicios),
idVeterinario varchar(8) references VETERINARIO(idVeterinario),
Precio double,
Descripcion varchar(500),

idEstado int references ESTADO_CITA(idEstado)
);

delimiter $
create trigger GenerarCodigo_citaVet before insert on CITA for each row
begin
	declare siguiente_codigo int;
	set siguiente_codigo=(select ifnull(max(convert(substring(IdCita,8),signed integer)),0)from CITA) +1;
	set new.IdCita=concat('CITA-',LPAD(siguiente_codigo,4,'0'));
end $

insert into CITA (DNI,idMascota,FechaCita,idTurno,idServicios,idVeterinario,Precio,Descripcion,idEstado) values
('77093218','PET-0002','2023-03-18',1,2,'VET-0001',200.00,'Requiere desparacitacion de la mascota',1);

select c.DNI,c.idMascota,c.FechaCita,c.idTurno,c.idServicios,c.idVeterinario,c.Precio,c.Descripcion
from CITA c
where c.idEstado=1 
order by 1;

select c.IdCita,c.FechaCita,t.hora,ec.TipoEstado
from CITA c
inner join turno t on c.idTurno=t.idTurno
inner join estado_cita ec on c.idEstado=ec.idEstado;

select * from CITA;
select * from MASCOTA;
select * from PROPIETARIO;
select * from SERVICIOS;
select * from VETERINARIO;
select * from TURNO;
select * from ESTADO_CITA;

select c.IdCita,p.Nombres,p.Apellidos,p.DNI,m.IdMascota,m.Nombre_mascota,s.NombreServicio,v.NombresVeterinario,c.FechaCita,t.hora,ec.TipoEstado
from CITA c
inner join propietario p on c.DNI=p.DNI
inner join mascota m on c.IdMascota=m.IdMascota
inner join servicios s on c.idServicios=s.idServicios
inner join veterinario v on c.idVeterinario=v.idVeterinario
inner join turno t on c.idTurno=t.idTurno
inner join estado_cita ec on c.idEstado=ec.idEstado
where c.idMascota='PET-0002';
where c.idEstado=1;

delete from CITA where IdCita='CITA-0029';

-- Datos ticket
select max(IdCita) as IdCita from CITA;

select c.FechaCita, t.hora
from CITA c
inner join TURNO t on c.idTurno=t.idTurno
where c.IdCita='CITA-0003';

-- Actualizar estado
update CITA set idEstado=1 where IdCita='CITA-0007';

-- Datos recibo
select c.IdCita, p.Nombres, p.Apellidos, p.DNI, m.idMascota, m.Nombre_mascota, 
s.NombreServicio, v.NombresVeterinario, v.ApellidosVeterinario, c.FechaCita, t.hora, c.Precio
from CITA c
inner join propietario p on c.DNI=p.DNI
inner join mascota m on c.IdMascota=m.IdMascota
inner join servicios s on c.idServicios=s.idServicios
inner join veterinario v on c.idVeterinario=v.idVeterinario
inner join TURNO t on c.idTurno=t.idTurno
where c.IdCita='CITA-0013';

-- Actualizar cita 
update CITA c set c.FechaCita='2023-03-26', c.idTurno=2 where c.IdCita='CITA-0003';