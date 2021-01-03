-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  `introduct` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Ulrica',500,'001.jpg','Ulrica is one of new products of our company, which is an electronic guide dog designed for blind people to travel. With environmentally conscious design and natural exterior, our product is characteristic of high response speed, high stability, good interactivity and low cost. The product is based on Bluetooth Application, IR remote control, ultrasound obstacle-avoidance mode, voice control mode and so on. According to market research, there are few high-end products in this industry, which makes our product highly competitive.'),(2,'18650 super fire battery',18,'002.jpg','18650 battery, single section 3.7v, can be reused after charging, responsible for providing the drive module with about 7v DC voltage, and powering the motor through the drive module, thus achieving the function of driving the car.'),(3,'Arduino uno',300,'003.jpg','Arduino uno board, providing 13 data interfaces, a pair of tx, rx interface, 5 analog interfaces, three grounding ports, a 3.3v interface, a 5v interface, can connect to the computer through the usb cable and use the arduino ide to the board Programming operation. It can interact with multiple sensors to sense multiple signals in the environment and output electrical signals to a variety of specified modules through a hardware language similar to c language to achieve interaction with the user.'),(4,'usb 数据线',10,'004.jpg','Usb data line, full name usb to square port data line, can achieve the data connection of arduino full series of circuit boards and computers to complete the data transmission and programming tasks, it can also connect the circuit board and charging treasure to achieve the circuit Board power supply function.'),(5,'infrared remote control',20,'005.jpg','Infrared remote control, with 21 buttons, we can use this remote control to control the movement of the car before and after, the movement of a certain angle, the display content of the lcd1602 display, the switching of the obstacle avoidance mode, and the switch of the cooling fan.'),(6,'battery case',50,'006.jpg','The battery case, specially designed for the 18650 battery, fits perfectly with the size of the 18650 battery, has good insulation and heat dissipation, and the reasonable shape design ensures that we can remove the battery in the first time.'),(7,'bread board',20,'007.jpg','The breadboard, the breadboard and the breadboard on Ulrica are from the same manufacturer. Its main function is the expansion of components. In view of the limited functions that the original car can achieve, you can use this interface to expand the breadboard. The method of use will be described in detail in the manual.'),(8,'Voice module',50,'008.jpg','The speech recognition module is a module based on embedded speech recognition technology, which mainly includes a speech recognition chip and some other auxiliary circuits, which can conveniently communicate with the main control chip, and the developer can conveniently embed the module into himself. Used in the product to achieve the purpose of voice interaction.'),(9,'Model shell',25,'009.jpg','This is the outer casing of our smart guide dog, which can be replaced when the product shell you purchased is damaged.');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderinfo` (
  `orderid` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `id` varchar(45) DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `ordertime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES (1,'q123456','5','Arduino uno',300,'2019-09-12 21:04:12'),(3,'a123456','1','18650 super fire battery',18,'2019-09-12 21:08:35'),(4,'a123456','|2(2)|3(1)','|Arduino uno(2)|usb 数据线(1)',610,'2019-09-16 12:31:13'),(5,'jsp201912','|2(1)|3(1)','|18650 super fire battery(1)|Arduino uno(1)',318,'2019-09-25 14:11:06'),(6,'jsp201813','3','Arduino uno',300,'2019-09-25 15:01:34');
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoppingcart` (
  `username` varchar(45) NOT NULL,
  `id` varchar(45) NOT NULL,
  `product` varchar(45) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
INSERT INTO `shoppingcart` VALUES ('jsp201813','2','18650 super fire battery',1,18);
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userinfo` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `paypassword` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('a123456','123qwe','123qwe','123@qq.com'),('jp123456','123456','123qwe','123456@qq.com'),('jsp201813','12345678','12345678','48488057@qq.com'),('jsp201912','12345678','12345678','494980184@qq.com'),('ll1234','ll1234','ll1234','qaz123@qq.com'),('q123456','123qwe','123456','1234567@qq.com');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'shopping'
--

--
-- Dumping routines for database 'shopping'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-26 18:48:42
