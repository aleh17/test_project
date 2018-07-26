-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2018 at 04:18 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employees_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`department_id`, `department_name`) VALUES
(1, 'Development'),
(2, 'Management'),
(3, 'Quality assurance');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birth_date` date NOT NULL,
  `title` varchar(45) NOT NULL,
  `salary` decimal(11,0) NOT NULL,
  `department_id` int(11) NOT NULL,
  `role` enum('EMPLOYEE','DEPARTMENT_MANAGER','TOP_MANAGER') NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`employee_id`, `first_name`, `last_name`, `birth_date`, `title`, `salary`, `department_id`, `role`, `login`, `password`) VALUES
(1, 'Johh', 'Doe', '1980-07-03', 'Senior manager', '2000', 2, 'TOP_MANAGER', 'johh', '$2a$10$dI./.XLZdb9/mVtq8JGkresXJ98A/xG.KYWPU7KHLBZUcTOUYZ51q'),
(2, 'James', 'Franco', '1990-07-19', 'Engineer', '950', 1, 'DEPARTMENT_MANAGER', 'james', '$2a$10$SYNuNBxMvxI9wseDnLvG8eh1FGeZ3Azsrf62d6DLRNb5YFivFq2Ua'),
(3, 'Laura', 'Haddock', '1985-09-09', 'QA engineer', '800', 3, 'EMPLOYEE', 'laura', '$2a$10$0jN2NtBVKp/G6.mtjta/IeT88y.890xPt1QiXBoM8sElpTJlvIGxO'),
(4, 'Rebecca', 'Dayan', '1987-07-26', 'QA engineer', '800', 3, 'EMPLOYEE', 'rebecca', '$2a$10$0jN2NtBVKp/G6.mtjta/IeT88y.890xPt1QiXBoM8sElpTJlvIGxO');

-- --------------------------------------------------------

--
-- Table structure for table `vacations`
--

CREATE TABLE `vacations` (
  `vacation_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL,
  `vacation_status` enum('WAITING_FOR_APPROVAL','APPROVED','DECLINED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vacations`
--

INSERT INTO `vacations` (`vacation_id`, `employee_id`, `from_date`, `to_date`, `vacation_status`) VALUES
(1, 1, '2018-07-23', '2018-07-25', 'DECLINED'),
(2, 3, '2018-08-01', '2018-08-10', 'DECLINED'),
(3, 2, '2018-08-09', '2018-08-31', 'APPROVED'),
(4, 2, '2018-09-15', '2018-09-21', 'WAITING_FOR_APPROVAL'),
(5, 3, '2018-09-15', '2018-09-21', 'WAITING_FOR_APPROVAL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`department_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `vacations`
--
ALTER TABLE `vacations`
  ADD PRIMARY KEY (`vacation_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `department_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vacations`
--
ALTER TABLE `vacations`
  MODIFY `vacation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
