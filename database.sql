create database intuit_challenge

create table persona(
	id serial,
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	fecha_nacimiento date not null,
	cuit varchar(50) not null,
	direccion varchar(50) not null,
	telefono varchar(50) not null,
	email varchar(50) not null)

insert into persona(nombres,apellidos,fecha_nacimiento,cuit,direccion,telefono,email) Values
('Nicolás','Cardozo','1992-02-19','20364920300','Avellaneda 1022 4B','1153289129','ncardozo19@gmail.com'),
('Lucila','Cardozo','1997-10-15','27404920301','Roque Simone 3965 PA','1153289130','lcardozo@gmail.com'),
('Silvia','Casciano','1965-02-27','27174920301','Roque Simone 3965 PA','1153289130','scasciano@gmail.com')