-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: DBMS
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Administration`
--

DROP TABLE IF EXISTS `Administration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Administration` (
  `AID` char(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `School` varchar(50) NOT NULL,
  `Salary` decimal(10,0) NOT NULL,
  PRIMARY KEY (`AID`),
  UNIQUE KEY `AID` (`AID`),
  KEY `School` (`School`),
  CONSTRAINT `administration_ibfk_1` FOREIGN KEY (`School`) REFERENCES `school` (`School`),
  CONSTRAINT `administration_chk_1` CHECK ((`Salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administration`
--

LOCK TABLES `Administration` WRITE;
/*!40000 ALTER TABLE `Administration` DISABLE KEYS */;
/*!40000 ALTER TABLE `Administration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Assignments`
--

DROP TABLE IF EXISTS `Assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Assignments` (
  `AssignmentID` char(10) NOT NULL,
  `TID` char(10) NOT NULL,
  `Class` decimal(2,0) NOT NULL,
  `Subject` varchar(10) NOT NULL,
  `School` varchar(50) NOT NULL,
  `Date` date NOT NULL,
  `Submissions` decimal(5,0) DEFAULT NULL,
  `Info` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`AssignmentID`),
  KEY `TID` (`TID`),
  KEY `School` (`School`),
  CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`TID`) REFERENCES `teacher` (`TID`),
  CONSTRAINT `assignments_ibfk_2` FOREIGN KEY (`School`) REFERENCES `school` (`School`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Assignments`
--

LOCK TABLES `Assignments` WRITE;
/*!40000 ALTER TABLE `Assignments` DISABLE KEYS */;
/*!40000 ALTER TABLE `Assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Attendance`
--

DROP TABLE IF EXISTS `Attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Attendance` (
  `SID` char(10) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`SID`,`Date`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Attendance`
--

LOCK TABLES `Attendance` WRITE;
/*!40000 ALTER TABLE `Attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `Attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Exams`
--

DROP TABLE IF EXISTS `Exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Exams` (
  `EID` char(10) NOT NULL,
  `Class` decimal(2,0) NOT NULL,
  `Subject` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Exams`
--

LOCK TABLES `Exams` WRITE;
/*!40000 ALTER TABLE `Exams` DISABLE KEYS */;
/*!40000 ALTER TABLE `Exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fee_Details`
--

DROP TABLE IF EXISTS `Fee_Details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Fee_Details` (
  `PID` char(10) NOT NULL,
  `SID` char(10) NOT NULL,
  `GID` char(10) NOT NULL,
  `DueDate` date NOT NULL,
  `Quarter` char(1) NOT NULL,
  `Status` varchar(10) NOT NULL,
  PRIMARY KEY (`PID`),
  UNIQUE KEY `PID` (`PID`),
  KEY `SID` (`SID`),
  KEY `GID` (`GID`),
  CONSTRAINT `fee_details_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`),
  CONSTRAINT `fee_details_ibfk_2` FOREIGN KEY (`GID`) REFERENCES `guardian` (`GID`),
  CONSTRAINT `fee_details_chk_1` CHECK ((`Quarter` in (_utf8mb4'1',_utf8mb4'2',_utf8mb4'3',_utf8mb4'4')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fee_Details`
--

LOCK TABLES `Fee_Details` WRITE;
/*!40000 ALTER TABLE `Fee_Details` DISABLE KEYS */;
/*!40000 ALTER TABLE `Fee_Details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Government_Officials`
--

DROP TABLE IF EXISTS `Government_Officials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Government_Officials` (
  `ID` char(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Department` varchar(50) NOT NULL,
  `Zone` varchar(10) NOT NULL,
  `Salary` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  CONSTRAINT `government_officials_chk_1` CHECK ((`Salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Government_Officials`
--

LOCK TABLES `Government_Officials` WRITE;
/*!40000 ALTER TABLE `Government_Officials` DISABLE KEYS */;
/*!40000 ALTER TABLE `Government_Officials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grades`
--

DROP TABLE IF EXISTS `Grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Grades` (
  `SID` char(10) NOT NULL,
  `EID` char(10) NOT NULL,
  `Marks` decimal(3,0) NOT NULL,
  PRIMARY KEY (`SID`,`EID`),
  KEY `EID` (`EID`),
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`),
  CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`SID`) REFERENCES `student` (`SID`),
  CONSTRAINT `grades_ibfk_3` FOREIGN KEY (`EID`) REFERENCES `exams` (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grades`
--

LOCK TABLES `Grades` WRITE;
/*!40000 ALTER TABLE `Grades` DISABLE KEYS */;
/*!40000 ALTER TABLE `Grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Guardian`
--

DROP TABLE IF EXISTS `Guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Guardian` (
  `GID` char(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone` char(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Account` char(12) NOT NULL,
  `PID` char(10) NOT NULL,
  PRIMARY KEY (`GID`),
  UNIQUE KEY `GID` (`GID`),
  KEY `PID` (`PID`),
  CONSTRAINT `guardian_ibfk_1` FOREIGN KEY (`PID`) REFERENCES `fee_details` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Guardian`
--

LOCK TABLES `Guardian` WRITE;
/*!40000 ALTER TABLE `Guardian` DISABLE KEYS */;
/*!40000 ALTER TABLE `Guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notice`
--

DROP TABLE IF EXISTS `Notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Notice` (
  `NID` char(10) NOT NULL,
  `ID` char(10) NOT NULL,
  `Date` date DEFAULT NULL,
  `Zone` varchar(10) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Audience` varchar(25) NOT NULL,
  `Info` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`NID`),
  UNIQUE KEY `NID` (`NID`),
  KEY `ID` (`ID`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `government_officials` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notice`
--

LOCK TABLES `Notice` WRITE;
/*!40000 ALTER TABLE `Notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `Notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `School`
--

DROP TABLE IF EXISTS `School`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `School` (
  `School` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Zone` varchar(10) NOT NULL,
  `Principal` varchar(50) NOT NULL,
  `Performance` decimal(3,2) NOT NULL,
  PRIMARY KEY (`School`),
  UNIQUE KEY `School` (`School`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `School`
--

LOCK TABLES `School` WRITE;
/*!40000 ALTER TABLE `School` DISABLE KEYS */;
/*!40000 ALTER TABLE `School` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Student` (
  `SID` char(10) NOT NULL,
  `GID` char(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `Sex` char(1) NOT NULL,
  `Father` varchar(50) NOT NULL,
  `Mother` varchar(50) NOT NULL,
  `Class` decimal(2,0) NOT NULL,
  `School` varchar(50) NOT NULL,
  `DOE` char(8) NOT NULL,
  `Height` decimal(4,1) DEFAULT NULL,
  `Weight` decimal(4,1) DEFAULT NULL,
  `BloodGroup` varchar(3) DEFAULT NULL,
  `Scholarship` varchar(10) NOT NULL,
  `Performance` decimal(5,2) NOT NULL,
  PRIMARY KEY (`SID`),
  UNIQUE KEY `SID` (`SID`),
  KEY `GID` (`GID`),
  KEY `School` (`School`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`GID`) REFERENCES `guardian` (`GID`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`School`) REFERENCES `school` (`School`),
  CONSTRAINT `student_chk_1` CHECK ((`Sex` in (_utf8mb4'M',_utf8mb4'F'))),
  CONSTRAINT `student_chk_2` CHECK ((`Class` <= 12))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subject_Details`
--

DROP TABLE IF EXISTS `Subject_Details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subject_Details` (
  `Class` decimal(2,0) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Book` varchar(100) NOT NULL,
  `NumberOfAssignments` decimal(3,0) DEFAULT NULL,
  `NumberOfExams` decimal(3,0) DEFAULT NULL,
  PRIMARY KEY (`Class`,`Name`),
  CONSTRAINT `subject_details_chk_1` CHECK ((`Class` <= 12))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subject_Details`
--

LOCK TABLES `Subject_Details` WRITE;
/*!40000 ALTER TABLE `Subject_Details` DISABLE KEYS */;
/*!40000 ALTER TABLE `Subject_Details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Teacher` (
  `TID` char(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `DOB` date NOT NULL,
  `Sex` char(1) NOT NULL,
  `Phone` char(10) DEFAULT NULL,
  `Subject` varchar(10) NOT NULL,
  `Qualification` varchar(5) NOT NULL,
  `YearsOfService` decimal(2,0) NOT NULL,
  `School` varchar(25) NOT NULL,
  `Feedback` decimal(4,2) DEFAULT NULL,
  `Salary` decimal(10,0) NOT NULL,
  PRIMARY KEY (`TID`),
  UNIQUE KEY `TID` (`TID`),
  KEY `School` (`School`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`School`) REFERENCES `school` (`School`),
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`School`) REFERENCES `school` (`School`),
  CONSTRAINT `teacher_chk_1` CHECK ((`Sex` in (_utf8mb4'M',_utf8mb4'F'))),
  CONSTRAINT `teacher_chk_2` CHECK ((`Salary` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 18:19:22
