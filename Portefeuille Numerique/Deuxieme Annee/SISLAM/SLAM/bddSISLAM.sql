CREATE TABLE privilege
(
	id_privilege INT NOT NULL AUTO_INCREMENT,
	libelle_privilege VARCHAR(25),
	PRIMARY KEY(id_privilege)
);

INSERT INTO privilege(libelle_privilege) VALUES("SuperAdmin"), ("Admin"), ("Dirigeant"), ("Tresorerier"), ("Visiteur");

CREATE TABLE utilisateurs
(
	id_utilisateur INT NOT NULL AUTO_INCREMENT,
	login_utilisateur VARCHAR(25) UNIQUE,
	password_utilisateur VARCHAR(25),
	mail_utilisateur VARCHAR(25),
	id_privilege INT,
	PRIMARY KEY(id_utilisateur),
	FOREIGN KEY(id_privilege) REFERENCES privilege(id_privilege)
);

INSERT INTO utilisateurs(login_utilisateur, password_utilisateur, mail_utilisateur, id_privilege) VALUES('bolobo', 'azerty', 'yolo@gmail.com', 1);

CREATE TABLE personne
(
	id_personne INT NOT NULL AUTO_INCREMENT,
	nom_personne VARCHAR(25),
	prenom_personne VARCHAR(25),
	telPortable_personne INT(10),
	telFixe_personne INT(10),
	adresse_personne VARCHAR(25),
	ville_personne VARCHAR(25),
	codePostale_personne INT(5),
	PRIMARY KEY(id_personne)
);

INSERT INTO personne(nom_personne, prenom_personne, telPortable_personne, telFixe_personne, adresse_personne, ville_personne, codePostale_personne)
VALUES('gérard', 'françois', '0677889933', '0199332277', 'IDK dude...', 'besanson', 15100),
('alfreda', 'françoise', '0612778899', '0199332277', 'LOL', 'bertrocourt', 14000),
('bondour', 'aureboir', '0612778899', '0199332277', 'MDR', 'salomon', 15000),
('bondour', 'aureboir', '0612778899', '0199332277', 'MDR', 'salomon', 15000),
('bondour', 'aureboir', '0612778899', '0199332277', 'MDR', 'salomon', 15000),
('bondour', 'aureboir', '0612778899', '0199332277', 'MDR', 'salomon', 15000);

CREATE TABLE pere
(
	id_pere INT NOT NULL AUTO_INCREMENT,
	id_personne INT,
	PRIMARY KEY(id_pere),
	FOREIGN KEY(id_personne) REFERENCES personne(id_personne)
);

INSERT INTO pere(id_personne) VALUES(1), (4);

CREATE TABLE mere
(
	id_mere INT NOT NULL AUTO_INCREMENT,
	id_personne INT,
	PRIMARY KEY(id_mere),
	FOREIGN KEY(id_personne) REFERENCES personne(id_personne)
);

INSERT INTO mere(id_personne) VALUES(2), (5);

CREATE TABLE joueur
(
	id_joueur INT NOT NULL AUTO_INCREMENT,
	mail1_joueur VARCHAR(25),
	mail2_joueur VARCHAR(25),
	id_pere INT,
	id_mere INT,
	id_personne INT,
	PRIMARY KEY(id_joueur),
	FOREIGN KEY(id_pere) REFERENCES pere(id_pere),
	FOREIGN KEY(id_mere) REFERENCES mere(id_mere),
	FOREIGN KEY(id_personne) REFERENCES personne(id_personne)
);

INSERT INTO joueur(mail1_joueur, mail2_joueur, id_pere, id_mere, id_personne) VALUES('yonocé@hotmail.fr', 'nothing@yahoo.fr', 1, 1, 3),
('fjeizofjez@ze.pe', 'fjizeo@pa.me', 2, 2, 6);

CREATE TABLE etatFinancier
(
	id_etatFinancier INT NOT NULL AUTO_INCREMENT,
	sommeAPayer_payement INT,
	sommePayer_payement INT,
	paiementComplet_payement INT(1),
	PRIMARY KEY(id_etatFinancier)
);

INSERT INTO etatFinancier(sommeAPayer_payement, sommePayer_payement, paiementComplet_payement) VALUES(1000, 0, 0);

CREATE TABLE payement
(
	id_payement INT NOT NULL AUTO_INCREMENT,
	noteFinanciere_payement VARCHAR(25),
	demandeAttFinancier_payement VARCHAR(25),
	demandeDeCotiFinancier_payement VARCHAR(25),
	numChequeFinancier_payement VARCHAR(25),
	depotBanque_payement VARCHAR(25),
	PRIMARY KEY(id_payement)
);

INSERT INTO payement(noteFinanciere_payement, demandeAttFinancier_payement, demandeDeCotiFinancier_payement, numChequeFinancier_payement, depotBanque_payement)
VALUES ("c'est noté", "oui", "oui", "124839", "oui");

CREATE TABLE avoir
(
	id_avoir INT NOT NULL AUTO_INCREMENT,
	id_etatFinancier INT,
	id_payement INT,
	PRIMARY KEY(id_avoir),
	FOREIGN KEY(id_etatFinancier) REFERENCES etatFinancier(id_etatFinancier),
	FOREIGN KEY(id_payement) REFERENCES payement(id_payement)
);

INSERT INTO avoir(id_etatFinancier, id_payement) VALUES(1, 1);

CREATE TABLE licence
(
	id_licence INT NOT NULL AUTO_INCREMENT,
	notes_licence VARCHAR(25),
	date_licence DATE,
	cat_licence VARCHAR(25),
	dirigeant_licence VARCHAR(50),
	inscrisNewLetter_licence INT,
	licenceDistrictDispo_licence INT,
	formation_licence VARCHAR(25),
	renouv_licence VARCHAR(25),
	id_joueur INT,
	PRIMARY KEY(id_licence),
	FOREIGN KEY(id_joueur) REFERENCES joueur(id_joueur)
);

INSERT INTO licence(notes_licence, date_licence, cat_licence, dirigeant_licence, inscrisNewLetter_licence, licenceDistrictDispo_licence,
formation_licence, renouv_licence, id_joueur)
VALUES("OK", "2005-02-01", "JUNIOR", "gerar", 1, 100, "oui", "non", 1);

CREATE TABLE photo
(
	id_photo INT NOT NULL AUTO_INCREMENT,
	binaire_photo BLOB,
  name_photo varchar(50),
  date_photo DATE ,
	md5_photo VARCHAR(50),
	id_licence INT,
	PRIMARY KEY(id_photo),
	FOREIGN KEY(id_licence) REFERENCES licence(id_licence)
);

CREATE TABLE commun
(
	id_commun INT AUTO_INCREMENT,
	id_payement INT,
	id_licence INT,
	PRIMARY KEY(id_commun),
	FOREIGN KEY(id_payement) REFERENCES payement(id_payement),
	FOREIGN KEY(id_licence) REFERENCES licence(id_licence)
);

INSERT INTO commun(id_payement, id_licence) VALUES(1, 1);
