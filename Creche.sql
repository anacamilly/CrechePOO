create database creche;
use creche;

create table crianca(
	id int auto_increment not null unique primary key,
	nome varchar (255),
    cpf varchar (11) not null unique,
    sexo enum('f','m') not null,
    nascimento varchar(50) not null,
	matricula varchar(255) not null unique
);

create table cuidador(
	id int auto_increment not null unique primary key,
    nome varchar(255),
	cpf varchar (11) not null unique,
    sexo enum('f','m') not null,
    nascimento varchar(50) not null,
    salario float,
    telefone varchar(20)
);


create table turma(
	codigo int primary key,
    nome varchar(50),
    quantidadeAlunos int
);

create table responsavel(
	id int auto_increment not null unique,
	nome varchar(255),
	cpf varchar (11) not null unique,
    sexo enum('f','m') not null,
    nascimento varchar(50) not null,
    telefone varchar(20)
);

create table extracurricular(
	codigo int primary key,
    nome varchar(50),
    modalidade varchar(50),
    codigoturma int,
	foreign key (codigoturma) references turma (codigo)
);