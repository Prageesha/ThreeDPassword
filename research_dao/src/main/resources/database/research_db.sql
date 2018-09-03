-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 03, 2018 at 01:43 PM
-- Server version: 5.7.20-ndb-7.6.5
-- PHP Version: 5.5.9-1ubuntu4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `research_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `DATABASECHANGELOG`
--

CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DATABASECHANGELOG`
--

INSERT INTO `DATABASECHANGELOG` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`) VALUES
('1', 'Prageesha', 'src/main/resources/liquibase/research-0.1.xml', '2018-08-18 06:43:07', 1, 'EXECUTED', '7:500c87024374a2adb1936b5e675d6d40', 'createTable', '', NULL, '3.4.2', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `graphical_login_time`
--

CREATE TABLE `graphical_login_time` (
  `id` int(11) NOT NULL,
  `time` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphical_login_time`
--

INSERT INTO `graphical_login_time` (`id`, `time`) VALUES
(79, 11),
(80, 8),
(81, 7),
(82, 11),
(83, 11),
(84, 8),
(85, 6),
(86, 14),
(87, 7),
(88, 9),
(89, 9),
(90, 12),
(91, 18),
(92, 14),
(93, 10),
(94, 8),
(95, 8),
(96, 8),
(97, 17),
(98, 10);

-- --------------------------------------------------------

--
-- Table structure for table `graphical_password`
--

CREATE TABLE `graphical_password` (
  `user_name` varchar(200) NOT NULL,
  `password` varchar(4000) DEFAULT NULL,
  `salt` varchar(4000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphical_password`
--

INSERT INTO `graphical_password` (`user_name`, `password`, `salt`) VALUES
('RM1', '5b5d3d0a58dd593cb6a8962adce59d02581a0d1eb25a6526', 'YMLXdglpKcVRTiqxczJWE3tIn6Ak3BtHYJvFKXzAVugqc3VnM4psdwfNoApXmlJMPponMFGlbpPXReIySRUs8jCGKkcqyd5kNS8iELxDc6l1qJS8YC2f0UF0Vwcd3hDF'),
('RM10', '39306402ccf875cecaf247cd2d448e4baf1ceacfb826bba2', '88kqluF5ruPgmAd4iX3n2LC1m2oclFDz6ZuzShflmSRhKgXrJSyjEsbXIJpQF3sA4kCs9QtsKBFsJLMoZUMQKX3I11pPfbF3X83bI8sRF2fwwhCtEEnVfSyrMX0QidWH'),
('RM11', '-73ab18e919010d24ebe1bca04ce6f194e44c8efae4b99521', 'aVUuIaqAuzJN1c5oFz6W36DB3tsDGx6HoSVA6noilqErUHD77dVo5tala6FjDYFyt2js8Bua7QfWlwXHACpn0VtRPXhBEpDqkOtZ7S4x9oAXjTLzFBLZfalErDDUh6f5'),
('RM12', '7a8d9fa245007880be4fc1c08859c37fec807cd4086b47e', 'CuZqgxI1Ke7iWW2wuWWF3uXFgclobAtWJzjodLL5GKvgLKTLxBu8jJ92BgYboc2EUPTH88URpi97P3ewPAZX8bIzEWSwqFtpnuwu6khpKXeB7UMFYUxAZfznwEjWhsvE'),
('RM13', '49fd7477ac339b4b7bf9660b6f1c577342cd0c261ac52490', 'ZmbVqCFk0i1ThBwsD6tS872yKaKNC4ionmVgHFhk5hYNF7t7HehJX7MF33coXUSAYh0VrmxIGK5XYT5WwbxG9QSNyQljI8JFCJGpzReQ3BhbQwvxIVyxHZaOnVTNWalM'),
('RM14', '22fccf8a100cb1a4047532aa495e31a716a45751599359eb', 'Kjcst62OdqK2PmRwiyDopYBHUjsy8axNtQrH2WmxSdYiVpnZ1hjLo9WbFjqIpPiFdF5E2N3wuxFymOKvkfDqv66FBBFHM2qUAxaCYjeLilLZLMMH7ivUpmfsgH6C351g'),
('RM15', '-2e08666fbcf2e644d93c2ad5a2f19774d56c1113414833ac', '2RfKwXAG6gFFsxmtu1ZH93nvgD7wAHsDI32Y80Ri3nUT13m3kG27IoZA7zgyzT7ZAfWKJOIKyYYSDcmbF0X5fmjHq23hR4WJie0tLI7xs7QKPSwlYTTFnabLaAoB4Ict'),
('RM16', '5759e311987e343134388559781d41f60e369d12b81ef417', 'hZwqt8kvQOwya3epQab9AW9z9ds8zHHYfUgydP0WXB2f1BXqyIpybNMlnRWZlSDnU3ZjiyaggsqQFynMFowYehx8D8UIF63FkoIBogcXYgFUfvRTs2KlblKaXLBml0S6'),
('RM17', '73c30f1afb532007b36eda3a5ba5bdf896bb6f0f78673d1b', 'HW2SNHlZZy8T5dckoc8U3AYuRjf3AD40mxELuysd4kMnPm5v6BUXfGHMWGykURtu7MFFcTVjsqfOe3OadcLABzPEyA4WbqPUwfuAVH7FPNnUFLFrXgdavXAdYXZJqi10'),
('RM18', '4ec39e2303cf732623cf70572b6381809490a55858b92c74', '6PFsUGs16YmVmoE3g5svgWPN1SvobXp2VrXT5qvHRz6ZrXCVUVSoiDrzMmqQdgMfmO8Kg6RIUVSCbpeClqqXXrvqtoTMTFJiNufHlrwMoKs8uR83F9DouSSgSkyZFfHT'),
('RM19', '1d819c8d8615872379f77a1371cd121f15ccdafce929aabe', 'P6B6hAh7quzjEtfilivd7fsT6ePCQzoZtRntV61zFpWKWbwjIRYiQtLA7XODeAq0YT94XEeR5l6k1w4yBsN3MtYKXcgdxR8RUcmORxPjlt2EvBS86u1KuMf9AQXsqWZL'),
('RM2', '422bf1c6ac6a40e41ba79cb998df1b38d495f5ce80d50f7', 'pmDkeE7UhbJD8dM5uXAAt7IngRyxWJWrcLiULuqn1Fnutpr8DaDAN7FwwJWTFhucGJegzmNFYIjduTfhyJFUa7I5ktn8UZbXuQcVqnmbR1yEX7ve3yVPCIngorGjxPv5'),
('RM20', '3f3a4fb28537d20efe1d84eea04e5b3322741031d2e51cd2', 'QYamI1oTqEA0Tu69kkgKgARrrwPj7bJSNQTLYflO3h1rbcq8Y7uPRL5JHdSTO1dg3YRyiRvHxt3Kimk1BYEyLHVcFzzeMlI9bWIpShaqwdJJxfPJzxhSZsBg2xbnugIj'),
('RM3', '6da20f5075b3cb5970200eaec5497f9b53e01ec3c0512c0', '4uLmQgFeHCHn4RJI9XVlV8jYItHV0ReLNcPnSxqgiIyycsrgvj5Ds1ax5rh8JdFGt8erbFiD49qVjrZe1OwLljdaaExx549BFNILRHUgpdL2blZAOfiyzwA93QCIBpT3'),
('RM4', '-3a77482dff1364fbee8191efe00f3c1c09a742cddca755be', 'UoVYXFiD9j9aQc9zFHA2DGwR03FvLCzsjUnYv3IrX5GvQJVC2P4w9xrOMMsiDRZkFaItoRbT9Y6qzNnLLZ5VTWanilB0XrZCjJOWTjnFxyK7J5GWivMHeMRFzIzWRIm3'),
('RM5', '29755aac293df82f5d3024d408648f547125538840d181f', 'FwpFe69hsgGQBkUzj9Fuab0OEMa84UhOXNRDPPpQziHBlWPWWyhkiqF2YwrYiUTFIhNuZsk2qeYJn3ekiXMEO0RhcUpeXjZm7GJgeYRJ6oO4aisTCQjEG2RlFbQfw8bp'),
('RM6', '-58165bb004ed3ee8cb30462c563eb226d59378a1ddd832db', '6BpuR7i19zfZTzRgVTV1mvbGWJTDllN37AqDVulqJGsk58aygmLC8c6F8XYz8Yu6YTB6uVVJa6GPx2q4D4j4h7tWSOb870HVwAnDHOn2FJvFCsjjOtrrQYtaAlCd211f'),
('RM7', '-399f8f4b57741ff6a52c6d44458cd77b6d7951ca4f5e73e0', 'PyZhuiLFPGWpQF3UKB8x52GhRS2P0DvNLQZQbBsnnNnwsoerfpLQLyeiVQ49HqzAomyBZDQjqQx0gkerIdx4YXb9lv2TXvrfb5b5mmzx1LwVQ8hsQCqloJDvjEmHrShX'),
('RM8', '-50edb65a4dea62209ca9c8bc4d3ca093d8638443a96d32d4', '5qkQNq4F80yX2ziNnxtFyoAJ1DENCcv215O3KDvi4CAlcKOAdZYRYWiZ9AJGclHEIf76EgFmn97lH8sUCXgvwmN1TF6mFVeGX5le44dIfybxG2Xt0sgIApci0di40qiW'),
('RM9', '584a801bc0371f07f7b627e9f4453ed58d04e6234823edc5', 'c2sQAK78HxWv8uHP9PXG6f3xyDKytiH2CmZajop375gzZJCABT09kurnHfp0Qq41ZQVdb4QVbMDiJlhFrbGkrCnP79FmFgK3KlsGmFWypozjxyzFOIFDVYQPldJk5DMw');

-- --------------------------------------------------------

--
-- Table structure for table `graphical_register_time`
--

CREATE TABLE `graphical_register_time` (
  `id` int(11) NOT NULL,
  `time` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graphical_register_time`
--

INSERT INTO `graphical_register_time` (`id`, `time`) VALUES
(54, 74),
(55, 73),
(56, 43),
(57, 88),
(58, 58),
(59, 40),
(60, 61),
(61, 25),
(62, 47),
(63, 42),
(64, 49),
(65, 43),
(66, 40),
(67, 38),
(68, 47),
(69, 45),
(70, 45),
(71, 48),
(72, 33),
(73, 43);

-- --------------------------------------------------------

--
-- Table structure for table `text_login_time`
--

CREATE TABLE `text_login_time` (
  `id` int(11) NOT NULL,
  `time` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `text_login_time`
--

INSERT INTO `text_login_time` (`id`, `time`) VALUES
(42, 18),
(43, 7),
(44, 7),
(45, 8),
(46, 5),
(47, 8),
(48, 6),
(49, 6),
(50, 5),
(51, 6),
(52, 7),
(53, 4),
(54, 9),
(55, 5),
(56, 14),
(57, 11),
(58, 6),
(59, 13),
(60, 6),
(61, 6),
(62, 10);

-- --------------------------------------------------------

--
-- Table structure for table `text_password`
--

CREATE TABLE `text_password` (
  `user_name` varchar(200) NOT NULL,
  `password` varchar(2000) NOT NULL,
  `salt` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `text_password`
--

INSERT INTO `text_password` (`user_name`, `password`, `salt`) VALUES
('RM1', '-196f256222485169e8520ea2cec5bcf1892d6a46370dfeea', 'yNyc3jWkfAvWpAAQf6VMwFtdIDfAsOqQxSyDv5XWp8ZahQMFFTWMubVhix0tS84lKhTZ7R1rYh1BT1GJjAcQM5ccddL8xTVCEWumH4FgUZmpjFHXE1wZOwBduFMxQ9HK'),
('RM10', '-27801c2e4e5753434a48d0633010a49e8cf470f97c2ef18e', 'FD1m1bjZGbubB50DDHLlgKwhVxMMGMozj6CBxFhjYfs0oiuuSF3gO7tcRTkWIgx8eMlPLr2hJt4FL40lCUkKji64OtCLWr6O6F98wZEw6MG3NsFiD5HuE1GzazfFBX8B'),
('RM11', '-29051c7615f12828ac30fcd1233aa46fc4da797a872d08e1', 'mvhFmwoLwOOTrfgtnymbasgCcls2UF2tF1YyfK8Mzs07gobz6ldsJzSHFuqENLquDCZhveepqq6kmnfVuFDezVoYIShqf5QRe35b5YwVVKn6PMvmc3l66J50VMDLZqfx'),
('RM12', '-591aec5faa6052fa95ffccd5e9d66cb3bfe5d165ccaed8e5', 'kTsTiMjnRqXlMXNDGKG9tE8ypBuioNXVCF0o6FMeuQNo8WyecJW4jgUayOJcZIG7tHbPjAArFaCcctOjxwVQIisjf0gbyLgkvkyFlohr0xhS6Q3NR1RBifFbAvYY5TZw'),
('RM13', '-4853aa92643a491fab74c661b2f24474e2628c4926ecb64d', 'xN6HKqsSunLQiGKPrCuUXzWFCurFLcF4hI3FAda9i7yMRmxuXcn05occC6v2S5SiWGAO36wnQN7gWOaOZr13FP86jfFjtCGbcfiwl3glRMLGKO4KkhyzOztLAYS2yhzR'),
('RM14', 'daba887917695147246977bc3f04eed6ec1fae59911b7ef', 'Lf66sMmI9TrisxdfFKqHsVe63a5YsWiJMDuHFRfDboP4w9zxbq0Ub9GQzfJ5cB3x2W0lG1DTRZ7vGQTFAMIL6ego1DKuDXGg0kImFF7Cxbs9OLFLs8X14cguBj3f4WAi'),
('RM15', '-377f1c4e007b67c8627e064b3c70aecb40eb6ae4ac294d0a', '7qZ8T04Mp6uyHIlnsdSWyaK5Rht9yFcpYPXRQBOLFZaWCOLaF6lE1FZvHzD4AHq9qFgbidcoEFGa0MiaI0cQmNaR4WeN3WjQxn9e5zPXb6yv2lpaFq8hSFzBYRrlROF7'),
('RM16', 'ddb1a65f90983caf4e1ca74a8e6c176da92a49ea4ac27ca', 'UlJFdM3sCSTGp5ar1fHFGnVynZtQsgnJWpK5O9MXca4v2F3XKgFRhTYG4KjwigxFoofdY8738ejBIFNlZlrSLsoVmqW80BmvVKJ2JWg4ETMPFQ6ncSu4qebdD2GHJOQr'),
('RM17', '-5ee339f3d9bc29713931912b082c9f11a43a1745cae1f2f8', '02cLPWr2A86zj6iNBssNFHtyFXbOMYJe1OLK6xoeNxzSvasTLM8NjkONjdEFcJhCQI25VLKfuSFxGFV6dkaQRMejFi6T3P38FqduLNfPBoZbIOtTE9fVY7Rc0FQRvgn3'),
('RM18', '56b4f7a559c58c5805099ed07f38e284e7c20f8dea649ab2', 'ymedi0yQK3caJNAldrv2431GFWT0FjBKz0JB3CnFPKrfoMB7gk6AziwhlGTJnAnmsKkKMRsjLFWoUwa6tiD2zFTTa4rLwpaaFuDVDUY7Exfawn49bIy46zixFZpVpdgG'),
('RM19', '-e998c38d75ed0c1e5e923453077b70fbdcf32aaa75725d5', 'FKFYHm3rrEkdoitil6kYY1wqmlNiNnpxF6sf7GYgbe36rFp7J0GQwFQMJ6LjSAKW1gMeanEiYle6OGu61d1SsmO7cJWhIqCkG4pfM6DFcQX0LtbdBoOblnrCnhITrtUw'),
('RM2', '-408d2715ab3553c5b30ddc8b2267182832f39c5d4bde5bd9', 'aueC7Tk1Sh5AiDD5L3FV40TOUGC3TnAGRhxmExXB9scHvIr5OfkyDoLmcNDAyvCrlhDcaadXgWJouZbJ9k3pRFpAHLwoPPqDbLFRJwAH5mpFjdpv4jmBOgo8vUJ1Zc0F'),
('RM20', '-72cf26306f248d29c18e0a361b1ab45f75d86574278f4fbf', '48VBKFkuG6QFDQdTbkeVzE39uF03E30FJk3DKDNHTzHQtkpwIaNjGqPUFDSe5qtfdm6eDc7kA2yTKN8A0kOnKr5RCh4xMUh2jwc7cLeDAHjM0OPGnPXl8fcv7SLEBpVD'),
('RM21', '-2daf495fbdb5a192c07d150dc0d40c89be3185f1a9cbd429', 'Rl7No1jda5yuD4RwTF1VbYaIFOZMFTgQOE8YF3407oVF3z1CFfFmlhLFSIs6vjO0Mxx1vm1OU4kJ4DFPchxYb4lG1hsS4CmRMLsFgL1UiVUCFb15hvEFz3ddLWxFpKGt'),
('RM22', '-51a8cfb25cde4b7eb51c2ead67454784fd45f16050313e96', 'LVJJ51fCuZJxptsuoSjZUnTVjIB8ot5W9hwPjXdMtbjFFOwyfWJA6iFMz9sUdxMG8IC8pftJPWCtAsDqImpCs2kINTkt0pUOMfowue1dFIlQPupNJGgWxbgj93ajHRlF'),
('RM23', '6d65e4eb2acd91f1e0124c9c383faf9fc5356552fa1d6a17', 'CdDk5eKFw4gp9CzEqYtbgjICZnmZBhVFCt8LL4W32vnUsxiJhOb7Fi4LF9o3Cv5FDlrxhyc7sNTFzxTbIfjzE5HCPF6lomCoGlSwAyg9ZB4biThQHQXYi94jlSuEChLF'),
('RM24', '-7d27bbe2d1c42af104d2820d235ae1c3888269501dddf2ba', 'kNFmYchRTGFPpymC3zbaoeTkqZp7lU8REugMPbhWV8ChFkfcls1V9T491BtepSEUj61FIbl8OMpP0VaVFyuamUnA8MtcEeIpdpjzFM0x2Wzhl6eYPdgtgFlQYoKn1i8M'),
('RM25', '7f68e0c6ab7959c3f836d6e396d9643850c2c0f85727d867', 'CqwUhJYm9MkAFFVcGa0aceLwRt88F4N3mMMF2H4ovW9BCJFsFsReCiCCRwNgB566fGcIUJeSytjYZFUgiu4r6RV0jNv4PETMpDmsOsQoAxfTG3LNCfJZEE1rmvaBmXmW'),
('RM3', '2694a5065e4ae525a9426fe46a3df9895d924e7873379ae3', '45LwZSvQTBFJ7Ds4XIFlqNIbzfLg3WNU4Zbhug8ddVD5FrIFFFrMFWbjdLBonBWTBsvFITGuuLjVgrKFc249ncy8d5wqcbV0Fhr5CvFiyKo6QjNplVT46zRjode73HcW'),
('RM4', '466ba11ee78aa39b8d4aae29a26627063edba0731af30047', 'TMjoGoTx0WZ0rSJOR2tB4n6rRvqyI2Dx1SAQKrJneAFGveOMPZwKVMrv0arEbF0haFNV0Or13unwXmFV0PvykET3o3F3XX8do6cpoHrzNVFSVgp4le2nqwoXH2JEhF81'),
('RM5', '781abd3f60ce18911a0bf3e090bab36c9d27508f6a777f29', '0VwaxAptMhUD33HyX9Nlk2LP0HUdo9pDobGFDmVAL4afnwuhatSUkooi7Yafx86IzQzUONtFHGFXqJuhIU9fhBGFFIzN3PwNsFFEM5BJk6kiLrhhapg2LGeb5rdHi6sZ'),
('RM6', '-67b119f0fd1f0158ee49acbab83e8b4ec297fff624e83ebd', 'MIINmYC81U0X7ac8zZtI0slNkr3cnFW1Iqb8PVBBu2XcpUO0LcyXTy0dL9pASSmdeyseZFXBevXjdJubMWOFatpEQZXRe6zgDbmht21bra4hSzifhdj3wAFFKgLvhFk2'),
('RM7', '50c6911204e3e85905d42de9192362cef910615b5ceeb1de', 'Sr5FH9uK3CAZ9uIfUkJ5cRBzoDWHfqwBH8HZ8p1CvGqfLUeZuX5PKOBfM80zU9V3Fde8cVSNJ2MgbzLIpzzZ7sRtZIzWiFHY48Ye47GEhGjwdLtSvyHFNA04HzFlmSNF'),
('RM8', '-76c2678d8bd9225e5b6050e9f9f2ae201b51158e7e2ec902', 'x7FCaBIufW0p9Xx91jFI6wPjnmOha7UJxQL8li3Fu3pzF8GONdpub5xB9Qek3wpZZEghBwWFKPejbMXm1EjAo2BzFpWWycmx1kKQVKVfJ8SgFJpw8AgLyugKLWRuD3wy'),
('RM9', '54bbf89b238700bfb60a763ff5679807be12198e8654022a', 'UyRJCFmRTBIuK4KV2JPizDD7MZLzpIQyYQd9bOVOfMhFr4PmNwrPjYK28cd3to1r0oo4zd9FhG8D8NPQjjRgjxEIYFoCJaIj9UricyW0kUOdydTfkfF1DZrBlRXzDKSY');

-- --------------------------------------------------------

--
-- Table structure for table `text_Register_time`
--

CREATE TABLE `text_Register_time` (
  `id` int(11) NOT NULL,
  `time` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `text_Register_time`
--

INSERT INTO `text_Register_time` (`id`, `time`) VALUES
(24, 50),
(25, 71),
(26, 47),
(27, 49),
(28, 72),
(29, 50),
(30, 49),
(31, 45),
(32, 52),
(33, 40),
(34, 56),
(35, 42),
(36, 45),
(37, 51),
(38, 67),
(39, 55),
(40, 68),
(41, 78),
(42, 40),
(44, 49),
(45, 57),
(46, 51),
(47, 42),
(48, 69),
(49, 50);

-- --------------------------------------------------------

--
-- Table structure for table `threed_password`
--

CREATE TABLE `threed_password` (
  `user_name` varchar(200) NOT NULL,
  `password` varchar(4000) NOT NULL,
  `salt` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `threed_password`
--

INSERT INTO `threed_password` (`user_name`, `password`, `salt`) VALUES
('RM1', '-54dc488b62da94dd26a09cd827093a849306758dc856d120', '2BORiu1banUm1LtxFR8oXu7gJ7fFRdP3N1MIQjGwCPBCx1oBQ2zSlMWxXBujv6pFuAM6k9LN328lBl0Gljidbc3XVjYk9c67PuTzQuaYeSQttpBHdnLyVHbQvMW7FH4b'),
('RM10', '7b46b2ef1dbe7db1ca1aa00333f281669b1476351717783e', 'vFjMn4ZTFjbgreAJTnEQBQuBgkUKqNicMBy4qaNFIh9m3AMFWLSlGg9PqttW3DRE3OUzYnbbahDXsT21KksGBvZDxlJBJ1hQmulzOcuFPzarg0rYIvdrfADo4nLBsz0x'),
('RM11', '-4ec559cc65a60d1e0fd68c84c4a06d1ab081021470699626', '6EnzdSOH12rpwQRBMtogNDJhCGM2IDpVIAuPbhCPNGetJn8VPFS87WrKkk7DjFgaxWzx1iyZboZhfQfqMX0F2NAK35ZZFLk0wz8yVgZn2UuALsEiKMtboxkME9sdDo4t'),
('RM12', '-6b585bf4c82781f00a38bd8acfdd59eb55b36575961925c5', '4LNjRbYdKUtSp4vd3VwLble0LAIPJQyFFWAeFfs1WJIDMfoZ5OaAjDaIqJvFYKCxRrpXQuqRzFr9Fmd3qzyi3zYxuTLeeg5kR75TUwo9fPXwozONQxia2Ij9WSZyYTzu'),
('RM13', '-f77463049350adcd96f9d98ffdf879c009aad91e9bade7f', 'auvqx8VBScmongCeN9XBx9nrKaroqXTPyFshkvPiZ3iyE922gkiS4XXeeet3R4chcJ8ftDhwR8EiXCaVMAqBqhCRNaCQ90IG0y7sqyl8h4oHNHCNHUmWAMRlfQuzkgyb'),
('RM14', '1d8a1768850efc1dcc3caaffaa17b9441dd442cee8c106d9', '1eO72kqgDpHBqKAg6rkuZIUj0lFhu63dHMB2hlpFyhl0WAvpxUatmP7aN7kFpuOeAPFCZaYX8OHYOB7w0UlW3G5pm5Qf9KrqrAFjhYJW0kyForenTMTw9As3u1Fpz0f9'),
('RM15', '11d31a666bcef2ad559282372c4e5b4570658879975c6c38', 'JMmUBl9pzir4OzKn8zFhWZfAFCvjVFmCBIcOHnEN372rjJx8FC3R0JOqkOKIaRqLP5bfKIghrH9qLv5P6i3ChRwse2FFIrNkEJi6IZ3bevdUWUecDGwJeKj2LHpaWaod'),
('RM16', '24db63cf231c42aef53586daededfe40a30fa4d5ebf3d4c4', 'viH6pxl45KuhDcTbJoHD1VY8OelfFzSFFt96gDhslpDgJhFgpItUu5ZwJwA9jkEmjmKfnAG0kToLaESRdHFKbxWrro2meuHX2mwlKFzAmUxwNUs34nGzDD54fGg9CLmZ'),
('RM17', '-5147ac19a00f8663157301453bdb6e3b626c0793a6697f11', '5C7ZKla0J3RMjJA43F3ps2hb45MeqQXYupeMLU8s5LxINEqvlf7f5FzBg8dd1yKlGZadgDFRhoHcwzxZrmKFOppjyHL7S0mYM2e6zj8Tv6KH6wnTJWTMIiYCvJvFgGlr'),
('RM18', '7045ba0fc51573b202e79f9a4487a36619a7236e87094788', 'XIDDpwPPVGEocOGrSuIzikjVgMvdITXKvT2IPFjjBjM44jyxbpxvDpilq8nfKdIp4FZcpDjdZBzKRAxemwwoUYnB576DiaPJNO7UFqmf5eDVXKOwExpZFE1CohKH9cww'),
('RM19', '5d87981f6d6014dc2d3b58eb61272e0652f146f3e67a4740', 'SFUE4sVM8B1xnkxSFKjTHG5rbrtVI4EcZhlnjXpmACug1u7IExOshuzKP5luSPwzP2bdbcmFJSn4WAEXR4pS5w0ssFDoFXBylGfSgRCGr5wGGOYi7o24qCrbvWkNP7qP'),
('RM2', '-5d3150582f6646dd7304d20b80a0c7ff60f262a19cc9e5d3', 'ks46Ltx08cbDC3fX7BLnZ2Fn3grRor7iA5ZWDv30MqWHLEz9ZIQN8HYo3YCCF7tYq8KqdfjRvxB3SoOsfzGMAIDQPD6d171SBqrpv2ryAjhKAHE351wGWllsBOYMMz2M'),
('RM20', '-729475a408fb6b70bc2747af8a4fb0570908f1569527cec7', 'F94b7dXJEyW6KabIFWpAle6Z476ua9AntaZ3uxabfKug2HQmGYBbnzRcUWo7GzFRKirVSkF7NIFGmd5umXL1wErF1n52ez6HqyFr5wxp5vIPZ31MlaiSNsqdyF0pELJ2'),
('RM3', '235d5eee5f8b0a47d084c3448f1c1a7ae15cbcaf5a4f2095', 'LcIYHHQp3TPLHD2PB1LVzGoUMiZh5kux28yEz2woQTVAgOhYcUipyz5G0LnslUAZjoqVgByz70E1NhXJIlMMFNCiJ8nmqFAd1nFDfWmUrkjaHnCfnS74AJ7UchlDRFNC'),
('RM4', '-66e20546c0d2d65441b2cf4934364faa13a7f7d02b13454a', 'FkQGwpt9p7FgDgGfnkLUSHFOfY3KlkLOWKzNUvnFBU7dyzXYniSrthpWF0EtuxTVH8hRB1TGLekvpcFrzyARSLXXYQYllBEZqIgpYqf6pjgw3FkNDaPM7EXn81VvV5yC'),
('RM5', '78a1443920790dfd6a9eddaf112b74687ea7aa1a2a2721ed', 'L5FtVcg3v3T4XCKcnuFeNNu2CqWCLACQ16mNC5UNVEGdTZJwDryq7TFREBtAiGWoGyaXsTh6hB95ZSCqFVSUOiZBBcvJQ8EyQxTIqSeuFrrrVRKfuZI4YZfFEi2Eyl19'),
('RM6', '-215301a780dc7102b4ebb3e5c903e3c519bd31f2ba593cfd', '1lEzXsLZFUVg7idrLP8N6CW0z710TegDqc7L21h0zC825wBFJt0cs9fBCT0qR3GfRHPX2xqYWnKGfBMMbgdOFqwfGuVWZsjLFifPKl9YFRGbxkLfWDFDshJIW2yiStMU'),
('RM7', '2068c1d321761f980cd37a90463c33ed4a5a9b3334a3f68e', 'n8ZiDxJ2csBSEiFeL0xKFIF9uD4P3DF9jsOdsFHBAFWcXJoxWlIEbrs7b1b0tXz0EXdQD92QFFHHtqVAmD3iXFufPbDmPgRezw3Ifekcggc4eWuFqhTtY2RsFw26VaW5'),
('RM8', '4e27d6a8927d10ad1434495a09c9ee0e8829f730cbbfd99d', 'Wvo0M4FL9oMtugtB7cai5NPqzRMDvqiKrAMeRs5VNmjLzFaaypvmSNNWAxjXKuO9ZDhGZXpw4yYxpnGpIDRDdAh09y1F1kC3bchrlWWaTajGGJ7sFRQZpd4FMAErXe3p'),
('RM9', '25e8b1a3fd94cf4c33d03405cc4d983e783eaf5654f4fe6b', 'ofLgc3WeqX3u8cmmcwHZa1q6iVeD985DcvAv0cQigEvlVNj3CLTRYFidSdMdja4vMBHYMxOxzvTPIIZKFHUUWCKhuT00jqNvDhSFEKBxr7rXGGFlvLyL8uJElWBY9hJA');

-- --------------------------------------------------------

--
-- Table structure for table `threed_password_login_time`
--

CREATE TABLE `threed_password_login_time` (
  `id` int(11) NOT NULL,
  `time` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `threed_password_login_time`
--

INSERT INTO `threed_password_login_time` (`id`, `time`) VALUES
(4, 41),
(5, 14),
(6, 21),
(7, 18),
(8, 12),
(9, 16),
(10, 11),
(11, 20),
(12, 17),
(13, 19),
(14, 10),
(15, 7),
(16, 11),
(17, 18),
(18, 16),
(19, 9),
(20, 14),
(21, 10),
(22, 23),
(23, 9);

-- --------------------------------------------------------

--
-- Table structure for table `threed_password_register_time`
--

CREATE TABLE `threed_password_register_time` (
  `id` int(11) NOT NULL,
  `time` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `threed_password_register_time`
--

INSERT INTO `threed_password_register_time` (`id`, `time`) VALUES
(2, 48),
(3, 57),
(4, 48),
(5, 51),
(6, 41),
(7, 245),
(8, 41),
(9, 49),
(10, 55),
(11, 37),
(12, 39),
(13, 40),
(14, 46),
(15, 44),
(16, 104),
(17, 39),
(18, 33),
(19, 50),
(20, 51),
(21, 46);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `DATABASECHANGELOGLOCK`
--
ALTER TABLE `DATABASECHANGELOGLOCK`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `graphical_login_time`
--
ALTER TABLE `graphical_login_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `graphical_password`
--
ALTER TABLE `graphical_password`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `graphical_register_time`
--
ALTER TABLE `graphical_register_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `text_login_time`
--
ALTER TABLE `text_login_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `text_password`
--
ALTER TABLE `text_password`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `text_Register_time`
--
ALTER TABLE `text_Register_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `threed_password`
--
ALTER TABLE `threed_password`
  ADD PRIMARY KEY (`user_name`);

--
-- Indexes for table `threed_password_login_time`
--
ALTER TABLE `threed_password_login_time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `threed_password_register_time`
--
ALTER TABLE `threed_password_register_time`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `graphical_login_time`
--
ALTER TABLE `graphical_login_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT for table `graphical_register_time`
--
ALTER TABLE `graphical_register_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `text_login_time`
--
ALTER TABLE `text_login_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `text_Register_time`
--
ALTER TABLE `text_Register_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT for table `threed_password_login_time`
--
ALTER TABLE `threed_password_login_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `threed_password_register_time`
--
ALTER TABLE `threed_password_register_time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
