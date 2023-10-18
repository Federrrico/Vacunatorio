-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2023 a las 00:41:48
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

DROP TABLE IF EXISTS `centrovacunacion`;
CREATE TABLE `centrovacunacion` (
  `idCV` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

DROP TABLE IF EXISTS `cita`;
CREATE TABLE `cita` (
  `id_cita` int(20) NOT NULL,
  `ciudadano` bigint(20) NOT NULL,
  `fecha_cita` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `centro_vacunacion` int(11) NOT NULL,
  `fecha_colocacion` timestamp NULL DEFAULT NULL,
  `vacuna` bigint(20) NOT NULL,
  `codigo_refuerzo` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
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
(222222, '22222222', '2222222', '222222'),
(999999, '99999999', '9999999', '99999999'),
(11111111, '11111111', '111111111', '111111111'),
(32555666, 'Umbrella', 'EEUU', 'Calle falsa 123, Pueblo Fantasma'),
(34534534, 'asdqwe', 'asdwqe', 'asd2qwe'),
(65656565, 'asdasdasd', 'asdasdasd', 'asdasdasd'),
(88888888, '88888888', '8888', '88888'),
(7777777777, '77777777777', '7777777', '777777');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

DROP TABLE IF EXISTS `vacuna`;
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
(222555888, 32555666, 0.3, 'UZ1', 'Z01', '2024-12-10', 1);

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
  MODIFY `idCV` int(11) NOT NULL AUTO_INCREMENT;

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
