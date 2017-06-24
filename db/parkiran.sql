-- phpMyAdmin SQL Dump
-- version 4.2.5
-- http://www.phpmyadmin.net
--
-- Host: localhost:8889
-- Generation Time: 24 Jun 2017 pada 10.25
-- Versi Server: 5.5.38
-- PHP Version: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sistem_parkir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkiran`
--

CREATE TABLE `parkiran` (
  `id_parkiran` varchar(12) NOT NULL,
  `no_polisi` varchar(35) NOT NULL,
  `jenis_kendaraan` varchar(25) NOT NULL,
  `tgl_masuk` date NOT NULL,
  `jam_masuk` time NOT NULL,
  `tgl_keluar` date DEFAULT NULL,
  `jam_keluar` time DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `parkiran`
--

INSERT INTO `parkiran` (`id_parkiran`, `no_polisi`, `jenis_kendaraan`, `tgl_masuk`, `jam_masuk`, `tgl_keluar`, `jam_keluar`, `total`) VALUES
('PR/00001', 'B4382TIR', 'Motor', '2017-06-18', '21:38:30', '2017-06-18', '22:03:33', 2000),
('PR/00002', 'B6666TRE', 'Mobil', '2017-06-18', '22:01:25', '2017-06-18', '22:02:07', 3000),
('PR/00004', 'B4382TIR', 'Motor', '2017-06-24', '15:15:32', '2017-06-24', '15:15:46', 2000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `parkiran`
--
ALTER TABLE `parkiran`
 ADD PRIMARY KEY (`id_parkiran`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
