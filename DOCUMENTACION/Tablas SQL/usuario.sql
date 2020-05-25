USE `concesionario`;

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `correo` varchar(100) DEFAULT NULL,  
  `password` int DEFAULT NULL,
  `dni` varchar(15) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `fecNac` varchar(10) DEFAULT NULL,
  `movil` int DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `codPostal` int DEFAULT NULL,
  `ciudad` varchar(20) DEFAULT NULL,
  `provincia` varchar(20) DEFAULT NULL,
  `tipoRol` varchar(20) DEFAULT NULL,
  `foto` longblob,
  PRIMARY KEY (`idUsuario`)
);

show tables;

