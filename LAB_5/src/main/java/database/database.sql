CREATE DATABASE studentsdb;

USE studentsdb;

CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          last_name VARCHAR(50) NOT NULL,
                          first_name VARCHAR(50) NOT NULL,
                          middle_name VARCHAR(50) NOT NULL,
                          birth_date DATE NOT NULL,
                          student_id VARCHAR(20) NOT NULL
);