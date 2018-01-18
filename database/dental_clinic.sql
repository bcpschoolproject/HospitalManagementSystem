-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2018 at 01:14 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dental_clinic`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` int(6) NOT NULL,
  `street_no` int(4) NOT NULL,
  `city` text NOT NULL,
  `municipality` text NOT NULL,
  `province` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` varchar(8) NOT NULL,
  `admin_name` varchar(12) NOT NULL,
  `admin_password` varchar(8) NOT NULL,
  `admin_level` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(6) NOT NULL,
  `tel` varchar(9) NOT NULL,
  `cell` varchar(12) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `doctors_id` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hmo`
--

CREATE TABLE `hmo` (
  `hmo_no` int(11) NOT NULL,
  `id` int(6) NOT NULL,
  `fund` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hmo_coverage`
--

CREATE TABLE `hmo_coverage` (
  `hmo_no` int(11) NOT NULL,
  `coverage` text NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `id` int(6) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `middlename` varchar(50) NOT NULL,
  `civil_status` varchar(12) NOT NULL,
  `birthdate` date NOT NULL,
  `nationality` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `birthplace` date NOT NULL,
  `occupation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `firstname`, `lastname`, `middlename`, `civil_status`, `birthdate`, `nationality`, `age`, `gender`, `birthplace`, `occupation`) VALUES
(1, 'nelson macalalag', '', '', '', '0000-00-00', '', 0, '', '0000-00-00', ''),
(2, '', '', '', '', '0000-00-00', '', 0, '', '0000-00-00', '');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Table structure for table `surgery`
--

CREATE TABLE `surgery` (
  `record_no` int(6) NOT NULL,
  `procedures` text NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `doctor` int(6) NOT NULL,
  `id` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `surgery`
--

INSERT INTO `surgery` (`record_no`, `procedures`, `date`, `time`, `doctor`, `id`) VALUES
(1101, 'tooth filling', '2017-12-07', '04:08:17', 0, 1),
(1102, 'oral prophylaxis', '2017-12-07', '08:36:32', 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` varchar(8) NOT NULL,
  `user_name` varchar(12) NOT NULL,
  `user_password` varchar(8) NOT NULL,
  `user_level` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `admin_id` (`admin_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`doctors_id`),
  ADD KEY `doctors_id` (`doctors_id`),
  ADD KEY `doctors_id_2` (`doctors_id`);

--
-- Indexes for table `hmo`
--
ALTER TABLE `hmo`
  ADD PRIMARY KEY (`hmo_no`),
  ADD KEY `hmo_no` (`hmo_no`),
  ADD KEY `hmo_no_2` (`hmo_no`),
  ADD KEY `hmo_no_3` (`hmo_no`),
  ADD KEY `holder` (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `hmo_no_4` (`hmo_no`);

--
-- Indexes for table `hmo_coverage`
--
ALTER TABLE `hmo_coverage`
  ADD PRIMARY KEY (`hmo_no`),
  ADD KEY `hmo_no` (`hmo_no`),
  ADD KEY `hmo_no_2` (`hmo_no`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `patient_no` (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `surgery`
--
ALTER TABLE `surgery`
  ADD PRIMARY KEY (`record_no`),
  ADD KEY `record_no` (`record_no`),
  ADD KEY `patient` (`id`),
  ADD KEY `doctor` (`doctor`),
  ADD KEY `record_no_2` (`record_no`),
  ADD KEY `id` (`id`),
  ADD KEY `doctor_2` (`doctor`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`id`) REFERENCES `patient` (`id`);

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`id`) REFERENCES `patient` (`id`);

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`doctors_id`) REFERENCES `surgery` (`doctor`);

--
-- Constraints for table `hmo`
--
ALTER TABLE `hmo`
  ADD CONSTRAINT `hmo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `patient` (`id`);

--
-- Constraints for table `hmo_coverage`
--
ALTER TABLE `hmo_coverage`
  ADD CONSTRAINT `hmo_coverage_ibfk_1` FOREIGN KEY (`hmo_no`) REFERENCES `hmo` (`hmo_no`);

--
-- Constraints for table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_ibfk_1` FOREIGN KEY (`id`) REFERENCES `info` (`id`);

--
-- Constraints for table `surgery`
--
ALTER TABLE `surgery`
  ADD CONSTRAINT `surgery_ibfk_2` FOREIGN KEY (`id`) REFERENCES `patient` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
