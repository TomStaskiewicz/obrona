CREATE TABLE insurances(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    clientName VARCHAR (255) NOT NULL,
    insuranceName VARCHAR (255) NOT NULL,
    sumInsurance BIGINT,
    premium DOUBLE,
    premiumPaid BOOLEAN

);