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
CREATE DATABASE IF NOT EXISTS `dbpam` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `dbpam`;

-- --------------------------------------------------------

--
-- Structure de la table `cotisations`
--

CREATE TABLE IF NOT EXISTS `cotisations` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CSGD` double NOT NULL,
  `CSGRDS` double NOT NULL,
  `RETRAITE` double NOT NULL,
  `SECU` double NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `cotisations`
--

INSERT INTO `cotisations` (`ID`, `CSGD`, `CSGRDS`, `RETRAITE`, `SECU`, `VERSION`) VALUES
(1, 6.15, 3.49, 7.88, 9.39, 1);

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE IF NOT EXISTS `employes` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADRESSE` varchar(50) NOT NULL,
  `CP` varchar(5) NOT NULL,
  `NOM` varchar(30) NOT NULL,
  `PRENOM` varchar(30) NOT NULL,
  `SS` varchar(15) NOT NULL,
  `VERSION` int(11) NOT NULL,
  `VILLE` varchar(20) NOT NULL,
  `INDEMNITE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_16wn4skb85wj4gssjesdsgjil` (`SS`),
  KEY `FK_7xa7rdyjqxrbvew7n6f83ey5h` (`INDEMNITE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `employes`
--

INSERT INTO `employes` (`ID`, `ADRESSE`, `CP`, `NOM`, `PRENOM`, `SS`, `VERSION`, `VILLE`, `INDEMNITE_ID`) VALUES
(1, '5 rue des oiseaux', '49203', 'Jouveinal', 'Marie', '254104940426058', 1, 'St Corentin', 2),
(2, 'La brûlerie', '49014', 'Laverti', 'Justine', '260124402111742', 1, 'St Marcel', 1);

-- --------------------------------------------------------

--
-- Structure de la table `indemnites`
--

CREATE TABLE IF NOT EXISTS `indemnites` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BASE_HEURE` double NOT NULL,
  `ENTRETIEN_JOUR` double NOT NULL,
  `INDEMNITES_CP` double NOT NULL,
  `INDICE` int(11) NOT NULL,
  `REPAS_JOUR` double NOT NULL,
  `VERSION` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_2u3layl1g058ptk6r2p77rwwy` (`INDICE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `indemnites`
--

INSERT INTO `indemnites` (`ID`, `BASE_HEURE`, `ENTRETIEN_JOUR`, `INDEMNITES_CP`, `INDICE`, `REPAS_JOUR`, `VERSION`) VALUES
(1, 1.93, 2, 12, 1, 3, 1),
(2, 2.1, 2.1, 15, 2, 3.1, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `employes`
--
ALTER TABLE `employes`
  ADD CONSTRAINT `FK_7xa7rdyjqxrbvew7n6f83ey5h` FOREIGN KEY (`INDEMNITE_ID`) REFERENCES `indemnites` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
