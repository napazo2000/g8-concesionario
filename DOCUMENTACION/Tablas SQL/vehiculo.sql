USE `concesionario`;

DROP TABLE IF EXISTS `vehiculo`;

CREATE TABLE `vehiculo` (
  `idVehiculo` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(100) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `tipoOferta` varchar(20) DEFAULT NULL,
  `kilometros` int DEFAULT NULL,
  `cilindrada` varchar(20) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `tipoCombustible` varchar(20) DEFAULT NULL,
  `tipoCambio` varchar(20) DEFAULT NULL,
  `anyoFabricacion` int DEFAULT NULL,
  `precioSinIva` double DEFAULT NULL,
  `matricula` varchar(15) DEFAULT NULL,
  `dispo` int DEFAULT NULL,
  `foto` longblob,
  PRIMARY KEY (`idVehiculo`)
);

show tables;
