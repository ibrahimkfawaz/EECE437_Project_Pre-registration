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
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rooms` (
  `idrooms` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `capacity` int(3) unsigned zerofill DEFAULT '000',
  PRIMARY KEY (`idrooms`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (141,'Mr. White200',030),(142,'Mr. White201',030),(143,'Mr. White202',030),(144,'Mr. White203',030),(145,'Mr. White204',060),(146,'Mr. White205',060),(147,'Mr. White206',060),(148,'Mr. White207',090),(149,'Mr. White208',090),(150,'Mr. White209',090),(151,'Simpsons200',030),(152,'Simpsons201',030),(153,'Simpsons202',030),(154,'Simpsons203',030),(155,'Simpsons204',060),(156,'Simpsons205',060),(157,'Simpsons206',060),(158,'Simpsons207',090),(159,'Simpsons208',090),(160,'Simpsons209',090),(161,'Castro200',030),(162,'Castro201',030),(163,'Castro202',030),(164,'Castro203',030),(165,'Castro204',060),(166,'Castro205',060),(167,'Castro206',060),(168,'Castro207',090),(169,'Castro208',090),(170,'Castro209',090),(171,'Dijkstra200',030),(172,'Dijkstra201',030),(173,'Dijkstra202',030),(174,'Dijkstra203',030),(175,'Dijkstra204',060),(176,'Dijkstra205',060),(177,'Dijkstra206',060),(178,'Dijkstra207',090),(179,'Dijkstra208',090),(180,'Dijkstra209',090);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-17 16:59:59
