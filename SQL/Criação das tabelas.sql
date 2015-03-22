-- Cria a tabela cargo e a inicializa com alguns valores
create table cargo(id int not null primary key generated always as identity(start with 1, increment by 1), nome varchar(20));

INSERT INTO cargo(NOME) VALUES('Gerente');
INSERT INTO cargo(NOME) VALUES('Secretario');
INSERT INTO cargo(NOME) VALUES('Atendente');
INSERT INTO cargo(NOME) VALUES('Limpeza');

-- Cria a tabela departamento e a inicializa com alguns valores
CREATE TABLE departamento(id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1), nome varchar(20));

INSERT INTO departamento(nome) VALUES('Gerência');
INSERT INTO departamento(nome) VALUES('Almoxarifado');
INSERT INTO departamento(nome) VALUES('Secretaria');
INSERT INTO departamento(nome) VALUES('RH');
INSERT INTO departamento(nome) VALUES('Recepção');

-- Cria a tabela funcionario e a inicializa com alguns valores
CREATE TABLE funcionario (id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),nome VARCHAR(20),rg VARCHAR(10),id_cargo INT, id_departamento INT);
ALTER TABLE funcionario ADD FOREIGN KEY(id_cargo) REFERENCES cargo(id);
ALTER TABLE funcionario ADD FOREIGN KEY(id_departamento) REFERENCES departamento(id);

INSERT INTO FUNCIONARIO(nome,rg,id_cargo,id_departamento) VALUES ('Cacique','MG123456',1,1);
INSERT INTO FUNCIONARIO(nome,rg,id_cargo,id_departamento) VALUES ('José','6543123',2,3);
INSERT INTO FUNCIONARIO(nome,rg,id_cargo,id_departamento) VALUES ('Maria','8372643',3,5);
INSERT INTO FUNCIONARIO(nome,rg,id_cargo,id_departamento) VALUES ('Sarah','6567567',3,5);
INSERT INTO FUNCIONARIO(nome,rg,id_cargo,id_departamento) VALUES ('Otávio','123',4,2);
-- Cria a tabela Ator e a inicializa com alguns valores
create table ator(id int not null primary key generated always as identity(start with 1, increment by 1), nome varchar(20), nacionalidade varchar(20), nascimento DATE);

INSERT INTO ator(NOME,NACIONALIDADE,NASCIMENTO) VALUES('Antonio','brasileiro','1995-07-19');
INSERT INTO ator(NOME,NACIONALIDADE,NASCIMENTO) VALUES('Gilson','americano','1992-10-22');
INSERT INTO ator(NOME,NACIONALIDADE,NASCIMENTO) VALUES('André','alemão','1996-12-15');

-- Cria a tabela cliente e a inicializa com alguns valores
create table cliente(id int not null primary key generated always as identity(start with 1, increment by 1), nome varchar(20), nascimento DATE, tipo varchar(15));

INSERT INTO cliente(NOME,NASCIMENTO,TIPO) VALUES('Antonio','1995-07-19','CADEIRANTE');
INSERT INTO cliente(NOME,NASCIMENTO,TIPO) VALUES('Gilson','1992-10-22','GERAL');
INSERT INTO cliente(NOME,NASCIMENTO,TIPO) VALUES('André','1996-12-15','OBESO');
-- Cria a tabela Diretor e a inicializa com alguns valores
create table diretor(id int not null primary key generated always as identity(start with 1, increment by 1), nome varchar(20));

INSERT INTO diretor(NOME) VALUES('Antonio');

-- Cria a tabela Distribuidora e a inicializa com alguns valores
create table distribuidora(id int not null primary key generated always as identity(start with 1, increment by 1), nome varchar(20));

INSERT INTO distribuidora(NOME) VALUES('Apple');
-- Cria a tabela Lista de Atores e a inicializa com alguns valores

create table listadeatores(id int not null primary key generated always as identity (start with 1 , increment by 1), id_filme int, id_ator int);
insert into listadeatores(id_filme,id_ator) values (1,1);


-- Cria a tabela Filme e a inicializa com alguns valores
create table filme(id int not null primary key generated always as identity(start with 1, increment by 1), titulo varchar(20),idioma varchar(20),situacao varchar(20), id_listadeatores int, id_distribuidora int, id_diretor int, classificacao int, ano int , duracao int);

alter table filme add foreign key(id_listadeatores) references listadeatores(id);

alter table filme add foreign key(id_distribuidora) references distribuidora(id);

alter table filme add foreign key(id_diretor) references diretor(id);

INSERT INTO filme(TITULO,idioma,situacao,id_listadeatores,id_distribuidora,id_diretor,classificacao,ano,duracao) VALUES('Piratas','ingles','lancamento',1,1,1,18,2015,130);

-- Cria a tabela Genero e a inicializa com alguns valores 

create table genero(id int not null primary key generated always as identity (start with 1 , increment by 1),nome varchar(20));

INSERT INTO genero(nome) values ('Suspense');
INSERT INTO genero(nome) values ('Acao');
INSERT INTO genero(nome) values ('Comedia');
INSERT INTO genero(nome) values ('Romance');

-- Cria a tabela InfoAtor e a inicializa com alguns valores 

create table infoator(id int not null primary key generated always as identity (start with 1, increment by 1),papel varchar(20),part varchar(20),id_ator int);

alter table infoator add foreign key(id_ator) references ator(id);

INSERT INTO infoator(papel,part,id_ator) values ('John coveiro','coadjuvante',1);

-- Cria a tabela Ingresso e a inicializa com alguns valores

create table ingresso(id int not null primary key generated always as identity(start with 1, increment by 1), numero int, inteira boolean, tipo varchar(20));
-- numero do ingresso automatico , ou numero da cadeira ? seria string por envolver letra.
insert into ingresso(numero,inteira,tipo) values (1,true,'geral');


--Cria a tabela sala de projecao e a inicializa com alguns valores .

create table saladeprojecao(id int not null primary key generated always as identity (start with 1, increment by 1),num int , lotacao int , postesp int , estados varchar(20));

insert into saladeprojecao(num,lotacao,postesp,estados) values (2,100,10,'livre');

-- Cria a tabela lista ingresso e a inicializa com alguns valores.

create table listaingresso(id int not null primary key generated always as identity (start with 1 , increment by 1) , id_ingresso int);

alter table listaingresso add foreign key (id_ingresso) references ingresso(id);

insert into listaingresso(id_ingresso) values (1);

-- Cria a tabela Sessão e a inicializa com alguns valores

 create table sessao(id int not null primary key generated always as identity (start with 1, increment by 1), id_saladeprojecao int , id_filme int,  diahora  date ,  legenda boolean , id_listaingresso int );

insert into sessao(id_saladeprojecao,id_filme,diahora,legenda,id_listaingresso) values (1,1,'2015-03-22',true,1);

-- Inserção de valores na tabela litadeatores , devido a convergência de dados.

alter table listadeatores add foreign key (id_ator) references ator(id);

