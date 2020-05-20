create database if not exists concesionario;

USE `concesionario`;

DROP TABLE IF EXISTS `operacion`;

CREATE TABLE `operacion` (
  `IDoperacion` int NOT NULL AUTO_INCREMENT,
  `Idvendedor` int NOT NULL,
  `IDvehiculo` int NOT NULL,
  `IDcliente` int NOT  NULL,
  `Date` varchar(12) NOT NULL,
  `Numdias` int DEFAULT NULL,
  `Importe`  double NOT NULL,
  `Financiacion` varchar(2) NOT NULL,
  `Meses`  int NOT NULL,
  `Formapago` varchar(30) DEFAULT NULL,
  `Tipooferta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDoperacion`),
  FOREIGN KEY (`Idvendedor`) REFERENCES usuario(`idUsuario`),
  FOREIGN KEY (`IDvehiculo`) REFERENCES vehiculo(`idVehiculo`),
  FOREIGN KEY (`IDcliente`) REFERENCES usuario(`idUsuario`)


);


show tables;