create table inventory (
	id int not null,
	name varchar(255) not null,
	par_qty int not null,
	on_hand_qty int not null,
	constraint inventory_pk primary key (id)
);