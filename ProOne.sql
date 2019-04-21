REVOKE ALL ON BEAR FROM PUBLIC;
REVOKE ALL ON BEAR_BEEHIVE FROM PUBLIC;
REVOKE ALL ON BEAR_TYPE FROM PUBLIC;
REVOKE ALL ON BEEHIVE FROM PUBLIC;
REVOKE ALL ON CAVE FROM PUBLIC;

--TABLES

CREATE TABLE LOGIN(
    USERNAME VARCHAR2(100) NOT NULL,
    UPASSWORD VARCHAR2(100) NOT NULL,
    EMPLOYEE_ID NUMBER
);
/

CREATE TABLE EMPLOYEES(
    EMPLOYEE_ID NUMBER PRIMARY KEY,
    TITLE VARCHAR2(100) DEFAULT 'TEMP',
    FIRSTNAME VARCHAR2(100),
    LASTNAME VARCHAR2(100),
    EMAIL VARCHAR2(100) NOT NULL,
    PRO_PIC BLOB,
    REPORTSTO NUMBER
    );
/

CREATE TABLE REQUESTS(
    REQUEST_ID INTEGER PRIMARY KEY,
    EMPLOYEE_ID NUMBER,
    MANAGEDBY NUMBER,
    RQ_DATE DATE NOT NULL,
    RQ_TYPE VARCHAR2(100),
    RQ_IMG BLOB,
    RQ_AMT NUMBER(10,2), 
    REQUEST_STATUS VARCHAR2(100) DEFAULT 'RECIEVED'
);
/


--CONTRAINTS

ALTER TABLE EMPLOYEES
ADD CONSTRAINT FK_REPORTSTO 
FOREIGN KEY (REPORTSTO) REFERENCES EMPLOYEES(EMPLOYEE_ID) ON DELETE CASCADE;
/

ALTER TABLE REQUESTS
ADD CONSTRAINT FK_EMPLOYEE_ID 
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(EMPLOYEE_ID)ON DELETE CASCADE;
/

ALTER TABLE REQUESTS
ADD CONSTRAINT FK_MANAGEDBY 
FOREIGN KEY (MANAGEDBY) REFERENCES EMPLOYEES(EMPLOYEE_ID)ON DELETE CASCADE;
/

ALTER TABLE LOGIN
ADD CONSTRAINT FK_E_LOGIN
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(EMPLOYEE_ID)ON DELETE CASCADE;
/

ALTER TABLE LOGIN
ADD CONSTRAINT PK_UN_PW
PRIMARY KEY (USERNAME, UPASSWORD);
/

--SEQUENCES
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_REQUEST_ID_PK
START WITH 1
INCREMENT BY 1;



--TRIGGERS
DROP TABLE EMPLOYEES;

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW 
BEGIN 
    SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REQUEST
BEFORE INSERT ON REQUESTS
FOR EACH ROW 
BEGIN 
    SELECT SQ_REQUEST_ID_PK.NEXTVAL INTO :NEW.REQUEST_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_RQ_DATE
BEFORE UPDATE OR INSERT ON REQUESTS
FOR EACH ROW
BEGIN
 :NEW.RQ_DATE:= SYSDATE;
END;

INSERT ALL
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('BROKER', 'EMILY', 'BAILLIE', 'EBAILLIE27@YAHOO.COM')
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('REAL ESTATE ADVISOR', 'CHRIS', 'BAILLIE', 'CBAILLIE@YAHOO.COM')
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('TEMP', 'ISABELLA', 'BAILLIE', 'IBAILLIE@YAHOO.COM')
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('CEO', 'JACK', 'BAILLIE', 'JBAILLIE@YAHOO.COM')
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('TEMP', 'JAMES', 'BAILLIE', 'JHBAILLIE@YAHOO.COM')
    INTO EMPLOYEES (TITLE, FIRSTNAME, LASTNAME, EMAIL) VALUES ('CTO', 'JACK', 'BAILLIE', 'JBAILLIE@YAHOO.COM')
SELECT * FROM DUAL;

INSERT ALL
    INTO REQUESTS (EMPLOYEE_ID, MANAGEDBY, RQ_TYPE, RQ_AMT) VALUES (9,8,'CERTIFICATION', 500.00)
    INTO REQUESTS (EMPLOYEE_ID, MANAGEDBY, RQ_TYPE, RQ_AMT) VALUES (9,8,'SALES EXPENSE', 300.00)
    INTO REQUESTS (EMPLOYEE_ID, MANAGEDBY, RQ_TYPE, RQ_AMT) VALUES (10,11, 'SALES EXPENSE', 3.00)
SELECT * FROM DUAL;

UPDATE EMPLOYEES SET REPORTSTO = 8 WHERE EMPLOYEE_ID = 9;
UPDATE EMPLOYEES SET REPORTSTO = 8 WHERE EMPLOYEE_ID = 10;
UPDATE EMPLOYEES SET REPORTSTO = 10 WHERE EMPLOYEE_ID = 11;
UPDATE EMPLOYEES SET REPORTSTO = 9 WHERE EMPLOYEE_ID = 12;
   
INSERT ALL 
    INTO LOGIN (USERNAME, UPASSWORD, EMPLOYEE_ID) VALUES ('ebaillie', 'rocks', 7)
    INTO LOGIN (USERNAME, UPASSWORD, EMPLOYEE_ID) VALUES ('ibaillie', 'socks', 9)
SELECT * FROM DUAL;

