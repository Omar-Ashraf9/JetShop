-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jetshop
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cart_items`
--

DROP TABLE IF EXISTS `cart_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_items` (
  `cart_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `amount` decimal(15,2) NOT NULL,
  PRIMARY KEY (`cart_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_item_ibfk_1` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`cart_id`),
  CONSTRAINT `cart_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_items`
--

LOCK TABLES `cart_items` WRITE;
/*!40000 ALTER TABLE `cart_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name_UNIQUE` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'men'),(4,'shoes'),(3,'watches'),(2,'women');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `password` varchar(255) NOT NULL,
  `job` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `credit_limit` decimal(15,2) DEFAULT '0.00',
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `street_name` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int NOT NULL,
  `amount` decimal(15,2) NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `orders_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `orders_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `ordered_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `image_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `image_url` varchar(255) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `fk_product_id` (`product_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES (1,1,'https://i.postimg.cc/zXHrsytV/C2989-AX-24-SP-BK81-01-01.webp'),(2,1,'https://i.postimg.cc/rw6kMq3g/C2989-AX-24-SP-BK81-02-01.webp'),(3,1,'https://i.postimg.cc/rwSLpvLT/C2989-AX-24-SP-BK81-03-01.webp'),(4,2,'https://i.postimg.cc/tJVMMxqb/B4803-AX-24-SP-OG165-01-02.webp'),(5,2,'https://i.postimg.cc/NLqzqjFH/B4803-AX-24-SP-OG165-02-02.webp'),(6,2,'https://i.postimg.cc/9XRXhgzm/B4803-AX-24-SP-OG165-03-02.webp'),(7,4,'https://i.postimg.cc/JzPCJjtY/B5783-AX-24-SP-NM28-01-02.webp'),(8,4,'https://i.postimg.cc/mrkfShHL/B5783-AX-24-SP-NM28-02-02.webp'),(9,4,'https://i.postimg.cc/HLNGvHwQ/B5783-AX-24-SP-NM28-03-02.webp'),(10,5,'https://i.postimg.cc/05p3D7BG/T5259-AZ-23-SP-GN246-01-02.webp'),(11,5,'https://i.postimg.cc/xTnZRqww/T5259-AZ-23-SP-GN246-02-02.webp'),(12,5,'https://i.postimg.cc/RVdDb49N/T5259-AZ-23-SP-GN246-04-01.webp'),(13,6,'https://i.postimg.cc/prRtzCQ7/Z8005-AZ-24-SP-NV135-01-01.webp'),(14,6,'https://i.postimg.cc/RhdxRtX0/Z8005-AZ-24-SP-NV135-02-01.webp'),(15,6,'https://i.postimg.cc/qBxr4f4d/Z8005-AZ-24-SP-NV135-03-01.webp'),(16,3,' https://i.postimg.cc/jd1zjF4M/B9304-AX-24-SP-NV243-01-04.webp'),(17,3,' https://i.postimg.cc/0yJ7K0tP/B9304-AX-24-SP-NV243-02-04.webp'),(18,3,'https://i.postimg.cc/LsKLtg7f/B9304-AX-24-SP-NV243-03-04.webp'),(20,8,' https://i.postimg.cc/rmtGX6b6/B4656-AX-24-SP-BR80-01-03.webp'),(21,7,'https://i.postimg.cc/6QvzwXsV/A8576-AX-23-AU-NV64-01-01.webp'),(22,7,'https://i.postimg.cc/26NGSKms/A8576-AX-23-AU-NV64-02-01.webp'),(23,8,' https://i.postimg.cc/rsX1qnXD/B4656-AX-24-SP-BR80-02-03.webp'),(24,8,' https://i.postimg.cc/T1Vr1VfC/B4656-AX-24-SP-BR80-03-03.webp'),(25,7,'https://i.postimg.cc/Qtgb9JdH/A8576-AX-23-AU-NV64-03-01.webp'),(26,9,' https://i.postimg.cc/1tyWKjTp/C1735-AX-24-SP-BG702-01-01.webp'),(27,9,' https://i.postimg.cc/d1n5N9Pg/C1735-AX-24-SP-BG702-02-01.webp'),(28,9,' https://i.postimg.cc/KjzJ6gmj/C1735-AX-24-SP-BG702-04-01.webp'),(29,10,'  https://i.postimg.cc/76gCnqdL/Y7168-AZ-23-SP-TR328-01-02.webp'),(30,10,'https://i.postimg.cc/rsMDhv2N/Y7168-AZ-23-SP-TR328-02-03.webp'),(31,10,' https://i.postimg.cc/brgs43zc/Y7168-AZ-23-SP-TR328-03-03.webp'),(32,11,'   https://i.postimg.cc/VkD25MNf/A9762-AX-23-HS-KH445-01-02.webp'),(33,11,' https://i.postimg.cc/KYjwTzKn/A9762-AX-23-HS-KH445-02-02.webp'),(34,11,' https://i.postimg.cc/s2L84rSb/A9762-AX-23-HS-KH445-03-02.webp'),(35,12,'  https://i.postimg.cc/N0X8ZqS3/W7734-AZ-24-SM-KH262-01-02.webp'),(36,12,'https://i.postimg.cc/NMw8cCw5/W7734-AZ-24-SM-KH262-02-02.webp'),(37,12,' https://i.postimg.cc/qRXsMckQ/W7734-AZ-24-SM-KH262-04-01.webp DeFacto'),(38,13,'https://i.postimg.cc/Yq6xxsQx/71-Q0v-E6-MI2-L-AC-SX466.jpg'),(39,13,'https://i.postimg.cc/nhnGSGkf/71-Ql-X2f-Qf-OL-AC-SX466.jpg'),(40,13,'https://i.postimg.cc/wjFcCRfy/71vcyu-Y2-P6-L-AC-SX466.jpg'),(41,14,'https://i.postimg.cc/xC9Qc7GF/613m-Yr-Cn0-L-AC-SY535.jpg'),(42,14,'https://i.postimg.cc/Z5y4g6Kj/71f-Iq-Y7-YKe-L-AC-SY535.jpg'),(43,14,'https://i.postimg.cc/LstR4RP1/71gb-Lk-Km-PRL-AC-SY535.jpg'),(44,15,'https://i.postimg.cc/9FmvZZ7z/B9727-AX-NS-BK26-01-01.webp'),(45,15,'https://i.postimg.cc/280gwyQG/B9727-AX-NS-BK26-02-02.webp'),(46,15,'https://i.postimg.cc/0yrFHvZs/B9727-AX-NS-BK26-04-02.webp'),(47,16,'https://i.postimg.cc/jd71YcPW/41-Hu-Vd-M4-Er-L-AC-SR38-50.jpg'),(48,16,'https://i.postimg.cc/4xRSfcQW/61-BBpc6p8q-L-AC-SX679.jpg'),(49,16,'https://i.postimg.cc/qvcZz7m4/71dns-Ok-JRy-L-AC-SY741.jpg\r\n'),(50,17,'https://i.postimg.cc/4yLwzKDh/W0516-AZ-22-SP-BG26-01-03.webp'),(51,17,'https://i.postimg.cc/fWBH4FVT/W0516-AZ-22-SP-BG26-02-03.webp'),(52,17,'https://i.postimg.cc/Yq0dt3FN/W0516-AZ-22-SP-BG26-03-03.webp'),(53,18,'https://i.postimg.cc/26gPnKnD/710-KANgk-W7-S-AC-SX679.jpg'),(54,18,'https://i.postimg.cc/9fg3QMMz/71-Saz-Kbitw-L-AC-SX679.jpg'),(55,18,'https://i.postimg.cc/tTsKZjZk/71xb-Oi1-Bbz-S-AC-SX679.jpg'),(56,19,'https://i.postimg.cc/FKwf80Sx/B4015-A8-23-AU-WT42-01-01.webp'),(57,19,'https://i.postimg.cc/767CkbMr/B4015-A8-23-AU-WT42-02-01.webp'),(58,19,'https://i.postimg.cc/sxrMDywQ/B4015-A8-23-AU-WT42-03-01.webp'),(59,20,'https://i.postimg.cc/L5XrPgyr/B0221-A8-23-AU-GR2-01-01.webp'),(60,20,'https://i.postimg.cc/59KcVpy1/B0221-A8-23-AU-GR2-02-01.webp'),(61,20,'https://i.postimg.cc/Kv16vL3T/B0221-A8-23-AU-GR2-03-01.webp');
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `stock_quantity` int NOT NULL DEFAULT '0',
  `product_description` varchar(255) DEFAULT NULL,
  `product_price` decimal(15,2) NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Insulated Regular Fit Puffer Jacket',10,'Stay warm in style with our Insulated Puffer Jacket. Designed for comfort and durability, it is your go-to for chilly weather.',2399.00,1),(2,'Oversize Fit Long Sleeve Sweatshirt',10,'Elevate your comfort game with our Oversize Fit Long Sleeve Sweatshirt. Designed for ultimate coziness and style, it is the perfect addition to your casual wardrobe.',1300.00,1),(3,'Long Sleeve Dress',10,'A Line Shirt Collar Poplin Low Shoulder Long Sleeve Dress',1499.00,2),(4,'Baggy Fit Pattern Normal Waist Wide Leg Jeans',10,'Introducing our Baggy Fit Wide Leg Jeans, a fusion of style and comfort. With a relaxed fit and a trendy wide leg design, these jeans are perfect for effortless, everyday wear.',1499.00,1),(5,'Slim Fit Polo Neck Short Sleeve T-Shirt',10,'Introducing our Slim Fit Polo Neck Short Sleeve T-Shirt. Combining classic style with modern flair, this tee offers a sleek silhouette and comfortable fit. Perfect for both casual and semi-formal occasions, it is a versatile essential for your wardrobe.',500.00,1),(6,'Midi Long Sleeve Dress',10,'Shirt Collar Printed Midi Long Sleeve Dress',1499.00,2),(7,'Relax Fit Polo Collar Oxford Striped Long Sleeve Shirt',10,'Introducing our Relax Fit Oxford Striped Shirt. Crafted for comfort and style, its classic polo collar and distinguished stripes elevate any ensemble with casual sophistication.',1299.00,1),(8,'Sports Sweatshirt',10,'DeFactoFit Oversize Fit Hooded Sports Sweatshirt',1499.00,2),(9,'Trousers',10,'Wide Leg Gabardine Trousers',1699.00,2),(10,'Biker Jacket',10,'Waterproof Relax Fit Faux Leather Crop Biker Jacket',2999.00,2),(11,'Tunic',10,'Regular Fit Long Sleeve Tunic',899.00,2),(12,'Long Sleeve Shirt',10,'Regular Fit Shirt Collar Long Sleeve Shirt',999.00,2),(13,'Smart Watch',10,'Newest 1.85 Inch Fitness Tracker, Heart Rate/Sleep Monitor/Pedometer/Calories',1384.00,3),(14,'Fashion Quartz Wristwatches',10,'Men is Watches Waterproof Sport Military Watch for Men Multifunction Chronograph Black Fashion Quartz Wristwatches Calendar with Leather Strap/Stainless Steel',49.00,3),(15,'Woman Faux Leather Serrated Sole Sport shoes',10,'Elevate your style with our Woman Faux Leather Sport Shoes. Designed for both fashion and function, these shoes feature a sleek faux leather design with a modern serrated sole. Perfect for any activity, they offer comfort and style all day long.',2000.00,4),(16,'Neo-Display Black Watch',10,'Casio Unisex MRW200H-2BV Neo-Display Black Watch with Resin Band,Multicolored',951.18,3),(17,'Nasa Licensed Lace-Up Sports Shoes',10,'Step into style with our NASA Licensed Lace-Up Sports Shoes. Officially licensed, they boast iconic NASA branding for a touch of cosmic flair. Comfortable and versatile, perfect for everyday wear or workouts.',1300.00,4),(18,'Sport Watch',10,'Fossil FB-01 Men is Dive-Inspired Sport Watch with Stainless Steel Bracelet Band',454.00,3),(19,'Girl Flat Sole Sneaker',10,'Introducing our Girl Flat Sole Sneakers, stylish and comfy for any adventure. With a sleek design and stable flat sole, they are perfect for school, hanging out, or exploring',600.00,4),(20,'Boy Discovery Licensed Faux Leather Thick Sole Sneaker',10,'Ignite curiosity with the Boy Discovery Licensed Sneakers. Featuring durable faux leather and a thick sole, they are built for young explorers. With iconic Discovery branding, these shoes inspire adventure at every step',1700.00,4);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-27  1:16:34
