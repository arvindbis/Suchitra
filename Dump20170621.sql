CREATE DATABASE  IF NOT EXISTS `ticketbookingandmanagementsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ticketbookingandmanagementsystem`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ticketbookingandmanagementsystem
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `auditorium_show_mapping`
--

DROP TABLE IF EXISTS `auditorium_show_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditorium_show_mapping` (
  `show_id` varchar(5) NOT NULL,
  `auditorium_name` varchar(45) NOT NULL,
  `movie_id` int(11) NOT NULL,
  PRIMARY KEY (`show_id`),
  KEY `f_key1_idx` (`movie_id`),
  CONSTRAINT `foreign_key1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditorium_show_mapping`
--

LOCK TABLES `auditorium_show_mapping` WRITE;
/*!40000 ALTER TABLE `auditorium_show_mapping` DISABLE KEYS */;
INSERT INTO `auditorium_show_mapping` VALUES ('sh1','Seasons',1),('sh2','westadh',2),('sh3','Seasons',8);
/*!40000 ALTER TABLE `auditorium_show_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus` (
  `bus_number` varchar(7) NOT NULL,
  `bus_name` varchar(45) NOT NULL,
  `number_of_seats` int(4) NOT NULL,
  `bus_type` varchar(25) NOT NULL,
  PRIMARY KEY (`bus_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES ('ga5679','ganesh',40,'AC Seater'),('ga5768','ganesh',40,'Non A/C Seater'),('ga6666','ganesh',40,'A/C Seater'),('sd6666','sugama',40,'A/C Seater'),('srs123','srs',40,'A/C Seater'),('su1122','sugama',40,'A/C Seater'),('su1234','sugama',40,'A/C Seater');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus_route_mapping`
--

DROP TABLE IF EXISTS `bus_route_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bus_route_mapping` (
  `bus_number` varchar(7) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  `time` time(1) NOT NULL,
  `day` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  KEY `f_key1_idx` (`bus_number`),
  KEY `f_key2_idx` (`route_id`),
  CONSTRAINT `f_key1` FOREIGN KEY (`bus_number`) REFERENCES `bus` (`bus_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `f_key2` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus_route_mapping`
--

LOCK TABLES `bus_route_mapping` WRITE;
/*!40000 ALTER TABLE `bus_route_mapping` DISABLE KEYS */;
INSERT INTO `bus_route_mapping` VALUES ('sd6666',1,'source','12:00:00.0','monday','wakad'),('sd6666',1,'pickup','12:30:00.0','monday','pimpri'),('sd6666',1,'pickup','13:00:00.0','monday','lonavala'),('sd6666',1,'pickup','14:00:00.0','monday','mumbai'),('srs123',2,'source','12:30:00.0','monday','mumbai'),('su1234',1,'source','12:22:00.0','monday','wakad'),('sd6666',1,'source','12:00:00.0','wednesday','wakad'),('sd6666',1,'pickup','12:30:00.0','wednesday','pimpri'),('sd6666',1,'pickup','13:00:00.0','wednesday','lonavala'),('sd6666',1,'pickup','14:00:00.0','wednesday','mumbai'),('srs123',2,'source','12:30:00.0','wednesday','mumbai'),('su1234',1,'source','12:22:00.0','wednesday','wakad'),('ga5679',1,'source','12:22:00.0','tuesday','wakad'),('ga5679',1,'pickup','12:22:00.0','tuesday','baner'),('ga5679',1,'pickup','12:48:00.0','tuesday','nigadi'),('ga5679',1,'droppoint','13:22:00.0','tuesday','chinchwad'),('ga5679',1,'droppoint','14:22:00.0','tuesday','lonavala'),('ga5679',1,'droppoint','15:22:00.0','tuesday','mumbai'),('sd6666',1,'droppoint','16:00:00.0','monday','navimumbai'),('sd6666',1,'droppoint','16:00:00.0','monday','navimumbai'),('sd6666',1,'droppoint','17:00:00.0','monday','thane'),('sd6666',1,'droppoint','17:00:00.0','monday','mumbaihighway'),('sd6666',1,'droppoint','19:00:00.0','monday','dombivli'),('sd6666',1,'destination','20:00:00.0','monday','mumbai'),('sd6666',1,'droppoint','16:00:00.0','wednesday','navimumbai'),('sd6666',1,'droppoint','17:00:00.0','wednesday','thane'),('sd6666',1,'droppoint','17:00:00.0','wednesday','mumbaihighway'),('sd6666',1,'droppoint','19:00:00.0','wednesday','dombivli'),('sd6666',1,'destination','20:00:00.0','wednesday','mumbai');
/*!40000 ALTER TABLE `bus_route_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'parvathi','9898989889'),(2,'ishwar','9898989898'),(3,'harish','9867567888'),(4,'harsha','9867567888'),(5,'suchitra','9483309902'),(6,'shetty','9483309902'),(7,'pradeep','9898989877'),(8,'rekha','9898989877'),(9,'karan','9898767897'),(10,'kiran','9898767897'),(11,'karan','9887657675'),(12,'kiran','9887657675'),(13,'sudha','9867567888'),(14,'thanu','9867567888'),(15,'faran','9867567887'),(16,'khan','9867567887'),(17,'dawan','9867567885'),(18,'rahul','9876787654'),(19,'girish','7898798789'),(20,'thani','7898765678'),(21,'austin','7898789876'),(22,'rohit','7898767896'),(23,'suchhi','9876567898'),(24,'satya','9878789788'),(25,'satya','9878789788'),(26,'rahul','8787878787'),(28,'kkaran','8988777777'),(29,'ranjit','9876789878'),(30,'john','89878988889'),(31,'gautham','8787898989'),(35,'ahana','9809878909'),(36,'naina','9809878909'),(51,'dinesh','4365456567'),(52,'dinesh','4365456567'),(53,'kashim','8765678909'),(54,'suchitras','9878987898'),(55,'austin','9878987898'),(56,'namrata','9878987898'),(57,'suchitrass','9489988989'),(58,'austinaa','9489988989'),(59,'pinky','9489988989'),(60,'ss','4444444444'),(61,'satyar','4545454544'),(62,'danush','7898767897'),(63,'sachin','7896545678'),(64,'ad','3453456546'),(65,'fggdf','3453456546'),(66,'sachin','7898987896'),(67,'shettys','7898987896'),(68,'sachin','7898987896'),(69,'shettys','7898987896'),(70,'sachin','7898987896'),(71,'shettys','7898987896'),(72,'sachin','7898987896'),(73,'shettys','7898987896'),(74,'sachin','7898987896'),(75,'shettys','7898987896'),(76,'sachin','7898987896'),(77,'shettys','7898987896'),(78,'sachin','7898987896'),(79,'shettys','7898987896'),(80,'sachin','7898987896'),(81,'shettys','7898987896'),(82,'sachin','7898987896'),(83,'shettys','7898987896'),(84,'sachin','7898987896'),(85,'shettys','7898987896'),(86,'sachin','7898987896'),(87,'shettys','7898987896'),(88,'danush','7878787878'),(89,'sachin','9887657675'),(90,'kiran','9887657675');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(21) NOT NULL,
  `password` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('a@gmail.com','12345678','normaluser'),('aa@gmail.com','12345678','normaluser'),('arvindk@gmail.com','arvindk','normaluser'),('austina@gmail.com','austina','normaluser'),('darshan@gmail.com','darshan1234','normaluser'),('darshans@gmail.com','darshan12345','normaluser'),('ganesh@gmail.com','ganesh1234','normaluser'),('namrata@kpit.com','1234567','normaluser'),('pooja@gmail.com','pooja12345','normaluser'),('pustin@kpit.com','qwertyui','normaluser'),('qwerty@gmail.com','12345678','normaluser'),('Rachana@gmail.com','rachana','normaluser'),('samruddi@gmail.com','samruddi','normaluser'),('sonu@gmail.com','sonu12345','normaluser'),('suchhi@gmail.com','1234567','normaluser'),('suchi@gmail.com','1234567','normaluser'),('suchitras@gmail.com','suchitras','admin');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `director` varchar(45) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'bahubali ','rajmouli'),(2,'kirikparty','rishabh'),(5,'bahubali2','rajmouli'),(8,'snake in eagle\'s shadow','Yuen Woo-ping');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_details`
--

DROP TABLE IF EXISTS `passenger_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger_details` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `contact` varchar(12) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=3529 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_details`
--

LOCK TABLES `passenger_details` WRITE;
/*!40000 ALTER TABLE `passenger_details` DISABLE KEYS */;
INSERT INTO `passenger_details` VALUES (1,'suchitra',22,'female','9483309902'),(2,'austin',22,'male','9888888888'),(3429,'prasad',22,'male','345322'),(3430,'pallu',33,'female','345322'),(3431,'sonu',34,'female','435456'),(3432,'suckesh',22,'male','22324'),(3433,'sachin',22,'male','22324'),(3434,'arvind',25,'male','37872'),(3435,'suman',22,'female','37872'),(3436,'kusum',22,'female','3232'),(3437,'sanvi',22,'female','23456'),(3438,'pratham',22,'male','23455'),(3439,'karan',22,'male','12345'),(3440,'kiran',22,'male','12345'),(3441,'arjun',22,'male','22435'),(3442,'parth',22,'male','22435'),(3443,'ssanvi',44,'female','234566'),(3444,'vikram',22,'male','1121'),(3445,'shraddha',22,'female','1121'),(3446,'rajendra',33,'male','24235'),(3447,'joshi',22,'male','24235'),(3448,'ssanvis',11,'female','12432'),(3449,'amar',33,'male','13456'),(3450,'anthony',33,'male','13456'),(3451,'kailash',23,'male','89203873'),(3452,'sagar',22,'male','89203873'),(3453,'param',33,'male','626782'),(3454,'soumya',22,'female','235787'),(3455,'shree',23,'female','235787'),(3456,'danya',23,'female','235787'),(3457,'austina',34,'male','5467'),(3458,'kumar',22,'male','5762537'),(3459,'karunkumar',33,'male','4324535'),(3460,'sushma',22,'female','9748392938'),(3461,'sushma',12,'female','4465768'),(3462,'sushma',22,'female','35465786'),(3463,'sushma',33,'female','232435'),(3464,'kasturi',23,'female','676798765'),(3465,'rahul',23,'male','346457657'),(3466,'Ankita',23,'female','9876354673'),(3467,'Anu',23,'female','9876354673'),(3468,'Ankita',24,'female','347685709'),(3469,'anthony',23,'male','347685709'),(3470,'Ankita',23,'female','9876757654'),(3471,'Anu',22,'female','9876757654'),(3472,'aher',23,'female','9875675676'),(3473,'kaif',23,'male','9867566776'),(3474,'kaif',23,'male','9867566776'),(3475,'kavya',23,'female','9676676888'),(3476,'swati',22,'female','8765432332'),(3477,'janifer',23,'female','5369877867'),(3478,'janifer',23,'female','5369877867'),(3479,'janifer',23,'female','5369877867'),(3480,'janifer',23,'female','5369877867'),(3481,'janifer',23,'female','5369877867'),(3482,'janifer',23,'female','5369877867'),(3483,'janifer',23,'female','5369877867'),(3484,'janifer',23,'female','5369877867'),(3485,'janifer',23,'female','5369877867'),(3486,'anjali',23,'female','9787656754'),(3487,'rekha',22,'female','9876745467'),(3488,'rabi',32,'male','9876745467'),(3489,'fhm',54,'hjh','246'),(3490,'paru',23,'female','986754231'),(3491,'sai',12,'male','5456576451'),(3492,'johny',23,'male','987654323'),(3493,'johny',23,'male','987654323'),(3494,'suma',21,'female','9807654378'),(3495,'sagar',32,'male','9080706050'),(3496,'priyashre',23,'female','9879878762'),(3497,'thara',34,'female','8765476854'),(3498,'Ankitas',23,'female','9877899876'),(3499,'sushmad',23,'female','987654378'),(3500,'ganesh',23,'male','9876545678'),(3501,'ganesh',34,'male','8797656789'),(3502,'Ankitae',34,'male','8976867895'),(3503,'kavita',23,'female','9897865656'),(3504,'kavita',23,'female','9897865656'),(3505,'ganesh',78,'male','9865454556'),(3506,'ganesh',45,'male','98765678467'),(3507,'sonud',33,'female','8765434567'),(3508,'faran',23,'male','8765444444'),(3509,'adya',45,'female','9876543678'),(3510,'raghu',23,'male','9898989898'),(3511,'dhanushree',22,'female','9876564567'),(3512,'anu',33,'female','9876556789'),(3513,'saif',43,'male','9876676767'),(3514,'saifm',34,'male','8787878787'),(3515,'jai',34,'male','8987667898'),(3516,'yuvi',23,'male','9867586787'),(3517,'jaik',23,'male','876786678'),(3518,'danush',22,'male','987657890'),(3519,'arjund',23,'male','9809980784'),(3520,'gouri',22,'female','9878654677'),(3521,'prema',44,'female','8976567846'),(3522,'karunya',22,'female','9087894754'),(3523,'harry',32,'male','8999899898'),(3524,'ganesh',22,'male','4352323'),(3525,'suma',3,'male','4352323'),(3526,'chiru',22,'male','878987896'),(3527,'chiru',22,'male','878987896'),(3528,'radha',22,'female','7523456789');
/*!40000 ALTER TABLE `passenger_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `source` varchar(45) NOT NULL,
  `destination` varchar(45) NOT NULL,
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'pune','mumbai'),(2,'pune','dharwad');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screening`
--

DROP TABLE IF EXISTS `screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screening` (
  `screen_id` varchar(5) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `timing` varchar(45) NOT NULL,
  `show_id` varchar(5) NOT NULL,
  PRIMARY KEY (`show_id`,`screen_id`,`date`,`timing`,`movie_id`),
  KEY `fkey1_idx` (`movie_id`),
  CONSTRAINT `fkey1` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foriegn_key2` FOREIGN KEY (`show_id`) REFERENCES `auditorium_show_mapping` (`show_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screening`
--

LOCK TABLES `screening` WRITE;
/*!40000 ALTER TABLE `screening` DISABLE KEYS */;
INSERT INTO `screening` VALUES ('s1',1,'2017-05-26','morning','sh1'),('s1',1,'2017-05-26','evening','sh2'),('s1',2,'2017-05-26','morning','sh2'),('s3',8,'2017-05-26','evening','sh3');
/*!40000 ALTER TABLE `screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_allocation`
--

DROP TABLE IF EXISTS `seat_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_allocation` (
  `bus_number` varchar(7) NOT NULL,
  `seat_number` varchar(45) NOT NULL,
  `pid` int(11) NOT NULL,
  `date` date NOT NULL,
  `pickup_location` varchar(45) DEFAULT NULL,
  `drop_location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bus_number`,`seat_number`,`date`),
  KEY `f_keys2_idx` (`pid`),
  CONSTRAINT `f_keys1` FOREIGN KEY (`bus_number`) REFERENCES `bus` (`bus_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `f_keys2` FOREIGN KEY (`pid`) REFERENCES `passenger_details` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_allocation`
--

LOCK TABLES `seat_allocation` WRITE;
/*!40000 ALTER TABLE `seat_allocation` DISABLE KEYS */;
INSERT INTO `seat_allocation` VALUES ('sd6666','s1',3451,'2017-06-14','wakad','mumbai'),('sd6666','s13',3490,'2017-05-24','wakad','mumbai'),('sd6666','s13',3459,'2017-06-14','wakad','mumbai'),('sd6666','s14',3471,'2017-06-14','wakad','mumbai'),('sd6666','s17',3489,'2017-05-24','wakad','mumbai'),('sd6666','s17',3491,'2017-06-14','wakad','mumbai'),('sd6666','s18',3469,'2017-06-14','wakad','mumbai'),('sd6666','s19',3507,'2017-06-14','wakad','mumbai'),('sd6666','s2',3475,'2017-06-14','wakad','mumbai'),('sd6666','s20',3464,'2017-06-14','wakad','mumbai'),('sd6666','s22',3486,'2017-06-14','wakad','mumbai'),('sd6666','s23',3519,'2017-06-14','pimpri','navimumbai'),('sd6666','s24',3501,'2017-05-17','wakad','mumbai'),('sd6666','s25',3500,'2017-05-17','wakad','mumbai'),('sd6666','s26',3465,'2017-05-17','wakad','mumbai'),('sd6666','s27',3502,'2017-05-17','wakad','mumbai'),('sd6666','s27',3494,'2017-05-24','wakad','mumbai'),('sd6666','s28',3508,'2017-05-17','wakad','mumbai'),('sd6666','s29',3476,'2017-05-15','wakad','mumbai'),('sd6666','s29',3495,'2017-05-17','wakad','mumbai'),('sd6666','s3',3499,'2017-05-17','wakad','mumbai'),('sd6666','s30',3498,'2017-05-17','wakad','mumbai'),('sd6666','s31',3477,'2017-05-17','wakad','mumbai'),('sd6666','s31',3487,'2017-05-24','wakad','mumbai'),('sd6666','s32',3492,'2017-06-14','wakad','mumbai'),('sd6666','s33',3509,'2017-06-14','wakad','mumbai'),('sd6666','s34',3528,'2017-05-24','pimpri','thane'),('sd6666','s34',3496,'2017-06-14','wakad','mumbai'),('sd6666','s35',3488,'2017-05-24','wakad','mumbai'),('sd6666','s36',3472,'2017-06-14','wakad','mumbai'),('sd6666','s38',3497,'2017-06-14','wakad','mumbai'),('sd6666','s40',3523,'2017-06-14','pune','mumbai'),('sd6666','s5',3455,'2017-05-24','wakad','mumbai'),('sd6666','s6',3456,'2017-05-24','wakad','mumbai'),('sd6666','s6',3473,'2017-06-14','wakad','mumbai'),('sd6666','s7',3526,'2017-05-24','lonavala','dombivli'),('sd6666','s7',3458,'2017-06-14','wakad','mumbai'),('sd6666','s9',3466,'2017-05-22','wakad','mumbai'),('sd6666','s9',3470,'2017-06-14','wakad','mumbai'),('su1234','s10',3506,'2017-06-14','wakad','dharwad'),('su1234','s2',3522,'2017-06-14','pune','mumbai'),('su1234','s25',3503,'2017-06-14','wakad','dharwad'),('su1234','s26',3524,'2017-05-31','wakad','mumbai'),('su1234','s27',3525,'2017-05-31','wakad','mumbai'),('su1234','s30',3505,'2017-06-14','wakad','dharwad');
/*!40000 ALTER TABLE `seat_allocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_reservation`
--

DROP TABLE IF EXISTS `seat_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_reservation` (
  `seat_reservation_id` int(11) NOT NULL,
  `show_id` varchar(5) NOT NULL,
  `seatnumber` varchar(5) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`seatnumber`,`show_id`),
  KEY `fk2_idx` (`show_id`),
  KEY `fk1_idx` (`customer_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk5` FOREIGN KEY (`show_id`) REFERENCES `screening` (`show_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_reservation`
--

LOCK TABLES `seat_reservation` WRITE;
/*!40000 ALTER TABLE `seat_reservation` DISABLE KEYS */;
INSERT INTO `seat_reservation` VALUES (7,'sh1','s10',59),(2,'sh1','s15',20),(3,'sh1','s3',21),(1,'sh1','s30',17),(8,'sh2','s39',60),(6,'sh1','s56',35),(6,'sh1','s57',36),(9,'sh3','s67',89),(9,'sh3','s68',12),(4,'sh1','s76',29),(5,'sh1','s77',30),(7,'sh1','s8',57),(7,'sh1','s9',58);
/*!40000 ALTER TABLE `seat_reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-21 18:02:36
