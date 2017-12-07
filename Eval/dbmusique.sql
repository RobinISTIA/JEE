-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 31 Août 2016 à 14:26
-- Version du serveur :  5.6.25-log
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `dbpam`
--
CREATE DATABASE IF NOT EXISTS `dbmusique` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbmusique`;

-- --------------------------------------------------------

--
-- Structure de la table `albums`
--

CREATE TABLE IF NOT EXISTS `albums` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITRE` varchar(50) NOT NULL,
  `NBTRACKS` int(11) NOT NULL,
  `ANNEE` int(11) NOT NULL,
  `PRIX` double NOT NULL,
  `VERSION` int(11) NOT NULL,
  `AUTEUR_ID` bigint(20) NOT NULL,  
  PRIMARY KEY (`ID`),
  KEY `FK_7xa7rdyjqxrbvew7n6f83ey5h` (`AUTEUR_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `albums`
--

INSERT INTO `albums` (`ID`, `TITRE`, `NBTRACKS`, `ANNEE`,`PRIX`, `VERSION`,`AUTEUR_ID`) VALUES
(1, 'No. 2', 12, 1965, 18, 1,1),
(2, 'Exile on Main St.', 18, 1972 , 20, 1, 1),
(3, 'By the Way', 16, 2002 , 25, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `auteurs`
--

CREATE TABLE IF NOT EXISTS `auteurs` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(50) NOT NULL,
  `PAYS` varchar(5) NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `employes`
--
INSERT INTO `auteurs` (`ID`, `NOM`, `PAYS`, `VERSION`) VALUES
(1, 'Rolling Stones', 'UK', 1),
(2, 'Red Hot Chili Peppers', 'USA', 1);


-- --------------------------------------------------------

--
-- Contraintes pour les tables exportées
--

-- Contraintes pour la table `albums`
--
ALTER TABLE `albums`
ADD CONSTRAINT `FK_7xa7rdyjqxrbvew7n6f83ey5h` FOREIGN KEY (`AUTEUR_ID`) REFERENCES `auteurs` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
