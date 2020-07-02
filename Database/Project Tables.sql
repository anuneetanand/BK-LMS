CREATE TABLE `Student`
(
    SID char(10) NOT NULL UNIQUE,
    GID char(10) NOT NULL,
    Name varchar(50) NOT NULL,
    DOB date NOT NULL,
    Sex char(1) NOT NULL CHECK (Sex in ('M','F')),
    Father varchar(50) NOT NULL,
    Mother varchar(50) NOT NULL,
    Class NUMERIC(2,0) NOT NULL CHECK (Class <= 12),
    School varchar(50) NOT NULL ,
    DOE date NOT NULL,
    Height NUMERIC(4,1) ,
    Weight NUMERIC(4,1),
    BloodGroup varchar(3),
    Scholarship varchar(10) NOT NULL,
    Performance numeric(5,2) NOT NULL,
    PRIMARY KEY (SID)
);

CREATE TABLE `Teacher`
(
   TID char(10) NOT NULL UNIQUE,
   Name varchar(50) NOT NULL,
   DOB date NOT NULL,
   Sex char(1) NOT NULL CHECK (Sex in ('M','F')),
   Phone char(10),
   Subject varchar(10) NOT NULL,
   Qualification varchar(5) NOT NULL,
   YearsOfService numeric(2) NOT NULL,
   School varchar(25) NOT NULL,
   Feedback  NUMERIC(4,2),
   Salary Numeric(10) NOT NULL CHECK ( Salary >= 0 ),
   Class Numeric(2) NOT NULL,
   FBCount Numeric(5).
   PRIMARY KEY (TID)
);

CREATE TABLE `Guardian` 
(
    GID char(10) NOT NULL UNIQUE,
    Name varchar(50) NOT NULL,
    Phone char(10) NOT NULL,
    Address varchar(50) NOT NULL,
    Account char(12) NOT NULL,
    PRIMARY KEY (GID)
);

CREATE TABLE `Administration`
(
  AID char(10) NOT NULL UNIQUE,
  Name varchar(50) NOT NULL,
  School  varchar(50) NOT NULL,
  Salary Numeric(10) NOT NULL CHECK ( Salary>=0 ),
  PRIMARY KEY (AID)
);

CREATE TABLE `Government_Officials`
(
    ID char(10) NOT NULL UNIQUE,
    Name varchar(50) NOT NULL,
    Department varchar(50) NOT NULL,
    Zone varchar(10) NOT NULL,
    Salary Numeric(10) NOT NULL CHECK ( Salary>=0 ),
    PRIMARY KEY (ID)
);

CREATE TABLE `School`
(
  School varchar(50) NOT NULL UNIQUE,
  Address varchar(100) NOT NULL,
  Zone varchar(10) NOT NULL,
  Principal varchar(50) NOT NULL,
  Performance numeric(3,2) NOT NULL,
  PRIMARY KEY (School)
);

CREATE TABLE `Notice`
(
   NID char(10) NOT NULL UNIQUE,
   ID char(10) NOT NULL,
   Date date,
   Zone varchar(10) NOT NULL,
   Title varchar(50) NOT NULL,
   Audience varchar(25) NOT NULL,
   Info varchar(10000),
   PRIMARY KEY (NID)
);

CREATE TABLE `Exams`
(
 EID char(10) NOT NULL,
 Class NUMERIC(2) NOT NULL,
 Subject varchar(10) NOT NULL,
 Date date NOT NULL,
 PRIMARY KEY (EID)
);

CREATE TABLE `Assignments`
(
   AssignmentID char(10) NOT NULL,
   TID char(10) NOT NULL,
   Class NUMERIC(2) NOT NULL,
   Subject varchar(10) NOT NULL,
   School varchar(50) NOT NULL,
   Date date NOT NULL,
   Info varchar(10000),
   PRIMARY KEY (AssignmentID)
);

CREATE TABLE `Grades`
(
      SID char(10) NOT NULL,
      EID char(10) NOT NULL,
      Marks numeric(3) NOT NULL,
      PRIMARY KEY (SID,EID)
);

CREATE TABLE `Submissions`
(
    SID char(10) NOT NULL,
    AssignmentID char(10) NOT NULL,
    PRIMARY KEY (SID,AssignmentID)
);

CREATE TABLE `SubjectInfo`
(
   Class NUMERIC(2) NOT NULL CHECK (Class<=12),
   Name varchar(10) NOT NULL,
   Book varchar(100) NOT NULL,
   NumberOfAssignments NUMERIC(3),
   NumberOfExams NUMERIC(3),
   School varchar(50) NOT NULL,
   PRIMARY KEY (Class, Name, School)
);

CREATE TABLE `Attendance`
(
  SID char(10) NOT NULL,
  Date date NOT NULL,
  PRIMARY KEY (SID,Date)
);

CREATE TABLE `Fee_Details`
(
    PID char(10) NOT NULL UNIQUE,
    SID char(10) NOT NULL,
    GID char(10) NOT NULL,
    DueDate date NOT NULL,
    Quarter char(1) NOT NULL CHECK ( Quarter in ('1','2','3','4') ),
    Status varchar(10) NOT NULL,
    PRIMARY KEY (PID)
);

ALTER TABLE Student ADD FOREIGN KEY (GID) REFERENCES Guardian(GID);
ALTER TABLE Student ADD FOREIGN KEY (School) REFERENCES School(School);
ALTER TABLE Teacher ADD FOREIGN KEY (School) REFERENCES School(School);
ALTER TABLE Guardian ADD FOREIGN KEY (PID) REFERENCES Fee_Details(PID);
ALTER TABLE Administration ADD FOREIGN KEY (School) REFERENCES School(School);
ALTER TABLE Notice ADD FOREIGN KEY (ID) REFERENCES Government_Officials(ID);
ALTER TABLE Assignments ADD FOREIGN KEY (TID) REFERENCES Teacher(TID);
ALTER TABLE Assignments ADD FOREIGN KEY (School) REFERENCES School(School);
ALTER TABLE Grades ADD FOREIGN KEY (SID) REFERENCES Student(SID);
ALTER TABLE Grades ADD FOREIGN KEY (EID) REFERENCES Exams(EID);
ALTER TABLE Submissions ADD FOREIGN KEY (SID) REFERENCES Student(SID);
ALTER TABLE Submissions ADD FOREIGN KEY (AssignmentID) REFERENCES Assignments(AssignmentID);
ALTER TABLE Fee_Details ADD FOREIGN KEY (SID) REFERENCES Student(SID);
ALTER TABLE Fee_Details ADD FOREIGN KEY (GID) REFERENCES Guardian(GID);
ALTER TABLE Attendance ADD FOREIGN KEY (SID) REFERENCES Student(SID);