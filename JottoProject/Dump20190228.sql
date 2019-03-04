-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: jotto
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) NOT NULL,
  `password` char(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'user1','password1'),(2,'user2','password2'),(3,'user3','password3'),(4,'user4','password4'),(5,'user5','password5'),(6,'newUser','newPass'),(7,'newUser2','newPass2');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game` (
  `game_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) DEFAULT NULL,
  `game_state` varchar(30) NOT NULL DEFAULT 'INCOMPLETE',
  `user_word` char(5) NOT NULL,
  `cpu_word` char(5) NOT NULL,
  `date_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`game_id`),
  KEY `username` (`username`),
  CONSTRAINT `game_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'user1','WIN','abort','plead','2019-02-28 00:00:00'),(2,'user1','INCOMPLETE','adieu','pride','2019-02-28 03:07:49'),(3,'user2','INCOMPLETE','hoped','rapid','2019-02-28 03:07:49'),(4,'user3','LOSE','horse','quiet','2019-02-28 03:07:49'),(5,'user3','INCOMPLETE','lemon','acids','2019-02-28 03:07:49'),(6,'user4','WIN','words','human','2019-02-28 03:07:50'),(7,'user4','WIN','music','front','2019-02-28 03:07:50'),(8,'user4','INCOMPLETE','backs','piano','2019-02-28 03:07:50'),(9,'user5','WIN','crazy','tiles','2019-02-28 03:07:50'),(10,'user5','LOSE','lance','baked','2019-02-28 03:07:50'),(11,'user5','INCOMPLETE','spear','smile','2019-02-28 03:07:50'),(12,'newUser2','INCOMPLETE','laser','drank','2019-02-28 03:07:50');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `round` (
  `round_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) DEFAULT NULL,
  `round_number` int(11) NOT NULL,
  `user_guess` char(5) NOT NULL,
  `cpu_guess` char(5) NOT NULL,
  PRIMARY KEY (`round_id`),
  KEY `game_id` (`game_id`),
  CONSTRAINT `round_ibfk_1` FOREIGN KEY (`game_id`) REFERENCES `game` (`game_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `round`
--

LOCK TABLES `round` WRITE;
/*!40000 ALTER TABLE `round` DISABLE KEYS */;
INSERT INTO `round` VALUES (1,1,1,'adore','price'),(2,1,2,'abore','plate'),(3,1,3,'abort','plane'),(4,2,1,'rakes','cakes'),(5,3,1,'abort','plate'),(6,3,2,'happy','poppy'),(7,4,1,'human','lakes'),(8,4,2,'haunt','quick'),(9,4,3,'store','quest'),(10,4,4,'shore','quiet'),(11,5,1,'pipes','lakes'),(12,6,1,'wives','hares'),(13,6,2,'words','shape'),(14,7,1,'lisps','shape'),(15,7,2,'ships','drift'),(16,7,3,'mains','delta'),(17,7,4,'manic','freed'),(18,7,5,'musky','freak'),(19,7,6,'music','froze'),(20,8,1,'brats','loved'),(21,8,2,'bears','ready'),(22,8,3,'beaks','prize'),(23,9,1,'crazy','masks'),(24,10,1,'break','lived'),(25,10,2,'leaps','bread'),(26,10,3,'beaks','bleed'),(27,10,4,'dance','baked'),(28,11,1,'mails','pesto'),(29,11,2,'rails','lasso'),(30,12,1,'music','trims'),(31,12,2,'anvil','prize'),(32,12,3,'lairs','press'),(33,12,4,'lease','dress');
/*!40000 ALTER TABLE `round` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'jotto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-28  3:10:03
