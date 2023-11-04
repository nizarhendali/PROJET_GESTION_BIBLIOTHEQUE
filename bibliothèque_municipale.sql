-- phpMyAdmin SQL Dump
-- version 3.3.9.2
-- http://www.phpmyadmin.net
--
-- Serveur: 127.0.0.1
-- Généré le : Mer 04 Janvier 2023 à 00:40
-- Version du serveur: 5.5.10
-- Version de PHP: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bibliothèque_municipale`
--

-- --------------------------------------------------------

--
-- Structure de la table `bibliothecaire`
--

CREATE TABLE IF NOT EXISTS `bibliothecaire` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(40) NOT NULL,
  `Prenom` varchar(40) NOT NULL,
  `motdepasse` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contenu de la table `bibliothecaire`
--

INSERT INTO `bibliothecaire` (`ID`, `Nom`, `Prenom`, `motdepasse`, `email`) VALUES
(1, 'Hendali', 'Nizar', '0000', 'hendali.fst@uhp.ac.ma'),
(2, 'Housni', 'Oussama', '9999', 'housni.fst@uhp.ac.ma'),
(3, 'Mounassif', 'fath', '3333', 'mounassif.fst@uhp.ac.ma');

-- --------------------------------------------------------

--
-- Structure de la table `disquecompact`
--

CREATE TABLE IF NOT EXISTS `disquecompact` (
  `idCD` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(40) NOT NULL,
  `nbrexemplaire` int(11) NOT NULL,
  `auteur` varchar(40) NOT NULL,
  `langue` varchar(40) NOT NULL,
  `datePub` varchar(40) NOT NULL,
  PRIMARY KEY (`idCD`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `disquecompact`
--

INSERT INTO `disquecompact` (`idCD`, `titre`, `nbrexemplaire`, `auteur`, `langue`, `datePub`) VALUES
(7, 'Fast and Furious', 6, '???', 'anglais', '2001-01-04');

-- --------------------------------------------------------

--
-- Structure de la table `exemplairecd`
--

CREATE TABLE IF NOT EXISTS `exemplairecd` (
  `idExemplaireCD` int(11) NOT NULL AUTO_INCREMENT,
  `idCD` int(11) NOT NULL,
  `statu` varchar(10) NOT NULL,
  PRIMARY KEY (`idExemplaireCD`),
  KEY `idCD` (`idCD`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=30 ;

--
-- Contenu de la table `exemplairecd`
--

INSERT INTO `exemplairecd` (`idExemplaireCD`, `idCD`, `statu`) VALUES
(24, 7, 'Dispo'),
(25, 7, 'Dipso'),
(26, 7, 'Dispo'),
(27, 7, 'Dispo'),
(28, 7, 'Dispo'),
(29, 7, 'Dispo');

-- --------------------------------------------------------

--
-- Structure de la table `exemplairelivre`
--

CREATE TABLE IF NOT EXISTS `exemplairelivre` (
  `idExemplaireL` int(11) NOT NULL AUTO_INCREMENT,
  `idLivres` int(11) NOT NULL,
  `statu` varchar(10) NOT NULL,
  PRIMARY KEY (`idExemplaireL`),
  KEY `fk_exemplaire_Livre` (`idLivres`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=172 ;

--
-- Contenu de la table `exemplairelivre`
--

INSERT INTO `exemplairelivre` (`idExemplaireL`, `idLivres`, `statu`) VALUES
(103, 13, 'Dispo'),
(104, 13, 'Dispo'),
(105, 13, 'Dispo'),
(106, 13, 'Dispo'),
(107, 13, 'Dispo'),
(108, 13, 'Dispo'),
(109, 13, 'Dispo'),
(110, 13, 'Dispo'),
(111, 13, 'Dispo'),
(112, 13, 'Dispo'),
(113, 13, 'Dispo'),
(114, 13, 'Dispo'),
(115, 13, 'Dispo'),
(116, 13, 'Dispo'),
(117, 13, 'Dispo'),
(118, 13, 'Dispo'),
(119, 13, 'Dispo'),
(120, 13, 'Dispo'),
(121, 13, 'Dispo'),
(122, 13, 'Dispo'),
(123, 13, 'Dispo'),
(124, 13, 'Dispo'),
(125, 13, 'Dispo'),
(126, 13, 'Dispo'),
(127, 13, 'Dispo'),
(128, 13, 'Dispo'),
(129, 13, 'Dispo'),
(130, 13, 'Dispo'),
(131, 13, 'Dispo'),
(132, 13, 'Dispo'),
(133, 13, 'Dispo'),
(134, 13, 'Dispo'),
(135, 13, 'Dispo'),
(136, 13, 'Dispo'),
(137, 13, 'Dispo'),
(138, 13, 'Dispo'),
(139, 13, 'Dispo'),
(140, 13, 'Dispo'),
(141, 13, 'Dispo'),
(142, 13, 'Dispo'),
(143, 13, 'Dispo'),
(144, 13, 'Dispo'),
(145, 13, 'Dispo'),
(146, 13, 'Dispo'),
(147, 13, 'Dispo'),
(148, 13, 'Dispo'),
(149, 13, 'Dispo'),
(150, 13, 'Dispo'),
(151, 13, 'Dispo'),
(152, 13, 'Dispo'),
(153, 13, 'Dispo'),
(154, 13, 'Dispo'),
(155, 13, 'Dispo'),
(156, 13, 'Dispo'),
(157, 13, 'Dispo'),
(158, 13, 'Dispo'),
(159, 13, 'Dispo'),
(160, 13, 'Dispo'),
(161, 13, 'Dispo'),
(162, 13, 'Dispo'),
(163, 13, 'Dispo'),
(164, 13, 'Dispo'),
(165, 14, 'Dispo'),
(166, 14, 'Dispo'),
(167, 14, 'Dispo'),
(168, 14, 'Dispo'),
(169, 14, 'Dispo'),
(170, 14, 'Dispo'),
(171, 14, 'Dispo');

-- --------------------------------------------------------

--
-- Structure de la table `exemplaireperiodiquesj`
--

CREATE TABLE IF NOT EXISTS `exemplaireperiodiquesj` (
  `idExemplaireP` int(11) NOT NULL AUTO_INCREMENT,
  `idp` int(11) NOT NULL,
  `statu` varchar(40) NOT NULL,
  PRIMARY KEY (`idExemplaireP`),
  KEY `fk_exemplaire_PeriodiqueJ` (`idp`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=38 ;

--
-- Contenu de la table `exemplaireperiodiquesj`
--

INSERT INTO `exemplaireperiodiquesj` (`idExemplaireP`, `idp`, `statu`) VALUES
(27, 8, 'Dispo'),
(28, 8, 'Dispo'),
(29, 8, 'Dispo'),
(30, 8, 'Dispo'),
(31, 8, 'Dispo'),
(32, 8, 'Dispo'),
(33, 9, 'Dispo'),
(34, 9, 'Dispo'),
(35, 9, 'Dispo'),
(36, 9, 'Dispo'),
(37, 9, 'Dispo');

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

CREATE TABLE IF NOT EXISTS `livres` (
  `idLivres` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(40) NOT NULL,
  `auteur` varchar(40) NOT NULL,
  `categorie` varchar(40) NOT NULL,
  `nbrExemplaire` int(11) NOT NULL,
  PRIMARY KEY (`idLivres`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `livres`
--

INSERT INTO `livres` (`idLivres`, `titre`, `auteur`, `categorie`, `nbrExemplaire`) VALUES
(13, 'Antigone', 'xxx', 'WWWWWWWwwww ', 2),
(14, '11111', '1111', '11111', 7);

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

CREATE TABLE IF NOT EXISTS `membre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `tel` varchar(40) NOT NULL,
  `ville` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `isResidant` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `membre`
--

INSERT INTO `membre` (`ID`, `nom`, `prenom`, `tel`, `ville`, `email`, `isResidant`) VALUES
(9, 'housni', 'oussama', '0694712851', 'Settat', 'housni@gmail.com', 1),
(10, 'hendali', 'nizar', '094095248', 'casablanca', 'hendali@gmail.com', 0);

-- --------------------------------------------------------

--
-- Structure de la table `membrereservecd`
--

CREATE TABLE IF NOT EXISTS `membrereservecd` (
  `IDR` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `idCD` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `dateNotification` int(11) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  PRIMARY KEY (`IDR`),
  KEY `idExemplaireCD` (`idCD`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `membrereservecd`
--


-- --------------------------------------------------------

--
-- Structure de la table `memempruntcd`
--

CREATE TABLE IF NOT EXISTS `memempruntcd` (
  `idEmpruntCD` int(11) NOT NULL AUTO_INCREMENT,
  `idExemplaireCD` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `Duree` int(40) NOT NULL,
  PRIMARY KEY (`idEmpruntCD`),
  KEY `memempruntcd_ibfk_1` (`ID`),
  KEY `memempruntcd_ibfk_2` (`idExemplaireCD`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `memempruntcd`
--

INSERT INTO `memempruntcd` (`idEmpruntCD`, `idExemplaireCD`, `ID`, `dateEmprunt`, `dateRetour`, `type`, `Duree`) VALUES
(6, 24, 9, '2023-01-03 17:55:30', '2023-01-03 19:02:37', 'Location', 9),
(7, 26, 9, '2023-01-03 17:56:15', '2023-01-03 19:02:33', 'Location', 8),
(8, 27, 9, '2023-01-03 17:56:27', '2023-01-03 19:02:28', 'Location', 8),
(9, 26, 9, '2023-01-03 18:16:27', '2023-01-03 19:16:29', 'Location', 8),
(10, 26, 9, '2023-01-03 18:16:58', '2023-01-03 19:17:16', 'Location', 8);

-- --------------------------------------------------------

--
-- Structure de la table `memempruntl`
--

CREATE TABLE IF NOT EXISTS `memempruntl` (
  `IdEmpruntL` int(11) NOT NULL AUTO_INCREMENT,
  `idExemplaireL` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `Duree` int(40) NOT NULL,
  UNIQUE KEY `IdEmpruntL` (`IdEmpruntL`),
  KEY `memempruntl_ibfk_1` (`idExemplaireL`),
  KEY `memempruntl_ibfk_2` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=30 ;

--
-- Contenu de la table `memempruntl`
--

INSERT INTO `memempruntl` (`IdEmpruntL`, `idExemplaireL`, `ID`, `dateEmprunt`, `dateRetour`, `type`, `Duree`) VALUES
(20, 103, 9, '2022-12-01 02:55:58', '2023-01-03 22:46:21', 'Location', 7),
(26, 103, 9, '2023-01-03 17:02:10', '2023-01-03 22:46:21', 'pret', 4);

-- --------------------------------------------------------

--
-- Structure de la table `memempruntp`
--

CREATE TABLE IF NOT EXISTS `memempruntp` (
  `IDEmpruntP` int(11) NOT NULL AUTO_INCREMENT,
  `idExemolaireP` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `Duree` int(40) NOT NULL,
  PRIMARY KEY (`IDEmpruntP`),
  KEY `memempruntp_ibfk_1` (`idExemolaireP`),
  KEY `memempruntp_ibfk_2` (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `memempruntp`
--

INSERT INTO `memempruntp` (`IDEmpruntP`, `idExemolaireP`, `ID`, `dateEmprunt`, `dateRetour`, `type`, `Duree`) VALUES
(8, 32, 12, '2023-01-03 18:01:38', '2023-01-03 19:14:11', 'Consultation sur place', 0),
(7, 31, 5, '2023-01-03 04:58:27', '2023-01-03 19:14:14', 'Location', 5),
(9, 31, 12, '2023-01-03 18:02:11', '2023-01-03 19:14:08', 'Consultation sur place', 0),
(10, 31, 12, '2023-01-03 18:17:23', '2023-01-03 19:17:27', 'Consultation sur place', 0);

-- --------------------------------------------------------

--
-- Structure de la table `memreservel`
--

CREATE TABLE IF NOT EXISTS `memreservel` (
  `IDR` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `idLivres` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `dateNotification` datetime DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  UNIQUE KEY `IDR` (`IDR`),
  KEY `memreservel_ibfk_2` (`ID`),
  KEY `memreservel_ibfk_3` (`idLivres`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=18 ;

--
-- Contenu de la table `memreservel`
--

INSERT INTO `memreservel` (`IDR`, `ID`, `idLivres`, `Date`, `dateNotification`, `titre`) VALUES
(14, 9, 13, '2023-01-03 12:14:29', NULL, 'xxxxx');

-- --------------------------------------------------------

--
-- Structure de la table `nmembre`
--

CREATE TABLE IF NOT EXISTS `nmembre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `tel` varchar(40) NOT NULL,
  `ville` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `nmembre`
--

INSERT INTO `nmembre` (`ID`, `nom`, `prenom`, `tel`, `ville`, `email`) VALUES
(3, 'MRx', 'XXX', '06984987', 'XVI', 'MRX@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `nmembrereservecd`
--

CREATE TABLE IF NOT EXISTS `nmembrereservecd` (
  `IDR` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `idCD` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `dateNotification` int(11) DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  PRIMARY KEY (`IDR`),
  KEY `idExemplaireCD` (`idCD`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `nmembrereservecd`
--

INSERT INTO `nmembrereservecd` (`IDR`, `ID`, `idCD`, `Date`, `dateNotification`, `titre`) VALUES
(10, 5, 7, '2023-01-03 13:26:32', NULL, 'YYYY');

-- --------------------------------------------------------

--
-- Structure de la table `nmemempruntcd`
--

CREATE TABLE IF NOT EXISTS `nmemempruntcd` (
  `idEmpruntCD` int(11) NOT NULL AUTO_INCREMENT,
  `idExemplaireCD` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `Duree` int(40) NOT NULL,
  PRIMARY KEY (`idEmpruntCD`),
  KEY `nmemempruntcd_ibfk_2` (`idExemplaireCD`),
  KEY `nmemempruntcd_ibfk_3` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `nmemempruntcd`
--

INSERT INTO `nmemempruntcd` (`idEmpruntCD`, `idExemplaireCD`, `ID`, `dateEmprunt`, `dateRetour`, `type`, `Duree`) VALUES
(8, 24, 3, '2023-01-03 18:15:34', '2023-01-03 19:15:37', 'Location', 4),
(9, 24, 3, '2023-01-03 18:17:45', '2023-01-03 19:17:47', 'Location', 4);

-- --------------------------------------------------------

--
-- Structure de la table `nmemempruntl`
--

CREATE TABLE IF NOT EXISTS `nmemempruntl` (
  `idEmpruntL` int(11) NOT NULL AUTO_INCREMENT,
  `idExemplaireL` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `duree` int(10) NOT NULL,
  PRIMARY KEY (`idEmpruntL`),
  KEY `nmemempruntl_ibfk_1` (`ID`),
  KEY `nmemempruntl_ibfk_2` (`idExemplaireL`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `nmemempruntl`
--


-- --------------------------------------------------------

--
-- Structure de la table `nmemempruntp`
--

CREATE TABLE IF NOT EXISTS `nmemempruntp` (
  `idEmpruntP` int(11) NOT NULL AUTO_INCREMENT,
  `idExemplaireP` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dateEmprunt` datetime NOT NULL,
  `dateRetour` datetime DEFAULT NULL,
  `type` varchar(40) NOT NULL,
  `duree` int(40) NOT NULL,
  PRIMARY KEY (`idEmpruntP`),
  KEY `nmemempruntp_ibfk_1` (`idExemplaireP`),
  KEY `nmemempruntp_ibfk_2` (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=13 ;

--
-- Contenu de la table `nmemempruntp`
--

INSERT INTO `nmemempruntp` (`idEmpruntP`, `idExemplaireP`, `ID`, `dateEmprunt`, `dateRetour`, `type`, `duree`) VALUES
(11, 27, 3, '2023-01-03 18:08:48', '2023-01-03 19:14:59', 'Consumtation sur place', 0),
(12, 27, 3, '2023-01-03 18:17:53', '2023-01-03 19:17:57', 'Consumtation sur place', 0);

-- --------------------------------------------------------

--
-- Structure de la table `nmemreservel`
--

CREATE TABLE IF NOT EXISTS `nmemreservel` (
  `IDR` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `idLivres` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `dateNotification` datetime DEFAULT NULL,
  `titre` varchar(255) NOT NULL,
  PRIMARY KEY (`IDR`),
  KEY `nmemreservel_ibfk_2` (`ID`),
  KEY `nmemreservel_ibfk_3` (`idLivres`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `nmemreservel`
--


-- --------------------------------------------------------

--
-- Structure de la table `periodiquesjournaux`
--

CREATE TABLE IF NOT EXISTS `periodiquesjournaux` (
  `idp` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(40) NOT NULL,
  `DateEdition` date NOT NULL,
  `periodicite` varchar(40) NOT NULL,
  `nbrExemplaire` int(11) NOT NULL,
  PRIMARY KEY (`idp`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `periodiquesjournaux`
--

INSERT INTO `periodiquesjournaux` (`idp`, `titre`, `DateEdition`, `periodicite`, `nbrExemplaire`) VALUES
(8, 'QQQ', '2023-01-18', 'QQQQQ', 0),
(9, 'AAAAAAAAAAA', '2023-01-11', 'AAAAAAAAAAA', 5);
