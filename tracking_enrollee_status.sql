-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2020 at 04:40 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tracking_enrollee_status`
--

-- --------------------------------------------------------

--
-- Table structure for table `dependent`
--

CREATE TABLE `dependent` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `date_of_birth` date NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL,
  `enrollee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dependent`
--

INSERT INTO `dependent` (`id`, `name`, `date_of_birth`, `created_by`, `created_date`, `updated_by`, `updated_date`, `enrollee_id`) VALUES
(1, 'dependent 1', '1985-08-10', 1, '2020-09-05 14:07:31', 1, '2020-09-05 14:11:41', 1),
(2, 'dependent 2', '1985-08-12', 1, '2020-09-05 14:08:32', 1, '2020-09-05 14:08:32', 1),
(4, 'dependent 3', '1985-08-12', 1, '2020-09-05 14:36:33', 1, '2020-09-05 14:36:33', 4),
(5, 'dependent 1', '1985-08-10', 1, '2020-09-05 14:36:40', 1, '2020-09-05 14:37:01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `enrollee`
--

CREATE TABLE `enrollee` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `activation_status` tinyint(1) NOT NULL,
  `date_of_birth` date NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `created_by` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_by` int(11) NOT NULL,
  `updated_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enrollee`
--

INSERT INTO `enrollee` (`id`, `name`, `activation_status`, `date_of_birth`, `phone_number`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES
(1, 'Peter James', 0, '1983-11-28', '9999999999', 1, '2020-09-05 18:55:03', 1, '2020-09-05 13:56:33'),
(4, 'Mike Hurly', 1, '1983-10-30', '2355543333', 1, '2020-09-05 13:58:51', 1, '2020-09-05 13:58:51');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dependent`
--
ALTER TABLE `dependent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_enrollee_id` (`enrollee_id`);

--
-- Indexes for table `enrollee`
--
ALTER TABLE `enrollee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uk_phone_number` (`phone_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dependent`
--
ALTER TABLE `dependent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `enrollee`
--
ALTER TABLE `enrollee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dependent`
--
ALTER TABLE `dependent`
  ADD CONSTRAINT `fk_enrollee_id` FOREIGN KEY (`enrollee_id`) REFERENCES `enrollee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
