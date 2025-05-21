-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2025 at 10:25 PM
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
-- Database: `sca`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_applicant`
--

CREATE TABLE `tbl_applicant` (
  `app_id` int(11) NOT NULL,
  `app_uid` int(11) NOT NULL,
  `app_progid` int(11) NOT NULL,
  `app_schoolName` varchar(255) NOT NULL,
  `app_schoolAddress` varchar(255) NOT NULL,
  `app_eduLevel` varchar(255) NOT NULL,
  `app_famIncome` varchar(255) NOT NULL,
  `app_homeAddress` varchar(255) NOT NULL,
  `app_progname` varchar(255) NOT NULL,
  `app_status` varchar(255) NOT NULL,
  `app_docs` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_applicant`
--

INSERT INTO `tbl_applicant` (`app_id`, `app_uid`, `app_progid`, `app_schoolName`, `app_schoolAddress`, `app_eduLevel`, `app_famIncome`, `app_homeAddress`, `app_progname`, `app_status`, `app_docs`) VALUES
(2, 7, 1, 'SCC', 'Ward 2', 'College', '10000', 'calajoan', 'Test Program', 'Accepted', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_cashreleasing`
--

CREATE TABLE `tbl_cashreleasing` (
  `cash_id` int(11) NOT NULL,
  `cash_progid` int(11) NOT NULL,
  `cash_appid` int(11) NOT NULL,
  `cash_release` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_cashreleasing`
--

INSERT INTO `tbl_cashreleasing` (`cash_id`, `cash_progid`, `cash_appid`, `cash_release`) VALUES
(4, 1, 2, '500');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `log_id` int(11) NOT NULL,
  `log_uid` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`log_id`, `log_uid`, `log_action`, `log_timestamp`) VALUES
(1, 3, 'Updated a user: Brown', '2025-04-04 09:45:38'),
(2, 3, 'Deleted user ID: 4', '2025-04-04 09:46:03'),
(3, 3, 'Created a Program Name: Test Program', '2025-05-20 17:18:14'),
(4, 3, 'Updated a user: test12', '2025-05-20 17:20:59'),
(5, 7, 'Applied to Cash Assistance Program: Test Program', '2025-05-20 17:52:20'),
(6, 7, 'Applied to Cash Assistance Program: Test Program', '2025-05-20 18:27:09'),
(7, 3, 'Accepted Application Request: 2', '2025-05-20 18:43:57'),
(8, 3, 'Accepted Application Request: 2', '2025-05-20 18:46:37'),
(9, 3, 'Rejected Application Request: 2', '2025-05-20 18:53:35'),
(10, 3, 'Accepted Application Request: 2', '2025-05-20 18:59:55'),
(11, 3, 'Rejected Application Request: 2', '2025-05-20 19:00:08'),
(12, 3, 'Accepted Application Request: 2', '2025-05-20 19:00:19'),
(13, 3, 'Released Cash Assistance to: 2', '2025-05-20 20:13:38');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_program`
--

CREATE TABLE `tbl_program` (
  `prog_id` int(11) NOT NULL,
  `prog_name` varchar(255) NOT NULL,
  `prog_description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_program`
--

INSERT INTO `tbl_program` (`prog_id`, `prog_name`, `prog_description`) VALUES
(1, 'Test Program', 'Test');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(20) NOT NULL,
  `u_lname` varchar(20) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_cpass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_username`, `u_email`, `u_type`, `u_status`, `u_image`, `u_pass`, `u_cpass`) VALUES
(3, 'Ivan', 'laluna', 'lan12', 'lan@lan.com', 'Admin', 'Active', '', 'vuGxOZUNnEfiPvhNqTmsgJKxU+HWYs8Au87VBzAPbmE=', 'vuGxOZUNnEfiPvhNqTmsgJKxU+HWYs8Au87VBzAPbmE='),
(6, 'Karl', 'Campoy', 'Brown', 'campoy@app.com', 'Admin', 'Active', '', 'DRMq8/pzj2GubAGvMUBmNDWzx7fpCVfUbXh+p7//Bi0=', 'DRMq8/pzj2GubAGvMUBmNDWzx7fpCVfUbXh+p7//Bi0='),
(7, 'Test', 'Test', 'test12', 'test@test.com', 'Applicant', 'Active', '', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_applicant`
--
ALTER TABLE `tbl_applicant`
  ADD PRIMARY KEY (`app_id`),
  ADD KEY `app_uid` (`app_uid`),
  ADD KEY `tbl_applicant_ibfk_2` (`app_progid`);

--
-- Indexes for table `tbl_cashreleasing`
--
ALTER TABLE `tbl_cashreleasing`
  ADD PRIMARY KEY (`cash_id`),
  ADD KEY `cash_progid` (`cash_progid`),
  ADD KEY `cash_appid` (`cash_appid`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `log_uid` (`log_uid`);

--
-- Indexes for table `tbl_program`
--
ALTER TABLE `tbl_program`
  ADD PRIMARY KEY (`prog_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_applicant`
--
ALTER TABLE `tbl_applicant`
  MODIFY `app_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_cashreleasing`
--
ALTER TABLE `tbl_cashreleasing`
  MODIFY `cash_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_program`
--
ALTER TABLE `tbl_program`
  MODIFY `prog_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_applicant`
--
ALTER TABLE `tbl_applicant`
  ADD CONSTRAINT `tbl_applicant_ibfk_1` FOREIGN KEY (`app_uid`) REFERENCES `tbl_user` (`u_id`),
  ADD CONSTRAINT `tbl_applicant_ibfk_2` FOREIGN KEY (`app_progid`) REFERENCES `tbl_program` (`prog_id`);

--
-- Constraints for table `tbl_cashreleasing`
--
ALTER TABLE `tbl_cashreleasing`
  ADD CONSTRAINT `tbl_cashreleasing_ibfk_2` FOREIGN KEY (`cash_progid`) REFERENCES `tbl_program` (`prog_id`),
  ADD CONSTRAINT `tbl_cashreleasing_ibfk_3` FOREIGN KEY (`cash_appid`) REFERENCES `tbl_applicant` (`app_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`log_uid`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
