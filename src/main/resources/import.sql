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