create schema if not exists Trip;
Use Trip;

create table if not exists Trip
(
	TripID  bigint not null primary key auto_increment,
	Name varchar(255) not null unique,
  Notes varchar(255) not null
);