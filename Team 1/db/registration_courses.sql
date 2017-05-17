-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: registration
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `idcourses` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(45) DEFAULT NULL,
  `professor` varchar(45) DEFAULT NULL,
  `coursedesc` varchar(200) DEFAULT NULL,
  `timeslot` varchar(45) DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  `capacity` int(11) unsigned zerofill DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  `coursen` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcourses`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (14,'MECH330','ibra','Mechanics','MWF @ 10:00 to 10:50','',00000000001,'MECH','Mechanics'),(16,'EECE432','fadi_zaraket','Operarting Systems','MWF @ 01:00 to 01:50','',00000000004,'EECE','Operating System'),(20,'EECE433','fadi_zaraket','Databases','MWF @ 02:00 to 03:15','',00000000001,'EECE','Database'),(21,'EECE436','fadi_zaraket','Parallel Progaming','MWF @ 08:00 to 08:50','Mr. White200',00000000001,'EECE','Parallel Programming'),(22,'EECE439','fadi_zaraket','Software Design','MWF @ 08:00 to 08:50','',00000000000,'EECE','Software Design'),(23,'EECE230','fadi_zaraket','Programming','MWF @ 12:00 to 12:50','',00000000002,'EECE','Prorgramming'),(25,'EECE430','fadi_zaraket','software','MWF @ 10:00 to 10:50','',00000000000,'EECE','software'),(26,'EECE503','fadi_zaraket','Java','TR @ 01:00 to 01:50','',00000000001,'EECE','Java'),(34,'EECE231','fadi_zaraket','Programming and Marlab','MWF @ 08:00 to 08:50','',00000000000,'EECE','Programming and Marlab'),(38,'EECE437','fadi_zaraket','Software arch','MWF @ 10:00 to 10:50','',00000000000,'EECE','Software Architecture');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-17 16:59:58
