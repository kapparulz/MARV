-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 18, 2013 at 12:50 AM
-- Server version: 5.5.29
-- PHP Version: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `marv`
--

-- --------------------------------------------------------

--
-- Table structure for table `auction_categories`
--

CREATE TABLE IF NOT EXISTS `auction_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `auction_categories`
--

INSERT INTO `auction_categories` (`id`, `parent_id`, `name`) VALUES
(1, NULL, 'Books'),
(2, 1, 'Programming'),
(3, 1, 'Graphical Design'),
(4, NULL, 'DVDs'),
(5, 4, 'Lectures'),
(6, 2, 'Java'),
(7, 2, 'C++');

-- --------------------------------------------------------

--
-- Table structure for table `auction_items`
--

CREATE TABLE IF NOT EXISTS `auction_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auction_category_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `start_price` decimal(10,2) NOT NULL,
  `byout_price` decimal(10,2) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `picture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_sold` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `auction_category_id` (`auction_category_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `auction_items`
--

INSERT INTO `auction_items` (`id`, `auction_category_id`, `user_id`, `name`, `description`, `start_price`, `byout_price`, `start_date`, `end_date`, `picture`, `is_sold`) VALUES
(1, 6, 1, 'Building Java Programs', NULL, 100.00, 200.00, '2013-04-16 00:00:00', '2013-04-23 00:00:00', NULL, 0),
(2, 7, 1, 'C++ Basics', NULL, 300.00, 500.00, '2013-04-16 00:00:00', '2013-04-23 00:00:00', NULL, 0),
(3, 6, 1, 'Advanced Java', 'Some short description of the Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book Some short description of the book ', 300.00, 500.00, '2013-04-16 00:00:00', '2013-04-30 00:00:00', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bids`
--

CREATE TABLE IF NOT EXISTS `bids` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auction_item_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `auction_item_id` (`auction_item_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `institutions`
--

CREATE TABLE IF NOT EXISTS `institutions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `institutions`
--

INSERT INTO `institutions` (`id`, `name`) VALUES
(1, 'KEA 2'),
(2, 'Test 7'),
(3, 'test test test'),
(5, 'avadfaf fdafa');

-- --------------------------------------------------------

--
-- Table structure for table `open_ids`
--

CREATE TABLE IF NOT EXISTS `open_ids` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `identifier` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `provider` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `identifier` (`identifier`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `open_ids`
--

INSERT INTO `open_ids` (`id`, `user_id`, `identifier`, `provider`) VALUES
(1, 1, '33', 'facebook'),
(2, 1, '35', 'linkedin'),
(3, 6, 'https://www.google.com/profiles/103380916811781997162', 'Google');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE IF NOT EXISTS `rooms` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` tinyint(2) NOT NULL DEFAULT '0',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `institution_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `institution_id` (`institution_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `type`, `email`, `phone`, `address`, `first_name`, `last_name`, `institution_id`) VALUES
(1, 'john', 'pass', 1, NULL, NULL, NULL, 'John', 'Blow', 1),
(2, 'brown', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'jack', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'Valerij Bancer', NULL, 2, '', NULL, NULL, 'Valerij', 'Bancer', NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auction_categories`
--
ALTER TABLE `auction_categories`
  ADD CONSTRAINT `auction_categories_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `auction_categories` (`id`);

--
-- Constraints for table `auction_items`
--
ALTER TABLE `auction_items`
  ADD CONSTRAINT `auction_items_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `auction_items_ibfk_3` FOREIGN KEY (`auction_category_id`) REFERENCES `auction_categories` (`id`);

--
-- Constraints for table `bids`
--
ALTER TABLE `bids`
  ADD CONSTRAINT `bids_ibfk_1` FOREIGN KEY (`auction_item_id`) REFERENCES `auction_items` (`id`),
  ADD CONSTRAINT `bids_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `open_ids`
--
ALTER TABLE `open_ids`
  ADD CONSTRAINT `open_ids_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`institution_id`) REFERENCES `institutions` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
