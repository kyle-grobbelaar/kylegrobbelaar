DROP TABLE IF EXISTS Persons;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Withdraws;

CREATE TABLE IF NOT EXISTS Persons(
      ID BIGSERIAL PRIMARY KEY,
      NAME VARCHAR(255) NOT NULL,
      EMAIL VARCHAR(100) NOT NULL,
      CONTACT VARCHAR(20),
      AGE INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Products(
   ID BIGSERIAL PRIMARY KEY,
   TYPE VARCHAR(255) CHECK (TYPE IN ('SAVINGS', 'RETIREMENT')),
   NAME VARCHAR(255) NOT NULL,
   CURRENT_BALANCE BIGINT NOT NULL,
   EMAIL VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Withdraws(
    ID BIGSERIAL PRIMARY KEY,
    MESSAGE VARCHAR(255) NOT NULL,
    PRODUCT_ID BIGINT NOT NULL,
    TYPE VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    NEW_BALANCE BIGINT NOT NULL,
    DATE_CREATED TIMESTAMP NOT NULL
);

INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('kyle', 'kyle@mail.com', '+27619302756', 21);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('john', 'john@mail.com', '+27812345678', 32);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('doe', 'doe@mail.com', '+27616541234', 25);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('bremmly', 'bremmly@mail.com', '+27747893045', 68);

INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'SAVINGS', 'kyle', 5600, 'kyle@mail.com' );
INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'RETIREMENT', 'john', 21000, 'john@mail.com' );
INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'SAVINGS', 'john', 1500, 'john@mail.com' );
INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'SAVINGS', 'doe', 32500, 'doe@mail.com' );
INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'SAVINGS', 'bremmly', 57800, 'bremmly@mail.com' );
INSERT INTO Products( TYPE, NAME, CURRENT_BALANCE, EMAIL )
    VALUES ( 'RETIREMENT', 'bremmly', 21000, 'bremmly@mail.com' );