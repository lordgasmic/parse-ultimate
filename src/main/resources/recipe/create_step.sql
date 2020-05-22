create table step (
	recipe_id int not null,
	sequence int not null,
	text varchar(255) not null,
	constraint step_pk primary key (recipe_id, sequence)
);