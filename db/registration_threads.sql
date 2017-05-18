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
-- Table structure for table `threads`
--

DROP TABLE IF EXISTS `threads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `threads` (
  `idThreads` int(11) NOT NULL AUTO_INCREMENT,
  `titleid` int(11) NOT NULL,
  `threadtitle` varchar(45) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `sender` varchar(45) DEFAULT NULL,
  `initiator` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idThreads`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threads`
--

LOCK TABLES `threads` WRITE;
/*!40000 ALTER TABLE `threads` DISABLE KEYS */;
INSERT INTO `threads` VALUES (24,1,'437','I\'m hassan','hassan','hassan'),(25,2,'437','I\'m hassan','hassan','hassan'),(26,3,'437','I\'m hassan','hassan','hassan'),(27,4,'437','I\'m hassan','hassan','hassan'),(28,5,'437','I\'m bob','hassan','hassan'),(29,6,'437','I\'m fadi','hassan','hassan'),(30,7,'437','I\'m zaraket','hassan','hassan'),(31,1,'638','I\'m rabab','hassan','hassan'),(32,8,'437','drop it','hassan','hassan'),(33,2,'638','hi','hassan','hassan'),(34,3,'638','hi','hassan','hassan'),(35,4,'638','hi','hassan','hassan'),(36,5,'638','hi','hassan','hassan'),(37,6,'638','hi','hassan','hassan'),(38,7,'638','hi','hassan','hassan'),(39,8,'638','hi','hassan','hassan'),(40,9,'638','hi','hassan','hassan'),(41,10,'638','hi','hassan','hassan'),(42,11,'638','hi','hassan','hassan'),(43,12,'638','hi','hassan','hassan'),(44,13,'638','hi','hassan','hassan'),(45,9,'437','Is the timing good with the people willing to take the coourse?','fadi_zaraket','fadi_zaraket'),(46,1,'EECE437 Timing','Is the timing ok?','fadi_zaraket','fadi_zaraket'),(47,2,'EECE437 Timing','Is the timing ok?','fadi_zaraket','fadi_zaraket'),(48,1,'EECE437','Is the time ok?','fadi_zaraket','fadi_zaraket'),(49,2,'EECE437','Is the time of the course ok?','fadi_zaraket','fadi_zaraket'),(50,3,'EECE437','is the time of the course ok?','fadi_zaraket','fadi_zaraket'),(51,1,'EECE437:Time','Is the time of the course ok?','fadi_zaraket','fadi_zaraket'),(52,1,'EECE437 Time','is the time ok?','fadi_zaraket','fadi_zaraket'),(53,1,'ya alla','1','hassan','hassan'),(54,1,'hoho','haha','hassan','hassan'),(55,1,'haha','hoho','hassan','hassan'),(56,1,'hihi','haha','hassan','hassan'),(57,1,'1212','asasa','hassan','hassan'),(58,1,'test','test','hassan','hassan');
/*!40000 ALTER TABLE `threads` ENABLE KEYS */;
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
