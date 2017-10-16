-- tables
-- Table: customer
CREATE TABLE customer (
    customer_id integer(10) NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

-- Table: customer_products
CREATE TABLE customer_products (
    customer_id integer(10) NOT NULL,
    product_id integer(10) NOT NULL,
    CONSTRAINT customer_products_pk PRIMARY KEY (customer_id,product_id)
);

-- Table: order
CREATE TABLE `order` (
    order_id integer(10) NOT NULL AUTO_INCREMENT,
    customer_id integer(10) NULL,
    delivery_address integer(10) NULL,
    creation_date Date NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (order_id)
);

-- Table: order_detail
CREATE TABLE order_detail (
    order_detail_id integer(10) NOT NULL AUTO_INCREMENT,
    product_description varchar(255) NOT NULL,
    price integer(10) NOT NULL,
    order_id integer(10) NOT NULL,
    CONSTRAINT order_detail_pk PRIMARY KEY (order_detail_id)
);

-- Table: product
CREATE TABLE product (
    product_id integer(10) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    price integer(10) NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- foreign keys
-- Reference: customer_products_customer (table: customer_products)
ALTER TABLE customer_products ADD CONSTRAINT customer_products_customer FOREIGN KEY customer_products_customer (customer_id)
    REFERENCES customer (customer_id);

-- Reference: customer_products_product (table: customer_products)
ALTER TABLE customer_products ADD CONSTRAINT customer_products_product FOREIGN KEY customer_products_product (product_id)
    REFERENCES product (product_id);

-- Reference: order_customer (table: order)
ALTER TABLE `order` ADD CONSTRAINT order_customer FOREIGN KEY order_customer (customer_id)
    REFERENCES customer (customer_id);

-- Reference: order_detail_order (table: order_detail)
ALTER TABLE order_detail ADD CONSTRAINT order_detail_order FOREIGN KEY order_detail_order (order_id)
    REFERENCES `order` (order_id);

-- Data
-- Table: customer
INSERT INTO customer (customer_id, name, email) VALUES (123, "Carlos Lopez", "carlos@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (456, "Sebastian Amaya", "sebastian@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (789, "Camila Munevar", "camila@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (987, "Juan Perez", "juan@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (654, "Karen Parra", "karen@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (321, "Alberto Rojas", "alberto@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (101, "Rosa Porras", "rosa@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (202, "Dayana Gomez", "dayana@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (303, "Alejandra Blanco", "alejandra@mail.com");
INSERT INTO customer (customer_id, name, email) VALUES (404, "Carolina Martinez", "carolina@mail.com");

-- Table: product
INSERT INTO product (product_id, name, price) VALUES (1, "Audifonos", 34500);
INSERT INTO product (product_id, name, price) VALUES (2, "Celular", 400000);
INSERT INTO product (product_id, name, price) VALUES (3, "Tablet", 200000);
INSERT INTO product (product_id, name, price) VALUES (4, "Computador", 1000000);
INSERT INTO product (product_id, name, price) VALUES (5, "Portatil", 800000);
INSERT INTO product (product_id, name, price) VALUES (6, "Cable HDMI", 24500);
INSERT INTO product (product_id, name, price) VALUES (7, "Parlantes", 50500);
INSERT INTO product (product_id, name, price) VALUES (8, "Teclado", 45000);
INSERT INTO product (product_id, name, price) VALUES (9, "Pantalla", 150000);
INSERT INTO product (product_id, name, price) VALUES (10, "Impresora", 450000);
INSERT INTO product (product_id, name, price) VALUES (11, "Mouse", 80000);
INSERT INTO product (product_id, name, price) VALUES (12, "USB", 20000);
INSERT INTO product (product_id, name, price) VALUES (13, "Bateria", 50000);
INSERT INTO product (product_id, name, price) VALUES (14, "Cargador", 30000);
INSERT INTO product (product_id, name, price) VALUES (15, "Camara", 60000);

-- Table: customer_products
INSERT INTO customer_products (customer_id, product_id) VALUES (123,1);
INSERT INTO customer_products (customer_id, product_id) VALUES (123,3);
INSERT INTO customer_products (customer_id, product_id) VALUES (123,5);
INSERT INTO customer_products (customer_id, product_id) VALUES (123,7);
INSERT INTO customer_products (customer_id, product_id) VALUES (123,9);
INSERT INTO customer_products (customer_id, product_id) VALUES (123,11);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,4);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,6);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,8);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,10);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,12);
INSERT INTO customer_products (customer_id, product_id) VALUES (456,14);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,3);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,5);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,4);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,6);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,9);
INSERT INTO customer_products (customer_id, product_id) VALUES (789,15);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,15);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,13);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,14);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,11);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,12);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,3);
INSERT INTO customer_products (customer_id, product_id) VALUES (987,4);;
INSERT INTO customer_products (customer_id, product_id) VALUES (654,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (654,1);
INSERT INTO customer_products (customer_id, product_id) VALUES (654,4);
INSERT INTO customer_products (customer_id, product_id) VALUES (654,5);
INSERT INTO customer_products (customer_id, product_id) VALUES (654,7);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,8);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,9);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,11);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,10);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,13);
INSERT INTO customer_products (customer_id, product_id) VALUES (321,14);
INSERT INTO customer_products (customer_id, product_id) VALUES (101,13);
INSERT INTO customer_products (customer_id, product_id) VALUES (101,12);
INSERT INTO customer_products (customer_id, product_id) VALUES (101,1);
INSERT INTO customer_products (customer_id, product_id) VALUES (101,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (101,4);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,15);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,11);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,10);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,7);
INSERT INTO customer_products (customer_id, product_id) VALUES (202,6);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,6);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,5);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,8);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,7);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (303,1);
INSERT INTO customer_products (customer_id, product_id) VALUES (404,1);
INSERT INTO customer_products (customer_id, product_id) VALUES (404,2);
INSERT INTO customer_products (customer_id, product_id) VALUES (404,3);
INSERT INTO customer_products (customer_id, product_id) VALUES (404,4);
INSERT INTO customer_products (customer_id, product_id) VALUES (404,5);

-- End of file.

