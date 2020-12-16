-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2020 at 09:07 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL,
  `categoryTitle` varchar(300) NOT NULL,
  `categoryDescription` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`categoryId`, `categoryTitle`, `categoryDescription`) VALUES
(1, 'Moblie', 'Contain mobiles'),
(2, 'Laptop', 'Contain laptop'),
(3, 'Sports', 'Contain sport item'),
(4, 'cloths', 'contain cloth');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productId` int(11) NOT NULL,
  `productCategory` varchar(300) NOT NULL,
  `productTitle` varchar(300) NOT NULL,
  `productPrice` varchar(300) NOT NULL,
  `productQuantity` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productId`, `productCategory`, `productTitle`, `productPrice`, `productQuantity`) VALUES
(9, 'mobile', 'Iphone 11 pro max', '150000', '3'),
(10, 'mobile', 'xaomi note 11 pro', '30000', '4'),
(11, 'mobile', 'one plus ', '36000', '2'),
(12, 'laptop', 'asus vivo book-531', '73000', '6'),
(13, 'laptop', 'HP 15S-du 1013', '70000', '3'),
(14, 'sport', 'Ball boom-boom', '120', '40'),
(15, 'cloths', 'jeans denim', '1000', '35'),
(16, 'cloths', 'tshirt polo', '500', '25'),
(17, 'desktop', 'Dell core-i3 8th gen', '50000', '2'),
(18, 'car', 'bmw', '2000', '2'),
(19, 'bike', 'fzsv-3', '210000', '2'),
(20, 'book', 'math', '200', '10'),
(21, 'book', 'physics part2', '350', '5'),
(22, 'mobile', 'realmex', '18000', '4'),
(23, 'mobile', 'realme x2', '22000', '7');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `firstName`, `lastName`, `userEmail`, `userName`, `userPassword`) VALUES
(11, 'Arifuzzaman ', 'Nishan', 'arifuzzamannishan@gmail.com', 'Anishan', '78789899'),
(12, 'a', 'nishan', 'aanishan', 'nishu', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD UNIQUE KEY `categoryId` (`categoryId`),
  ADD UNIQUE KEY `categoryTitle` (`categoryTitle`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD UNIQUE KEY `productId` (`productId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `UK_user` (`userEmail`,`userName`,`userPassword`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
