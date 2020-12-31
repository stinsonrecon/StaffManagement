-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: QLCB
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CanBo`
--

DROP TABLE IF EXISTS `CanBo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CanBo` (
  `IdCanBo` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) DEFAULT NULL,
  `GioiTinh` varchar(5) DEFAULT NULL,
  `Tuoi` int DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `SDT` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdCanBo`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CanBo`
--

LOCK TABLES `CanBo` WRITE;
/*!40000 ALTER TABLE `CanBo` DISABLE KEYS */;
INSERT INTO `CanBo` VALUES (1,'dung','nam',20,'hn','2341341324','minhtin'),(2,'tien','nam',20,'HN','0964336859','minhtienstinson@gmail.com'),(4,'vinh ','nam ',19,'HaNoi ','0818582222 ','vinhcho@gmail.com '),(6,'Joji ','Nam ',25,'Aus ','45893745 ','pinkguy@mail.com '),(10,'Le Minh Tien ','Nam ',20,'Ha Noi ','0964336859 ','minhtienlomo@gmail.com '),(11,'Tuan ','Nam ',49,'HaNoi ','123456789 ','minhtuan997@gmail.com '),(13,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(14,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(15,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(16,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(17,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(18,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(19,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(20,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(21,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(22,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(23,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(24,'Tung ','nam ',19,'HN ','0123566 ','tu@mail '),(25,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(28,'Tu ','nam ',19,'HN ','0123566 ','tu@mail '),(29,'Hien ','Nam ',50,'HaNoi ','08345345 ','hien@mail.com '),(30,'bao ','nam ',23,'hn ','124124 ','baohihi '),(31,'Huu Son ','nam ',20,'Hn ','242134 ','sonbeo '),(32,'Tùng ','Nam ',20,'Hn ','234234324235 ','tung@gmail.com ');
/*!40000 ALTER TABLE `CanBo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-31 14:14:39
