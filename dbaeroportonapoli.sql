-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2025 at 05:16 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbaeroportonapoli`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `booking_number` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `seat_number` varchar(255) NOT NULL,
  `booking_status` enum('CONFIRMED','PENDING','CANCELLED','','') NOT NULL DEFAULT 'CONFIRMED'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `user_id`, `flight_id`, `booking_number`, `first_name`, `last_name`, `seat_number`, `booking_status`) VALUES
(1, 3, 4, 25, 'ottanio', 'carciofo', 'B4', 'CONFIRMED');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `flight_number` varchar(255) NOT NULL,
  `flight_company` varchar(255) NOT NULL,
  `scheduled_date` date NOT NULL,
  `planned_time` time NOT NULL,
  `delay_time` time DEFAULT NULL,
  `departure_airport` varchar(255) NOT NULL,
  `arrival_airport` varchar(255) NOT NULL,
  `assigned_gate` varchar(255) DEFAULT NULL,
  `flight_status` enum('SCHEDULED','BOARDING','DEPARTED','DELAYED','IN_AIR','LANDED','CANCELLED','DIVERTED','UNKNOWN') NOT NULL DEFAULT 'SCHEDULED'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `flight_number`, `flight_company`, `scheduled_date`, `planned_time`, `delay_time`, `departure_airport`, `arrival_airport`, `assigned_gate`, `flight_status`) VALUES
(1, 'N34B', 'VolaFelice', '2025-10-10', '18:00:00', '00:00:00', 'Napoli', 'BARI', 'N43', 'IN_AIR'),
(2, 'N717F', 'VolaSereno', '2025-02-27', '18:15:00', NULL, 'Napoli', 'Firenze', NULL, 'SCHEDULED'),
(3, 'B65N', 'VolaVeramenteBene', '2025-07-25', '07:30:00', '00:00:00', 'Bergamo', 'Napoli', 'B73', 'DIVERTED'),
(4, 'R93T', 'Volasudai', '2025-08-14', '09:15:00', '00:00:00', 'Rimini', 'Torino', 'J65', 'IN_AIR'),
(5, 'B331B', 'MaCheVoliAFare', '2025-12-12', '10:00:00', '08:00:00', 'Bergamo', 'BaiaDomizia', 'N65', 'DIVERTED'),
(6, 'N933N', 'MaDavveroVuoiVolare', '2025-12-12', '04:45:00', '00:00:00', 'NewYork', 'Napoli', NULL, 'BOARDING'),
(7, 'B681N', 'MaCheVOliAFAre', '2005-12-24', '18:25:00', NULL, 'Barcellona', 'Napoli', NULL, 'SCHEDULED');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `admin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `admin`) VALUES
(1, 'Mario', '1234', 1),
(2, 'Pietro', 'nonadmin', NULL),
(3, 'ottanio', 'Carrucola', 0),
(4, 'Gianluca', '12345', 0),
(5, 'Gianluca21', '12345f', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
