CREATE DATABASE IF NOT EXISTS petclinic;
GRANT ALL PRIVILEGES ON petclinic.* TO pc@localhost IDENTIFIED BY 'pc';

USE petclinic;

CREATE TABLE IF NOT EXISTS applicants (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  birthdate DATE
) engine=InnoDB;
