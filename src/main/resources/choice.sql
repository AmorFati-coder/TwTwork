CREATE TABLE `vote` (
  `vote_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `choice_id` int NOT NULL,
  `subject` varchar(255) NOT NULL,
  PRIMARY KEY (`vote_id`),
  KEY `user_id` (`user_id`),
  KEY `choice_id` (`choice_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci