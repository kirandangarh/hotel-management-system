-- Database for Hotel Management System
CREATE DATABASE IF NOT EXISTS hotelmanagementsystem;
USE hotelmanagementsystem;

-- Login table
CREATE TABLE login (
    username VARCHAR(25),
    password VARCHAR(25)
);

INSERT INTO login VALUES ('admin', '12345');

-- Employee table
CREATE TABLE employee (
    name VARCHAR(25),
    age VARCHAR(15),
    gender VARCHAR(15),
    job VARCHAR(30),
    salary VARCHAR(30),
    phone VARCHAR(15),
    email VARCHAR(40),
    aadhar VARCHAR(20)
);

-- Room table
CREATE TABLE room (
    roomnumber VARCHAR(10),
    availability VARCHAR(20),
    cleaning_status VARCHAR(20),
    price VARCHAR(20),
    bed_type VARCHAR(20)
);

-- Driver table
CREATE TABLE driver (
    name VARCHAR(10),
    age VARCHAR(20),
    gender VARCHAR(20),
    company VARCHAR(20),
    model VARCHAR(50),
    available VARCHAR(20),
    location VARCHAR(100)
);

-- Customer table
CREATE TABLE customer (
    id VARCHAR(10),
    num VARCHAR(30),
    name VARCHAR(30),
    gender VARCHAR(20),
    country VARCHAR(20),
    room VARCHAR(50),
    CheckInTime VARCHAR(40),
    deposit VARCHAR(100)
);

-- Department table
CREATE TABLE department (
    name VARCHAR(50),
    budget VARCHAR(20)
);

-- Insert sample department data
INSERT INTO department VALUES ('Front office', '500000');
INSERT INTO department VALUES ('HouseKeeping', '40000');
INSERT INTO department VALUES ('Food and Beverages', '23000');
INSERT INTO department VALUES ('Kitchen and Food Production', '54000');
INSERT INTO department VALUES ('Security', '32000');
