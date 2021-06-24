-- MySQL dump 10.13  Distrib 5.7.21, for macos10.13 (x86_64)
--
-- Host: localhost    Database: interview_schedule_system
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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `department_code` varchar(255) NOT NULL,
  `department_name` varchar(255) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_89g8qie2y696a3tarmty43sq9` (`department_code`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'2021-06-17 13:10:23','00','総務管理部',0,'2021-06-17 14:36:52'),(2,'2021-06-17 13:14:35','01','営業部',0,'2021-06-17 14:46:49'),(3,'2021-06-17 14:47:09','02','仙台事業部',0,'2021-06-17 14:47:09'),(4,'2021-06-17 14:47:32','03','第一システム開発部',0,'2021-06-17 14:47:32'),(5,'2021-06-17 14:48:01','04','第二システム開発部',0,'2021-06-17 14:48:01'),(6,'2021-06-17 17:31:59','05','人事部',1,'2021-06-17 17:32:12');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_flag` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `employee_code` varchar(4) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `is_deleted` int(11) NOT NULL,
  `password` varchar(64) NOT NULL,
  `updated_at` datetime NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_etqhw9qqnad1kyjq3ks1glw8x` (`employee_code`),
  KEY `FKgy4qe3dnqrm3ktd76sxp7n4c2` (`department_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,1,'2021-06-17 16:35:37','0000','細矢隆明',0,'5902BB407DC19D9CA6DF3D18908B47039A2A0715012D2734633866EB0E95A514','2021-06-24 12:21:21',1),(2,0,'2021-06-17 17:33:25','0001','銘苅 穂菜美',0,'43238450C7D4D929E14D6A12A84941D44C26FBDC11D2769C6F8CE54979D26EBC','2021-06-24 12:56:25',1),(3,0,'2021-06-18 13:54:32','0003','田 イッシン',0,'3479606A7D3C0DD6E94836D4D584EB25102F0841FB76352DF7A61F24A5BC96F5','2021-06-24 12:23:26',2),(4,0,'2021-06-24 09:51:42','0005','蔵田 剛',0,'A3F91A2B3620E79024D75962DE8C5D649B0A1C38B4BA96E469B43B41A220E77D','2021-06-24 12:25:59',4),(5,0,'2021-06-24 11:35:11','0002','安田 純',0,'FD5183647082E50E0C0AAD032DC608CE591D147E49123664EB194FA385B35862','2021-06-24 12:25:07',2),(6,0,'2021-06-24 12:24:55','0004','山内 陸生',0,'71A66C5F969BF2C29AFD47EE34954D062738ECBEAF70B45C5B98BB70809964DC','2021-06-24 12:25:16',2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aspiration_situation` int(11) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `first_interview_date` date DEFAULT NULL,
  `first_interview_format` int(11) DEFAULT NULL,
  `first_interview_id` varchar(255) DEFAULT NULL,
  `first_interview_password` varchar(255) DEFAULT NULL,
  `first_interview_scheduled_date` date DEFAULT NULL,
  `first_interview_scheduled_time` time DEFAULT NULL,
  `first_interview_time` time DEFAULT NULL,
  `first_interview_tool` varchar(255) DEFAULT NULL,
  `first_interview_url` varchar(255) DEFAULT NULL,
  `interview_situation` int(11) DEFAULT NULL,
  `introduce_date` date DEFAULT NULL,
  `is_deleted` int(11) NOT NULL,
  `number_of_interviews` int(11) DEFAULT NULL,
  `ordering_company` varchar(255) NOT NULL,
  `pass_fail_status` int(11) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `project_overview` longtext NOT NULL,
  `project_title` varchar(255) NOT NULL,
  `second_interview_date` date DEFAULT NULL,
  `second_interview_format` int(11) DEFAULT NULL,
  `second_interview_id` varchar(255) DEFAULT NULL,
  `second_interview_password` varchar(255) DEFAULT NULL,
  `second_interview_scheduled_date` date DEFAULT NULL,
  `second_interview_scheduled_time` time DEFAULT NULL,
  `second_interview_time` time DEFAULT NULL,
  `second_interview_tool` varchar(255) DEFAULT NULL,
  `second_interview_url` varchar(255) DEFAULT NULL,
  `supplement` longtext NOT NULL,
  `updated_at` datetime NOT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `employee_id` int(11) NOT NULL,
  `sales_employee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk1xoduufw1mu7ywao2xg90g3f` (`employee_id`),
  KEY `FKsyvd73osd0is9qabalyxl5wu` (`sales_employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,NULL,'2021-06-24 13:39:06',NULL,NULL,'','',NULL,NULL,NULL,'','',NULL,'2021-06-24',0,NULL,'富士通',NULL,'人形町',NULL,'','i',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-24 13:39:06','',1,6);
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-24 13:46:15
