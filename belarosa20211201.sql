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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'86773894077','24061993','Andre Raimundo Rodrigues de Oliveira','91984001327',1),(2,'63079207009','30111991','Andre Fake User','91987567180',2),(3,'29167241093','10031991','Pamela Lorena Fake User','91999001422',3),(4,'01011990','82640149253','Gizela Rodrigues de Oliveira','91999132862',4),(5,'63079207009','13122009','Roberto Luiz Cabral Moraes','91988646337',5);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Centro','68655000','Comercio','Irituia','Rua Coronel Joao Cancio','20','PA',1,1),(2,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',2,2),(3,'Vila Nova','68655000','centro','Irituia','Rua Bom Sossego','34','PA',3,3),(4,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',5,4),(5,'Vila Nova','68655000','centro','Irituia','Rua Coronel Jose Vieira','38','PA',5,5);
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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` varchar(255) DEFAULT NULL,
  `currency_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unit_price` int DEFAULT NULL,
  `reference_external_reference` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb2v3p796fda1eokjywf4808jw` (`reference_external_reference`),
  CONSTRAINT `FKb2v3p796fda1eokjywf4808jw` FOREIGN KEY (`reference_external_reference`) REFERENCES `reference` (`external_reference`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'1','BRL','Smartphone Motorola G5','wwww.minhaimage.com/myrepositore/motog5.png',2,'MotoG5',500,1),(2,'1','BRL','Iphone 11 preto 128gb','wwww.minhaimage.com/myrepositore/iphone11.png',1,'Iphone11',1000,2);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
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
INSERT INTO `pagamento_dinheiro` VALUES ('2021-01-21 20:00:00.000000',3),('2021-01-22 21:00:00.000000',5),('2021-01-21 20:00:00.000000',6),('2021-01-12 22:00:00.000000',7),('2021-01-20 21:00:00.000000',8),('2021-01-14 20:00:00.000000',9),('2021-01-23 22:00:00.000000',10),('2021-01-30 21:00:00.000000',11),('2021-01-01 20:00:00.000000',12),('2021-01-06 22:00:00.000000',13),('2021-01-12 21:00:00.000000',14),('2021-01-27 20:00:00.000000',15);
/*!40000 ALTER TABLE `pagamento_dinheiro` ENABLE KEYS */;
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
INSERT INTO `pedido` VALUES (1,'2021-01-23 22:00:00.000000',2,2,2),(2,'2021-01-22 21:00:00.000000',2,2,2),(3,'2021-01-21 20:00:00.000000',2,2,2),(4,'2021-01-03 22:00:00.000000',2,2,2),(5,'2021-01-22 21:00:00.000000',2,2,2),(6,'2021-01-27 20:00:00.000000',2,2,2),(7,'2021-01-12 22:00:00.000000',2,2,2),(8,'2021-01-20 21:00:00.000000',2,2,2),(9,'2021-01-14 20:00:00.000000',2,2,2),(10,'2021-01-23 22:00:00.000000',2,2,2),(11,'2021-01-30 21:00:00.000000',2,2,2),(12,'2021-01-01 20:00:00.000000',2,2,2),(13,'2021-01-06 22:00:00.000000',2,2,2),(14,'2021-01-12 21:00:00.000000',2,2,2),(15,'2021-01-27 20:00:00.000000',2,2,2);
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
INSERT INTO `perfis` VALUES (1,1),(1,2),(2,1),(3,1),(3,2),(4,1),(4,2),(5,1),(5,2);
/*!40000 ALTER TABLE `perfis` ENABLE KEYS */;
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
INSERT INTO `produto` VALUES (1,'Carteita victorino em couro',0),(2,'Bolsa Santa Lolla Baú Marrom',279.99),(3,'Les Sombra quarteto multiefeitos',199.9),(4,'Bolsa Feminina Grande Tote Transversal Couro Ecológico',89.65),(5,'Bolsa + Sapato Feminino Coleção Verão',99.99),(6,'Produto 1',99.99),(7,'Produto 2',99.99),(8,'Produto 3',99.99),(9,'Produto 4',99.99),(10,'Produto 5',99.99),(11,'Produto 6',99.99),(12,'Produto 7',99.99),(13,'Produto 8',99.99),(14,'Produto 9',99.99),(15,'Produto 10',99.99),(16,'Produto 11',99.99),(17,'Produto 12',99.99),(18,'Produto 13',99.99),(19,'Produto 14',99.99),(20,'Produto 15',99.99),(21,'Produto 16',99.99),(22,'Produto 17',99.99),(23,'Produto 18',99.99),(24,'Produto 19',99.99),(25,'Produto 20',99.99),(26,'Produto 21',99.99),(27,'Fantazia Noturna Dracula',129.9),(28,'Rabo de gato',9.9),(29,'Tapa olho do pirata',7),(30,'Oculos bifocal dia',90);
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
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `reference` (
  `external_reference` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`external_reference`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES (1),(2);
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `registro` VALUES (1,'9000andre@gmail.com','$2a$10$jiyNLsJote.Qb.9OtPVcueMvT423KdvThPDks0HDZMWQpSEIweCGy'),(2,'andrefake@gmail.com','$2a$10$UxrrHw6/S3Z3QxplCurh.uuTZUSasyMts2VWyxglvIAjw.Yb0KC2O'),(3,'gizelamgro@gmail.com','$2a$10$rdyg1uCxLnwJYe2oszz4Eu/g/r4752T7fuDNJ1yLaGMMc5Bs7UCa2'),(4,'robertolcm92@gmail.com','$2a$10$NuTSAYImO7vzfN.qJHtsquAKNldS79rdcsfn7EKuS6ccAYZvo0ImO'),(5,'terezinhajro@gmail.com','$2a$10$kDHcprd4oin6VwxkiiNaVeHz0SrlGaS1b2KIZBUjJ7OhzG/5FYhTK');
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01 13:49:08
