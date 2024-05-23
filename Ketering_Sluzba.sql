CREATE DATABASE  IF NOT EXISTS `ketering` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ketering`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ketering
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kategorija` (
  `kategorijaID` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `programID` int DEFAULT NULL,
  PRIMARY KEY (`kategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'kolaci',1),(2,'palacinke',1),(3,'slatko od',1),(4,'supe',2),(5,'rostilj',2),(6,'pecenje',2),(7,'kuvana jela',2),(8,'specijaliteti',2),(9,'jela na zaru',2);
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korisnik` (
  `korisnikID` int NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `sifra` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `kontakt` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `uloga` int NOT NULL,
  `adresa` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `imeKorisnika` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'nikolic@live.com','123','252525',12,NULL,'Marko'),(2,'nikolic.uros@live.com','123','064582920',1,'Kneza Milosa 1','Milenko Nikolov'),(3,'dragic@live.com','123','066006600',1,'Kneza Milosa 1','Dragic Uros'),(4,'admin@live.com','123','000000000',3,'Milosa Bikovica 3','Admin1'),(5,'moderator1@live.com','123','111111111',2,'Skender Begova 2','Moderator Dusko'),(6,'deki@live.com','123','66666666666',2,'Kneza Milosa 222','Dejan Palic'),(8,'miomir@live.com','123','055647821',1,'Ante Pavelica 5','Zlatan Ibrahimovic');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korpa`
--

DROP TABLE IF EXISTS `korpa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `korpa` (
  `korpaID` int NOT NULL AUTO_INCREMENT,
  `korisnikID` int NOT NULL,
  `datumVreme` datetime NOT NULL,
  `ponudaID` int NOT NULL,
  `kolicina` int NOT NULL,
  PRIMARY KEY (`korpaID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korpa`
--

LOCK TABLES `korpa` WRITE;
/*!40000 ALTER TABLE `korpa` DISABLE KEYS */;
INSERT INTO `korpa` VALUES (1,1,'2022-05-22 15:22:00',2,7),(2,1,'2022-05-22 15:22:00',10,2),(3,1,'2022-05-22 15:22:00',8,5),(24,2,'2022-05-22 15:22:00',16,3),(25,2,'2022-05-22 15:22:00',8,2);
/*!40000 ALTER TABLE `korpa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `narudzbina`
--

DROP TABLE IF EXISTS `narudzbina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `narudzbina` (
  `narudzbinaID` int NOT NULL AUTO_INCREMENT,
  `ukupaniznos` double NOT NULL,
  `datum` datetime NOT NULL,
  `korisnikID` int NOT NULL,
  `nacinplacanja` varchar(45) NOT NULL,
  `zavrsena` int NOT NULL,
  PRIMARY KEY (`narudzbinaID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `narudzbina`
--

LOCK TABLES `narudzbina` WRITE;
/*!40000 ALTER TABLE `narudzbina` DISABLE KEYS */;
INSERT INTO `narudzbina` VALUES (2,2250,'2022-06-14 14:50:00',4,'Kartica',1),(3,12900,'2022-06-14 14:50:00',6,'Gotovina',0),(4,3400,'2022-06-14 14:50:00',3,'Racun',0),(5,1600,'2022-06-14 14:50:00',4,'Gotovina',0),(6,1350,'2022-06-14 14:50:00',4,'Gotovina',0),(7,1650,'2022-06-14 14:50:00',4,'Gotovina',0),(8,4200,'2022-06-14 14:50:00',4,'Racun',0),(9,6570,'2022-06-14 14:50:00',6,'Gotovina',0),(10,4600,'2022-06-14 14:50:00',6,'Gotovina',0),(11,900,'2022-06-14 14:50:00',3,'Kartica',0),(12,750,'2022-06-14 14:50:00',6,'Kartica',0),(13,900,'2022-06-14 14:50:00',3,'Gotovina',0),(14,2800,'2022-06-14 14:50:00',3,'Gotovina',0),(15,450,'2022-06-14 14:50:00',3,'Kartica',0),(16,500,'2022-06-14 14:50:00',3,'Kartica',0),(17,450,'2022-06-14 14:50:00',3,'Kartica',0),(18,250,'2022-06-14 14:50:00',3,'Kartica',0),(19,1800,'2022-06-14 14:50:00',5,'Kartica',0),(20,1350,'2022-06-14 14:50:00',3,'Kartica',0),(21,3250,'2022-06-14 14:50:00',3,'Racun',0),(22,4750,'2022-06-14 14:50:00',3,'Kartica',0),(23,24000,'2022-06-14 14:50:00',6,'Kartica',0),(24,12500,'2022-06-14 14:50:00',4,'Kartica',0),(25,2650,'2022-06-14 14:50:00',4,'Gotovina',0),(26,1000,'2022-06-14 14:50:00',6,'Kartica',0),(27,8450,'2022-06-14 14:50:00',6,'Racun',0),(28,2150,'2022-06-14 14:50:00',4,'Kartica',0);
/*!40000 ALTER TABLE `narudzbina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ponuda`
--

DROP TABLE IF EXISTS `ponuda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ponuda` (
  `ponudaID` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `kategorijaID` int NOT NULL,
  `kolicina` int NOT NULL,
  `cena` double NOT NULL,
  `cenaSaPopustom` double DEFAULT NULL,
  `slika` varchar(45) NOT NULL,
  `brisano` int NOT NULL,
  PRIMARY KEY (`ponudaID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ponuda`
--

LOCK TABLES `ponuda` WRITE;
/*!40000 ALTER TABLE `ponuda` DISABLE KEYS */;
INSERT INTO `ponuda` VALUES (1,'Riblja corba',9,30,2500,2300,'riblja_corba.jpg',1),(2,'Cevapi',5,1995,500,450,'cevapi.jpg',0),(3,'Teleca corba',4,22,350,350,'telecacorba.jpg',0),(4,'Svinjsko pecenje',6,499,1200,1000,'prasece_pecenje.jpg',0),(5,'Jagnjece pecenje',6,339,1400,1400,'jagnjece_pecenje.jpg',0),(6,'Teletina ispod Saca',8,8,4500,4000,'teletina_ispod_saca.jpg',0),(7,'Riblja corba',4,4,2000,1600,'riblja_corba.jpg',0),(8,'Tiramisu',1,450,250,250,'tiramisu.jpeg',0),(9,'Palacinke sa Nutelom',2,598,300,300,'palacinka_nutela.jpg',0),(10,'Palacinke sa euro kremom',2,290,250,250,'palacinke_eurokrem.jpg',0),(11,'Bajadere',1,298,200,200,'bajadere.jpg',0),(12,'Slatko od Visnje',3,7,190,190,'slatkoOdVisnje.jpg',0),(13,'Corbast pasulj',7,45,650,650,'corbastPasulj.jpg',0),(14,'Prebranac',7,89,850,850,'prebranac.jpg',0),(15,'Deciji Sendvici',5,50,1500,1300,'deciji_sendvici.webp',0),(16,'Cevapi 500 Grama',5,30,650,600,'riblja_corba.jpg',1),(17,'Mesano meso 5',5,30,600,600,'mesanoMeso.jpeg',0),(18,'Nemacke kobasice',5,30,600,550,'nemackeKobasice.jpg',0),(19,'Palacinke sa nutelom i Jagodom',2,250,340,340,'palacinka_nutela.jpg',0),(20,'Palacinke sa nutelom i Jagodom 3000',2,300,340,250,'palacinka_nutela.jpg',0);
/*!40000 ALTER TABLE `ponuda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `program` (
  `programID` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`programID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'slatki'),(2,'slani');
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavkenarudzbine`
--

DROP TABLE IF EXISTS `stavkenarudzbine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stavkenarudzbine` (
  `stavkeID` int NOT NULL AUTO_INCREMENT,
  `narudzbinaID` int NOT NULL,
  `ponudaID` int NOT NULL,
  `cena` double NOT NULL,
  `kolicina` int NOT NULL,
  PRIMARY KEY (`stavkeID`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavkenarudzbine`
--

LOCK TABLES `stavkenarudzbine` WRITE;
/*!40000 ALTER TABLE `stavkenarudzbine` DISABLE KEYS */;
INSERT INTO `stavkenarudzbine` VALUES (1,2,2,500,5),(2,3,9,300,5),(3,3,7,1600,5),(4,3,14,850,4),(5,4,14,850,4),(6,5,7,1600,1),(7,6,2,450,3),(8,7,2,450,2),(9,7,10,250,3),(10,8,4,1000,3),(11,8,16,600,2),(12,9,5,1400,2),(13,9,7,1600,2),(14,9,12,190,3),(15,10,11,200,3),(16,10,6,4000,1),(17,11,9,300,3),(18,12,10,250,3),(19,13,2,450,2),(20,14,5,1400,2),(21,15,2,450,1),(22,16,8,250,2),(23,17,2,450,1),(24,18,10,250,1),(25,19,17,600,3),(26,20,2,450,3),(27,21,13,650,5),(28,22,8,250,3),(29,22,6,4000,1),(30,23,4,1000,10),(31,23,5,1400,10),(32,24,4,1000,10),(33,24,10,250,10),(34,25,17,600,3),(35,25,14,850,1),(36,26,9,300,2),(37,26,11,200,2),(38,27,2,450,1),(39,27,4,1000,1),(40,27,5,1400,1),(41,27,6,4000,1),(42,27,7,1600,1),(43,28,2,450,4),(44,28,3,350,1);
/*!40000 ALTER TABLE `stavkenarudzbine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-26  4:11:40
