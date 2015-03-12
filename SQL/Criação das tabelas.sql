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