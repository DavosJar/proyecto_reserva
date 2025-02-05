/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.7.1-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: reserva
-- ------------------------------------------------------
-- Server version	11.7.1-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Current Database: `reserva`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `reserva` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;

USE `reserva`;

--
-- Table structure for table `accidente`
--

DROP TABLE IF EXISTS `accidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accidente` (
  `id_accidente` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_vehiculo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_accidente`),
  KEY `id_vehiculo` (`id_vehiculo`),
  CONSTRAINT `accidente_ibfk_1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accidente`
--

LOCK TABLES `accidente` WRITE;
/*!40000 ALTER TABLE `accidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `accidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquiler` (
  `id_alquiler` int(11) NOT NULL AUTO_INCREMENT,
  `estado_alquiler` varchar(25) DEFAULT 'disponible',
  `fecha_devolucion` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `costo_dia` varchar(30) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_alquiler`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_usuario` int(11) NOT NULL,
  `esta_habilitado` varchar(10) DEFAULT '10',
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `id_cuenta` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(30) DEFAULT NULL,
  `contrasenia` varchar(30) DEFAULT NULL,
  `nombre_usuario` varchar(20) DEFAULT NULL,
  `estado` varchar(15) DEFAULT 'activo',
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cuenta`),
  UNIQUE KEY `correo` (`correo`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id_direccion` int(11) NOT NULL AUTO_INCREMENT,
  `calle` text DEFAULT NULL,
  `numero` text DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `numero_factura` int(11) DEFAULT NULL,
  `fecha_emision` date DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `id_alquiler` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  UNIQUE KEY `numero_factura` (`numero_factura`),
  KEY `id_alquiler` (`id_alquiler`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_alquiler`) REFERENCES `alquiler` (`id_alquiler`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licencia`
--

DROP TABLE IF EXISTS `licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licencia` (
  `id_licencia` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) DEFAULT NULL,
  `fecha_caducidad` date DEFAULT NULL,
  `fecha_expedicion` date DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_licencia`),
  UNIQUE KEY `codigo` (`codigo`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `licencia_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licencia`
--

LOCK TABLES `licencia` WRITE;
/*!40000 ALTER TABLE `licencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodo_pago`
--

DROP TABLE IF EXISTS `metodo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metodo_pago` (
  `id_metodo_pago` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_metodo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo_pago`
--

LOCK TABLES `metodo_pago` WRITE;
/*!40000 ALTER TABLE `metodo_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `metodo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(40) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` varchar(10) DEFAULT NULL,
  `nombre_sucursal` varchar(30) DEFAULT NULL,
  `id_direccion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sucursal`),
  KEY `id_direccion` (`id_direccion`),
  CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `id_telefono` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_telefono`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabaja`
--

DROP TABLE IF EXISTS `trabaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabaja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_sucursal` (`id_sucursal`),
  CONSTRAINT `trabaja_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `trabaja_ibfk_2` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabaja`
--

LOCK TABLES `trabaja` WRITE;
/*!40000 ALTER TABLE `trabaja` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traspaso`
--

DROP TABLE IF EXISTS `traspaso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traspaso` (
  `id_traspaso` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  `resposanble` varchar(50) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_sucursal` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_traspaso`),
  KEY `id_sucursal` (`id_sucursal`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `traspaso_ibfk_1` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  CONSTRAINT `traspaso_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traspaso`
--

LOCK TABLES `traspaso` WRITE;
/*!40000 ALTER TABLE `traspaso` DISABLE KEYS */;
/*!40000 ALTER TABLE `traspaso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usa`
--

DROP TABLE IF EXISTS `usa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usa` (
  `id_usa` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) DEFAULT NULL,
  `id_metodo_pago` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usa`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_metodo_pago` (`id_metodo_pago`),
  CONSTRAINT `usa_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `usa_ibfk_2` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id_metodo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usa`
--

LOCK TABLES `usa` WRITE;
/*!40000 ALTER TABLE `usa` DISABLE KEYS */;
/*!40000 ALTER TABLE `usa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `id_direccion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `dni` (`dni`),
  KEY `id_direccion` (`id_direccion`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usurio_interno`
--

DROP TABLE IF EXISTS `usurio_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usurio_interno` (
  `id_usuario` int(11) NOT NULL,
  `departamento` varchar(30) DEFAULT NULL,
  `puesto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `usurio_interno_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usurio_interno`
--

LOCK TABLES `usurio_interno` WRITE;
/*!40000 ALTER TABLE `usurio_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `usurio_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(6) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  `capacidad_personas` int(11) DEFAULT NULL,
  `year_fabricacion` int(11) DEFAULT NULL,
  `estado` varchar(30) DEFAULT 'disponible',
  `marca` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES
(1,'ABC123','Modelo A',5,2020,'disponible','Marca 1'),
(2,'DEF456','Modelo B',4,2019,'disponible','Marca 2'),
(3,'GHI789','Modelo C',7,2021,'disponible','Marca 3'),
(4,'JKL012','Modelo D',5,2018,'disponible','Marca 4'),
(5,'MNO345','Modelo E',5,2022,'disponible','Marca 5'),
(6,'PQR678','Modelo F',4,2017,'disponible','Marca 6'),
(7,'STU901','Modelo G',8,2020,'disponible','Marca 7'),
(8,'VWX234','Modelo H',6,2019,'disponible','Marca 8'),
(9,'YZA567','Modelo I',7,2021,'disponible','Marca 9'),
(10,'BCD890','Modelo J',5,2023,'disponible','Marca 10'),
(11,'ABC124','Corolla',NULL,NULL,'disponible','Toyota'),
(12,'ABC126','Corolla',NULL,NULL,'disponible','Toyota'),
(13,'ABC128','Corolla',NULL,NULL,'disponible','Toyota'),
(14,'ABC129','Corolla',NULL,NULL,'disponible','Toyota'),
(15,'ABC121','Corolla',NULL,NULL,'ocupado','Toyota'),
(16,'ABC119','Corolla',5,2022,'ocupado','Toyota');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-02-05 14:14:06
