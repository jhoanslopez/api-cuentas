-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 04, 2023 at 09:55 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuentasbd`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `persona_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`id`, `contrasena`, `estado`, `persona_id`) VALUES
(1, '1234', 1, 1),
(2, '33', 1, 3),
(3, 'string', 1, 4),
(4, 'string', 1, 7);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_cuenta`
--

CREATE TABLE `cliente_cuenta` (
  `id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `cuenta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cliente_cuenta`
--

INSERT INTO `cliente_cuenta` (`id`, `cliente_id`, `cuenta_id`) VALUES
(1, 1, 1),
(8, 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `cuenta`
--

CREATE TABLE `cuenta` (
  `id` int(11) NOT NULL,
  `numero_cuenta` bigint(20) NOT NULL,
  `tipo_cuenta_id` int(11) NOT NULL,
  `saldo` bigint(20) NOT NULL DEFAULT 0,
  `estado` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Cuentas de los clientes';

--
-- Dumping data for table `cuenta`
--

INSERT INTO `cuenta` (`id`, `numero_cuenta`, `tipo_cuenta_id`, `saldo`, `estado`) VALUES
(1, 123123, 1, 140000, 1),
(2, 310, 1, 100000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE `genero` (
  `id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`id`, `codigo`, `descripcion`) VALUES
(1, 'NN', 'No Definido'),
(2, 'M', 'Masculino'),
(3, 'F', 'Femenino');

-- --------------------------------------------------------

--
-- Table structure for table `movimiento`
--

CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `cuenta_id` int(11) NOT NULL,
  `tipo_movimiento_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `saldo_inicial` bigint(20) NOT NULL,
  `valor_movimiento` bigint(20) NOT NULL,
  `saldo_disponible` bigint(20) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Movimientos bancarios realizados a una cuenta';

--
-- Dumping data for table `movimiento`
--

INSERT INTO `movimiento` (`id`, `cuenta_id`, `tipo_movimiento_id`, `cliente_id`, `saldo_inicial`, `valor_movimiento`, `saldo_disponible`, `fecha`) VALUES
(1, 2, 1, 4, 99000, 1000, 100000, '2023-02-04 14:49:28'),
(2, 2, 1, 4, 99000, 1000, 100000, '2023-02-04 14:52:11'),
(3, 2, 2, 4, 100000, -100000, 0, '2023-02-04 14:52:40'),
(4, 2, 1, 4, 0, 100000, 100000, '2023-02-04 15:01:37');

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `genero_id` int(11) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `tipo_identificacion_id` int(11) NOT NULL,
  `direccion` varchar(300) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `nombre`, `genero_id`, `edad`, `tipo_identificacion_id`, `direccion`, `telefono`) VALUES
(1, 'Jose Lema', 2, 30, 1, 'Otavalo sn y principal', '098254785'),
(2, 'Jhoan', 2, 24, 1, 'string', 'string'),
(3, 'Jhoan20000', 3, 37, 1, '11', '22'),
(4, 'Jhoan', 2, 24, 1, 'string', 'string'),
(6, 'Jhoan', 2, 24, 1, 'string', 'string'),
(7, 'Jhoan', 2, 24, 1, 'string', 'string'),
(10, 'Jhoan20000', 3, 37, 1, '11', '22');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tipos de cuenta bancaría';

--
-- Dumping data for table `tipo_cuenta`
--

INSERT INTO `tipo_cuenta` (`id`, `codigo`, `descripcion`) VALUES
(1, 'AHO', 'Ahorro'),
(2, 'COR', 'Corriente');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_identificacion`
--

CREATE TABLE `tipo_identificacion` (
  `id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipo_identificacion`
--

INSERT INTO `tipo_identificacion` (`id`, `codigo`, `descripcion`) VALUES
(1, 'CC', 'Cédula de Ciudadanía');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_movimiento`
--

CREATE TABLE `tipo_movimiento` (
  `id` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipo_movimiento`
--

INSERT INTO `tipo_movimiento` (`id`, `codigo`, `descripcion`) VALUES
(1, 'CRE', 'Crédito'),
(2, 'DEB', 'Débito');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_persona_FK` (`persona_id`);

--
-- Indexes for table `cliente_cuenta`
--
ALTER TABLE `cliente_cuenta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cliente_cuenta_un` (`cuenta_id`),
  ADD KEY `cliente_cuenta_cliente_FK` (`cliente_id`);

--
-- Indexes for table `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cuenta_tipo_cuenta_FK` (`tipo_cuenta_id`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `genero_un` (`codigo`);

--
-- Indexes for table `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `movimiento_cuenta_FK` (`cuenta_id`),
  ADD KEY `movimiento_tipo_movimiento_FK` (`tipo_movimiento_id`),
  ADD KEY `movimiento_cliente_FK` (`cliente_id`);

--
-- Indexes for table `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `persona_genero_FK` (`genero_id`),
  ADD KEY `persona_tipo_identificacion_FK` (`tipo_identificacion_id`);

--
-- Indexes for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tipo_cuenta_un` (`codigo`);

--
-- Indexes for table `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tipo_identificacion_un` (`codigo`);

--
-- Indexes for table `tipo_movimiento`
--
ALTER TABLE `tipo_movimiento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tipo_movimiento_un` (`codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cliente_cuenta`
--
ALTER TABLE `cliente_cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `genero`
--
ALTER TABLE `genero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tipo_movimiento`
--
ALTER TABLE `tipo_movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_persona_FK` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`);

--
-- Constraints for table `cliente_cuenta`
--
ALTER TABLE `cliente_cuenta`
  ADD CONSTRAINT `cliente_cuenta_cliente_FK` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `cliente_cuenta_cuenta_FK` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`id`);

--
-- Constraints for table `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `cuenta_tipo_cuenta_FK` FOREIGN KEY (`tipo_cuenta_id`) REFERENCES `tipo_cuenta` (`id`);

--
-- Constraints for table `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_cliente_FK` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `movimiento_cuenta_FK` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`id`),
  ADD CONSTRAINT `movimiento_tipo_movimiento_FK` FOREIGN KEY (`tipo_movimiento_id`) REFERENCES `tipo_movimiento` (`id`);

--
-- Constraints for table `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_genero_FK` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`),
  ADD CONSTRAINT `persona_tipo_identificacion_FK` FOREIGN KEY (`tipo_identificacion_id`) REFERENCES `tipo_identificacion` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
