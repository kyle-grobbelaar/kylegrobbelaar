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
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('smithy', 'smithy1@mail.com', '+27747893046', 45);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('johnson', 'johnson2@mail.com', '+27747893047', 32);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('miller', 'miller3@mail.com', '+27747893048', 55);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('thompson', 'thompson4@mail.com', '+27747893049', 38);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('brown', 'brown5@mail.com', '+27747893050', 29);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('davis', 'davis6@mail.com', '+27747893051', 42);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('martinez', 'martinez7@mail.com', '+27747893052', 51);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('anderson', 'anderson8@mail.com', '+27747893053', 97);
INSERT INTO Persons( NAME, EMAIL, CONTACT, AGE) VALUES ('wilson', 'wilson9@mail.com', '+27747893054', 34);


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
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('SAVINGS', 'smithy', 1230, 'smithy1@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('RETIREMENT', 'johnson', 5600, 'johnson2@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('SAVINGS', 'miller', 970, 'miller3@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('RETIREMENT', 'thompson', 0, 'thompson4@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('SAVINGS', 'brown', 0, 'brown5@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('RETIREMENT', 'davis', 21, 'davis6@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('SAVINGS', 'martinez', 0, 'martinez7@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('RETIREMENT', 'anderson', 48, 'anderson8@mail.com');
INSERT INTO Products(TYPE, NAME, CURRENT_BALANCE, EMAIL)
VALUES ('SAVINGS', 'wilson', 0, 'wilson9@mail.com');

