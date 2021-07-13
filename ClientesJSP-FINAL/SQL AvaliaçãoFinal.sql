create database avaliacaofinal;

create table avaliacaofinal.clientes(
id int auto_increment primary key,
nome varchar(200) not null,
telefone varchar(20),
endereco varchar(200) not null
);

insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Luis Diogo','989870062', 'Rua General Osório');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Alan Michael','9440246588', 'Quadra QI 21 ');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Fernanda Viana','9467028182', 'Avenida Doutor Albino Imparato');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Felipe Caldeira','9221583144', 'Avenida Maria de Fátima Borges');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Vitor Costa','952355924', 'Rua Francisco Nogueira Ramos');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('João Guilherme Correia','9869292506', 'Avenida Padre Antônio José dos Santos');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Ana Lívia Moura','934743393', 'Rua Vereador Romero Barbosa');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Arthur Mendes','9291491786', 'Parque Bob Kennedy');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Enzo Gabriel Lima','98696439', 'Travessa Igarapé Maruanum');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Laura Correia','925401742', 'Rua Barbacena');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Kamilly Azevedo','911537778', 'Rua Luís Molico');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Heloísa Ribeiro','974778988', 'Quadra 1206 Sul Alameda 14');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Ryan Campos','957315877', 'Rua João Ramalho 40');
insert into avaliacaofinal.clientes (nome, telefone, endereco) values ('Renan Fogaça','948100378', 'Avenida Caicó');

select * from avaliacaofinal.clientes;

update avaliacaofinal.clientes set nome = 'Jeferson Cavalcante', telefone = '11985643459' where id = 28;