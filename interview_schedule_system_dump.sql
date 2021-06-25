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
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'2021-06-17 13:10:23','00','総務管理部',0,'2021-06-17 14:36:52'),(2,'2021-06-17 13:14:35','01','営業部',0,'2021-06-17 14:46:49'),(3,'2021-06-17 14:47:09','02','仙台事業部',0,'2021-06-17 14:47:09'),(4,'2021-06-17 14:47:32','03','第一システム開発部',0,'2021-06-17 14:47:32'),(5,'2021-06-17 14:48:01','04','第二システム開発部',0,'2021-06-24 19:10:49');
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
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,1,'2021-06-17 16:35:37','0000','細矢隆明',0,'5902BB407DC19D9CA6DF3D18908B47039A2A0715012D2734633866EB0E95A514','2021-06-24 12:21:21',1),(2,0,'2021-06-17 17:33:25','0001','銘苅 穂菜美',0,'43238450C7D4D929E14D6A12A84941D44C26FBDC11D2769C6F8CE54979D26EBC','2021-06-24 18:00:23',1),(3,0,'2021-06-18 13:54:32','0003','田 イッシン',0,'3479606A7D3C0DD6E94836D4D584EB25102F0841FB76352DF7A61F24A5BC96F5','2021-06-24 12:23:26',2),(4,0,'2021-06-24 09:51:42','0005','蔵田 剛',0,'A3F91A2B3620E79024D75962DE8C5D649B0A1C38B4BA96E469B43B41A220E77D','2021-06-24 12:25:59',4),(5,0,'2021-06-24 11:35:11','0002','安田 純',0,'FD5183647082E50E0C0AAD032DC608CE591D147E49123664EB194FA385B35862','2021-06-24 12:25:07',2),(6,0,'2021-06-24 12:24:55','0006','山内 陸生',0,'71A66C5F969BF2C29AFD47EE34954D062738ECBEAF70B45C5B98BB70809964DC','2021-06-24 17:13:04',2),(8,0,'2021-06-24 17:49:28','0007','紅谷 学',0,'1DA31FEF148FC6BE484AFD71369DDB3460981E6B9381CC7378CD58E9AA4FE393','2021-06-24 20:27:22',5),(9,0,'2021-06-24 18:00:12','0008','中谷 正明',0,'C1A0532897C48BE45BF3BCD0515E558AD1A41C108C28A22CF298067A0914BCDF','2021-06-24 20:27:15',4),(10,0,'2021-06-24 18:00:52','0009','草分 大地',0,'F9DD0957D1F02BDE0B594D25AE898B284E9269413FE3B0B100D72FC37C43EC89','2021-06-24 18:00:52',4),(11,0,'2021-06-24 20:35:34','0010','田中太郎',0,'198396168A0ED4D1D3381E71358797C06F2866472F3582AA02767C7F9E1BB56E','2021-06-24 20:35:34',3),(12,0,'2021-06-24 20:36:00','0011','佐々木小次郎',0,'162EBBD3C928AE4A011DA229E461BC4251069310EF3CAA03CB7D6500F34F0F92','2021-06-24 20:36:00',4),(13,0,'2021-06-24 20:36:27','0012','北島三郎',0,'5EFDA3A5A3B8A8D386726A52EA0BC52CDF3E4A58F8882787CACE81E2985B396F','2021-06-24 20:36:27',5),(14,0,'2021-06-24 20:36:53','0013','葉加瀬太郎',0,'87F2A490C19FD63A5A4AE74AE38B37B4DF66983A20D39DFEC3EB1FD01EEABC82','2021-06-24 20:36:53',5),(15,0,'2021-06-24 20:37:19','0014',' 小島花子',0,'A939A7ABC7A06A7353B314C4C576AA0FCE20395796A5122692B7B3CA361D5767','2021-06-24 20:37:19',5),(16,0,'2021-06-24 20:37:39','0015','戸田恵梨香',0,'E35A0A49B450C6706CE6038FA08FC03AE0D54D039FEA69B365500FF3DAA27E07','2021-06-24 20:37:39',4),(17,0,'2021-06-24 20:38:28','0016','徳田信玄',0,'0B42CBBBCC6B8AEBF0C508255B94B5F2ADFBA3415DE6C2611BFF0583ACCE3486','2021-06-24 20:38:28',3);
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
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (1,1,'2021-06-24 18:04:15',NULL,NULL,'','',NULL,NULL,NULL,'','',1,'2021-06-24',0,NULL,'Z社',NULL,'日本橋',NULL,'【作業内容】\r\n英語or日本語を使用してのサポート業務/不具合調査\r\n 日本語顧客の場合は日本人対応、英語使用の場合はバイリンガルか外国籍が対応\r\n【必須スキル】\r\n英語能力\r\n以下のいずれかの経験\r\n（SQL コマンド/ UNIX コマンド/ サポート経験 / 何かしらのチケット管理ツール）\r\n【尚可スキル】\r\n（Python / 投資銀行 / Digital Technologies）','プロダクションサポート',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-24 18:07:47','',10,3),(2,2,'2021-06-24 20:24:25',NULL,1,'','','2021-06-29','17:30:00',NULL,'ZOOM','',3,'2021-06-24',0,2,'A社',1,'豊洲',2,'案件概要\r\nCtoC車売買サービスのフルスタックエンジニアとしてスクラム開発に参加していただきます。\r\nよって担当業務は以下となります。\r\n現時点で全て満たすのは難しくても、今後これに向けて努力いただける方を求めております。\r\n\r\n･ アプリ、WEB、運営管理システムの開発要件、仕様整理\r\n･ 開発作業の効率化・自動化\r\n･ ペアプログラミング、モブプログラミング\r\n･ GoogleAnalytics、firebase設計・構築、BigQueryデータ連携\r\n･ CI/CDの整備\r\n･ 障害対応\r\n･ 新規技術要素の検証・実装\r\n･ 専門知識の共有、仲間とのコミュニケーション\r\n･ スクラム開発のルール厳守\r\n･ 上記に関連した付帯作業\r\n･ インフラ設計・構築\r\n･ 監視設計・構築\r\n･ 運用作業の標準化/自動化','CtoC車売買サービス ',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-24 20:25:35','',8,5),(3,1,'2021-06-24 20:41:37',NULL,NULL,'','',NULL,NULL,NULL,'','',1,'2021-06-24',0,2,'G社',NULL,'',1,'【概要】\r\nVue.js/Nuxt.jsを用いたフロントエンド開発\r\nTypeScriptでの実装\r\nAtomic DesignベースでのUI設計\r\nE2Eテストの導入検証\r\nSPAのパフォーマンス改善\r\n\r\n【開発環境】\r\n言語：Vue.js TypeScript,\r\nフレームワーク：Vue.js (Nuxt.js), Ruby on Rails, Play Framework\r\nインフラ：AWS, GCP, Datadog\r\nコミュニケーションツール：Slack, G Suite\r\nDE: IntelliJ, RubyMine\r\nその他使用サービス、ライブラリ：GitHub, Jenkins, CircleCI, Firebase, Google Analytics\r\n\r\n【その他環境】\r\nMacbook Pro (ディスプレイ1個支給)\r\nイヤホンで音楽を聞きながら作業OK','自社プロダクト',NULL,NULL,'','',NULL,NULL,NULL,'','','','2021-06-24 20:41:37','',16,6);
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

-- Dump completed on 2021-06-24 20:52:19
