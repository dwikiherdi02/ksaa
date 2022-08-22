-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2022 at 09:46 AM
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
-- Table structure for table `adj_kas`
--

CREATE TABLE `adj_kas` (
  `id` int(11) NOT NULL,
  `cash_in` int(11) DEFAULT NULL,
  `cash_out` int(11) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `notes` text DEFAULT NULL
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
  `address` text DEFAULT NULL,
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
(15, 'Andi Basso', '1234123412341234', 'Pulau Seribu', NULL, 'Jl.Tanjung Priok', 2, 'Swasta', 5, 'PT. Gistec Prima', 7000000, '81922344557', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(16, 'M. Darwis', '1234123412341234', 'Brebes', NULL, 'Jl. Simatupang', 0, 'Security', 2, 'Perumahan Kalibata Indah', 4500000, '82345618912', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(17, 'Arifin', '1234123412341234', 'Jakarta Barat', NULL, 'Jl. Raya Kuningan', 1, 'Swasta', 5, 'PT. Multi Guna Laksindo', 5000000, '82331233132', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(18, 'Dea Ananda', '1234123412341234', 'Cirebon', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 10, 'PT. Heburinas Nusantara', 6000000, '82345678945', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(19, 'Irwansyah Kumara', '1234123412341234', 'Banten', NULL, 'Jl. Raya Kalideres', 0, 'Swasta', 5, 'PT. Mitrais', 5000000, '81235678456', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(20, 'Mira Sartika', '1234123412341234', 'Surabaya', NULL, 'Jl. Raya Pasar Minggu', 4, 'Swasta', 15, 'PT. Tempo Land', 7000000, '81234568902', '2022-08-22 09:07:55', '2022-08-22 09:07:55', NULL),
(21, 'Pandji', '1234123412341235', 'Bandung', '1990-08-22', 'Jalan kebenaran', 1, 'Swasta', 12, 'PT SIDO', 1000000000, '087782320919', '2022-08-22 09:39:17', '2022-08-22 09:39:53', NULL);

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
(7, 'Supervisor', 'SPV', '2022-08-21 01:50:21', '2022-08-21 03:22:10', '2022-08-21 03:22:10');

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
(1, 1, 'ADM001', 'Dwiki Herdiansyah', 'dwikiherdi520@gmail.com', 'Jalan Edelweis No 11', 1, '2022-08-17 09:24:18', '2022-08-21 23:25:05', NULL),
(2, 1, 'USR001', 'User 1', 'user1@mail.com', 'Jalan Kebenaran', 1, '2022-08-17 09:24:18', '2022-08-20 04:39:14', NULL),
(3, 3, 'USR002', 'User 2', 'user2@mail.com', 'Jalan Buntu', 0, '2022-08-17 09:24:18', '2022-08-20 04:19:44', NULL),
(4, 1, 'ADM002', 'Admin-2', 'admin2@mail.com', 'Jalan jalan', 0, '2022-08-17 22:40:16', '2022-08-20 04:25:59', '2022-08-20 04:25:59'),
(5, 4, 'USR003', 'User 3', 'user3@mail.com', 'jalan senopati', 0, '2022-08-17 22:41:24', '2022-08-17 22:41:24', NULL),
(6, 5, 'USR004', 'User 4', 'user4@mail.com', 'Jalan magelang', 1, '2022-08-17 22:43:54', '2022-08-17 22:43:54', NULL),
(7, 3, 'USR005', 'User 5', 'user5@mail.com', 'jalan kaki', 1, '2022-08-19 05:40:04', '2022-08-19 05:40:04', NULL),
(8, 4, 'USR006', 'User 6', 'user6@mail.com', 'jalan jalan', 1, '2022-08-19 17:08:25', '2022-08-20 02:04:42', NULL),
(9, 1, 'USR007', 'User 7', 'user7@mail.com', 'jalan kebayoran', 0, '2022-08-19 18:31:46', '2022-08-21 06:33:48', NULL),
(10, 2, 'USR008', 'User 8', 'user8@mail.com', 'jalan buntu', 0, '2022-08-20 04:02:04', '2022-08-20 04:26:27', '2022-08-20 04:26:27'),
(11, 1, 'USR008', 'User 8', 'user8@mail.com', 'jalan jalan', 0, '2022-08-20 04:39:52', '2022-08-21 06:32:01', '2022-08-21 06:32:01');

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
  `address` text DEFAULT NULL,
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
(45, 'Ferry Irawan', '1234123412341234', 'Bekasi', NULL, 'JL. Pancoran', 2, 'Swasta', 3, 'PT. Humpuss', 5000000, '81927423423', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(46, 'Andis Ramadhan', '1234123412341234', 'Bogor', NULL, 'Jl.Tanjung Priok', 5, 'Swasta', 8, 'PT. Humpuss Karbometil Selulosa', 7000000, '81922344557', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(47, 'Bambang', '1234123412341234', 'Depok', NULL, 'Jl. Rawasari', 2, 'Swasta', 2, 'PT. Usaha Gemilang Utama', 5000000, '82345618672', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(48, 'Hasanuddin', '1234123412341234', 'Medan', NULL, 'Jl. Raya Kalibata', 2, 'Swasta', 5, 'PT. Bank Ina Perdana Tbk.', 7000000, '82331232332', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(49, 'Reza Ardian', '1234123412341234', 'Makassar', NULL, 'Jl. Raya Kalideres', 1, 'Swasta', 7, 'PT. Anggun Permai Tekindo', 4500000, '82345667945', '2022-08-22 03:51:10', '2022-08-22 03:51:10', NULL),
(50, 'Jauhari', '1234123412341234', 'Jambi', '1990-09-12', 'Jl. Raya Kalibata', 3, 'Swasta', 6, 'PT. Digital Andalan Nusantara', 7000000, '81235611456', '2022-08-22 03:51:10', '2022-08-22 08:51:47', NULL),
(51, 'Pandji', '1234123412341234', 'Jakarta', '1997-03-06', 'Jalan jalan', 0, 'Swasta', 7, 'PT IID', 15000000, '087782320199', '2022-08-22 07:57:13', '2022-08-22 09:24:54', NULL),
(52, 'Panjul', '1234123412341235', 'Bandung', '2000-08-15', 'Jalan Kaki', 3, 'Swasta', 1, 'PT UUD', 1000000, '08778232193', '2022-08-22 08:59:26', '2022-08-22 08:59:26', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(11) NOT NULL,
  `nominal` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `cara_bayar` varchar(255) DEFAULT NULL,
  `notes` text DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `pengajuan_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id`, `nominal`, `date`, `cara_bayar`, `notes`, `is_deleted`, `last_updated`, `update_by`, `pengajuan_id`) VALUES
(1, 400000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 1),
(2, 400000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 1),
(3, 400000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 1),
(4, 400000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 1),
(5, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3),
(6, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3),
(7, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3),
(8, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3),
(9, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3),
(10, 350000, '0000-00-00', 'Transfer', '', 0, '0000-00-00 00:00:00', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan`
--

CREATE TABLE `pengajuan` (
  `id` int(11) NOT NULL,
  `no_pengajuan` varchar(255) DEFAULT NULL,
  `nasabah_id` int(11) DEFAULT NULL,
  `tipe_id` int(1) DEFAULT NULL,
  `nama_jasa` varchar(255) DEFAULT NULL,
  `modal` int(11) DEFAULT NULL,
  `est_laba` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `total_up` int(11) DEFAULT NULL,
  `total_angsuran` int(11) DEFAULT NULL,
  `dp` int(11) DEFAULT NULL,
  `cicilan` int(11) DEFAULT NULL,
  `notes` text DEFAULT NULL,
  `status_pengajuan` varchar(255) DEFAULT NULL,
  `status_pembiayaan` varchar(200) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  `nama_barang` varchar(255) DEFAULT NULL,
  `tipe_barang` int(11) DEFAULT NULL,
  `dp_date` date DEFAULT NULL,
  `act_laba` int(11) DEFAULT NULL,
  `est_end` date DEFAULT NULL,
  `act_end` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengajuan`
--

INSERT INTO `pengajuan` (`id`, `no_pengajuan`, `nasabah_id`, `tipe_id`, `nama_jasa`, `modal`, `est_laba`, `total`, `total_up`, `total_angsuran`, `dp`, `cicilan`, `notes`, `status_pengajuan`, `status_pembiayaan`, `is_deleted`, `last_update`, `update_by`, `nama_barang`, `tipe_barang`, `dp_date`, `act_laba`, `est_end`, `act_end`) VALUES
(1, 'P210921/1', 1, 1, '', 1584000, 476000, 2060000, 2060000, 4, 460000, 400000, '', 'Disetujui', 'Lunas', 0, '0000-00-00 00:00:00', 2, 'Infinix Hot 10', 1, '2021-09-22', 476000, '2022-02-01', '2022-01-28'),
(2, 'P310822/1', 2, 1, '', 226200, 61800, 288000, 288000, 2, 100000, 94000, '', 'Disetujui', 'Belum Lunas', 0, '0000-00-00 00:00:00', 2, 'STB Android TV BOX MXQ PRO', 1, '2022-08-31', 0, '0000-00-00', '0000-00-00'),
(3, 'P010122/1', 3, 1, '', 2140000, 642000, 2782000, 2782000, 7, 332000, 350000, '', 'Disetujui', 'Menunggak', 0, '0000-00-00 00:00:00', 2, 'Kasur Inoac', 3, '2022-01-01', 0, '0000-00-00', '0000-00-00');

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
(1, 1, 'ddd', '$2a$12$w1reEO4G5Ag1KmhEQxPCTuepIny9DDbzCmzEprJLrQyA8O8PSUa7u', 1, '2022-07-25 17:00:00', '2022-08-21 23:25:05'),
(2, 2, 'user1', '$2a$12$QWyRQFFBzFLPIols6ArfruHpSXiC7pl7rqS6Q2ktzBmAoHZnHcXUe', 1, '2022-07-25 17:00:00', '2022-08-20 04:39:14'),
(3, 4, 'admin2', '$2a$12$RtfPEq/NwHhKueKau3yhHu54V7kAf7L0xppOMDofuEhpygcmr09WG', 0, '2022-08-17 22:40:16', '2022-08-20 04:25:59'),
(4, 6, 'user4', '$2a$12$FXT.dB8UMdG8./whG2ftTOy2u0XC1WeXgEpboWc6MNtEtbZ4hVLI.', 1, '2022-08-17 22:43:54', '2022-08-20 04:19:36'),
(5, 7, 'user5', '$2a$12$ka5wvjTmaWnCevIjtvqqYOZXE4OM3M/o04eWS2ZudSg8AOk6h5mUG', 1, '2022-08-19 05:40:04', '2022-08-19 05:40:04'),
(6, 8, 'user6', '$2a$12$4yBMBu7WPGV9i.O9gb3FiuFYnN4HiW/jL2udq6CZ0REANivBmb6Gm', 1, '2022-08-19 17:08:25', '2022-08-19 17:08:25'),
(7, 9, 'user7', '$2a$12$HFoQQs1kx0ius7tJWqC3UOy9t34FXgwAWKR61j/yotzF.at5CiCG.', 0, '2022-08-19 18:31:46', '2022-08-21 06:33:48'),
(9, 10, 'user8', '$2a$12$8Wc4EEAA1cnka6Z/Qv/z0eAqEESu8SPYnxqeyMaognCWwCcCLsIbi', 0, '2022-08-20 04:15:10', '2022-08-20 04:26:27'),
(10, 11, 'user8', '$2a$12$cB/BjGHHr2kS4KaC32tLbuQbAFhGsEV6jwVcNcMvdl.2RzgkSUHZy', 0, '2022-08-20 04:40:08', '2022-08-21 06:32:01');

-- --------------------------------------------------------

--
-- Table structure for table `saham`
--

CREATE TABLE `saham` (
  `id` int(11) NOT NULL,
  `no_saham` varchar(255) DEFAULT NULL,
  `investor_id` int(11) DEFAULT NULL,
  `head_id` int(11) DEFAULT NULL,
  `kelompok` varchar(255) DEFAULT NULL,
  `buy_price` int(11) DEFAULT NULL,
  `buy_date` date DEFAULT NULL,
  `no_bukti` varchar(255) DEFAULT NULL,
  `notes` text DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL,
  `last_updated` datetime DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `saham`
--

INSERT INTO `saham` (`id`, `no_saham`, `investor_id`, `head_id`, `kelompok`, `buy_price`, `buy_date`, `no_bukti`, `notes`, `is_deleted`, `last_updated`, `update_by`) VALUES
(1, 'S010218-01', 1, NULL, '', 50000000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(2, 'S010218-02', 2, NULL, '', 50000000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(3, 'S010218-03', 3, NULL, '', 10000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(4, 'S010218-14', 14, NULL, '', 2000000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(5, 'S010218-15', 15, NULL, '', 3500000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(6, 'S010218-16', 16, NULL, '', 4000000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(7, 'S010218-17', 17, NULL, '', 2750000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2),
(8, 'S010218-18', 18, NULL, '', 3000000, '0000-00-00', '', '', 0, '0000-00-00 00:00:00', 2);

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
  ADD KEY `Pembayaran_fk0` (`update_by`),
  ADD KEY `Pembayaran_fk1` (`pengajuan_id`);

--
-- Indexes for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Pengajuan_fk0` (`nasabah_id`),
  ADD KEY `Pengajuan_fk1` (`tipe_id`),
  ADD KEY `Pengajuan_fk2` (`update_by`),
  ADD KEY `Pengajuan_fk3` (`tipe_barang`);

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
  ADD KEY `Saham_fk0` (`investor_id`),
  ADD KEY `Saham_fk1` (`head_id`),
  ADD KEY `Saham_fk2` (`update_by`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `pengajuan`
--
ALTER TABLE `pengajuan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `saham`
--
ALTER TABLE `saham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
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
-- Constraints for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `FK_pengguna_karyawan` FOREIGN KEY (`karyawan_id`) REFERENCES `karyawan` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
