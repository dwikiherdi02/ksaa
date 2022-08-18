-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2022 at 07:17 AM
-- Server version: 10.2.12-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ksaa`
--

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(3) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`id`, `name`, `code`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Admin', 'ADM', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL),
(2, 'Ketua', 'LDR', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL),
(3, 'Sekretaris', 'SCR', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL),
(4, 'Bendahara', 'TRS', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL),
(5, 'Pemasaran', 'MRK', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` int(11) NOT NULL,
  `jabatan_id` int(11) DEFAULT NULL,
  `emp_id` varchar(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `is_pengguna` tinyint(1) DEFAULT 0,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `jabatan_id`, `emp_id`, `name`, `email`, `address`, `is_pengguna`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'ADM001', 'Dwiki Herdiansyah', 'dwikiherdi520@gmail.com', 'Jalan Edelweis No 11', 1, '2022-08-17 09:24:18', '2022-08-17 09:24:20', NULL),
(2, 2, 'USR001', 'User 1', 'user1@mail.com', 'Jalan Kebenaran', 1, '2022-08-17 09:24:18', '2022-08-17 09:24:20', NULL),
(3, 3, 'USR002', 'User 2', 'user2@mail.com', 'Jalan Buntu', 0, '2022-08-17 09:24:18', '2022-08-17 09:24:20', NULL),
(4, 1, 'ADM002', 'Admin-2', 'admin2@mail.com', 'Jalan jalan', 1, '2022-08-17 22:40:16', '2022-08-17 22:40:16', NULL),
(5, 4, 'USR003', 'User 3', 'user3@mail.com', 'jalan senopati', 0, '2022-08-17 22:41:24', '2022-08-17 22:41:24', NULL),
(6, 5, 'USR004', 'User 4', 'user4@mail.com', 'Jalan magelang', 1, '2022-08-17 22:43:54', '2022-08-17 22:43:54', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `karyawan_id` int(11) NOT NULL,
  `username` varchar(191) NOT NULL,
  `password` varchar(191) NOT NULL,
  `is_active` tinyint(1) DEFAULT 1,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `karyawan_id`, `username`, `password`, `is_active`, `created_at`, `updated_at`) VALUES
(1, 1, 'dwikiherdi', '$2a$12$pL9ZNcsyZJMCZ6189RAT.OZWup/8fxPWHQweWFokAwTQWHwAbcjV6', 1, '2022-07-25 17:00:00', '2022-07-25 17:00:00'),
(2, 2, 'user1', '$2a$12$pL9ZNcsyZJMCZ6189RAT.OZWup/8fxPWHQweWFokAwTQWHwAbcjV6', 1, '2022-07-25 17:00:00', '2022-07-25 17:00:00'),
(3, 4, 'admin2', '$2a$12$RtfPEq/NwHhKueKau3yhHu54V7kAf7L0xppOMDofuEhpygcmr09WG', 1, '2022-08-17 22:40:16', '2022-08-17 22:40:16'),
(4, 6, 'user4', '$2a$12$FXT.dB8UMdG8./whG2ftTOy2u0XC1WeXgEpboWc6MNtEtbZ4hVLI.', 1, '2022-08-17 22:43:54', '2022-08-17 22:43:54');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_karyawan_jabatan` (`jabatan_id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pengguna_karyawan` (`karyawan_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `FK_karyawan_jabatan` FOREIGN KEY (`jabatan_id`) REFERENCES `jabatan` (`id`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `FK_pengguna_karyawan` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
