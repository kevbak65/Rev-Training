
-- Delete Tables
DROP TABLE IF EXISTS Customer_tbl CASCADE;
DROP TABLE IF EXISTS Employee_tbl CASCADE;
DROP TABLE IF EXISTS Account_tbl CASCADE;
DROP TABLE IF EXISTS Acct_Type_tbl CASCADE;
DROP TABLE IF EXISTS Acct_Bal_tbl CASCADE;
DROP TABLE IF EXISTS User_tbl CASCADE;
DROP TABLE IF EXISTS Permissions_tbl CASCADE;
DROP TABLE IF EXISTS User_Access_tbl CASCADE;
DROP TABLE IF EXISTS Trxn_tbl CASCADE;
DROP TABLE IF EXISTS Trxn_Type_tbl CASCADE;
DROP TABLE IF EXISTS Approval_tbl CASCADE;
DROP TABLE IF EXISTS new_acct_req_tbl CASCADE;

-- CREATE CUSTOMER TABLE
CREATE TABLE Customer_tbl (
	id SERIAL PRIMARY KEY,
	--acct_num UNIQUE VARCHAR(10) NOT NULL,
	user_id int NOT NULL,
	cust_ssn VARCHAR(11) NOT NULL,
	cust_lname VARCHAR(25) NOT NULL,
	cust_fname VARCHAR(25) NOT NULL,
	cust_address VARCHAR(50),
	cust_city VARCHAR(50),
	cust_state VARCHAR(2),
	cust_zip VARCHAR(10),
	cust_DOB VARCHAR(10) NOT NULL,
	cust_phonenum VARCHAR(12) NOT NULL,
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES User_tbl(user_id)
);

-- CREATE NEW ACCOUNT REQUEST TABLE
CREATE TABLE New_Acct_Req_tbl (
	app_id SERIAL PRIMARY KEY,
	user_id int NOT NULL,
	cust_ssn VARCHAR(11) NOT NULL,
	cust_lname VARCHAR(25) NOT NULL,
	cust_fname VARCHAR(25) NOT NULL,
	cust_address VARCHAR(50),
	cust_city VARCHAR(50),
	cust_state VARCHAR(2),
	cust_zip VARCHAR(10),
	cust_DOB VARCHAR(10) NOT NULL,
	cust_phonenum VARCHAR(12) NOT NULL,
	acct_approve_code CHARACTER(1) DEFAULT 'S'
);

-- CREATE EMPLOYEE TABLE
CREATE TABLE Employee_tbl (
	emp_id SERIAL PRIMARY KEY,
	user_id int NOT NULL,
	emp_lname VARCHAR(25) NOT NULL,
	emp_fname VARCHAR(25) NOT NULL,
	approval_code int NOT NULL,
	approval_date VARCHAR(10) NOT NULL,
	CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES User_tbl(user_id)
);

-- CREATE ACCOUNT TABLE
CREATE TABLE Account_tbl (
	id SERIAL PRIMARY KEY,
	acct_num VARCHAR(12) NOT NULL,
	acct_type CHARACTER(1) DEFAULT 'C',
	acct_desc VARCHAR(15) NOT NULL,
	acct_balance MONEY,
	init_date DATE DEFAULT NOW(), 
	cust_id INTEGER NOT NULL,
	CONSTRAINT fk_custumer FOREIGN KEY(cust_id) REFERENCES Customer_tbl(id)
);

-- CREATE ACCOUNT TYPE TABLE
CREATE TABLE Acct_Type_tbl (
	id SERIAL PRIMARY KEY,
	acct_code CHARACTER(1) NOT NULL,
	acct_desc VARCHAR(10) NOT NULL
);

-- CREATE NEW ACCOUNT STATUS TABLE
CREATE TABLE New_Acct_Status_tbl (
	id SERIAL PRIMARY KEY,
	app_id INTEGER NOT NULL,
	reject BOOLEAN,
	approve BOOLEAN,
	r_reason TEXT
);

-- CREATE ACCOUNT BALANCE TABLE
CREATE TABLE Acct_Bal_tbl (
	id SERIAL PRIMARY KEY,
	acct_num VARCHAR(12) NOT NULL,
	acct_balance MONEY DEFAULT 0,
	acct_type CHARACTER(1) NOT NULL
);

-- CREATE USER TABLE
CREATE TABLE User_tbl (
	user_id SERIAL PRIMARY KEY,
	access_code VARCHAR(5) NOT NULL,
	username VARCHAR(50) NOT NULL,
	user_password VARCHAR(15) NOT NULL
);

-- CREATE USER ACCESS TABLE
CREATE TABLE User_Access_tbl (
	id SERIAL PRIMARY KEY,
	access_level SMALLINT NOT NULL,
	access_type VARCHAR(2) NOT NULL,
	access_desc VARCHAR(50) NOT NULL
);

-- CREATE TRANSACTION TABLE
CREATE TABLE Trxn_tbl (
	id SERIAL PRIMARY KEY,
	trxn_code CHARACTER(1) NOT NULL,
	trxn_desc TEXT NOT NULL,
	acct_num VARCHAR(12) NOT NULL,
	trxn_amt MONEY NOT NULL
);

-- CREATE TRANSACTION TYPE TABLE
CREATE TABLE Trxn_Type_tbl (
	id SERIAL PRIMARY KEY,
	trxn_code CHARACTER(1) NOT NULL,
	trxn_type_desc VARCHAR(50) NOT NULL
);

-- CREATE APPROVAL  TABLE
CREATE TABLE Approval_tbl (
	id SERIAL PRIMARY KEY,
	approval_code CHARACTER(1) NOT NULL,
	approval_desc VARCHAR(12)
);

INSERT INTO User_Access_tbl (access_level, access_type, access_desc)
VALUES
('0', 'RO','Read Only'),
('1', 'UD', 'Update'),
('2', 'DE', 'Delete');

INSERT INTO player (player_name, player_position, gender, age, phone_number, team_id)
VALUES
('Joe', 'PG', 'Male', 24, '111-111-1111', 1),
('Bob', 'SG', 'Male', 22, '222-222-2222', 1),
('Mary', 'PF', 'Female', 26, '333-333-3333', 1),
('Jimmy', 'SF', 'Male', 27, '444-444-4444', 1),
('Tommy', 'C', 'Male', 25, '555-555-5555', 1),
('Sarah', 'PG', 'Female', 21, '666-666-6666', 1);


SELECT * FROM user_access_tbl uat 

SELECT a.curr_acct_bal, t.transfer_to_amount FROM account_tbl at INNER JOIN transfer_tbl tt ON a.acct_num = t.transfer_to_amount; 