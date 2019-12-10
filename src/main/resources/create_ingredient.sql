create table ingredient (
	recipe_id int not null,
	inventory_id int not null,
	sequence int not null,
	adjective varchar(255),
	quantity int not null,
	partial_quantity varchar(255) not null,
	uom varchar(255) not null,
	constraint ingredient_pk primary key (recipe_id, inventory_id)
);