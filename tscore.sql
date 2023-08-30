-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2023 at 05:13 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `tscore`
--

CREATE TABLE `tscore` (
  `id` int(11) NOT NULL,
  `username` varchar(55) NOT NULL,
  `score` int(11) NOT NULL,
  `standing` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tscore`
--

INSERT INTO `tscore` (`id`, `username`, `score`, `standing`) VALUES
(1, 'hiihha', 3695, 184),
(2, 'ghafur', 415, 20),
(3, 'hayyuukk', 655, 30),
(4, 'apur', 290, 16),
(5, 'baru', 145, 6),
(6, 'tes', 90, 6),
(7, 'gas', 65, 4),
(8, 'tess', 35, 3),
(9, 'hoki', 290, 16),
(10, 'yaaay', 200, 10),
(11, 'vale', 25, 1),
(12, 'keyboard', 220, 11),
(13, 'monyet', 245, 13),
(14, 'hutan', 155, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tscore`
--
ALTER TABLE `tscore`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tscore`
--
ALTER TABLE `tscore`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
