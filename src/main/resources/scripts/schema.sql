DROP TABLE IF EXISTS orders_products;

DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS customers;

DROP TABLE IF EXISTS products;

CREATE TABLE customers
(
  id serial NOT NULL,
  name character varying(255),
  phone character varying(15),
  email character varying(255),
  birthday date,
  CONSTRAINT customers_id_pk PRIMARY KEY (id)
);

CREATE TABLE products
(
  id serial NOT NULL,
  name character varying(255),
  weight numeric,
  price numeric,
  CONSTRAINT product_id_pk PRIMARY KEY (id)
);

CREATE TABLE orders
(
  id serial NOT NULL,
  number character varying(255),
  placed timestamp,
  customer_id integer,
  CONSTRAINT order_id_pk PRIMARY KEY (id),
  FOREIGN KEY(customer_id) REFERENCES customers 
);

CREATE TABLE orders_products
(
  id serial NOT NULL,
  order_id integer,
  product_id integer,
  quantity numeric,
  CONSTRAINT order_product_id_pk PRIMARY KEY (id),
  foreign key (order_id) references orders,
  foreign key (product_id) references products
);

