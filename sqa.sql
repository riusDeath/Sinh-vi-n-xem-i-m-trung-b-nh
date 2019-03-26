-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xemdiemthi
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

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
-- Table structure for table `cau_hinh`
--

DROP TABLE IF EXISTS `cau_hinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cau_hinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chuyen_can` float DEFAULT NULL,
  `thuc_hanh` float DEFAULT NULL,
  `kiem_tra` float DEFAULT NULL,
  `bao_tap_lon` float DEFAULT NULL,
  `cuoi_ky` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cau_hinh`
--

LOCK TABLES `cau_hinh` WRITE;
/*!40000 ALTER TABLE `cau_hinh` DISABLE KEYS */;
INSERT INTO `cau_hinh` VALUES (1,0.1,0,0.2,0.2,0.5);
/*!40000 ALTER TABLE `cau_hinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cau_hinh` int(11) NOT NULL,
  `id_sinh_vien` int(11) NOT NULL,
  `id_mon_hoc` int(11) NOT NULL,
  `chuyen_can` double DEFAULT NULL,
  `kiem_tra` double DEFAULT NULL,
  `thuc_hanh` double DEFAULT NULL,
  `bai_tap_lon` double DEFAULT NULL,
  `cuoi_ky` double DEFAULT NULL,
  `tk` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cau_hinh_idx` (`id_cau_hinh`),
  KEY `fk_sinh_vien_idx` (`id_sinh_vien`),
  KEY `fk_mon_hoc_idx` (`id_mon_hoc`),
  CONSTRAINT `fk_cau_hinh` FOREIGN KEY (`id_cau_hinh`) REFERENCES `cau_hinh` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sinh_vien` FOREIGN KEY (`id_sinh_vien`) REFERENCES `sinhvien` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_hoc`
--

DROP TABLE IF EXISTS `mon_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mon_hoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_mon_hoc` varchar(45) NOT NULL,
  `nganh_hoc` varchar(45) NOT NULL,
  `ky_hoc` int(11) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_hoc`
--

LOCK TABLES `mon_hoc` WRITE;
/*!40000 ALTER TABLE `mon_hoc` DISABLE KEYS */;
INSERT INTO `mon_hoc` VALUES (1,'SQA','CNPM',8,3),(2,'KTPM','CNPM',8,3),(3,'LTM','CNPM',7,3),(4,'ANDROID','CNPM',8,3);
/*!40000 ALTER TABLE `mon_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sinhvien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ma_sinh_vien` varchar(45) NOT NULL,
  `ho_ten` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `lop` varchar(45) NOT NULL,
  `khoa` varchar(45) NOT NULL,
  `ngay_sinh` datetime NOT NULL,
  `gioi_tinh` int(11) NOT NULL,
  `que_quan` varchar(45) NOT NULL,
  `he_dao_tao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (1,'b15dccn545','nguyễn đức thuận','123','b15cqcn6','cntt','0000-00-00 00:00:00',1,'bắc ninh','đại học chính quy');
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'xemdiemthi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-26 21:54:03
