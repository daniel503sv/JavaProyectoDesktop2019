-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_incidente` int(11) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `porcentaje` int(11) DEFAULT '0',
  `documento` blob,
  `creado_el` date DEFAULT NULL,
  `actualizado_el` date DEFAULT NULL,
  `detalle` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_bitacora_usuario1_idx` (`usuario`),
  CONSTRAINT `fk_bitacora_usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
INSERT INTO `bitacora` VALUES (2,4,6,15,NULL,'2019-04-05',NULL,'primer bitacora'),(3,4,6,10,NULL,'2019-04-05',NULL,'segunda  bitacora'),(4,4,6,74,NULL,'2019-04-05',NULL,'gran avance'),(5,4,6,1,NULL,'2019-04-05',NULL,'ultima bitacora');
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `usuario` int(11) DEFAULT NULL,
  `bitacora_id` int(11) DEFAULT NULL,
  `creado_el` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comentario_usuario1_idx` (`usuario`),
  KEY `fk_comentario_bitacora1_idx` (`bitacora_id`),
  CONSTRAINT `fk_comentario_bitacora1` FOREIGN KEY (`bitacora_id`) REFERENCES `bitacora` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentario_usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'IT','Area de tecnologia'),(2,'Recursos Humanos','Area de RH'),(3,'Administración','Area administrativa'),(4,'Facturacion movil','Area de facturacion movil');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `desarrollador` int(11) DEFAULT NULL,
  `probador` int(11) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `id_proyecto` int(11) NOT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  `detalle_caso` varchar(45) DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_incidente_proyecto1_idx` (`id_proyecto`),
  CONSTRAINT `fk_incidente_proyecto1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (3,'incidente','asadfsadf',0,0,'2019-04-05',1,1,NULL,'dedsds',NULL),(4,'incidente 2','tes',6,4,'2019-04-05',2,1,'RE050419407','desc','2018-12-31'),(5,'incidente 3','gedad',0,0,'2019-04-05',1,1,NULL,NULL,NULL),(6,'test','test',19,8,'2019-04-05',2,4,'FA050419728','pruebas','2018-12-31'),(7,'testeo','desc test',0,0,'2019-04-05',1,5,NULL,NULL,NULL);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `documento` blob,
  `encargado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_proyecto_usuario1_idx` (`encargado`),
  KEY `fk_proyecto_departamento1_idx` (`departamento`),
  CONSTRAINT `fk_proyecto_departamento1` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_proyecto_usuario1` FOREIGN KEY (`encargado`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'pr0','proy RH',2,NULL,3),(2,'pr2','desc',2,NULL,3),(3,'pr1','desc1',2,NULL,3),(4,'proyectoFacturacion','nuevo modulo',4,NULL,7),(5,'proyectoAdmon','correccion de bugs',3,NULL,10);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'SYSTEM','rol administrador'),(2,'Administrador','Encargado de usuarios y departamentos'),(3,'Jefe de Area','Encargado de crear incidentes y observar los avances de estos'),(4,'Empleado','Probador de las soluciones, puede ver el avance de los mismos y aprobar la solucion'),(5,'Jefe de Desarrollo','Encargado de asignar los incidentes a los programadores'),(6,'Programador','Encargado de crear las soluciones al incidente dejando constancia en forma de bitacora y avance');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `departamento_id` int(11) DEFAULT NULL,
  `rol_id` int(11) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_departamento_idx` (`departamento_id`),
  KEY `fk_usuario_rol1_idx` (`rol_id`),
  CONSTRAINT `fk_usuario_departamento` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Carlos','Sanchez','admin','2292-3366','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',1,1,'2019-03-29'),(2,'usuario rh','administrador','admin@rh.com','22445577','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2,2,'2019-04-05'),(3,'user jefe','rech','jefe@rh.com','55449966','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2,3,'2019-04-05'),(4,'user emp','emprh','emp@rh.com','88778855','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2,4,'2019-04-05'),(5,'jefe des','rh','des@rh.com','77889895','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2,5,'2019-04-05'),(6,'user prog','prgrh','prog@rh.com','778855445','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2,6,'2019-04-05'),(7,'pepito','sanchez','pepito@rh.com','45324565','c8cdf720db5562a039be5d81c51a07c5120eaf0bf142b2144f1a1eb7a95678d3',4,3,'2019-04-05'),(8,'miguel','bonilla','miguel@rh.com','76531234','5ef68465886fa04d3e0bbe86b59d964dd98e5775e95717df978d8bedee6ff16c',4,4,'2019-04-05'),(9,'azucena','garcia','azucena@rh.com','45678903','5e5509e2ff1ad330ed03fdd3f210515c3d2a6d046efcb77151754472a7d5632a',3,4,'2019-04-05'),(10,'laura','escalante','laura@rh.com','12340987','5d702eb07928ed7b84626b777c86c39bf4cb403d4024f031d5f97a4b0664421f',3,3,'2019-04-05'),(11,'isabel','mejia','isabel@rh.com','45368790','eb5094069f5e287ad7cfce5fc944f1c6565da2481af83fd5c24568e2481d09e3',1,6,'2019-04-05'),(12,'rafael','herrera','rafael@rh.com','34567891','79063e8037fff16d297a1fe65136f1251126cddb2cc9870ecf8d653835538e85',1,6,'2019-04-05'),(13,'daniel','jimenez','daniel@rh.com','65430967','e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855',1,3,'2019-04-05'),(14,'jose','alas','jose@rh.com','12430978','1ec4ed037766aa181d8840ad04b9fc6e195fd37dedc04c98a5767a67d3758ece',1,5,'2019-04-05'),(15,'oscar','lopez','oscar@rh.com','45657687','f5a1971c2ef02a5ab2263f20895b14e7ac1607d21d28805ca8a7ed31ef802364',3,6,'2019-04-05'),(16,'david','polanco','david@rh.com','78905678','07d046d5fac12b3f82daf5035b9aae86db5adc8275ebfbf05ec83005a4a8ba3e',3,5,'2019-04-05'),(17,'victoria','sigÃ¼enza','victoria@rh.com','45670912','ab1cb712f2dca756105160805501f4d6d8657d93d40b16eee4ecb5fd048d26eb',1,2,'2019-04-05'),(18,'anabell','diaz','anabell@rh.com','234565343','1d8dd86687f10bbdeff9edc863382bb9cc13465f8ab1bfd485ba0afba23b43cf',4,5,'2019-04-05'),(19,'isaac','portillo','isaac@rh.com','89673421','1fd6227a465211891ddf2da7cd8b8f143097d5ebefa804e65afe3724ee127a20',4,6,'2019-04-05'),(20,'javier','aparicio','javier@rh.com','67453212','384dac3368de6f658d7bc66e8fd4c8206b91c17a9084498948c7dd6e44d4a055',4,2,'2019-04-05');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-05 17:25:05
