insert into Pessoa(id, nome, cpf, idade) values (nextval('hibernate_sequence'), 'Fredson', '111', 37);
insert into Pessoa(id, nome, cpf, idade) values (nextval('hibernate_sequence'), 'Silvano', '222', 40);
insert into Pessoa(id, nome, cpf, idade) values (nextval('hibernate_sequence'), 'Marco', '333', 41);


insert into Estado(nome, data_cadastro, sigla) values ('Tocantins', '08-25-2022', 'TO');
insert into Estado(nome, data_cadastro, sigla) values ('Goiás', '08-25-2022', 'GO');
insert into Estado(nome, data_cadastro, sigla) values ('Maranhão', '08-25-2022', 'MA');
insert into Estado(nome, data_cadastro, sigla) values ('Pará', '08-25-2022', 'PA');
insert into Estado(nome, data_cadastro, sigla) values ('Rio de Janeiro', '08-25-2022', 'RJ');
insert into Estado(nome, data_cadastro, sigla) values ('São Paulo', '08-25-2022', 'SP');


insert into Cidade(nome, data_cadastro, id_estado) values ('Palmas', '08-25-2022', 1);
insert into Cidade(nome, data_cadastro, id_estado) values ('Gurupi', '08-25-2022', 1);

insert into Usuario(nome, login, senha, nomeImagem, data_cadastro, id_cidade) values ('Jon Snow', 'jon@gmail.com', 'AceO9r1pjFITo2FgWL4z1xynZ20NbQRVLKL7ztuXU1zH7nrZXlvkmFXIOJBB1c7eXpo6ALvWMJv1APx2QtzdkA==', '1e4dbf1d-ec16-469f-9841-c846c2bdba0e.png', '10-18-2022', 1);
insert into Usuario(nome, login, senha, data_cadastro, id_cidade) values ('Vegeta', 'vegeta@gmail.com', 'AceO9r1pjFITo2FgWL4z1xynZ20NbQRVLKL7ztuXU1zH7nrZXlvkmFXIOJBB1c7eXpo6ALvWMJv1APx2QtzdkA==', '10-18-2022', 1);

insert into Roles(id_usuario, role) values (1, 'Admin');
insert into Roles(id_usuario, role) values (1, 'User');

insert into Roles(id_usuario, role) values (2, 'User');