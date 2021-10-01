CREATE TABLE inventory.product (
	id serial NOT NULL,
	USER_ID VARCHAR ( 250 ) NOT null,
	barcode varchar(250) NOT NULL,
	name varchar(250) NOT NULL,
	description varchar(250) NOT NULL,
	quantity int4 NOT NULL,
	sale_price int4 NOT NULL,
	purchase_price int4 NOT NULL,
	category_id varchar(50) NOT NULL,
	supplier_id varchar(50) NOT NULL,
	date_added timestamp NOT NULL,
	last_update timestamp NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);