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