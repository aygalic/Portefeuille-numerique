-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 19 Mai 2016 à 18:19
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `tpemploye`
--

-- --------------------------------------------------------

--
-- Structure de la table `manutarisque`
--

CREATE TABLE IF NOT EXISTS `manutarisque` (
  `idmanutarisque` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `nbheure` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmanutarisque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `manutentionnaire`
--

CREATE TABLE IF NOT EXISTS `manutentionnaire` (
  `idmanutentionnaire` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `nbheure` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmanutentionnaire`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `representant`
--

CREATE TABLE IF NOT EXISTS `representant` (
  `idrepresentant` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `chiffreaffaire` float DEFAULT NULL,
  `POURCENT_REPRESENTANT` float DEFAULT NULL,
  `BONUS_REPRESENTANT` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrepresentant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `techarisque`
--

CREATE TABLE IF NOT EXISTS `techarisque` (
  `idtecharisque` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `nbunite` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtecharisque`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `technicien`
--

CREATE TABLE IF NOT EXISTS `technicien` (
  `idtechnicien` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `nbunite` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtechnicien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

CREATE TABLE IF NOT EXISTS `vendeur` (
  `idvendeur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dateEmbauche` date DEFAULT NULL,
  `chiffreaffaire` double DEFAULT NULL,
  `POURCENT_VENDEUR` double DEFAULT NULL,
  `BONUS_VENDEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`idvendeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
