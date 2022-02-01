-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: belarosa
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Adulto'),(2,'Acessorios'),(3,'Calçados'),(4,'Bolsas'),(5,'Maquiagens'),(6,'Oculos'),(7,'Roupas'),(8,'Utensilios');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `date_nasc` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbr0y8pbkpqhuhio7wybfyrsy6` (`registro_id`),
  CONSTRAINT `FKbr0y8pbkpqhuhio7wybfyrsy6` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'86773894077','24061993','Andre Raimundo Rodrigues de Oliveira','91984001327',1),(2,'63079207009','30111991','Andre Fake User','91987567180',2),(3,'29167241093','10031991','Pamela Lorena Fake User','91999001422',3),(4,'01011990','82640149253','Gizela Rodrigues de Oliveira','91999132862',4),(5,'63079207009','13122009','Roberto Luiz Cabral Moraes','91988646337',5),(6,'11111111111','30/11/1998','TESTYPLFCXOQ','91987654472',6),(7,'22501422031','30/11/1998','Andre Raimundoo Oliveira','91987654472',7);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descricao`
--

DROP TABLE IF EXISTS `descricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `descricao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descricao`
--

LOCK TABLES `descricao` WRITE;
/*!40000 ALTER TABLE `descricao` DISABLE KEYS */;
INSERT INTO `descricao` VALUES (1,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(2,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(3,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(4,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(5,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(6,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(7,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(8,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(9,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(10,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(11,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(12,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(13,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(14,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(15,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(16,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(17,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(18,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(19,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(20,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(21,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(22,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(23,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(24,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(25,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(26,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(27,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(28,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(29,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres '),(30,'Essa é uma descrição deste produto, poder ser detalhado ou ate mesmo resumo, desde que atenda o mínimo de de setecentos e cinquenta caracteres ');
/*!40000 ALTER TABLE `descricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `localidade` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  `registro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8s7ivtl4foyhrfam9xqom73n9` (`cliente_id`),
  KEY `FKrk4nvpy0exgj3tmqi78a75sm3` (`registro_id`),
  CONSTRAINT `FK8s7ivtl4foyhrfam9xqom73n9` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKrk4nvpy0exgj3tmqi78a75sm3` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Centro','68655000','Comercio','Irituia','Rua Coronel Joao Cancio','20','PA',1,1),(2,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',2,2),(3,'Vila Nova','68655000','centro','Irituia','Rua Bom Sossego','34','PA',3,3),(4,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',4,4),(5,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',5,5),(6,'Centro','68655000','Comercio','Irituia','Rua Coronel Joao Cancio','20','PA',6,6),(7,'Centro','68655000','Comercio','Irituia','Rua Coronel Joao Cancio','20','PA',7,7);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_pedido`
--

DROP TABLE IF EXISTS `item_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `item_pedido` (
  `desconto` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  `pedido_id` int NOT NULL,
  `produto_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`,`produto_id`),
  KEY `FKtk55mn6d6bvl5h0no5uagi3sf` (`produto_id`),
  CONSTRAINT `FK60ym08cfoysa17wrn1swyiuda` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `FKtk55mn6d6bvl5h0no5uagi3sf` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_pedido`
--

LOCK TABLES `item_pedido` WRITE;
/*!40000 ALTER TABLE `item_pedido` DISABLE KEYS */;
INSERT INTO `item_pedido` VALUES (0,279.99,1,1,1),(0,559.98,2,2,2),(0,387.8,3,3,3),(0,358.6,3,4,4),(0,99.99,1,5,5),(0,99.99,1,6,6),(0,99.99,1,7,7),(0,99.99,1,8,8),(0,99.99,1,9,9),(0,99.99,1,10,10),(0,99.99,1,11,11),(0,99.99,1,12,12),(0,99.99,1,13,13),(0,99.99,1,14,14),(0,99.99,1,15,15);
/*!40000 ALTER TABLE `item_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `pedido_id` int NOT NULL,
  `situacao_pedido` int DEFAULT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKthad9tkw4188hb3qo1lm5ueb0` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,1),(2,1),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_boleto`
--

DROP TABLE IF EXISTS `pagamento_boleto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pagamento_boleto` (
  `data_pagamento` datetime(6) DEFAULT NULL,
  `data_vencimento` datetime(6) DEFAULT NULL,
  `pedido_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKdqk2a6n9it7vodk056daxe4jy` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_boleto`
--

LOCK TABLES `pagamento_boleto` WRITE;
/*!40000 ALTER TABLE `pagamento_boleto` DISABLE KEYS */;
INSERT INTO `pagamento_boleto` VALUES (NULL,'2021-01-10 23:59:00.000000',2);
/*!40000 ALTER TABLE `pagamento_boleto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_cartao`
--

DROP TABLE IF EXISTS `pagamento_cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pagamento_cartao` (
  `numeros_de_parcelas` int DEFAULT NULL,
  `pedido_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FK936sknk6dwq1oa3p2y7d4s8ol` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_cartao`
--

LOCK TABLES `pagamento_cartao` WRITE;
/*!40000 ALTER TABLE `pagamento_cartao` DISABLE KEYS */;
INSERT INTO `pagamento_cartao` VALUES (10,1),(4,4);
/*!40000 ALTER TABLE `pagamento_cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_dinheiro`
--

DROP TABLE IF EXISTS `pagamento_dinheiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pagamento_dinheiro` (
  `data_pagamento` datetime(6) DEFAULT NULL,
  `pedido_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKb5ma55icc6n3rc2h9m7tg628e` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_dinheiro`
--

LOCK TABLES `pagamento_dinheiro` WRITE;
/*!40000 ALTER TABLE `pagamento_dinheiro` DISABLE KEYS */;
INSERT INTO `pagamento_dinheiro` VALUES ('2021-01-22 21:00:00.000000',5),('2021-01-21 20:00:00.000000',6),('2021-01-12 22:00:00.000000',7),('2021-01-20 21:00:00.000000',8),('2021-01-14 20:00:00.000000',9),('2021-01-23 22:00:00.000000',10),('2021-01-30 21:00:00.000000',11),('2021-01-01 20:00:00.000000',12),('2021-01-06 22:00:00.000000',13),('2021-01-12 21:00:00.000000',14),('2021-01-27 20:00:00.000000',15);
/*!40000 ALTER TABLE `pagamento_dinheiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento_pix`
--

DROP TABLE IF EXISTS `pagamento_pix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pagamento_pix` (
  `data_pedido` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `pedido_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKmiypj5w2h1nwwskuvbvvs5plp` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento_pix`
--

LOCK TABLES `pagamento_pix` WRITE;
/*!40000 ALTER TABLE `pagamento_pix` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento_pix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payer_user`
--

DROP TABLE IF EXISTS `payer_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `payer_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `process_payment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK226o6sj1nqtfk1k71kkecq8ow` (`process_payment_id`),
  CONSTRAINT `FK226o6sj1nqtfk1k71kkecq8ow` FOREIGN KEY (`process_payment_id`) REFERENCES `process_payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payer_user`
--

LOCK TABLES `payer_user` WRITE;
/*!40000 ALTER TABLE `payer_user` DISABLE KEYS */;
INSERT INTO `payer_user` VALUES (1,'test_user_3815517@testuser.com',1);
/*!40000 ALTER TABLE `payer_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `instante` datetime(6) DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  `endereco_de_entrega_id` int DEFAULT NULL,
  `registro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`),
  KEY `FK1fihyy2fnocpuwc74674qmfkv` (`endereco_de_entrega_id`),
  KEY `FKe8xqg6t8ctck3s3e00h408tlo` (`registro_id`),
  CONSTRAINT `FK1fihyy2fnocpuwc74674qmfkv` FOREIGN KEY (`endereco_de_entrega_id`) REFERENCES `endereco` (`id`),
  CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `FKe8xqg6t8ctck3s3e00h408tlo` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2021-01-23 22:00:00.000000',7,7,7),(2,'2021-01-22 21:00:00.000000',7,7,7),(3,'2021-01-21 20:00:00.000000',7,7,7),(4,'2021-01-03 22:00:00.000000',7,7,7),(5,'2021-01-22 21:00:00.000000',7,7,7),(6,'2021-01-27 20:00:00.000000',7,7,7),(7,'2021-01-12 22:00:00.000000',7,7,7),(8,'2021-01-20 21:00:00.000000',7,7,7),(9,'2021-01-14 20:00:00.000000',7,7,7),(10,'2021-01-23 22:00:00.000000',7,7,7),(11,'2021-01-30 21:00:00.000000',7,7,7),(12,'2021-01-01 20:00:00.000000',7,7,7),(13,'2021-01-06 22:00:00.000000',7,7,7),(14,'2021-01-12 21:00:00.000000',7,7,7),(15,'2021-01-27 20:00:00.000000',7,7,7);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfis`
--

DROP TABLE IF EXISTS `perfis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `perfis` (
  `registro_id` int NOT NULL,
  `perfis` int DEFAULT NULL,
  KEY `FKj7j0wuhtl2k4xwpk3t77ylc3` (`registro_id`),
  CONSTRAINT `FKj7j0wuhtl2k4xwpk3t77ylc3` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfis`
--

LOCK TABLES `perfis` WRITE;
/*!40000 ALTER TABLE `perfis` DISABLE KEYS */;
INSERT INTO `perfis` VALUES (1,1),(1,2),(2,1),(3,1),(3,2),(4,1),(4,2),(5,1),(5,2),(6,1),(7,1),(8,1);
/*!40000 ALTER TABLE `perfis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pix_application_data`
--

DROP TABLE IF EXISTS `pix_application_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pix_application_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `pix_point_of_interaction_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkxxlgmgcufu0gcc048r2mxsxh` (`pix_point_of_interaction_id`),
  CONSTRAINT `FKkxxlgmgcufu0gcc048r2mxsxh` FOREIGN KEY (`pix_point_of_interaction_id`) REFERENCES `pix_point_of_interaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pix_application_data`
--

LOCK TABLES `pix_application_data` WRITE;
/*!40000 ALTER TABLE `pix_application_data` DISABLE KEYS */;
INSERT INTO `pix_application_data` VALUES (1,'VERSION_NUMBER','NAME_SDK',1);
/*!40000 ALTER TABLE `pix_application_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pix_payment`
--

DROP TABLE IF EXISTS `pix_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pix_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_process` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `status_detail` varchar(255) DEFAULT NULL,
  `registro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs3d81n4ygk5765hy3npqwnods` (`registro_id`),
  CONSTRAINT `FKs3d81n4ygk5765hy3npqwnods` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pix_payment`
--

LOCK TABLES `pix_payment` WRITE;
/*!40000 ALTER TABLE `pix_payment` DISABLE KEYS */;
INSERT INTO `pix_payment` VALUES (1,'5466317','pending','pending_waiting_transfer',6);
/*!40000 ALTER TABLE `pix_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pix_point_of_interaction`
--

DROP TABLE IF EXISTS `pix_point_of_interaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pix_point_of_interaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sub_type` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `pix_payment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsfe0wsmfhp0aug05obp8v7xbt` (`pix_payment_id`),
  CONSTRAINT `FKsfe0wsmfhp0aug05obp8v7xbt` FOREIGN KEY (`pix_payment_id`) REFERENCES `pix_payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pix_point_of_interaction`
--

LOCK TABLES `pix_point_of_interaction` WRITE;
/*!40000 ALTER TABLE `pix_point_of_interaction` DISABLE KEYS */;
INSERT INTO `pix_point_of_interaction` VALUES (1,NULL,'PIX',1);
/*!40000 ALTER TABLE `pix_point_of_interaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pix_transaction_data`
--

DROP TABLE IF EXISTS `pix_transaction_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pix_transaction_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qr_code` varchar(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `pix_point_of_interaction_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2k8vi6byw57m3bu4rp1kcuwx9` (`pix_point_of_interaction_id`),
  CONSTRAINT `FK2k8vi6byw57m3bu4rp1kcuwx9` FOREIGN KEY (`pix_point_of_interaction_id`) REFERENCES `pix_point_of_interaction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pix_transaction_data`
--

LOCK TABLES `pix_transaction_data` WRITE;
/*!40000 ALTER TABLE `pix_transaction_data` DISABLE KEYS */;
INSERT INTO `pix_transaction_data` VALUES (1,'00020126600014br.gov.bcb.pix0117john@yourdomain.com0217additionaldata520400005303986540510.005802BR5913MariaSilva6008Brasilia62070503***6304E2CA','iVBORw0KGgoAAAANSUhEUgAABRQAAAUUCAYAAACu5p7oAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAIABJREFUeJzs2luO3LiWQNFmI+Y/Zd6vRt36KGNXi7ZOBtcagHD4kNLeiLX33v8DAAAAABD879sDAAAAAAA/h6AIAAAAAGSCIgAAAACQCYoAAAAAQCYoAgAAAACZoAgAAAAAZIIiAAAAAJAJigAAAABAJigCAAAAAJmgCAAAAABkgiIAAAAAkAmKAAAAAEAmKAIAAAAAmaAIAAAAAGSCIgAAAACQCYoAAAAAQCYoAgAAAACZoAgAAAAAZIIiAAAAAJAJigAAAABAJigCA',1);
/*!40000 ALTER TABLE `pix_transaction_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pix_transaction_details`
--

DROP TABLE IF EXISTS `pix_transaction_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pix_transaction_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `external_resource_url` varchar(255) DEFAULT NULL,
  `financial_institution` varchar(255) DEFAULT NULL,
  `installment_amount` double DEFAULT NULL,
  `net_received_amount` double DEFAULT NULL,
  `overpaid_amount` double DEFAULT NULL,
  `total_paid_amount` double DEFAULT NULL,
  `pix_payment_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmrf0xo8gxim7srb8q8xul6qsg` (`pix_payment_id`),
  CONSTRAINT `FKmrf0xo8gxim7srb8q8xul6qsg` FOREIGN KEY (`pix_payment_id`) REFERENCES `pix_payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pix_transaction_details`
--

LOCK TABLES `pix_transaction_details` WRITE;
/*!40000 ALTER TABLE `pix_transaction_details` DISABLE KEYS */;
INSERT INTO `pix_transaction_details` VALUES (1,'linkpix','mp',2,0,0,10,1);
/*!40000 ALTER TABLE `pix_transaction_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `process_payment`
--

DROP TABLE IF EXISTS `process_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `process_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `installments` int DEFAULT NULL,
  `issuer_id` int DEFAULT NULL,
  `payment_method_id` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `transaction_amount` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process_payment`
--

LOCK TABLES `process_payment` WRITE;
/*!40000 ALTER TABLE `process_payment` DISABLE KEYS */;
INSERT INTO `process_payment` VALUES (1,'pagamento com cartao master',4,24,'master','ae806f1f4ede27b833a843805a375b81',19.9);
/*!40000 ALTER TABLE `process_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Carteita victorino em couro',0),(2,'Bolsa Santa Lolla Baú Marrom',279.99),(3,'Les Sombra quarteto multiefeitos',199.9),(4,'Bolsa Feminina Grande Tote Transversal Couro Ecológico',89.65),(5,'Bolsa + Sapato Feminino Coleção Verão',99.99),(6,'Produto 1',99.99),(7,'Produto 2',99.99),(8,'Produto 3',99.99),(9,'Produto 4',99.99),(10,'Produto 5',99.99),(11,'Produto 6',99.99),(12,'Produto 7',99.99),(13,'Produto 8',99.99),(14,'Produto 9',99.99),(15,'Produto 10',99.99),(16,'Produto 11',99.99),(17,'Produto 12',99.99),(18,'Produto 13',99.99),(19,'Produto 14',99.99),(20,'Produto 15',99.99),(21,'Produto 16',99.99),(22,'Produto 17',99.99),(23,'Produto 18',99.99),(24,'Produto 19',99.99),(25,'Produto 20',99.99),(26,'Produto 21',99.99),(27,'Fantazia Noturna Dracula',129.9),(28,'Rabo de gato',10),(29,'Tapa olho do pirata',7),(30,'Oculos bifocal dia',90);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_categoria`
--

DROP TABLE IF EXISTS `produto_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `produto_categoria` (
  `produto_id` int NOT NULL,
  `categoria_id` int NOT NULL,
  KEY `FKq3g33tp7xk2juh53fbw6y4y57` (`categoria_id`),
  KEY `FK1c0y58d3n6x3m6euv2j3h64vt` (`produto_id`),
  CONSTRAINT `FK1c0y58d3n6x3m6euv2j3h64vt` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `FKq3g33tp7xk2juh53fbw6y4y57` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_categoria`
--

LOCK TABLES `produto_categoria` WRITE;
/*!40000 ALTER TABLE `produto_categoria` DISABLE KEYS */;
INSERT INTO `produto_categoria` VALUES (1,4),(2,4),(3,5),(4,4),(5,3),(5,4),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,1),(28,1),(29,1),(30,4);
/*!40000 ALTER TABLE `produto_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_descricao`
--

DROP TABLE IF EXISTS `produto_descricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `produto_descricao` (
  `produto_id` int NOT NULL,
  `descricao_id` int NOT NULL,
  KEY `FKe2pue9kod0651bvaetpr7mcv` (`descricao_id`),
  KEY `FKsf1lylynsa45t4f5la2h1dxq` (`produto_id`),
  CONSTRAINT `FKe2pue9kod0651bvaetpr7mcv` FOREIGN KEY (`descricao_id`) REFERENCES `descricao` (`id`),
  CONSTRAINT `FKsf1lylynsa45t4f5la2h1dxq` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_descricao`
--

LOCK TABLES `produto_descricao` WRITE;
/*!40000 ALTER TABLE `produto_descricao` DISABLE KEYS */;
INSERT INTO `produto_descricao` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30);
/*!40000 ALTER TABLE `produto_descricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `registro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_svqlqo2hd1f1kxd6yyi2x9dtq` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (1,'9000andre@gmail.com','$2a$10$Y3zwBiIkMwM4B2y54CbCjei.c37h6CudsdrZMpYlFhXIXFndqVYdO'),(2,'andrefake@gmail.com','$2a$10$3iYlzdbqOqGaWmLrjv/XW.YhR/HQ61Pxnk53Hmi9XyUj5.MZjFCW2'),(3,'gizelamgro@gmail.com','$2a$10$Huv2PNc9DKR2A/9Zcxf5B.hDoSK7atqkY8sZFs8YjSb44syQMOoFK'),(4,'robertolcm92@gmail.com','$2a$10$v8Qw9Guqvz4koArwVx7OVeY5lwxmaDonc.OID0TWSYTJCNKRZ5OGi'),(5,'terezinhajro@gmail.com','$2a$10$hP.G1kQv5lg7S4WrYHpzmuktBbVC6Zkp69XMDl6Y20uX8bXb5Au3q'),(6,'test_user_3815517@testuser.com','$2a$10$DqXRovQgfXFG.wC9f62CJuuGeBR.Sk.coZTRxXBod2Q4H/qMQFwge'),(7,'andreraimundoo@hotmail.com','$2a$10$o2fFzG41s3yiT.jlb8qlM.SrG0FE/A8AsS9QCFcsmLD9gawpqN25C'),(8,'andreraimundo.me@gmail.com','$2a$10$dTAFhE8paj47flGPJ95TJ.KMM6agZRPTRJCzvpvDmsIigYrn07hbK');
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_de_pedido`
--

DROP TABLE IF EXISTS `reserva_de_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `reserva_de_pedido` (
  `data_pedido` datetime(6) DEFAULT NULL,
  `informacao_de_entrega` varchar(255) DEFAULT NULL,
  `pedido_id` int NOT NULL,
  PRIMARY KEY (`pedido_id`),
  CONSTRAINT `FKbrrvtes4y5d5oyyrm44s9k23h` FOREIGN KEY (`pedido_id`) REFERENCES `pagamento` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_de_pedido`
--

LOCK TABLES `reserva_de_pedido` WRITE;
/*!40000 ALTER TABLE `reserva_de_pedido` DISABLE KEYS */;
INSERT INTO `reserva_de_pedido` VALUES ('2021-01-21 20:00:00.000000','Retirar na loja',3);
/*!40000 ALTER TABLE `reserva_de_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_payment`
--

DROP TABLE IF EXISTS `status_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `status_payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_approved` datetime(6) DEFAULT NULL,
  `id_process` varchar(255) DEFAULT NULL,
  `payment_method_id` varchar(255) DEFAULT NULL,
  `payment_type_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `status_detail` varchar(255) DEFAULT NULL,
  `process_payment_id` int DEFAULT NULL,
  `registro_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmqdcbfi6wfw2tml4qtg0ri6ea` (`process_payment_id`),
  KEY `FK5dc3o92pi9fdx8iqn7pym6b4s` (`registro_id`),
  CONSTRAINT `FK5dc3o92pi9fdx8iqn7pym6b4s` FOREIGN KEY (`registro_id`) REFERENCES `registro` (`id`),
  CONSTRAINT `FKmqdcbfi6wfw2tml4qtg0ri6ea` FOREIGN KEY (`process_payment_id`) REFERENCES `process_payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_payment`
--

LOCK TABLES `status_payment` WRITE;
/*!40000 ALTER TABLE `status_payment` DISABLE KEYS */;
INSERT INTO `status_payment` VALUES (1,'2022-01-23 22:00:00.000000','1212122','master','credit card','aproved','payment aproved',1,6);
/*!40000 ALTER TABLE `status_payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-30 15:11:11
