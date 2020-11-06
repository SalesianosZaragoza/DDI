create table IF NOT EXISTS OWNER(
    codOwner INT IDENTITY,
    name varchar(25),
    surname varchar(25),
    PRIMARY KEY (codOwner)
);

create table IF NOT EXISTS PET(
    petName varchar(25),
    codOwner INT,
    PRIMARY KEY (petName),
    FOREIGN KEY (codOwner) REFERENCES OWNER(codOwner)
);

create table IF NOT EXISTS ACTIVITY(
    name varchar(25),
    gauging integer
);