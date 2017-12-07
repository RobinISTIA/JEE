-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 24 Août 2016 à 16:58
-- Version du serveur :  5.6.25-log
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `dbrdvmedecins`
--
CREATE DATABASE IF NOT EXISTS `dbrdvmedecins` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbrdvmedecins`;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITRE` varchar(5) COLLATE utf8_general_ci NOT NULL,
  `NOM` varchar(30) COLLATE utf8_general_ci NOT NULL,
  `VERSION` int(11) NOT NULL,
  `PRENOM` varchar(30) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`ID`, `TITRE`, `NOM`, `VERSION`, `PRENOM`) VALUES
(1, 'Mr', 'MARTIN', 1, 'Jules'),
(2, 'Mme', 'GERMAN', 1, 'Christine'),
(3, 'Mr', 'JACQUARD', 1, 'Jules'),
(4, 'Melle', 'BISTROU', 1, 'Brigitte'),
(5, 'Mr', 'DURAND', 1, 'Thomas');

-- --------------------------------------------------------

--
-- Structure de la table `creneaux`
--

CREATE TABLE IF NOT EXISTS `creneaux` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MDEBUT` int(11) NOT NULL,
  `HFIN` int(11) NOT NULL,
  `HDEBUT` int(11) NOT NULL,
  `MFIN` int(11) NOT NULL,
  `VERSION` int(11) NOT NULL,
  `ID_MEDECIN` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CRENEAUX_ID_MEDECIN` (`ID_MEDECIN`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=47 ;

--
-- Contenu de la table `creneaux`
--

INSERT INTO `creneaux` (`ID`, `MDEBUT`, `HFIN`, `HDEBUT`, `MFIN`, `VERSION`, `ID_MEDECIN`) VALUES
(1, 0, 8, 8, 20, 1, 1),
(2, 20, 8, 8, 40, 1, 1),
(3, 40, 9, 8, 0, 1, 1),
(4, 0, 9, 9, 20, 1, 1),
(5, 20, 9, 9, 40, 1, 1),
(6, 40, 10, 9, 0, 1, 1),
(7, 0, 10, 10, 20, 1, 1),
(8, 20, 10, 10, 40, 1, 1),
(9, 40, 11, 10, 0, 1, 1),
(10, 0, 11, 11, 20, 1, 1),
(11, 20, 11, 11, 40, 1, 1),
(12, 40, 12, 11, 0, 1, 1),
(13, 0, 14, 14, 20, 1, 1),
(14, 20, 14, 14, 40, 1, 1),
(15, 40, 15, 14, 0, 1, 1),
(16, 0, 15, 15, 20, 1, 1),
(17, 20, 15, 15, 40, 1, 1),
(18, 40, 16, 15, 0, 1, 1),
(19, 0, 16, 16, 20, 1, 1),
(20, 20, 16, 16, 40, 1, 1),
(21, 40, 17, 16, 0, 1, 1),
(22, 0, 17, 17, 20, 1, 1),
(23, 20, 17, 17, 40, 1, 1),
(24, 40, 18, 17, 0, 1, 1),
(25, 0, 8, 8, 20, 1, 2),
(26, 20, 8, 8, 40, 1, 2),
(27, 40, 9, 8, 0, 1, 2),
(28, 0, 9, 9, 20, 1, 2),
(29, 20, 9, 9, 40, 1, 2),
(30, 40, 10, 9, 0, 1, 2),
(31, 0, 10, 10, 20, 1, 2),
(32, 20, 10, 10, 40, 1, 2),
(33, 40, 11, 10, 0, 1, 2),
(34, 0, 11, 11, 20, 1, 2),
(35, 20, 11, 11, 40, 1, 2),
(36, 40, 12, 11, 0, 1, 2),
(37, 0, 8, 8, 20, 1, 3),
(38, 20, 8, 8, 40, 1, 3),
(39, 40, 9, 8, 0, 1, 3),
(40, 0, 9, 9, 20, 1, 3),
(41, 20, 9, 9, 40, 1, 3),
(42, 40, 10, 9, 0, 1, 3),
(43, 0, 10, 10, 20, 1, 3),
(44, 20, 10, 10, 40, 1, 3),
(45, 40, 11, 10, 0, 1, 3),
(46, 0, 11, 11, 20, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `medecins`
--

CREATE TABLE IF NOT EXISTS `medecins` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITRE` varchar(5) COLLATE utf8_general_ci NOT NULL,
  `NOM` varchar(30) COLLATE utf8_general_ci NOT NULL,
  `VERSION` int(11) NOT NULL,
  `PRENOM` varchar(30) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `medecins`
--

INSERT INTO `medecins` (`ID`, `TITRE`, `NOM`, `VERSION`, `PRENOM`) VALUES
(1, 'Mme', 'PELISSIER', 1, 'Marie'),
(2, 'Mr', 'BROMARD', 1, 'Jacques'),
(3, 'Mr', 'JANDOT', 1, 'Philippe'),
(4, 'Melle', 'JACQUEMOT', 1, 'Justine');

-- --------------------------------------------------------

--
-- Structure de la table `rv`
--

CREATE TABLE IF NOT EXISTS `rv` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JOUR` date NOT NULL,
  `ID_CLIENT` bigint(20) NOT NULL,
  `ID_CRENEAU` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ1_RV` (`JOUR`,`ID_CRENEAU`),
  KEY `FK_RV_ID_CRENEAU` (`ID_CRENEAU`),
  KEY `FK_RV_ID_CLIENT` (`ID_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `creneaux`
--
ALTER TABLE `creneaux`
  ADD CONSTRAINT `FK_CRENEAUX_ID_MEDECIN` FOREIGN KEY (`ID_MEDECIN`) REFERENCES `medecins` (`ID`);

--
-- Contraintes pour la table `rv`
--
ALTER TABLE `rv`
  ADD CONSTRAINT `FK_RV_ID_CLIENT` FOREIGN KEY (`ID_CLIENT`) REFERENCES `clients` (`ID`),
  ADD CONSTRAINT `FK_RV_ID_CRENEAU` FOREIGN KEY (`ID_CRENEAU`) REFERENCES `creneaux` (`ID`);


INSERT INTO `rv` (`ID`, `JOUR`, `ID_CLIENT`, `ID_CRENEAU`) VALUES
(1, '2006-08-22', 2, 1),
(2, '2006-08-23', 4, 20),
(3, '2006-09-10', 2, 10),
(4, '2006-08-23', 3, 7),
(5, '2006-08-23', 2, 10),
(6, '2006-08-23', 1, 28);
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
