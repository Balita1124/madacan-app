DROP TABLE applicants IF EXISTS;

CREATE TABLE applicants (
  id          INTEGER IDENTITY PRIMARY KEY,
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  birthdate DATE
);
