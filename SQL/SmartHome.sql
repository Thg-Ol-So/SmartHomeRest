CREATE DATABASE SmartHome;
USE SmartHome;
DROP TABLE IF EXISTS `smarthome`;
CREATE TABLE `smarthome` (
  `id` int(11) NOT NULL AUTO_INCREMENT primary key,
  `dia_hora` datetime NOT NULL UNIQUE,
  `quarto` varchar(20) NOT NULL,
  `sala` varchar(20) NOT NULL,
  `tv` varchar(20) NOT NULL,
  `ventilador` varchar(20) NOT NULL,
  `estado` varchar(10) DEFAULT NULL);
