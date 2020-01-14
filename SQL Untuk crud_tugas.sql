-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14 Jan 2020 pada 04.45
-- Versi Server: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fakultas`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dosen`
--

CREATE TABLE `dosen` (
  `ID_DOSEN` varchar(15) NOT NULL,
  `NAMA` varchar(30) NOT NULL,
  `ALAMAT_DOSEN` varchar(20) NOT NULL,
  `NO_HP` bigint(12) NOT NULL,
  `status` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `dosen`
--

INSERT INTO `dosen` (`ID_DOSEN`, `NAMA`, `ALAMAT_DOSEN`, `NO_HP`, `status`) VALUES
('19581212', 'agdjh', 'adjwhkd', 0, ''),
('19581212198601', 'Ir. Diding Suhardi, MT', 'Jl. Tirto Utomo Gg.I', 2147483647, ''),
('19581212198602', 'M. Chasrun Hasani, ST., MT', 'Jl. Kenanga no.92 Ar', 811360494, ''),
('19581212198603', 'Ir. Lailis Syafa`ah, MT', 'Perum. Tanjung Sekar', 2147483647, ''),
('19581212198604', 'Ir. M. Irfan, MT', 'Perum. Tanjung Sekar', 2147483647, ''),
('19581212198605', 'Drs. Budi Priyanto, MSi', 'Perum. Tanjung Sekar', 2147483647, ''),
('19581212198606', 'Machmud Effendy, ST., MEng', 'Terusan Cangkalang 1', 2147483647, ''),
('19581212198607', 'Ir. Nurhadi, MT', 'Terusan Cangkalang 1', 2147483647, ''),
('19581212198608', 'Ir. Nur Alif Mardiyah, MT', 'Jl. Merpati Utara no', 2147483647, ''),
('19581212198609', 'Zulfatman, ST., MEng', 'Jl. Merpati Utara no', 2147483647, ''),
('19581212198610', 'Eko Budi Cahyono, SKomp', 'Raya Sidomakmur no.9', 2147483647, ''),
('19581212198611', 'Ir. Nur Kasan, MT', 'Tebet Barat Kav.3 Te', 2147483647, ''),
('19581212198612', 'Ir. Ermanu Azizal Hakim, MT', 'Taman Borobudur Inda', 2147483647, ''),
('19581212198613', 'Akhmad Maulidi, ST ', 'Perum. IKIP Blok 2 H', 7338443, ''),
('19581212198614', 'Erik Hermawan, ST', 'Jl. Untung Suropati ', 2147483647, ''),
('19581212198615', 'Fatthurrohman, ST.,MT', 'Jl. Semolowaru Elok ', 2147483647, ''),
('19581212198616', 'Hary Suswanto, ST., MT', 'Jl. Sentaurus', 2147483647, ''),
('19581212198617', 'Ir. H. Syamsudin Maskat', 'Jl. Bendungan Jati L', 2147483647, ''),
('19581212198618', 'Ir. Ahmad Anshori, DEA ', 'Jl. Teknik Pengairan', 2147483647, ''),
('19581212198619', 'Ir. Totok Mujiono, MSc', 'Jl. Teknik Elektro P', 2147483647, ''),
('19581212198620', 'Drs. Imam Khambali', 'Jl. Dr. Sutomo no.10', 2147483647, ''),
('19581212198621', 'DR. Imam Robandi., MT', 'Jl. Dr. Sutomo no.10', 2147483647, ''),
('19581212198622', 'Prof. DR. Mauridhi Hery, MSc', 'Jl. Semolowaru Elok ', 2147483647, ''),
('19581212198623', 'Drs. Madari H', 'Jl. Tumapel No. 1 (w', 586397, ''),
('19581212198624', 'Hj. Kartini, SH', 'Jl. Candi VI B/100 G', 2147483647, ''),
('19581212198625', 'Drs. Nurhadi, MSi', 'Jl. Simpang Wonogiri', 2147483647, ''),
('19581212198626', 'Dra Tutik Sulistyowati, MSi', 'Perum. Unibraw / Per', 2147483647, ''),
('19581212198627', 'Lailiyah Agustina, SSos', 'Jl. Tirto Utomo 22', 2147483647, ''),
('19581212198628', 'M. Nasar, ST', 'Perum. Bumi Asri Blo', 2147483647, ''),
('19581212198629', 'Bahtiar Effendi, ST', 'Jl. Sudimoro 4 RT.01', 2147483647, ''),
('19581212198630', 'Drs. H. Humaidi Tatapangarsa', 'Jl. Simpang Bogor 22', 2147483647, ''),
('2222', '2222', '2222', 22222, '222222'),
('qqqq', 'qqqq', 'qqqq', 0, 'qqqq');

-- --------------------------------------------------------

--
-- Stand-in structure for view `perkuliahan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `perkuliahan` (
);

-- --------------------------------------------------------

--
-- Struktur untuk view `perkuliahan`
--
DROP TABLE IF EXISTS `perkuliahan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `perkuliahan`  AS  select `mahasiswa`.`NIM` AS `NIM`,`mahasiswa`.`NAMA_m` AS `nama_m`,`mahasiswa`.`ALAMAT` AS `alamat`,`dosen`.`ID_DOSEN` AS `ID_DOSEN`,`dosen`.`NAMA` AS `NAMA` from (`mahasiswa` join `dosen`) where (`mahasiswa`.`NIM` = `dosen`.`ID_DOSEN`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`ID_DOSEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
