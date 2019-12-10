create table id_generator (
	name varchar(255) not null,
	seed int not null,
	constraint id_generator_pk primary key (name)
);