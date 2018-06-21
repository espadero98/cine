-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2018 a las 16:05:38
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actor`
--

CREATE TABLE `actor` (
  `idActor` varchar(3) NOT NULL,
  `actor` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actor`
--

INSERT INTO `actor` (`idActor`, `actor`) VALUES
('a10', 'mich'),
('ss1', 'enrique');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `idClasificacion` varchar(3) NOT NULL,
  `clasificacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clasificacion`
--

INSERT INTO `clasificacion` (`idClasificacion`, `clasificacion`) VALUES
('bb1', 'mayores de 18 años');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `director`
--

CREATE TABLE `director` (
  `idDirector` varchar(3) NOT NULL,
  `director` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `director`
--

INSERT INTO `director` (`idDirector`, `director`) VALUES
('21w', 'weon '),
('dd1', 'enrique tercero'),
('qq1', 'zukaritas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idGenero` varchar(3) NOT NULL,
  `genero` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idGenero`, `genero`) VALUES
('gg1', 'drama'),
('pl2', 'ciencia ficcion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` varchar(3) NOT NULL,
  `pelicula` varchar(200) NOT NULL,
  `duracion` varchar(4) NOT NULL,
  `estreno` varchar(100) NOT NULL,
  `sinopsis` varchar(900) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `pelicula`, `duracion`, `estreno`, `sinopsis`) VALUES
('aa2', 'kdsljfldsñlkdñlsk', '5', 'shiit', 'hey bitch'),
('lll', 'kdjsjkd', '7', 'mañana', 'chingue a su madre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculaactor`
--

CREATE TABLE `peliculaactor` (
  `idPelicula` varchar(3) NOT NULL,
  `idActor` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculaactor`
--

INSERT INTO `peliculaactor` (`idPelicula`, `idActor`) VALUES
('lll', 'a10'),
('lll', 'a10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculaclasificacion`
--

CREATE TABLE `peliculaclasificacion` (
  `idPelicula` varchar(3) NOT NULL,
  `idClasificacion` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculaclasificacion`
--

INSERT INTO `peliculaclasificacion` (`idPelicula`, `idClasificacion`) VALUES
('lll', 'bb1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculadirector`
--

CREATE TABLE `peliculadirector` (
  `idPelicula` varchar(3) NOT NULL,
  `idDirector` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculadirector`
--

INSERT INTO `peliculadirector` (`idPelicula`, `idDirector`) VALUES
('lll', 'dd1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculagenero`
--

CREATE TABLE `peliculagenero` (
  `idPelicula` varchar(3) NOT NULL,
  `idGenero` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculagenero`
--

INSERT INTO `peliculagenero` (`idPelicula`, `idGenero`) VALUES
('lll', 'gg1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`idActor`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`idClasificacion`);

--
-- Indices de la tabla `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`idDirector`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `peliculaactor`
--
ALTER TABLE `peliculaactor`
  ADD KEY `idPelicula_2` (`idPelicula`),
  ADD KEY `idActor` (`idActor`);

--
-- Indices de la tabla `peliculaclasificacion`
--
ALTER TABLE `peliculaclasificacion`
  ADD KEY `idPelicula_2` (`idPelicula`),
  ADD KEY `idClasificacion` (`idClasificacion`);

--
-- Indices de la tabla `peliculadirector`
--
ALTER TABLE `peliculadirector`
  ADD KEY `idPelicula_2` (`idPelicula`),
  ADD KEY `idDirector` (`idDirector`);

--
-- Indices de la tabla `peliculagenero`
--
ALTER TABLE `peliculagenero`
  ADD KEY `idPelicula_2` (`idPelicula`),
  ADD KEY `idGenero` (`idGenero`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `peliculaactor`
--
ALTER TABLE `peliculaactor`
  ADD CONSTRAINT `peliculaactor_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `peliculaactor_ibfk_4` FOREIGN KEY (`idActor`) REFERENCES `actor` (`idActor`);

--
-- Filtros para la tabla `peliculaclasificacion`
--
ALTER TABLE `peliculaclasificacion`
  ADD CONSTRAINT `peliculaclasificacion_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `peliculaclasificacion_ibfk_4` FOREIGN KEY (`idClasificacion`) REFERENCES `clasificacion` (`idClasificacion`);

--
-- Filtros para la tabla `peliculadirector`
--
ALTER TABLE `peliculadirector`
  ADD CONSTRAINT `peliculadirector_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `peliculadirector_ibfk_4` FOREIGN KEY (`idDirector`) REFERENCES `director` (`idDirector`);

--
-- Filtros para la tabla `peliculagenero`
--
ALTER TABLE `peliculagenero`
  ADD CONSTRAINT `peliculagenero_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `peliculagenero_ibfk_4` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
