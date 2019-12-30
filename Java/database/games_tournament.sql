-- MySQL dump 10.14  Distrib 5.5.64-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: games_tournament
-- ------------------------------------------------------
-- Server version	5.5.64-MariaDB

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
-- Table structure for table `consolas`
--

DROP TABLE IF EXISTS `consolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consolas` (
  `consola_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `firmware` varchar(10) NOT NULL,
  PRIMARY KEY (`consola_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consolas`
--

LOCK TABLES `consolas` WRITE;
/*!40000 ALTER TABLE `consolas` DISABLE KEYS */;
INSERT INTO `consolas` VALUES (1,'Nintendo Wii U','5.0.0'),(2,'Nintendo Switch','9.0.0'),(3,'Play Station 3','4.3.8');
/*!40000 ALTER TABLE `consolas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfrentamientos`
--

DROP TABLE IF EXISTS `enfrentamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfrentamientos` (
  `enfrentamiento_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` char(1) NOT NULL,
  `ubicacion` varchar(20) NOT NULL,
  `horaInicio` datetime NOT NULL,
  `horaFin` datetime NOT NULL,
  `videojuego_id` int(11) NOT NULL,
  `torneo_id` int(11) NOT NULL,
  PRIMARY KEY (`enfrentamiento_id`),
  KEY `videojuego_id` (`videojuego_id`),
  KEY `enfrentamientos_torneos_idx` (`torneo_id`),
  CONSTRAINT `enfrentamientos_ibfk_1` FOREIGN KEY (`videojuego_id`) REFERENCES `videojuegos` (`videojuego_id`),
  CONSTRAINT `enfrentamientos_torneos` FOREIGN KEY (`torneo_id`) REFERENCES `torneos` (`torneo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfrentamientos`
--

LOCK TABLES `enfrentamientos` WRITE;
/*!40000 ALTER TABLE `enfrentamientos` DISABLE KEYS */;
INSERT INTO `enfrentamientos` VALUES (1,'A','Plaza 1','2019-11-18 11:11:11','2019-11-18 11:26:00',1,3),(2,'A','Plaza 2','2019-11-18 11:01:01','2019-11-18 11:36:00',2,1),(3,'E','Plaza 3','2019-11-18 11:01:01','2019-11-18 11:16:00',2,1),(4,'E','Plaza 3','2019-11-18 11:01:01','2019-11-18 11:22:00',2,1),(5,'C','Plaza 4','2019-11-18 11:01:01','2019-11-18 11:22:00',3,2),(6,'C','Plaza 5','2019-11-18 11:01:01','2019-11-18 11:42:00',3,2);
/*!40000 ALTER TABLE `enfrentamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipos` (
  `equipo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`equipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES (1,'Los Gatos'),(2,'Asesinos'),(3,'Figuras Retóricas'),(4,'Maestros del Orden'),(5,'Amos del Desorden'),(6,'Señores de la Armonía'),(7,'Las Tres Suegras'),(8,'Equipo Maravilla'),(9,'La Liga de la Verdad'),(10,'Team Hackers'),(11,'AAAAAAAAAA'),(12,'Doom'),(13,'Mood'),(14,'Ojo de Tigre'),(15,'Dragones'),(16,'Hinchas'),(17,'Máxima Intensidad'),(18,'anais95'),(19,'ilvagunner'),(20,'JaredThePro'),(21,'Juanito888'),(22,'tres_bien'),(23,'ko-ni-chi-wa'),(24,'lolaLaDestructora'),(25,'jaja');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participantes` (
  `participante_id` int(11) NOT NULL AUTO_INCREMENT,
  `tarjeta_id` int(11) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `edad` smallint(6) NOT NULL,
  `genero` char(1) DEFAULT NULL,
  `email` varchar(35) NOT NULL,
  `equipo_id` int(11) NOT NULL,
  PRIMARY KEY (`participante_id`),
  KEY `equipo_id` (`equipo_id`),
  CONSTRAINT `participantes_ibfk_1` FOREIGN KEY (`equipo_id`) REFERENCES `equipos` (`equipo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES (1,111111,'Pepa Alberta','Gomez Gomez',15,'F','jaja@jaja.com',25),(2,10124,'Lola','Archundia',19,'F','loladestruye@hotmail.com',24),(3,10134,'Koni','Chiwa',29,'F','ggg@hotmail.com',23),(4,10234,'Pierre','Lorentz',33,'M','pierre@hotmail.com',22),(5,10534,'Juan','Aguirre',18,'M','juanirre@hotmail.com',21),(6,10534,'Jared','Knanbnauer',28,'M','jthepro@gmail.com',20),(7,11534,'Silva','Anbnauer',22,'F','ilva@gmail.com',19),(8,12534,'Anais','Water',24,'F','anaisw@gmail.com',18),(9,13534,'Pepe','Candy',24,'M','pepecandy@gmail.com',17),(10,13534,'Martin','Candy',22,'M','martincandy@gmail.com',17),(11,13534,'Pipe','Bueno',19,'M','pipey@gmail.com',16),(12,13534,'Gustavo','Niño',49,'M','epey@gmail.com',16),(13,13534,'Carlos','Celeste',24,'M','ccc@gmail.com',15),(14,13534,'Zhen','Yu',24,'M','zy@gmail.com',15);
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntajes`
--

DROP TABLE IF EXISTS `puntajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntajes` (
  `equipo_id` int(11) NOT NULL,
  `enfrentamiento_id` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL,
  PRIMARY KEY (`equipo_id`,`enfrentamiento_id`),
  KEY `enfrentamiento_id` (`enfrentamiento_id`),
  CONSTRAINT `PUNTAJES_ibfk_1` FOREIGN KEY (`equipo_id`) REFERENCES `equipos` (`equipo_id`),
  CONSTRAINT `PUNTAJES_ibfk_2` FOREIGN KEY (`enfrentamiento_id`) REFERENCES `enfrentamientos` (`enfrentamiento_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntajes`
--

LOCK TABLES `puntajes` WRITE;
/*!40000 ALTER TABLE `puntajes` DISABLE KEYS */;
INSERT INTO `puntajes` VALUES (15,1,5),(15,2,5),(15,4,8),(16,1,2),(16,2,2),(16,3,3),(17,1,4),(17,3,2),(17,4,18),(18,1,1),(22,1,30),(23,1,15),(24,1,13),(25,1,8);
/*!40000 ALTER TABLE `puntajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneos`
--

DROP TABLE IF EXISTS `torneos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torneos` (
  `torneo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`torneo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneos`
--

LOCK TABLES `torneos` WRITE;
/*!40000 ALTER TABLE `torneos` DISABLE KEYS */;
INSERT INTO `torneos` VALUES (1,'Torneo Municipal de Smash Bros Ultimate por equipo'),(2,'Amistoso Regional de TF2 por equipos'),(3,'Copa de Mario Kart 8 Wii U');
/*!40000 ALTER TABLE `torneos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos`
--

DROP TABLE IF EXISTS `videojuegos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videojuegos` (
  `videojuego_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `version` varchar(10) NOT NULL,
  PRIMARY KEY (`videojuego_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos`
--

LOCK TABLES `videojuegos` WRITE;
/*!40000 ALTER TABLE `videojuegos` DISABLE KEYS */;
INSERT INTO `videojuegos` VALUES (1,'Mario Kart 8','2.0.1'),(2,'Smash Bros. Ultimate','1.5.8'),(3,'TEAM FORTRESS 2','1.9.8');
/*!40000 ALTER TABLE `videojuegos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videojuegos_consolas`
--

DROP TABLE IF EXISTS `videojuegos_consolas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `videojuegos_consolas` (
  `videojuego_id` int(11) NOT NULL,
  `consola_id` int(11) NOT NULL,
  PRIMARY KEY (`videojuego_id`,`consola_id`),
  KEY `consola_id` (`consola_id`),
  CONSTRAINT `videojuegos_consolas_ibfk_1` FOREIGN KEY (`videojuego_id`) REFERENCES `videojuegos` (`videojuego_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `videojuegos_consolas_ibfk_2` FOREIGN KEY (`consola_id`) REFERENCES `consolas` (`consola_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videojuegos_consolas`
--

LOCK TABLES `videojuegos_consolas` WRITE;
/*!40000 ALTER TABLE `videojuegos_consolas` DISABLE KEYS */;
/*!40000 ALTER TABLE `videojuegos_consolas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-30 15:53:52
