-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: elearningboot3
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(255) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'fas fa-file-code',1,'development'),(2,'fas fa-briefcase',2,'business'),(4,'fas fa-search-dollar',3,'finance & accounting'),(5,'fas fa-desktop',4,'it & software'),(6,'fas fa-building',5,'office & productivity'),(7,'fas fa-user-graduate',7,'personal development'),(9,'fas fa-film',0,'art'),(10,'fas fa-utensils',0,'food & beverage');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `hour_count` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_update` varchar(255) DEFAULT NULL,
  `lecture_count` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `promotion_price` double DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72l5dj585nq7i6xxv1vj51lyn` (`category_id`),
  CONSTRAINT `FK72l5dj585nq7i6xxv1vj51lyn` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (12,1,'Learn Python like a Professional! Start from the basics and go all the way to creating your own applications and games!','Become a Python Programmer and learn one of employer\'s most requested skills',NULL,2,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3.jpg',NULL,5,194.99,NULL,'Complete Python Bootcamp: Go from zero to hero in Python 3',NULL),(13,1,'Build Python Web Applications from Beginner to Expert using Python and Flask','The Complete Python Web Developer Course will lead you down a path of understanding and skill that may well, with work and patience, result in an income boost or a career change.',NULL,2,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change.jpg',NULL,5,99.98,NULL,'Complete Python Web Course: Build 8 Python Web Apps',NULL),(14,2,'** #1 Best Selling Business Course! ** Everything You Need to Know About Business from Start-up to IPO','Getting your MBA has never been easier. Haroun is one of the highest rated professors on Udemy, so you can expect to be in good hands through the course of your education',NULL,7,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof.jpg',NULL,6,199.99,NULL,'An Entire MBA in 1 Course:Award Winning Business School Prof',NULL),(15,4,'Digital Marketing & Social Media Marketing Mastery, Facebook Ads, Instagram Marketing, WordPress, SEO, YouTube, Selling','The Complete Digital Marketing Guide. In this Course you\'ll get 18 Courses in 1, instead of buying 18 different Courses around Digital Marketing - This Course has it all!',NULL,3,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1.jpg',NULL,7,99.85,NULL,'The Complete Digital Marketing Guide - 18 Courses in 1',NULL),(16,9,'Drawing is not a talent. It\'s a skill anyone can learn.\r\n','The Art & Science of Drawing is a remarkable program that will teach you how to draw one day at a time.',NULL,4,'http://localhost:8082/assets/upload/images/The_Art_&_Science_of_Drawing.jpg',NULL,5,49.95,NULL,'The Art & Science of Drawing / BASIC SKILLS',NULL),(17,9,'Draw Like a Pro With Colored Pencils','No prior knowledge or experience is necessary, just a willingness to learn.',NULL,4,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course.jpg',NULL,6,22,NULL,'The Colored Pencil Drawing Course',NULL),(18,10,'Learn The Truth About Nutrition, Dieting For Weight Loss, Building Muscle, Healthy Eating, Meal Planning, Fat Loss','Learn How To Build The Perfect Diet & Meal Plan For Improved Health, Better Weight Loss And More Muscle Gains',NULL,4,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan.jpg',NULL,5,25,NULL,'Nutrition Masterclass: Build Your Perfect Diet & Meal Plan',NULL),(19,9,'Learn the #1 most important building block of all art','The course is your track to obtaining drawing skills like you always knew you should have! Whether for your own projects or to draw for other people.',NULL,4,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced.jpg',NULL,6,149.99,NULL,'The Ultimate Drawing Course - Beginner to Advanced',NULL);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Quàn trị viên','ROLE_ADMIN'),(2,'Nhân viên','ROLE_STAFF'),(3,'Khách hàng','ROLE_GUEST'),(6,'Pháp chế','ROLE_LEGAL'),(8,'Thử việc 2 tháng','ROLE_PROBATION');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `targets`
--

DROP TABLE IF EXISTS `targets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `targets` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8cuthmda1kl4o6d5fftqn9lxf` (`course_id`),
  CONSTRAINT `FK8cuthmda1kl4o6d5fftqn9lxf` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `targets`
--

LOCK TABLES `targets` WRITE;
/*!40000 ALTER TABLE `targets` DISABLE KEYS */;
INSERT INTO `targets` VALUES (7,12,0,'Learn to use Python professionally, learning both Python 2 and Python 3!'),(8,12,0,'Learn advanced Python features, like the collections module and how to work with timestamps!'),(9,12,0,'Understand complex topics, like decorators.'),(10,12,0,'Get an understanding of how to create GUIs in the Jupyter Notebook system!'),(11,12,0,'Create games with Python, like Tic Tac Toe and Blackjack!'),(12,12,0,'Learn to use Object Oriented Programming with classes!'),(13,12,0,'Understand how to use both the Jupyter Notebook and create .py files'),(14,12,0,'Build a complete understanding of Python from the ground up!'),(15,13,0,'Design, develop, and deploy engaging web applications using Python and web languages'),(16,13,0,'Develop applications that use MongoDB databases'),(17,13,0,'Understand the way the internet works from the point of view of all development areas'),(18,14,0,'Understand how investment banking firms work and what they can do to help your business.'),(19,14,0,'Analyze entire markets and companies from a qualitative and quantitative perspective.'),(20,14,0,'Set up the correct and most beneficial legal entity for your company.'),(21,14,0,'Identify what makes an entrepreneur extremely successful.'),(22,14,0,'Understand what is venture capital and how to partner with the top venture capital firms to take your company to the next level.'),(23,14,0,'Raise a lot of money quickly.'),(24,15,0,'Set up Your Website, Design It & Post Content on Your Blog.'),(25,15,0,'Use Google Analytics to Understand Your Audience.'),(26,15,0,'Optimize Your Website & YouTube Videos with SEO (Search Engine Optimization).'),(27,15,0,'Drive Traffic to Your New Website.'),(28,16,0,'How to draw any shape.'),(29,16,0,'How to draw any form by breaking it down into basic shapes before adding dark lines.'),(30,16,0,'How to hold the pencil.'),(31,16,0,'How to observe and analyze any subject.'),(32,16,0,'How to use light lines and basic shapes to lay an accurate foundation for finished drawings.'),(33,16,0,'How to bring your drawings to life with detail and texture.'),(34,17,0,'Learn how to become a pro with colored pencils'),(35,17,0,'Be familiar with common colored pencil surfaces and colored pencil types'),(36,17,0,'Draw accurate portraits with colored pencils'),(37,17,0,'Apply various colored pencil techniques to produce a variety of effects'),(38,17,0,'Mix watercolor applications with colored pencils'),(39,18,0,'Understand the fundamentals of healthy dieting (calories, protein, carbs, fat, vitamins & minerals)'),(40,18,0,'Learn when, what and how much you should eat for optimal body composition'),(41,18,0,'Lose fat faster by optimizing your meal plan'),(42,18,0,'Create a diet that is perfect for your needs and lifestyle'),(43,18,0,'Build more muscle by optimizing your meal plan'),(44,18,0,'Improve immunity and energy levels with the right vitamins and minerals'),(45,19,0,'Draw objects out of your head'),(46,19,0,'Understand the fundamentals of art'),(47,19,0,'Draw the human face and figure'),(48,19,0,'Draw realistic light and shadow'),(49,19,0,'Draw perspective drawings');
/*!40000 ALTER TABLE `targets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'http://localhost:8082/assets/upload/images/ava1.jpg','teole@gmail.com.vn','Lê Văn Tèo','$2a$10$7j4v/FrOupDryoLTcAmb8.T0jiWgr4r72zc2MuaSKCelhGVfStZbq','123456789',1),(4,'http://localhost:8082/assets/upload/images/ava2.jpg','taohuynh@gmail.com','Huỳnh Chân Tạo','$2a$10$Z/gNNudaavTdVolNwgMOke7hsju8P4kh.9bIP9zY.S8wrImSsGN9q','111111111111',2),(6,'http://localhost:8082/assets/upload/avar04.png','nhik@gmail.com','Kiến Ngô Nhi','$2a$10$utrYlfG6TQawLdFYjABHPe8dJtcK.z7CxFEvMTnuSxexkrTsOufgG','0987654321',6),(7,'http://localhost:8082/assets/upload/Screen_Shot_2020-05-29_at_8.49.15_AM.png','kietho@gmail.com','Hồ Trinh Kiệt','$2a$10$GTTQLakSj3ZeHbz06hyJg.6uQWvrqr14yFuaOAdRlFUaQfU9JsnYC','9876543212',6),(9,'http://localhost:8082/assets/upload/Screen_Shot_2020-05-30_at_8.39.29_AM.png','quycao@gmail.com','Cao Trần Quý','$2a$10$8XTj/bp6wIH66QV6K9XlZuvgXp58.fNWHnwqFg1wPMa7DLax14rHG','1234567890',3),(10,'http://localhost:8082/assets/upload/Screen_Shot_2020-05-29_at_11.31.46_AM.png','conk@ttlecom.com','Kí Con','$2a$10$SQP7wDYB195H.TuriE5P7e1dvrBPoHR5Ivf5t4mDlU48yXiKNBnKC','423423423432',3),(13,'http://localhost:8082/assets/upload/avar04.png','xuanph@gmail.com','Phương Lê Xuân','$2a$10$SSl4deEOPQisCpwLMufGVetyIJaJfrGe368c8ILD28XaRaG4hdCfa','1231231231',3),(15,'http://localhost:8082/assets/upload/Screen_Shot_2020-05-29_at_11.31.46_AM.png','lyki@yahoo.com.vn','Kì Công Lý','$2a$10$AC5ykVbXwCE2Taa01PP4SuP8LpJvyKLLiWMAS5uYLTswkHXxgNiJu','1234567890',3),(17,'http://localhost:8082/assets/upload/avar01.jpg','tungle@gmail.com','Lê Văn Tùng','$2a$10$KLz76AXES7HhMZdX2WmDDOUa0O8DWWVaODRDaojIp2WUMqcmV1tQi','1234567899',2),(19,'http://localhost:8082/assets/upload/avar02.png','kytruong@gmail.com','Trương Vĩnh Ký','$2a$10$HMBYVQLxOXkkOEC8WHb0Z.T48zr/X57BABIEnk.ly3AwPS2xR0fNy','1234567890',3),(23,'http://localhost:8082/assets/upload/avar01.jpg','giaole@yahoo.com','Lê Quỳnh Giao','$2a$10$gH8SCvMdZz.AhXFRZgcWQeHZp/QQMJxudQPQo/tlc5.UfpzErjRXC','0912313213',3),(24,'http://localhost:8082/assets/upload/avar05.png','thucngo@gmail.com','Ngô Phương Duy Thức','$2a$10$cjx/QxH9v7xZUspv1xquGOW6BFNic8mJLGicUW3j6p/DYA438ynca','1234567890',3),(25,NULL,'tinle@gmail.com','Lê Trung Tín','$2a$10$LROSrfTyI/6mx2yP4SkQI.O.MUn3aI6uMoc3M5MOBn3WgdTLWgPXG','1234567890',3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_courses`
--

DROP TABLE IF EXISTS `users_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhnobs8cb619w5klgkfp61f7nx` (`course_id`),
  KEY `FKf9urfrtqmay7r1ee9s5v2ngk5` (`user_id`),
  CONSTRAINT `FKf9urfrtqmay7r1ee9s5v2ngk5` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKhnobs8cb619w5klgkfp61f7nx` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_courses`
--

LOCK TABLES `users_courses` WRITE;
/*!40000 ALTER TABLE `users_courses` DISABLE KEYS */;
INSERT INTO `users_courses` VALUES (38,2,12,4),(39,2,13,4),(40,2,14,4),(41,2,15,4),(42,2,16,4),(43,2,17,4),(44,2,18,4),(47,3,13,23),(48,3,15,23),(49,3,16,23),(50,3,19,23),(56,6,12,6),(57,6,13,6),(58,6,14,6),(59,6,17,6),(60,6,16,6),(61,6,18,6),(62,6,19,6),(63,3,12,19),(64,3,13,19),(65,3,14,19),(66,3,15,19),(67,3,16,19),(106,3,12,24),(107,3,13,24),(108,3,14,24),(118,1,12,1),(119,1,13,1),(120,1,14,1),(121,1,15,1),(122,1,16,1),(123,1,19,1),(124,1,17,1),(125,1,18,1),(126,2,12,17),(127,2,13,17),(128,2,19,17),(129,2,14,17),(130,2,15,17),(131,2,16,17),(132,2,17,17),(133,2,18,17),(134,3,12,13),(135,3,13,13),(136,3,14,13),(137,3,16,13),(138,3,17,13);
/*!40000 ALTER TABLE `users_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `order_index` int(11) DEFAULT NULL,
  `time_count` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrccvc1a5qx2dqsyienwhuk66j` (`course_id`),
  CONSTRAINT `FKrccvc1a5qx2dqsyienwhuk66j` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (13,12,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3_1.jpg',0,15,'Auto-Welcome Message','https://www.youtube.com/watch?v=v0t42xBIYIs'),(14,12,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3_2.jpg',0,45,'Variable Assignments ','https://www.youtube.com/watch?v=v0t42xBIYIs'),(15,12,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3_3.png',0,34,'Print Formatting with Strings','https://www.youtube.com/watch?v=v0t42xBIYIs'),(16,12,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3_4.jpg',0,23,'Dictionaries in Python','https://www.youtube.com/watch?v=v0t42xBIYIs'),(17,12,'http://localhost:8082/assets/upload/images/Complete_Python_Bootcamp-_Go_from_zero_to_hero_in_Python_3_5.png',0,33,'Resources for More Basic Practice','https://www.youtube.com/watch?v=v0t42xBIYIs'),(18,13,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change_1.png',0,24,'Solution to coding exercise: creating variables','https://www.youtube.com/watch?v=v0t42xBIYIs'),(19,13,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change_2.jpg',0,45,'The format() method','https://www.youtube.com/watch?v=v0t42xBIYIs'),(20,13,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change_3.png',0,23,'Solution to coding exercise: creating functions','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(21,13,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change_4.png',0,43,'Dataclasses in Python 3.7','https://www.youtube.com/watch?v=v0t42xBIYIs'),(22,13,'http://localhost:8082/assets/upload/images/The_Complete_Python_Web_Developer_Course_will_lead_you_down_a_path_of_understanding_and_skill_that_may_well,_with_work_and_patience,_result_in_an_income_boost_or_a_career_change_5.jpg',0,23,'Limiting some pages only to logged in users','https://www.youtube.com/watch?v=v0t42xBIYIs'),(23,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_1.jpg',0,65,'How to Start a Successful Company + Qualities of the Top Business People','https://www.youtube.com/watch?v=v0t42xBIYIs'),(24,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_2.jpg',0,83,' How to Legally Protect Your Company/Family in Business + Easy Overview of Taxes','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(25,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_3.jpg',0,96,'Unabridged 25 Page Downloadable Recap of Section 1','https://www.youtube.com/watch?v=v0t42xBIYIs'),(26,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_4.png',0,100,'Case Study on How to Deal with VC Firms Investing in Your Company Like Sequoia','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(27,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_5.jpg',0,34,'How to Value Private Companies the Easy Way + Growth Metrics','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(28,14,'http://localhost:8082/assets/upload/images/An_Entire_MBA_in_1_Course-Award_Winning_Business_School_Prof_6.png',0,55,'Additional Internet Resources for Section 9','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(29,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_1.jpg',0,53,'Why Most People Fail Digital Marketing','https://www.youtube.com/watch?v=v0t42xBIYIs'),(30,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_2.png',0,34,'The Digital Marketing System in 4 Minutes','https://www.youtube.com/watch?v=v0t42xBIYIs'),(31,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_3.jpg',0,12,'How to Use This Course','https://www.youtube.com/watch?v=v0t42xBIYIs'),(32,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_4.jpeg',0,52,'Free WordPress Alternatives','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(33,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_5.jpg',0,25,'Navigating WordPress','https://www.youtube.com/watch?v=v0t42xBIYIs'),(34,15,'http://localhost:8082/assets/upload/images/The_Complete_Digital_Marketing_Guide_-_18_Courses_in_1_6.png',0,23,'Getting Started Assignment','https://www.youtube.com/watch?v=v0t42xBIYIs'),(35,15,'/assets/images/1.png',0,31,'Building Your First Website Assignment','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(36,16,'http://localhost:8082/assets/upload/images/The_Art_&_Science_of_Drawing_1.jpg',0,45,'Final Drawing Demonstration, Closing Thoughts & Your Final Assignment','https://www.youtube.com/watch?v=v0t42xBIYIs'),(37,16,'http://localhost:8082/assets/upload/images/The_Art_&_Science_of_Drawing_2.jpg',0,55,'Supplementary Information: Bio / Materials / How to Use this Program','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(38,16,'http://localhost:8082/assets/upload/images/The_Art_&_Science_of_Drawing_3.jpg',0,63,'Drawing Demonstration: Botanicals Part 3','https://www.youtube.com/watch?v=v0t42xBIYIs'),(39,16,'http://localhost:8082/assets/upload/images/The_Art_&_Science_of_Drawing_4.png',0,73,'Drawing Demonstration: Figure Drawing Part 2','https://www.youtube.com/watch?v=v0t42xBIYIs'),(40,16,'http://localhost:8082/assets/upload/images/Final_Drawing_Demonstration,_Closing_Thoughts_&_Your_Final_Assignment_5.jpg',0,35,'Bonus Lecture: Continue Learning to Draw','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(41,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_1.jpg',0,34,'Value and the Underpainting','https://www.youtube.com/watch?v=v0t42xBIYIs'),(42,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_2.jpg',0,40,'Color Theory','https://www.youtube.com/watch?v=v0t42xBIYIs'),(43,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_3.jpg',0,50,'Composition and Still Life','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(44,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_4.jpg',0,36,'Landscape Drawing Part 1','https://www.youtube.com/watch?v=v0t42xBIYIs'),(45,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_5.jpg',0,53,'Landscape Drawing Part 2','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(46,17,'http://localhost:8082/assets/upload/images/The_Colored_Pencil_Drawing_Course_6.jpg',0,32,'Watercolor and Colored Pencils Part 1','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(47,18,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan_1.jpg',0,45,'How Much Protein Should You Consume Per Day?','https://www.youtube.com/watch?v=v0t42xBIYIs'),(48,18,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan_2.jpeg',0,35,'The Different Types Of Carbs','https://www.youtube.com/watch?v=v0t42xBIYIs'),(49,18,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan_3.jpg',0,50,'What About The Anabolic Window','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(50,18,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan_4.jpg',0,55,'Finding Your Ideal Carb Intake','https://www.youtube.com/watch?v=v0t42xBIYIs'),(51,18,'http://localhost:8082/assets/upload/images/Nutrition_Masterclass-_Build_Your_Perfect_Diet_&_Meal_Plan_5.jpg',0,62,'Quality Protein Sources','https://www.youtube.com/watch?v=v0t42xBIYIs'),(52,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced__1.jpg',0,45,' Drawing an eye - Step by Step','https://www.youtube.com/watch?v=v0t42xBIYIs'),(53,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced_2.jpg',0,55,'Adding the detail to your eye drawing','https://www.youtube.com/watch?v=v0t42xBIYIs'),(54,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced_3.jpg',0,32,'Basics of geometric and organic shapes','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(55,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced_4.jpg',0,38,'Learn the basics of geometric 3D form','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(56,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced_5.jpg',0,63,'Finding geometric forms in the human face','https://www.youtube.com/watch?v=fnpmR6Q5lEc'),(57,19,'http://localhost:8082/assets/upload/images/The_Ultimate_Drawing_Course_-_Beginner_to_Advanced_6.jpg',0,25,'Learn how to draw the nose','https://www.youtube.com/watch?v=fnpmR6Q5lEc');
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-04 10:24:55
