-- Lenguaje de Definición de Datos (DDL)

drop schema prueba;
create database prueba;
use prueba;

create table Asegurados(
	id int not null auto_increment,
    tipo_identificacion int not null,
	numero_identificacion int not null,
	apellidos varchar(50) not null,
	nombres varchar(50) not null,
	sexo int not null,
	fecha_nacimiento date not null,
    lista_amparos varchar(255),
    primary key(id)
);

create table Amparos(
	codigo int not null auto_increment,
    nombre varchar(50) not null,
    primary key(codigo)
);

create table Primas(
	id int not null auto_increment,
    codigo_amparo int not null,
    edad_minima int not null,
    edad_maxima int not null,
    porcentaje_prima float not null,
    foreign key (codigo_amparo) references Amparos(codigo),
    primary key(id)
);