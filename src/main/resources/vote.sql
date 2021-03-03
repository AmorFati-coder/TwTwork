CREATE TABLE `choice` (
  `choice_id` int NOT NULL AUTO_INCREMENT,
  `text` varchar(255) NOT NULL,
  `count` int DEFAULT '0',
  UNIQUE KEY `choice_choice_id_uindex` (`choice_id`),
  CONSTRAINT `choice_id` FOREIGN KEY (`choice_id`) REFERENCES `vote` (`choice_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci