-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2021 a las 21:41:12
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IdCategoria` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `nombre`) VALUES
(1, 'Deporte'),
(2, 'Historia'),
(3, 'Entretenimiento'),
(4, 'Geografia'),
(5, 'Ciencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `nickname` varchar(25) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idHistorial` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `contenido` varchar(255) NOT NULL,
  `IdPregunta` int(11) NOT NULL,
  `Nivel` int(11) NOT NULL,
  `IdCategoria` int(11) NOT NULL,
  `puntos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`contenido`, `IdPregunta`, `Nivel`, `IdCategoria`, `puntos`) VALUES
('¿De donde es Luis Suarez?', 1, 1, 1, 25),
('¿Qué club uruguayo tiene mas años?', 2, 2, 1, 50),
('¿En que club de futbol juega Rodrigo Bentancour?', 3, 3, 1, 75),
('¿De que club de futbol es el estadio Old Tranfford?', 4, 4, 1, 100),
('¿Cuantas Champions League tiene el Real Madrid?', 5, 5, 1, 150),
('¿Cuándo acabó la II Guerra Mundial? ', 6, 1, 2, 25),
('¿En qué año fue el descubrimiento de América?', 7, 2, 2, 50),
('¿Cuándo llegó el primer hombre a la Luna?', 8, 3, 2, 75),
('¿Cuál es el idioma más hablado del mundo?', 9, 4, 2, 100),
('¿En qué países se encuentra el Everest?', 10, 5, 2, 150),
('¿Cuál fue la primera película de Disney?', 11, 1, 3, 25),
('¿Qué famoso youtuber español tiene su propia serie de animación?', 12, 2, 3, 50),
('¿Cómo se llama el líder de los Autobots en la saga de películas de “Transformers”?', 13, 3, 3, 75),
('¿Cómo se llama la madre de Simba en la película de “El rey león”?', 14, 4, 3, 100),
('¿En qué ciudad vive el mago de Oz?', 15, 5, 3, 150),
('¿Cuál es el río más caudaloso del mundo?', 16, 1, 4, 25),
('¿Qué país está entre Perú y Colombia?', 17, 2, 4, 50),
('¿Dónde se encuentra la Casa Rosada?', 18, 3, 4, 75),
('¿Por cuántos estados está formado Estados Unidos?', 19, 4, 4, 100),
('¿Entre qué países se encuentra el Estrecho de Bering?', 20, 5, 4, 150),
('¿Cuál es la velocidad de la luz?', 21, 1, 5, 25),
('¿Qué ciencia estudia la sangre?', 22, 2, 5, 50),
('¿Cuál es el animal más venenoso del mundo?', 23, 3, 5, 75),
('¿En qué lado del cuerpo está el hígado?', 24, 4, 5, 100),
('¿Cuántos elementos tiene la tabla periódica?', 25, 5, 5, 150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `IdPregunta` int(11) NOT NULL,
  `contenido` varchar(255) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  `IdRespuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`IdPregunta`, `contenido`, `tipo`, `IdRespuesta`) VALUES
(1, 'Uruguay', 1, 1),
(1, 'Argentina', 0, 2),
(1, 'España', 0, 3),
(1, 'Chile', 0, 4),
(2, 'Peñarol', 1, 5),
(2, 'Nacional', 0, 6),
(2, 'Defensor SP', 0, 7),
(2, 'Albion ', 0, 8),
(3, 'Barcelona', 0, 9),
(3, 'Inter ', 0, 10),
(3, 'Juventus', 1, 11),
(3, 'Milan', 0, 12),
(4, 'Chelsea FC', 0, 13),
(4, 'Liverpool', 0, 14),
(4, 'Manchester United', 1, 15),
(4, 'Manchester City', 0, 16),
(5, '12', 0, 17),
(5, '13', 1, 18),
(5, '14', 0, 19),
(5, '11', 0, 20),
(6, '1946', 0, 21),
(6, '1945', 1, 22),
(6, '1944', 0, 23),
(6, '1947', 0, 24),
(7, '1492', 1, 25),
(7, '1485', 0, 26),
(7, '1500', 0, 27),
(7, '1470', 0, 28),
(8, '1969', 1, 29),
(8, '1975', 0, 30),
(8, '1960', 0, 31),
(8, '1965', 0, 32),
(9, 'Ingles', 0, 33),
(9, 'Chino Mandarin', 1, 34),
(9, 'Español', 0, 35),
(9, 'Frances', 0, 36),
(10, 'China y Nepal', 1, 37),
(10, 'China y Japon', 0, 38),
(10, 'Nepal y India', 0, 39),
(10, 'India y Japon', 0, 40),
(11, 'Blancanieves', 1, 41),
(11, 'Mickey Mouse', 0, 42),
(11, 'El Pájaro Loco', 0, 43),
(11, 'Tomm y Jerry', 0, 44),
(12, 'El Rubius', 1, 45),
(12, 'Auron Play', 0, 46),
(12, 'Ibai', 0, 47),
(12, 'Vegeta 777', 0, 48),
(13, 'Optimus Prime', 1, 49),
(13, 'Megatron', 0, 50),
(13, 'Bumblebee', 0, 51),
(13, 'Jazz', 0, 52),
(14, 'Sarabi', 1, 53),
(14, 'Sarubi', 0, 54),
(14, 'Lucia', 0, 55),
(14, 'Sumba', 0, 56),
(15, 'La ciudad Esmeralda', 1, 57),
(15, 'La ciudad se Oro', 0, 58),
(15, 'La ciudad de plata', 0, 59),
(15, 'La ciudad embrujada', 0, 60),
(16, 'Amazonas', 1, 61),
(16, 'Rio Nilo', 0, 62),
(16, 'Rio Parana', 0, 63),
(16, 'Rio Uruguay', 0, 64),
(17, 'Ecuador', 1, 65),
(17, 'Venezuela', 0, 66),
(17, 'Bolivia', 0, 67),
(17, 'Paraguay', 0, 68),
(18, 'Argentina', 1, 69),
(18, 'Uruguay', 0, 70),
(18, 'Brasil', 0, 71),
(18, 'Chile', 0, 72),
(19, '50', 1, 73),
(19, '49', 0, 74),
(19, '45', 0, 75),
(19, '52', 0, 76),
(20, 'Estados Unidos y Rusia', 1, 77),
(20, 'Inglaterra y Escocia ', 0, 78),
(20, 'Russia y Canada', 0, 79),
(20, 'Estados Unidos y Mexico', 0, 80),
(21, '300.000 km/s', 1, 81),
(21, '200.000 km/s', 0, 82),
(21, '250.000 km/s', 0, 83),
(21, '190.000 km/s', 0, 84),
(22, 'Hematología', 1, 85),
(22, 'Cardiologia', 0, 86),
(22, 'Neurología', 0, 87),
(22, 'Dermatología', 0, 88),
(23, 'Mamba Negra', 0, 89),
(23, 'La medusa avispa de mar', 1, 90),
(23, 'Pez piedra', 0, 91),
(23, 'Rana punta de flecha', 0, 92),
(24, 'Derecho', 1, 93),
(24, 'Izquierdo', 0, 94),
(24, 'Centro', 0, 95),
(24, 'Atras', 0, 96),
(25, '118', 1, 97),
(25, '120', 0, 98),
(25, '100', 0, 99),
(25, '112', 0, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `nickname` varchar(25) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `clave` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `apellido`, `nickname`, `idUsuario`, `clave`) VALUES
('Lucas', 'Milessi', 'Lucasbohe', 1, 'Passw0rd'),
('Fernando', 'Hernandez', 'fish', 2, 'fish');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`idHistorial`),
  ADD KEY `historial` (`idUsuario`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`IdPregunta`),
  ADD KEY `preguntas` (`IdCategoria`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`IdRespuesta`),
  ADD KEY `respuesta` (`IdPregunta`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `nickname` (`nickname`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `idHistorial` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `IdRespuesta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`);

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`);

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `respuesta` FOREIGN KEY (`IdPregunta`) REFERENCES `preguntas` (`IdPregunta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
