-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2022 at 10:19 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
-- Table structure for table `adj_kas`
--

CREATE TABLE `adj_kas` (
  `id` int(11) NOT NULL,
  `cash_in` int(11) DEFAULT NULL,
  `cash_out` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `notes` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `investor`
--

CREATE TABLE `investor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nik` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `address` text,
  `children` int(11) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `job_length` int(11) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `income` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `investor`
--

INSERT INTO `investor` (`id`, `name`, `nik`, `birth_place`, `birth_date`, `address`, `children`, `job`, `job_length`, `company_name`, `income`, `phone`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Sylva Zoldyck', '1234123412341234', 'Jakarta Timur', NULL, 'Jl. Sudirman', 0, 'Professional Killer', 46, 'PT. Malacca Elab', 500000000, NULL, '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(2, 'Zeno Zoldyck', '1234123412341234', 'Jakarta Timur', NULL, 'Jl. Sudirman', 0, 'Professional Killer', 67, 'PT. Malacca Elab', 500000000, NULL, '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(3, 'Togashi Sensei', '1234123412341234', 'Jakarta Timur', NULL, 'Jl. Sudirman', 0, 'Mangaka', 58, 'PT. Malacca Elab', 8000000, NULL, '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(4, 'Saryani', '1234123412341234', 'Indramayu', NULL, 'Jl. Sudirman', 3, 'Swasta', 6, 'PT. Malacca Elab', 10000000, '87727281913', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(5, 'Gustina', '1234123412341234', 'Jambi', NULL, 'Jl. Rawamangun', 2, 'Swasta', 5, 'PT. Andhini Nugraha', 8000000, '89812982025', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(6, 'Andreas Siregar', '1234123412341234', 'Pekanbaru', NULL, 'Jl. Gatotsubroto', 4, 'PNS', 15, 'Bakamla', 7000000, '81992018123', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(7, 'Amanda Sari', '1234123412341234', 'Pancoran', NULL, 'Jl. Raya Pasar Minggu', 3, 'Swasta', 13, 'PT. Fineks Utama', 8000000, '81292847556', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(8, 'Fitrianti', '1234123412341234', 'Jakarta Timur', NULL, 'Jl. Raya Condet', 3, 'Guru', 5, 'SMA N 5 Jakarta Timur', 5000000, '81923424556', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(9, 'Serli Damayanti', '1234123412341234', 'Lubuk Linggau', NULL, 'Jl. Raya Pasar Minggu', 2, 'PNS', 5, 'Kementerian Pertanian', 6000000, '82291844733', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(10, 'Indah Cahyani', '1234123412341234', 'Kelapa Gading', NULL, 'Jl. Kelapa Gading II', 3, 'Swasta', 7, 'PT. Vierlines Indonesia', 7000000, '82359854745', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(11, 'Ayu Wandira', '1234123412341234', 'Jambi', NULL, 'Jl. Raya Kalibata', 2, 'Swasta', 6, 'PT. Multi Guna Laksindo', 8000000, '81234556533', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(12, 'Caca Permata', '1234123412341234', 'Kuningan', NULL, 'Jl. Johor Raya', 1, 'Swasta', 1, 'PT. Jasa Cita', 4500000, '81239843783', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(13, 'Mila Karmila', '1234123412341234', 'Palembang', NULL, 'Jl . Muara Angke', 0, 'Swasta', 3, 'PT. Duta Firza', 5000000, '82334455612', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(14, 'Hariyanti', '1234123412341234', 'Jakarta Timur', NULL, 'Gang. Arab I', 3, 'PNS', 8, 'Kementerian Perhubungan', 5000000, '81927423463', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(15, 'Andi Basso', '1234123412341234', 'Pulau Seribu', NULL, 'Jl.Tanjung Priok', 2, 'Swasta', 5, 'PT. Gistec Prima', 7000000, '81922344557', '2022-08-22 09:07:55', '2022-08-23 20:35:45', '2022-08-23 20:35:45'),
(16, 'M. Darwis', '1234123412341234', 'Brebes', NULL, 'Jl. Simatupang', 0, 'Security', 2, 'Perumahan Kalibata Indah', 4500000, '82345618912', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(17, 'Arifin', '1234123412341234', 'Jakarta Barat', NULL, 'Jl. Raya Kuningan', 1, 'Swasta', 5, 'PT. Multi Guna Laksindo', 5000000, '82331233132', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(18, 'Dea Ananda', '1234123412341234', 'Cirebon', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 10, 'PT. Heburinas Nusantara', 6000000, '82345678945', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(19, 'Irwansyah Kumara', '1234123412341234', 'Banten', NULL, 'Jl. Raya Kalideres', 0, 'Swasta', 5, 'PT. Mitrais', 5000000, '81235678456', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(20, 'Mira Sartika', '1234123412341234', 'Surabaya', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 15, 'PT. Tempo Land', 7000000, '81234568902', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(21, 'Pandji', '1234123412341235', 'Bandung', '1990-08-22', 'Jalan kebenaran', 1, 'Swasta', 12, 'PT SIDO', 1000000000, '087782320919', '2022-08-22 09:39:17', '2022-08-22 11:28:40', '2022-08-22 11:28:40'),
(22, 'Razor', '23421', 'axsa', '1980-08-20', '', 0, '', 0, '', 0, '', '2022-08-22 11:28:23', '2022-08-22 11:28:47', '2022-08-22 11:28:47'),
(23, 'Gojo Satoru', '3261519384762', 'Okinawa', '1989-06-14', 'Okinawa', 0, 'Jujutsu', 36, 'Jujutsu', 30000000, '08236711233', '2022-08-23 17:33:33', '2022-08-23 17:33:33', NULL),
(24, 'Riki Setiawan', '32647439344', 'Bekasi', '2002-05-15', 'Bekasi', 0, 'Engineer', 12, 'Bytecom', 8000000, '08623267123', '2022-08-23 17:45:51', '2022-08-23 17:45:51', NULL),
(25, 'Rika Damayanti', '532324534323', 'Bekasi', '1985-03-06', 'Bekkasi', 0, 'Staff', 6, 'PT Anabatic', 5600000, '0834623444', '2022-08-23 20:33:18', '2022-08-23 20:33:46', NULL),
(26, 'Ardli Firdlaus', '32555623754767', 'Jakarta', '2001-07-11', 'Bekasi', 0, 'Swasta', 60, '', 5500000, '0863442344', '2022-08-26 15:00:02', '2022-08-26 15:00:02', NULL);

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
(5, 'Pemasaran', 'MRK', '2022-08-17 09:14:47', '2022-08-17 09:14:49', NULL),
(7, 'Supervisor', 'SPV', '2022-08-21 01:50:21', '2022-08-21 03:22:10', '2022-08-21 03:22:10'),
(8, 'Staff', 'ST0', '2022-08-23 13:40:27', '2022-08-23 13:40:42', '2022-08-23 13:40:42');

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
  `address` text,
  `is_pengguna` tinyint(1) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `jabatan_id`, `emp_id`, `name`, `email`, `address`, `is_pengguna`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'ADM001', 'Dwiki Herdiansyah', 'dwikiherdi520@gmail.com', 'Jalan Edelweis No 11', 1, '2022-08-17 09:24:18', '2022-08-21 23:25:05', NULL),
(12, 1, 'ARKA51', 'Ardli Firdlaus', 'gmail@ardli.com', 'Bekasi', 1, '2022-08-22 06:57:14', '2022-08-23 13:27:47', NULL),
(13, 2, 'ASRI01', 'Asri', 'gmail@asri.com', 'Jakarta', 0, '2022-08-23 10:30:14', '2022-08-23 10:44:05', '2022-08-23 10:44:05'),
(14, 3, 'FERI003', 'Ferina', 'gmail@ferina.com', 'Bogor', 1, '2022-08-23 10:41:10', '2022-08-23 10:41:10', NULL),
(15, 4, 'DIN0021', 'Dino', '', '', 0, '2022-08-23 13:22:15', '2022-08-23 13:29:07', '2022-08-23 13:29:07'),
(16, 2, 'Vierhan', 'Vierhan Rahman', '', '', 0, '2022-08-23 13:27:25', '2022-08-23 13:30:44', NULL),
(17, 5, 'ADT398', 'Adit Eko Prasetyo', 'mail@adit.com', '', 1, '2022-08-24 07:10:03', '2022-08-24 07:10:03', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nik` varchar(255) DEFAULT NULL,
  `birth_place` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `address` text,
  `children` int(11) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `job_length` int(11) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `income` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`id`, `name`, `nik`, `birth_place`, `birth_date`, `address`, `children`, `job`, `job_length`, `company_name`, `income`, `phone`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Amiruddin', '1234123412341234', 'Makassar', NULL, 'Jl. Rawajati Timur', 1, 'PNS', 3, 'Bawaslu', 7000000, '82277123451', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(2, 'M.Husin', '1234123412341234', 'Kalibata', NULL, 'Jl. Kalibata Tengah', 4, 'Swasta', 10, 'PT. Gistec Prima', 10000000, '82219102920', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(3, 'Nur Wahyudii', '1234123412341234', 'Wonigiri', NULL, 'Jl. Kramat Jati', 2, 'Swasta', 5, 'PT. Humpuss', 8000000, '81918191688', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(4, 'Saryani', '1234123412341234', 'Indramayu', NULL, 'Jl. Sudirman', 3, 'Swasta', 6, 'PT. Malacca Elab', 10000000, '87727281913', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(5, 'Gustina', '1234123412341234', 'Jambi', NULL, 'Jl. Rawamangun', 2, 'Swasta', 5, 'PT. Andhini Nugraha', 8000000, '89812982025', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(6, 'Andreas Siregar', '1234123412341234', 'Pekanbaru', NULL, 'Jl. Gatotsubroto', 4, 'PNS', 15, 'Bakamla', 7000000, '81992018123', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(7, 'Amanda Sari', '1234123412341234', 'Pancoran', NULL, 'Jl. Raya Pasar Minggu', 3, 'Swasta', 13, 'PT. Fineks Utama', 8000000, '81292847556', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(8, 'Fitrianti', '1234123412341234', 'Jakarta Timur', NULL, 'Jl. Raya Condet', 3, 'Guru', 5, 'SMA N 5 Jakarta Timur', 5000000, '81923424556', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(9, 'Serli Damayanti', '1234123412341234', 'Lubuk Linggau', NULL, 'Jl. Raya Pasar Minggu', 2, 'PNS', 5, 'Kementerian Pertanian', 6000000, '82291844733', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(10, 'Indah Cahyani', '1234123412341234', 'Kelapa Gading', NULL, 'Jl. Kelapa Gading II', 3, 'Swasta', 7, 'PT. Vierlines Indonesia', 7000000, '82359854745', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(11, 'Ayu Wandira', '1234123412341234', 'Jambi', NULL, 'Jl. Raya Kalibata', 2, 'Swasta', 6, 'PT. Multi Guna Laksindo', 8000000, '81234556533', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(12, 'Caca Permata', '1234123412341234', 'Kuningan', NULL, 'Jl. Johor Raya', 1, 'Swasta', 1, 'PT. Jasa Cita', 4500000, '81239843783', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(13, 'Mila Karmila', '1234123412341234', 'Palembang', NULL, 'Jl . Muara Angke', 0, 'Swasta', 3, 'PT. Duta Firza', 5000000, '82334455612', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(14, 'Hariyanti', '1234123412341234', 'Jakarta Timur', NULL, 'Gang. Arab I', 3, 'PNS', 8, 'Kementerian Perhubungan', 5000000, '81927423463', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(15, 'Andi Basso', '1234123412341234', 'Pulau Seribu', NULL, 'Jl.Tanjung Priok', 2, 'Swasta', 5, 'PT. Gistec Prima', 7000000, '81922344557', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(16, 'M. Darwis', '1234123412341234', 'Brebes', NULL, 'Jl. Simatupang', 0, 'Security', 2, 'Perumahan Kalibata Indah', 4500000, '82345618912', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(17, 'Arifin', '1234123412341234', 'Jakarta Barat', NULL, 'Jl. Raya Kuningan', 1, 'Swasta', 5, 'PT. Multi Guna Laksindo', 5000000, '82331233132', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(18, 'Dea Ananda', '1234123412341234', 'Cirebon', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 10, 'PT. Heburinas Nusantara', 6000000, '82345678945', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(19, 'Irwansyah Kumara', '1234123412341234', 'Banten', NULL, 'Jl. Raya Kalideres', 0, 'Swasta', 5, 'PT. Mitrais', 5000000, '81235678456', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(20, 'Mira Sartika', '1234123412341234', 'Surabaya', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 15, 'PT. Tempo Land', 7000000, '81234568902', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(21, 'Lisda Yanti', '1234123412341234', 'Indragiri', NULL, 'Jl. Kemuning II', 2, 'PNS', 5, 'SMP N 2 Jakarta Selatan', 5000000, '81982463462', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(22, 'Ambo Tang', '1234123412341234', 'Makassar', NULL, 'Jl. Raya Pasar Minggu', 1, 'Swasta', 7, 'PT. Filma Utama Soap', 7000000, '82346509456', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(23, 'Besse Rosda', '1234123412341234', 'Sulewesi Tengah', NULL, 'Jl.Tanjung Barat', 1, 'Swasta', 3, 'PT. Ayuberga', 6000000, '81286364744', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(24, 'Kamelia Putri', '1234123412341234', 'Palembang', NULL, 'Jl. Pulau Gebang', 2, 'Swasta', 6, 'PT. Tempo Logistic', 6500000, '81238547547', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(25, 'Berta Nigrum', '1234123412341234', 'Tegal', NULL, 'Jl. Kalibata Barat', 3, 'Swasta', 5, 'PT. NNA Indonesia', 6000000, '81234758569', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(26, 'Mistang A', '1234123412341234', 'Jambi', NULL, 'Jl. Rawasari', 2, 'Swasta', 7, 'PT. Fineks Utama', 8000000, '81234590234', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(27, 'Rusli Hartono', '1234123412341234', 'Lampung', NULL, 'Jl. Rawasari', 3, 'Swasta', 5, 'PT. Filma Utama Soap', 7000000, '81234560921', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(28, 'Santi Della', '1234123412341234', 'Medan', NULL, 'Jl. Simatupang', 1, 'Swasta', 6, 'PT. Sum Prima Sentosa', 6000000, '81244347423', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(29, 'Fadli Alamsya', '1234123412341234', 'Banten', NULL, 'Jl. Kramat Jati', 0, 'Swasta', 5, 'PT. Titan Trading', 6000000, '82314456346', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(30, 'Irham Raynaldi', '1234123412341234', 'Cirebon', NULL, 'Jl. Pulau Gebang', 2, 'Swasta', 7, 'PT. Citra Bakti Indonesia', 7000000, '81234892742', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(31, 'Ridwa', '1234123412341234', 'Dumai', NULL, 'Jl. Rawajati Timur', 3, 'Swasta', 5, 'PT. Surya Teknik Anugerah', 6000000, '81234356671', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(32, 'Rusdianto', '1234123412341234', 'Kota Batam', NULL, 'Jl. Simatupang', 5, 'Swasta', 4, 'PT. Gistec Prima', 8000000, '82277123451', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(33, 'Suhardi', '1234123412341234', 'Kerinci', NULL, 'Jl. Simatupang', 2, 'Swasta', 3, 'PT. Indorama Polypet Indonesia', 7000000, '82359102920', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(34, 'Irvan Rinaldi', '1234123412341234', 'Batanghari', NULL, 'Jl. Raya Pasar Minggu', 3, 'Swasta', 6, 'PT. Istech Resources Asia', 6000000, '81278191688', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(35, 'Jondrawan', '1234123412341234', 'Bengkalis', NULL, 'Jl. Kalibata Tengah', 2, 'Swasta', 9, 'PT. Pelayaran Kartika Samudra Adijaya', 6000000, '87727222913', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(36, 'Ridho Oktama', '1234123412341234', 'Tembilahan', NULL, 'Jl. Raya Kalideres', 4, 'Swasta', 6, 'PT. Pesona Khatulistiwa Nusantara', 7000000, '87712982025', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(37, 'Zainal Rifaldi', '1234123412341234', 'Pariaman', NULL, 'Jl. Sudirman', 2, 'Swasta', 7, 'PT. Pro Energi', 8000000, '81596018123', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(38, 'Suhardi', '1234123412341234', 'Padang', NULL, 'JL. Pancoran', 0, 'Swasta', 3, 'PT. Sa Ary Indoraya', 4500000, '81292847126', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(39, 'Warto', '1234123412341234', 'Palembang', NULL, 'JL. Pancoran', 3, 'Swasta', 4, 'PT. Semen Baturaja Tbk.', 5000000, '81923466556', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(40, 'Suci Fauziah', '1234123412341234', 'Bengkulu', NULL, 'Jl. Raya Kalibata', 5, 'Swasta', 10, 'PT. Yanaprima Hastapersada Tbk.', 5000000, '82291344733', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(41, 'Andi Ririn', '1234123412341234', 'Lahat', NULL, 'Jl. Kalibata Tengah', 2, 'Swasta', 7, 'PT. E2Pay Global Utama', 7000000, '82359834745', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(42, 'Nur Atika', '1234123412341234', 'Belitung', NULL, 'Jl. Kramat Jati', 1, 'Swasta', 5, 'PT. Teguh Jayaprima Abadi', 4500000, '81234553433', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(43, 'Melawati', '1234123412341234', 'Cilegon', NULL, 'Jl. Sudirman', 0, 'Swasta', 3, 'PT. Bumi Asri Prima Pratama', 5000000, '81239876783', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(44, 'M. Yusuf', '1234123412341234', 'Serang', NULL, 'Jl. Rawabadak', 4, 'Swasta', 12, 'PT. EPT.co Dian Persada', 6000000, '82334423612', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(45, 'Ferry Irawan', '1234123412341234', 'Bekasi', NULL, 'JL. Pancoran', 2, 'Swasta', 3, 'PT. Humpuss', 5000000, '81927423423', '2022-08-22 03:51:10', '2022-08-23 20:38:54', '2022-08-23 20:38:54'),
(46, 'Andis Ramadhan', '1234123412341234', 'Bogor', NULL, 'Jl.Tanjung Priok', 5, 'Swasta', 8, 'PT. Humpuss Karbometil Selulosa', 7000000, '81922344557', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(47, 'Bambang', '1234123412341234', 'Depok', NULL, 'Jl. Rawasari', 2, 'Swasta', 2, 'PT. Usaha Gemilang Utama', 5000000, '82345618672', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(48, 'Hasanuddin', '1234123412341234', 'Medan', NULL, 'Jl. Raya Kalibata', 2, 'Swasta', 5, 'PT. Bank Ina Perdana Tbk.', 7000000, '82331232332', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(49, 'Reza Ardian', '1234123412341234', 'Makassar', NULL, 'Jl. Raya Kalideres', 1, 'Swasta', 7, 'PT. Anggun Permai Tekindo', 4500000, '82345667945', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(50, 'Jauhari', '1234123412341234', 'Jambi', '1990-09-12', 'Jl. Raya Kalibata', 3, 'Swasta', 6, 'PT. Digital Andalan Nusantara', 7000000, '81235611456', '2022-08-22 03:51:10', '2022-08-22 08:51:47', NULL),
(51, 'Pandji', '1234123412341234', 'Jakarta', '1997-03-06', 'Jalan jalan', 0, 'Swasta', 7, 'PT IID', 15000000, '087782320199', '2022-08-22 07:57:13', '2022-08-22 09:24:54', NULL),
(52, 'Panjul', '1234123412341235', 'Bandung', '2000-08-15', 'Jalan Kaki', 3, 'Swasta', 1, 'PT UUD', 1000000, '08778232193', '2022-08-22 08:59:26', '2022-08-22 08:59:26', NULL),
(53, 'Razor', '325433323212', 'Greed Island', '1983-09-20', '', 0, 'Game Master', 36, 'Hunter x Hunter', 12000000, '', '2022-08-23 20:38:22', '2022-08-23 20:38:40', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(11) NOT NULL,
  `pengajuan_id` int(11) DEFAULT NULL,
  `nominal` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `cara_bayar` varchar(255) DEFAULT NULL,
  `notes` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id`, `pengajuan_id`, `nominal`, `date`, `cara_bayar`, `notes`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 10500000, '2022-08-23', '-', 'Bayar DP', '2022-08-23 20:59:32', '2022-08-23 20:59:32', NULL),
(2, 2, 19500000, '2022-08-23', '-', 'Bayar DP', '2022-08-23 22:32:17', '2022-08-23 22:32:17', NULL),
(3, 4, 285000, '2022-08-24', '-', 'Bayar DP', '2022-08-24 14:02:00', '2022-08-24 14:02:00', NULL),
(4, 5, 585000, '2022-08-24', '-', 'Bayar DP', '2022-08-24 14:12:42', '2022-08-24 14:12:42', NULL),
(5, 2, 2500000, '2022-09-23', '', '', '2022-08-25 08:33:31', '2022-08-26 14:43:05', NULL),
(6, 1, 6000000, '2022-09-26', '', '', '2022-08-25 08:34:51', '2022-08-25 08:34:51', NULL),
(7, 6, 425000, '2018-04-08', '-', 'Bayar DP', '2022-08-25 09:08:20', '2022-08-25 10:09:40', NULL),
(8, 7, 2055000, '2020-09-28', '-', 'Bayar DP', '2022-08-25 09:16:34', '2022-08-25 10:09:18', NULL),
(9, 8, 149500, '2015-01-01', '-', 'Bayar DP', '2022-08-25 09:33:08', '2022-08-25 10:08:45', NULL),
(10, 7, 565000, '2020-10-28', '', '', '2022-08-25 10:10:52', '2022-08-25 10:10:52', NULL),
(11, 8, 100000, '2015-02-01', '', '', '2022-08-25 10:11:25', '2022-08-25 10:11:25', NULL),
(12, 8, 100000, '2015-03-04', '', '', '2022-08-25 10:11:48', '2022-08-25 10:11:48', NULL),
(13, 8, 100000, '2015-04-16', '', '', '2022-08-25 10:12:10', '2022-08-25 10:12:10', NULL),
(14, 8, 100000, '2015-08-12', '', '', '2022-08-25 10:12:43', '2022-08-25 10:12:43', NULL),
(15, 8, 800000, '2022-08-03', '', '', '2022-08-25 10:13:08', '2022-08-25 10:13:08', NULL),
(16, 9, 1040000, '2020-10-26', '-', 'Bayar DP', '2022-08-25 10:35:12', '2022-08-25 10:35:12', NULL),
(17, 11, 100000, '2022-08-25', '-', 'Bayar DP', '2022-08-25 16:36:58', '2022-08-25 16:36:58', NULL),
(18, 11, 100000, '2022-09-25', '', '', '2022-08-25 16:37:44', '2022-08-25 16:37:44', NULL),
(19, 9, 2860000, '2022-08-25', 'Tunai', '', '2022-08-25 16:40:26', '2022-08-25 16:40:26', NULL),
(20, 2, 2500000, '2022-10-23', '', '', '2022-08-26 14:46:08', '2022-08-26 14:46:08', NULL),
(21, 2, 2500000, '2022-08-23', '', '', '2022-08-26 14:46:31', '2022-08-26 14:46:31', NULL),
(22, 2, 30000000, '2022-12-23', '', '', '2022-08-26 14:47:36', '2022-08-26 14:47:36', NULL),
(23, 14, 16000000, '2022-08-26', '-', 'Bayar DP', '2022-08-26 15:01:28', '2022-08-26 15:01:28', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan`
--

CREATE TABLE `pengajuan` (
  `id` int(11) NOT NULL,
  `no_pengajuan` varchar(255) DEFAULT NULL,
  `status_pengajuan_id` int(11) DEFAULT NULL,
  `nasabah_id` int(11) DEFAULT NULL,
  `tipe_pengajuan_id` int(11) DEFAULT NULL,
  `nama_jasa` varchar(255) DEFAULT NULL,
  `tipe_barang_id` int(11) DEFAULT NULL,
  `nama_barang` varchar(255) DEFAULT NULL,
  `modal` int(11) DEFAULT NULL,
  `est_laba` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `total_up` int(11) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `dp_date` date DEFAULT NULL,
  `cicilan` int(11) DEFAULT NULL,
  `total_angsuran` int(11) DEFAULT NULL,
  `notes` text,
  `act_laba` int(11) DEFAULT NULL,
  `est_end` date DEFAULT NULL,
  `act_end` date DEFAULT NULL,
  `status_pembiayaan` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengajuan`
--

INSERT INTO `pengajuan` (`id`, `no_pengajuan`, `status_pengajuan_id`, `nasabah_id`, `tipe_pengajuan_id`, `nama_jasa`, `tipe_barang_id`, `nama_barang`, `modal`, `est_laba`, `total`, `total_up`, `dp`, `dp_date`, `cicilan`, `total_angsuran`, `notes`, `act_laba`, `est_end`, `act_end`, `status_pembiayaan`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'P220823-01', 2, 51, 1, NULL, 1, 'Laptop ASUS Vivobook 2022', 15000000, 1500000, 16500000, NULL, 10500000, '2022-08-23', 500000, 12, 'Bayar DP', NULL, '2023-08-23', NULL, NULL, '2022-08-23 20:59:31', '2022-08-23 20:59:31', NULL),
(2, 'P220823-02', 2, 51, 1, NULL, 1, 'Honda CBR 250 CC', 50000000, 7000000, 57000000, NULL, 19500000, '2022-08-23', 2500000, 15, 'Beli Lagi', NULL, '2023-11-23', NULL, NULL, '2022-08-23 22:32:17', '2022-08-23 22:32:17', NULL),
(3, 'S220823-03', 3, 7, 1, NULL, 2, 'Alat Dapur', 1000000, 150000, 1150000, NULL, 1050000, NULL, 20000, 5, 'Beli Peralatan Dapur', NULL, NULL, NULL, NULL, '2022-08-23 23:10:20', '2022-08-23 23:10:20', NULL),
(4, 'P220824-01', 2, 47, 1, NULL, 1, 'Xiaomi Redmi 9c 4/64', 1601000, 434000, 2035000, NULL, 285000, '2022-08-24', 250000, 7, 'Dari Budi Grent 2', NULL, '2023-03-24', NULL, NULL, '2022-08-24 14:02:00', '2022-08-24 14:02:00', NULL),
(5, 'P201217-01', 2, 16, 1, NULL, 3, 'Kasur Ukuran 2', 1689500, 395500, 2085000, NULL, 585000, '2022-08-24', 500000, 3, '', NULL, '2022-11-24', NULL, NULL, '2022-08-24 14:12:42', '2022-08-24 14:12:42', NULL),
(6, 'P180408-01', 2, 29, 1, NULL, 1, 'Samsung Galaxy Bima Sakti', 3923077, 1176923, 5100000, NULL, 425000, '2018-04-08', 425000, 12, 'Epoy', NULL, '2019-04-08', NULL, NULL, '2022-08-25 09:08:20', '2022-08-25 09:08:20', NULL),
(7, 'P200928-01', 2, 48, 1, NULL, 1, 'Kipas Pemanas', 5500000, 1640000, 7140000, NULL, 2055000, '2020-09-28', 565000, 9, 'Hendro Misitama', NULL, '2021-06-28', NULL, NULL, '2022-08-25 09:16:34', '2022-08-25 09:16:34', NULL),
(8, 'P150101-01', 2, 42, 1, NULL, 5, 'Paket Bistara Bubble', 1049500, 300000, 1349500, NULL, 149500, '2015-01-01', 100000, 12, 'Ka Nia', NULL, '2016-01-01', NULL, NULL, '2022-08-25 09:33:08', '2022-08-25 09:33:08', NULL),
(9, 'P201026-01', 2, 10, 1, NULL, 1, 'Realmi 7i', 3074000, 826000, 3900000, NULL, 1040000, '2022-08-25', 260000, 11, '', NULL, '2021-09-26', NULL, NULL, '2022-08-25 10:35:12', '2022-08-25 10:35:12', NULL),
(10, 'P220825-01', 1, 6, 1, NULL, 2, 'Yamaha Fazio Classy', 22000000, 6600000, 28600000, NULL, 3400000, NULL, 2100000, 12, '', NULL, NULL, NULL, NULL, '2022-08-25 14:43:40', '2022-08-25 14:43:40', NULL),
(11, 'P220825-02', 2, 41, 1, NULL, 3, 'Meja Lipat', 750000, 250000, 1000000, NULL, 100000, '2022-08-25', 100000, 9, '', NULL, '2023-05-25', NULL, NULL, '2022-08-25 16:36:58', '2022-08-25 16:36:58', NULL),
(12, 'P220825-03', 1, 17, 1, NULL, 4, 'Palu Besar', 250000, 75000, 325000, NULL, 125000, NULL, 50000, 4, '', NULL, NULL, NULL, NULL, '2022-08-25 16:34:52', '2022-08-25 16:34:52', NULL),
(14, 'P220826-01', 2, 5, 1, NULL, 2, 'Brio 2017', 55000000, 16000000, 71000000, NULL, 16000000, '2022-08-26', 2750000, 20, '', NULL, '2024-04-26', NULL, NULL, '2022-08-26 15:01:28', '2022-08-26 15:01:28', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `karyawan_id` int(11) NOT NULL,
  `username` varchar(191) NOT NULL,
  `password` varchar(191) NOT NULL,
  `is_active` tinyint(1) DEFAULT '1',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `karyawan_id`, `username`, `password`, `is_active`, `created_at`, `updated_at`) VALUES
(1, 1, 'ddd', '$2a$12$w1reEO4G5Ag1KmhEQxPCTuepIny9DDbzCmzEprJLrQyA8O8PSUa7u', 1, '2022-07-25 17:00:00', '2022-08-21 23:25:05'),
(11, 12, 'ardli.firdlaus', '$2a$12$0CEwEPxNsG4ps4IOIHRKYefbCoklJBLbTR0g6Z/CQEfBNXrQkMorO', 1, '2022-08-22 06:57:14', '2022-08-23 13:27:47'),
(12, 13, 'asri', '$2a$12$fh.urXSrDJ6MG4aapx9mMeBEG5BsY5ESLN.DqRNeaI7mhX.E4952K', 0, '2022-08-23 10:30:14', '2022-08-23 10:44:05'),
(13, 14, 'ferina', '$2a$12$4pIRxmQJSpzPRuRpIEeS/uf9OlVGO9mjjz7Erd.lnqJ2UCRWcmMfa', 1, '2022-08-23 10:41:10', '2022-08-23 10:41:10'),
(14, 15, 'dino', '$2a$12$Z2GIj.sDoKdKcGKMt2p4eO01MI1kDNCwSs5h913QCdS4qh.11b/ly', 0, '2022-08-23 13:22:15', '2022-08-23 13:29:07'),
(15, 16, 'vierhan', '$2a$12$D0XLqvFcZvk/GJHV26ilE.XvPUCbB9ELoYVCvKxJ5crHnmRUhZ2KS', 0, '2022-08-23 13:27:25', '2022-08-23 13:30:44'),
(16, 17, 'adit', '$2a$12$DcNeTGz0NIQn1IsTrDmpPe20gaJUSGA6KZK93OQb7OU69se/083me', 1, '2022-08-24 07:10:03', '2022-08-24 07:10:03');

-- --------------------------------------------------------

--
-- Table structure for table `saham`
--

CREATE TABLE `saham` (
  `id` int(11) NOT NULL,
  `no_saham` varchar(255) DEFAULT NULL,
  `investor_id` int(11) DEFAULT NULL,
  `buy_price` int(11) DEFAULT NULL,
  `buy_date` date DEFAULT NULL,
  `no_bukti` varchar(255) DEFAULT NULL,
  `notes` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saham`
--

INSERT INTO `saham` (`id`, `no_saham`, `investor_id`, `buy_price`, `buy_date`, `no_bukti`, `notes`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'S010218-01', 1, 50000000, '0000-00-00', '', '', NULL, NULL, NULL),
(2, 'S010218-02', 2, 50000000, '0000-00-00', '', '', NULL, NULL, NULL),
(3, 'S010218-03', 3, 10000, '0000-00-00', '', '', NULL, NULL, NULL),
(4, 'S010218-14', 14, 2000000, '0000-00-00', '', '', NULL, NULL, NULL),
(5, 'S010218-15', 15, 3500000, '0000-00-00', '', '', NULL, NULL, NULL),
(6, 'S010218-16', 16, 4000000, '0000-00-00', '', '', NULL, NULL, NULL),
(7, 'S010218-17', 17, 2750000, '0000-00-00', '', '', NULL, NULL, NULL),
(8, 'S010218-18', 18, 3000000, '0000-00-00', '', '', NULL, NULL, NULL),
(18, 'SH00934', 24, 200000, '2022-08-01', '', '', '2022-08-23 18:01:41', '2022-08-23 18:01:41', NULL),
(19, 'SH08456', 25, 150000, '2021-08-12', '', '', '2022-08-23 20:34:48', '2022-08-23 20:34:48', NULL),
(20, 'SH220826-01', 26, 10000000, '2022-08-26', '', '', '2022-08-26 15:00:26', '2022-08-26 15:00:26', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `status_pengajuan`
--

CREATE TABLE `status_pengajuan` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_pengajuan`
--

INSERT INTO `status_pengajuan` (`id`, `name`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Belum Disetujui', '2022-08-23 11:00:43', '2022-08-23 11:00:45', NULL),
(2, 'Disetujui', '2022-08-23 11:00:43', '2022-08-23 11:00:45', NULL),
(3, 'Ditolak', '2022-08-23 11:00:43', '2022-08-23 11:00:45', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tipe_barang`
--

CREATE TABLE `tipe_barang` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipe_barang`
--

INSERT INTO `tipe_barang` (`id`, `name`, `notes`) VALUES
(1, 'Elektronik', NULL),
(2, 'Otomotif', NULL),
(3, 'Rumah Tangga', NULL),
(4, 'Pertukangan', NULL),
(5, 'Lainnya', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tipe_pengajuan`
--

CREATE TABLE `tipe_pengajuan` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipe_pengajuan`
--

INSERT INTO `tipe_pengajuan` (`id`, `name`, `notes`) VALUES
(1, 'Murabahah', NULL),
(2, 'Musyarakah', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adj_kas`
--
ALTER TABLE `adj_kas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Adj_Kas_fk0` (`update_by`);

--
-- Indexes for table `investor`
--
ALTER TABLE `investor`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pembayaran_pengajuan` (`pengajuan_id`);

--
-- Indexes for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pengajuan_status_pengajuan` (`status_pengajuan_id`),
  ADD KEY `FK_pengajuan_nasabah` (`nasabah_id`),
  ADD KEY `FK_pengajuan_tipe_pengajuan` (`tipe_pengajuan_id`),
  ADD KEY `FK_pengajuan_tipe_barang` (`tipe_barang_id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_pengguna_karyawan` (`karyawan_id`);

--
-- Indexes for table `saham`
--
ALTER TABLE `saham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_saham_investor` (`investor_id`);

--
-- Indexes for table `status_pengajuan`
--
ALTER TABLE `status_pengajuan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipe_barang`
--
ALTER TABLE `tipe_barang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipe_pengajuan`
--
ALTER TABLE `tipe_pengajuan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adj_kas`
--
ALTER TABLE `adj_kas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `investor`
--
ALTER TABLE `investor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `pengajuan`
--
ALTER TABLE `pengajuan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `saham`
--
ALTER TABLE `saham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `status_pengajuan`
--
ALTER TABLE `status_pengajuan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tipe_barang`
--
ALTER TABLE `tipe_barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tipe_pengajuan`
--
ALTER TABLE `tipe_pengajuan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `FK_karyawan_jabatan` FOREIGN KEY (`jabatan_id`) REFERENCES `jabatan` (`id`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `FK_pembayaran_pengajuan` FOREIGN KEY (`pengajuan_id`) REFERENCES `pengajuan` (`id`);

--
-- Constraints for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD CONSTRAINT `FK_pengajuan_nasabah` FOREIGN KEY (`nasabah_id`) REFERENCES `nasabah` (`id`),
  ADD CONSTRAINT `FK_pengajuan_status_pengajuan` FOREIGN KEY (`status_pengajuan_id`) REFERENCES `status_pengajuan` (`id`),
  ADD CONSTRAINT `FK_pengajuan_tipe_barang` FOREIGN KEY (`tipe_barang_id`) REFERENCES `tipe_barang` (`id`),
  ADD CONSTRAINT `FK_pengajuan_tipe_pengajuan` FOREIGN KEY (`tipe_pengajuan_id`) REFERENCES `tipe_pengajuan` (`id`);

--
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `FK_pengguna_karyawan` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`);

--
-- Constraints for table `saham`
--
ALTER TABLE `saham`
  ADD CONSTRAINT `FK_saham_investor` FOREIGN KEY (`investor_id`) REFERENCES `investor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
