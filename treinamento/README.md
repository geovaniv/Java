Olá,

O projeto foi desenvolvido usando Eclipse IDE e servidor Tomcat 9.0, e não utiliza outras bibliotecas externas.
Será necessário criar um banco de dados MySQL nomeado "training", contendo as tableas "people, "room" e "coffee".

Segue script de criação:

create database training;
show databases;
use training;
create table people(
	peopleId int primary key auto_increment,
    peopleFirstName varchar(50) not null,
    peopleLastName varchar(50) not null,
    idFirstRoom int,
    idLastRoom int,
    idFirstCoffee int,
    idLastCoffee int
);
create table room(
	roomId int primary key auto_increment,
    roomName varchar(50) not null,
    roomCapacity int not null
);
create table coffee(
	coffeeId int primary key auto_increment,
    coffeeName varchar(50) not null
);
show tables;
describe person;
describe room;
describe coffee;

A aplicação deverá ser importada e executava através da IDE Eclipse.

Sua interface é intuitiva. Para adicionar novas pessoas, salas ou espaços de café, acesse Cadastro>Pessoas/Salas de Evento/Espaços de Café.
Para informações sobre os cadastros, na tela de Cadastro, selecione a opção desejada e uma tabela com todas as informações cadastradas será exibida. Clique no botão info para exibir mais informações daquele cadastro.

No momento o projeto não está completo, estando implantadas apenas as funções de adição, edição, exclusão e listagem.
