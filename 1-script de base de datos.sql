-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-10-2023 a las 23:42:37
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
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id_cita` int(20) NOT NULL,
  `ciudadano` bigint(20) NOT NULL,
  `fecha_cita` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `centro_vacunacion` varchar(30) NOT NULL,
  `fecha_colocacion` timestamp NULL DEFAULT NULL,
  `vacuna` bigint(20) NOT NULL,
  `codigo_refuerzo` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id_cita`, `ciudadano`, `fecha_cita`, `centro_vacunacion`, `fecha_colocacion`, `vacuna`, `codigo_refuerzo`) VALUES
(0, 34155039, '2023-12-10 18:00:00', 'Springfield', '2023-12-10 18:15:00', 222555888, 1);

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
  `ambito_laboral` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`dni`, `nombre_completo`, `correo_electronico`, `telefono`, `patologia`, `ambito_laboral`) VALUES
(34155039, 'Federico Acenjo', 'federico@asdasd.com', 1155522255, NULL, 'casa');

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
(32555666, 'Umbrella', 'EEUU', 'Calle falsa 123, Pueblo Fantasma');

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
(222555888, 32555666, 0.3, 'UZ1', 'Z01', '2024-12-10', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id_cita`),
  ADD KEY `ciudadano` (`ciudadano`),
  ADD KEY `vacuna` (`vacuna`);

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
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
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
