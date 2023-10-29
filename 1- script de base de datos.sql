-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2023 a las 23:41:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vacunatorio`
--
CREATE DATABASE IF NOT EXISTS `vacunatorio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacunatorio`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centrovacunacion`
--

CREATE TABLE `centrovacunacion` (
  `idCV` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `centrovacunacion`
--

INSERT INTO `centrovacunacion` (`idCV`, `nombre`, `localidad`, `provincia`, `direccion`, `estado`) VALUES
(1, 'uritorco', 'capilla del monte', 'cordoba', 'los talas 908', 1),
(2, 'polideportivo', 'pergamino', 'buenos aires', 'calle mitre 54', 1),
(3, 'pilar norte', 'pilar', 'buenos aires', 'belgrano 65', 1),
(4, 'pilar sur', 'pilar', 'buenos aires', 'dean funes 900', 1),
(5, 'hospital municipal', 'pergamino', 'buenos aires', 'jujuy 655', 1),
(6, 'hospital luqui', 'capilla del monte', 'cordoba', 'samiento 25', 1),
(9, 'club colon', 'parana', 'entre rios', 'av colon 222', 1),
(10, 'salita municipal', 'parana', 'entre rios', 'mitre 23', 1),
(11, 'hospital castillo', 'concordia', 'entre rios', 'av santa fe  676', 1),
(12, 'club platense', 'concordia', 'entre rios', 'las heras 2569', 1),
(13, 'dispensario', 'carlos paz', 'cordoba', 'saavedra 567', 1),
(14, 'policlinico', 'carlos paz', 'cordoba', 'lavelle 1456', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id_cita` int(20) NOT NULL,
  `ciudadano` bigint(20) NOT NULL,
  `fecha_cita` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `centro_vacunacion` int(11) NOT NULL,
  `fecha_colocacion` timestamp NULL DEFAULT NULL,
  `vacuna` bigint(20) DEFAULT NULL,
  `codigo_refuerzo` int(2) NOT NULL,
  `estado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id_cita`, `ciudadano`, `fecha_cita`, `centro_vacunacion`, `fecha_colocacion`, `vacuna`, `codigo_refuerzo`, `estado`) VALUES
(2, 28179377, '2023-10-27 11:00:00', 2, '2023-10-05 13:20:00', 1234, 1, 1),
(5, 34567890, '2023-10-07 11:15:00', 2, '2023-10-01 14:00:00', 1236, 1, 1),
(6, 98765432, '2023-08-14 12:00:00', 9, '2023-10-25 19:10:00', 1235, 1, 1),
(7, 31489790, '2023-09-28 12:30:00', 1, NULL, NULL, 1, 0),
(8, 12345678, '2023-09-18 17:30:00', 4, '2023-11-13 15:05:00', 1237, 1, 1),
(9, 23456789, '2023-10-29 20:12:06', 4, NULL, NULL, 1, 2),
(10, 45678901, '2023-07-14 12:05:00', 5, '2023-08-14 16:00:00', 2222, 1, 1),
(11, 78901234, '2023-11-15 12:00:00', 11, NULL, NULL, 1, 0),
(12, 89012345, '2023-11-28 15:05:00', 12, NULL, NULL, 1, 0),
(13, 90123456, '2023-10-29 20:59:28', 9, NULL, NULL, 1, 2),
(14, 28179377, '2023-11-24 11:00:00', 6, '2023-11-24 13:00:00', 4560, 2, 1),
(15, 90123456, '2023-10-28 11:00:00', 9, '2023-11-16 17:05:00', 2345, 1, 1),
(16, 56789012, '2023-10-29 21:51:05', 13, NULL, NULL, 1, 2),
(17, 67890123, '2023-11-16 13:00:00', 14, NULL, NULL, 1, 0),
(18, 56789012, '2023-10-01 11:00:00', 13, NULL, NULL, 1, 0),
(19, 23456789, '2023-11-02 12:00:00', 3, NULL, NULL, 1, 0),
(20, 34567890, '2023-10-29 21:59:47', 5, NULL, NULL, 2, 2),
(21, 34567890, '2023-11-04 11:15:00', 5, '2023-11-04 13:00:00', 2346, 2, 1),
(22, 34567890, '2023-12-02 11:15:00', 5, '2023-12-02 14:00:00', 1111, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `dni` bigint(20) NOT NULL,
  `nombre_completo` varchar(50) NOT NULL,
  `correo_electronico` varchar(30) NOT NULL,
  `telefono` bigint(15) NOT NULL,
  `patologia` varchar(50) DEFAULT NULL,
  `ambito_laboral` varchar(20) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `provincia` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`dni`, `nombre_completo`, `correo_electronico`, `telefono`, `patologia`, `ambito_laboral`, `localidad`, `provincia`) VALUES
(12345678, 'juan lopez', 'juan@gmail.com', 1122334455, 'bronquitis', 'Educación', 'Pilar', 'Buenos Aires'),
(23456789, 'ana sanchez', 'anita@gmail.com', 1133445566, 'asma', 'Otros', 'Pilar', 'Buenos aires'),
(28179377, 'andres sampedro', 'andres80@gmail.com', 1125236833, '', 'Otros', 'Capilla del Monte', 'Cordoba'),
(31489790, 'gabriela costa', 'gabi@gmail.com', 2323551585, '', 'Salud', 'Capilla del Monte', 'Cordoba'),
(34567890, 'luis rodriguez', 'luchi@hotmail.com', 1156567878, 'artritris reumatoidea', 'Otros', 'Pergamino', 'Buenos Aires'),
(45678901, 'lila araoz', 'lila@yahoo.com.ar', 1178789090, '', 'Salud', 'Pergamino', 'Buenos Aires'),
(56789012, 'javier  montez', 'javo@hotmail.com', 1133445566, '', 'Educación', 'Carlos Paz', 'Cordoba'),
(67890123, 'tomas napoli', 'tomi@gmail.com', 1155665566, '', 'Otros', 'Carlos Paz', 'Cordoba'),
(78901234, 'lara ramirez', 'lara_4@gmail.com', 1167867855, 'asma', 'Educación', 'Concordia', 'Entre Rios'),
(89012345, 'raul perez', 'rau23@yahoo.com.ar', 1134564455, '', 'Salud', 'Concordia', 'Entre Rios'),
(90123456, 'ariel montoya', 'ari_22@gmail.com', 1156785566, '', 'Otros', 'Paraná', 'Entre Rios'),
(98765432, 'benjamin silva', 'ben10@gmail.com', 1122334455, '', 'Otros', 'Paraná', 'Entre Rios');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `cuit` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `pais_origen` varchar(30) NOT NULL,
  `direccion_fiscal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`cuit`, `nombre`, `pais_origen`, `direccion_fiscal`) VALUES
(20324567683, 'astrazeneca', 'eeuu', 'av lincoln 78'),
(21123456789, 'sputnik', 'rusia', 'av putin 56'),
(23445566778, 'moderna', 'eeuu', 'washington 906'),
(25667788991, 'pfizer', 'eeuu', 'av franklin 555'),
(34123454567, 'sinopharm', 'china', 'chun li 33');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `nro_serie` bigint(20) NOT NULL,
  `cuit` bigint(20) NOT NULL,
  `dosis` decimal(2,1) NOT NULL,
  `nombre_vacuna` varchar(20) NOT NULL,
  `antigeno` varchar(20) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `aplicada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`nro_serie`, `cuit`, `dosis`, `nombre_vacuna`, `antigeno`, `fecha_vencimiento`, `aplicada`) VALUES
(1111, 25667788991, 0.3, 'pfizer', 'sarscov2', '2024-12-31', 1),
(1234, 21123456789, 0.9, 'sputnik', 'sarscov2', '2023-10-31', 1),
(1235, 20324567683, 0.3, 'astrazeneca', 'sarscov2', '2023-10-30', 1),
(1236, 34123454567, 0.5, 'sinopharm', 'sarscov2', '2023-12-31', 1),
(1237, 23445566778, 0.3, 'moderna', 'sarscov2', '2023-12-31', 1),
(1238, 23445566778, 0.3, 'moderna', 'sarscov2', '2024-12-31', 0),
(1239, 23445566778, 0.3, 'moderna', 'sarscov2', '2024-12-31', 0),
(1240, 23445566778, 0.3, 'moderna', 'sarscov2', '2024-12-31', 0),
(1241, 23445566778, 0.3, 'moderna', 'sarscov2', '2024-12-31', 0),
(2222, 25667788991, 0.3, 'pfizer', 'sarscov2', '2024-12-31', 1),
(2345, 20324567683, 0.3, 'astrazeneca', 'sarscov2', '2024-12-31', 1),
(2346, 20324567683, 0.3, 'astrazeneca', 'sarscov2', '2024-12-31', 1),
(2347, 20324567683, 0.3, 'astrazeneca', 'sarscov2', '2024-12-31', 0),
(2348, 20324567683, 0.3, 'astrazeneca', 'sarscov2', '2024-12-31', 0),
(3333, 25667788991, 0.3, 'pfizer', 'sarscov2', '2024-12-31', 0),
(3456, 34123454567, 0.5, 'sinopharm', 'sarscov2', '2024-12-31', 0),
(3457, 34123454567, 0.5, 'sinopharm', 'sarscov2', '2024-12-31', 0),
(3458, 34123454567, 0.5, 'sinopharm', 'sarscov2', '2024-12-31', 0),
(3459, 34123454567, 0.5, 'sinopharm', 'sarscov2', '2024-12-31', 0),
(4444, 25667788991, 0.3, 'pfizer', 'sarscov2', '2024-12-31', 0),
(4560, 21123456789, 0.9, 'sputnik', 'sarscov2', '2024-12-31', 1),
(4567, 21123456789, 0.9, 'sputnik', 'sarscov2', '2024-12-31', 0),
(4568, 21123456789, 0.9, 'sputnik', 'sarscov2', '2024-12-31', 0),
(4569, 21123456789, 0.9, 'sputnik', 'sarscov2', '2024-12-31', 0),
(5555, 25667788991, 0.3, 'pfizer', 'sarscov2', '2024-12-31', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centrovacunacion`
--
ALTER TABLE `centrovacunacion`
  ADD PRIMARY KEY (`idCV`);

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id_cita`),
  ADD KEY `ciudadano` (`ciudadano`),
  ADD KEY `vacuna` (`vacuna`),
  ADD KEY `centroVacunacion` (`centro_vacunacion`);

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`cuit`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`nro_serie`),
  ADD KEY `laboratorio` (`cuit`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centrovacunacion`
--
ALTER TABLE `centrovacunacion`
  MODIFY `idCV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id_cita` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `centroVacunacion` FOREIGN KEY (`centro_vacunacion`) REFERENCES `centrovacunacion` (`idCV`),
  ADD CONSTRAINT `ciudadano` FOREIGN KEY (`ciudadano`) REFERENCES `ciudadano` (`dni`),
  ADD CONSTRAINT `vacuna` FOREIGN KEY (`vacuna`) REFERENCES `vacuna` (`nro_serie`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `laboratorio` FOREIGN KEY (`cuit`) REFERENCES `laboratorio` (`cuit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
