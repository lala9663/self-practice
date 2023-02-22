select * from tutorial.user;

# INSERT INTO USER (userID, userPassword)
# VALUES('14', '12345');

CREATE DATABASE LECTURE;
USE LECTURE;
CREATE TABLE USER(
    userID VARCHAR(20),
    userPassword VARCHAR(64),
    userEmail VARCHAR(50),
    userEmailHash VARCHAR(64),
    userEmailChecked BOOLEAN
);
DESC user;
ALTER TABLE USER ADD PRIMARY KEY (userID);

CREATE TABLE EVALUATION
(
    evaluationID      int PRIMARY KEY AUTO_INCREMENT,
    userID            VARCHAR(20),
    lectureName       VARCHAR(50),
    professorName     VARCHAR(20),
    lectureYear       INT,
    semesterDivide    VARCHAR(20),
    lectureDivide     VARCHAR(10),
    evaluationTitle   VARCHAR(50),
    evaluationContent VARCHAR(2048),
    totalScore        VARCHAR(5),
    creditScore       VARCHAR(5),
    comfortableScore  VARCHAR(5),
    lectureScore      VARCHAR(5),
    likeCount         int
);
DESC EVALUATION;

CREATE TABLE LIKELY(
    userID VARCHAR(20),
    evaluationID int,
    userIP VARCHAR(50)
);
DESC EVALUATION;