<?php
// CODE ALEX
function getConnection() {
    $dbhost="127.0.0.1";
    $dbuser="root";
    $dbpass="";
    $dbname="bddSISLAM";
    $dbh = new PDO("mysql:host=$dbhost;dbname=$dbname;charset=utf8", $dbuser, $dbpass);
    //$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    return $dbh;
}

function getPrivilege($ndc, $mail, $mdp)
{
        $bdh=getConnexion();
        $sql = "SELECT id_privilege FROM utilisateurs where login_utilisateur = :login OR mail_utilisateur = :mail AND password_utilisateur= :pass";
        $result->$bdh->prepare($sql);
        $result->execute(array(
          ':login', $ndc,
          ':mail', $mail,
          ':pass', $mdp
        ));
        if($result != null)
          return $result ;
        else
          return  null ;
}

// AJOUT UTILISATEUR DANS LA BASE DE DONN

function adduser($ndc,$mdp,$mail){
  $bdh=getConnection();
  $result=$bdh->prepare("INSERT INTO `utilisateurs`(login_utilisateur,password_utilisateur,mail_utilisateur) VALUES (:ndc,:mdp,:mail)");
  $result->execute(array(
  ':login_utilisateur'=>$ndc,
  ':password_utilisateur'=>$mdp,
  ':mail_utilisateur'=>$mail
  ));
}

function getLastidfromlicence()
{
  $bdh=getConnection();
  $result=$bdh->prepare("SELECT count(id_licence) from licences");
  return $result ;
}

function addImage($binaire_photo,$name_photo)
{
    $bdh = getConnection();
    $result=$bdh->preapre("insert into `photo`(date_photo,binaire_photo,name_photo,md5_photo,id_licence FROM photo) values (:binaire_photo,:md5_photo,:name_photo,:date_photo,:id_licence)" );
    $lastID = getLastidfromLicence();
    $DateActuel = date("Y-m-d H:i:s");
    $md5 = md5($binaire_photo);
    $result->execute(array(
      ':date_photo'=>$DateActuel,
      ':binaire_photo'=>$binaire_photo,
      ':name_photo'=>$name_photo,
      ':md5_photo'=>$md5,
      ':id_licence'=>$lastiD,
    ));
}

function getFlag($id_joueur)
{
  $bdh=getConnection();
  $result=$bdh->prepare("SELECT paiementComplet_payement from etatFinancier e, avoir a, payement p, commun c, licence l
  WHERE e.id_etatFinancier = a.id_etatFinancier
  AND a.id_payement = p.id_payement
  AND p.id_payement = c.id_payement
  AND c.id_licence = l.id_licence
  AND l.id_joueur=:id_joueur");
  $result->bindParam(':id_licence', $id_joueur, PDO::PARAM_STR);
  $result->execute();
  return $res ;
}

function getEtatFinancier($id_joueur)
{
  $dbh = getConnection();
  $flag = getFlag($id_joueur);
  if($flag == 0) {
      $sql="SELECT paiementComplet_payement from etatFinancier e, avoir a, payement p, commun c, licence l
      WHERE e.id_etatFinancier = a.id_etatFinancier
      AND a.id_payement = p.id_payement
      AND p.id_payement = c.id_payement
      AND c.id_licence = l.id_licence
      AND l.id_joueur = :id_joueur";
      $result=$dbh->prepare($sql);
      $result->bindParam(':id_licence', $id_joueur, PDO::PARAM_STR);
      $result->execute();
      return $result;
    } else {
    return "ok";
  }
}

function setEtatFinancier($id_joueur)
{
  $dbh = getConnection();
  $sql = "UPDATE etatFinancier, avoir, payement,commun, licence
  SET etatFinancier.paiementComplet_payement = 1
  WHERE etatFinancier.id_etatFinancier = avoir.id_etatFinancier
  AND avoir.id_payement = payement.id_payement
  AND payement.id_payement = commun.id_payement
  AND commun.id_licence = licence.id_licence
  AND licence.id_joueur = :id_joueur";
  $result=$dbh->prepare($sql);
  $result->bindParam(':id_joueur', $id_joueur, PDO::PARAM_STR);
  $result->execute();
}

function addLicence($notes_licence, $date_licence, $cat_licence, $dirigeant_licence, $inscrisNewLetter_licence, $licenceDistrictDispo_licence, $formation_licence, $renouv_licence, $id_joueur) {
    $dbh = connection();
    $result=$dbh->prepare("INSERT INTO licence(notes_licence, date_licence, cat_licence, dirigeant_licence, inscrisNewLetter_licence, licenceDistrictDispo_licence,
    formation_licence, renouv_licence, id_joueur)
    VALUES(:note_licence, :date_licence, :cat_licence, :dirigeant_licence, :inscrisNewLetter_licence, licenceDistrictDispo_licence, formation_licence, renouv_licence, id_joueur)");
    $result->execute(array(
        ':note_licence'=>$notes_licence,
        ':date_licence' => $date_licence,
        ':cat_licence' => $cat_licence,
        ':dirigeant_licence' => $dirigeant_licence,
        ':inscrisNewLetter_licence' => $inscrisNewLetter_licence,
        ':licenceDistrictDispo_licence' => $licenceDistrictDispo_licence,
        ':formation_licence' => $formation_licence,
        ':renouv_licence' => $renouv_licence,
        ':id_joueur' => $id_joueur
    ));
}
function getLicenceFromJoueur($id_joueur) {
  $dbh = getConnection();
  $sql ='SELECT * FROM licence WHERE id_joueur=:id';
	$resultat=$dbh->prepare($sql);
	$resultat->bindParam(':id', $id_joueur, PDO::PARAM_INT);
	$resultat->execute();
  return $resultat->fetchAll();
}

function getLastIdFromPersonne()
{
  $dbh = getConnection();
  $sql ='SELECT COUNT(id_personne) FROM personne';
  $result = $dbh->prepare($sql);
  $result->execute();
  return $result;
}

function getLastIdFromPere()
{
  $dbh = getConnection();
  $sql = 'SELECT COUNT(id_pere) FROM pere';
  $result = $dbh->prepare($sql);
  $result->execute();
  return $result;
}

function getLastIdFromMere()
{
  $dbh = getConnection();
  $sql = 'SELECT COUNT(id_mere) FROM mere';
  $result = $dbh->prepare($sql);
  $result->execute();
  return $result;
}

function addCoordonneeMereOuMere($nom_personne, $prenom_personne, $telPortable_personne, $telFixe_personne, $adresse_personne, $ville_personne, $codePostale_personne)
{
  $dbh = getConnection();
  $sql = 'INSERT INTO personne(nom_personne, prenom_personne, telPortable_personne, telFixe_personne, adresse_personne, ville_personne, codePostale_personne)
  VALUES (:nom_personne, :prenom_personne, :telPortable_personne, :telFixe_personne, :adresse_personne, :ville_personne, :codePostale_personne)';
  $result = $dbh->prepare($sql);
  $result->execute(array(
      ':nom_personne'=>$nom_personne,
      ':prenom_personne' => $prenom_personne,
      ':telPortable_personne' => $telPortable_personne,
      ':telFixe_personne' => $telFixe_personne,
      ':adresse_personne' => $adresse_personne,
      ':ville_personne' => $ville_personne,
      ':codePostale_personne' => $codePostale_personne
  ));
  $lastId = getLastIdFromPersonne();
  $sql = 'INSERT INTO mere(id_personne) VALUES(:id_personne)';
  $result = $dbh->prepare($sql);
  $result->execute(array(
    ':id_personne'=>$lastId
  ));
}

function addCoordonneJoueur($nom_personne, $prenom_personne, $telPortable_personne, $telFixe_personne, $adresse_personne, $ville_personne, $codePostale_personne, $mail1_joueur, $mail2_joueur)
{
  $sql = 'INSERT INTO personne(nom_personne, prenom_personne, telPortable_personne, telFixe_personne, adresse_personne, ville_personne, codePostale_personne)
  VALUES (:nom_personne, :prenom_personne, :telPortable_personne, :telFixe_personne, :adresse_personne, :ville_personne, :codePostale_personne)';
  $result = $dbh->prepare($sql);
  $result->execute(array(
      ':nom_personne'=>$nom_personne,
      ':prenom_personne' => $prenom_personne,
      ':telPortable_personne' => $telPortable_personne,
      ':telFixe_personne' => $telFixe_personne,
      ':adresse_personne' => $adresse_personne,
      ':ville_personne' => $ville_personne,
      ':codePostale_personne' => $codePostale_personne
  ));
  $idPere = getLastIdFromPere();
  $idMere = getLastIdFromMere();
  $idPersonne = getLastIdFromPersonne();
  $sql = 'INSERT INTO joueur(mail1_joueur, mail2_joueur, id_pere, id_mere, id_personne)
  VALUES(:mail1_joueur, :mail2_joueur, id_pere, id_mere, id_personne)';
  $result->$dbh->prepare($sql);
  $result->execute(array(
    ':mail1_joueur', $mail1_joueur,
    ':mail2_joueur', $mail2_joueur,
    ':id_pere', $idPere,
    ':id_mere', $idMere,
    ':id_personne', $idPersonne
  ));
}

function getAllJoueurs()
{
  $dbh = getConnection();
  $sql ='SELECT j.*, p.nom_personne, p.prenom_personne FROM joueur j, personne p WHERE j.id_personne = p.id_personne ';
	$result =$dbh->query($sql);
  return $result->fetchAll(PDO::FETCH_OBJ);
}

function getPereFromJoueur($id_pere)
{
  $dbh = getConnection();
  $sql = 'SELECT * FROM pere WHERE id_pere = :id_pere';
  $result=$dbh->prepare($sql);
  $result->bindParam(':id_pere', $id_pere, PDO::PARAM_STR);
  $result->execute();
  $pere = array();
  foreach($resultat->fetchAll(PDO::FETCH_OBJ) as $ligne)
  {
    array_push($pere, $ligne);
  }
  return $pere;
}

function getMereFromJoueur($id_mere)
{
    $dbh = getConnection();
    $sql = 'SELECT * FROM mere WHERE id_mere = :id_mere';
    $result=$dbh->prepare($sql);
    $result->bindParam(':id_mere', $id_mere, PDO::PARAM_STR);
    $result->execute();
    $mere = array();
    foreach($result->fetchAll(PDO::FETCH_OBJ) as $ligne)
    {
      array_push($mere, $ligne);
    }
    return $mere;
}


function deletelicencier($id_licence){
 $dbh=getConnection();
//delete commun (obligatoire pour supprimer licence)
 $sql="SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bddSISLAM' AND   TABLE_NAME   = 'commun'" ;
 $result=$dbh->prepare($sql);
 $result->execute();
 $maxAuto = $Res;
 $result = null;
 $sql="DELETE FROM commun c, licence l WHERE l.id_licence = :id_licence";
 $result=$dbh->prepare($sql);
 $result->bindParam(':id_licence', $id_licence, PDO::PARAM_STR);
 $result->execute();
 $result = null;
 $sql="ALTER TABLE licence AUTO_INCREMENT = :nbIncrement";
 $result=$dbh->prepare($sql);
 $result->bindParam(':nbIncrement', $max - 1, PDO::PARAM_STR);
 $result->execute();
 $result = null;
 $maxAuto = null;

 //delete licence après avoir supprimer commun
 $sql= "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bddSISLAM' AND   TABLE_NAME   = 'licence'" ;
 $result=$dbh->prepare($sql);
 $result->execute();
 $maxAuto = $Res;
 $result = null;
 $sql="DELETE FROM licence WHERE id_licence = :id_licence";
 $result=$dbh->prepare($sql);
 $result->bindParam(':id_licence', $id_licence, PDO::PARAM_STR);
 $result->execute();
 $result = null;
 $sql = "ALTER TABLE licence AUTO_INCREMENT = :nbIncrement";
 $result=$dbh->prepare($sql);
 $result->bindParam(':nbIncrement', $maxAuto - 1, PDO::PARAM_STR);
 $result->execute();

}


function getPayment($id_joueur)

{
    $dbh=getConnection();
    $sql="SELECT * FROM payement p,commun c, licence l
            WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
    $result=$dbh->prepare($sql);
    $result->bindParam(':id_joueur', $id_joueur, PDO::PARAM_STR);
    $result = execute();
    $pay = array();

    foreach($result->fetchAll(PDO::FETCH_OBJ) as $ligne)
    {
        array_push($pay,$ligne);
    }
    return $pay;

    }


  /*  // Inutile pour l'instant
    function getAllPayement()
    {
      $dbh = getConnection();
      $sql="SELECT * FROM payement";
      $res=$dbh->prepare($sql);
      $res->execute()
      return $res->fetchAll();
    }*/


// FONCTION PAS CLAIRE ...
// Un switch possible ? dissocier ce code en plusieur fonction , comme sa on appel la fonction adéquat directe ? Donc 7 fonctions en tout au final .
// C'est jute un raccourci et plus clair je pense  . On voit sa demain de toute façon sa se trouve tout est faux dans mon idée ou dans ma fonction .

function SetPayment($noteFinanciere_payement,$sommeAPayer_payement,$sommePayer_payement,$demandeAttFinancier_licence,$demandeDeCotiFinancier_licence,$paiementComplet_payement,$depotBanque_payement)
{
    $result = null ;
    GetPayement();

    if($result == "noteFinancière_payement")
    {
        $result = $noteFinanciere_payement;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set noteFinancière_payement = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    }else if($result == "sommeAPayer_payement")

    {
        $result = $sommeAPayer_payement ;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set sommeAPayer_payement = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    }else if($result == "sommePayer_payement")

    {
        $result = $sommePayer_payement;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set sommePayer_payement = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    } else if ($result == "demandeAttFinancier_licence")

    {
        $result = $demandeAttFinancier_licence;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set demandeAttFinancier_licence = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    } else if ($result == "demandeDeCotiFinancier_licence")

    {
        $result = $demandeAttFinancier;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set demandeDeCotiFinancier_licence = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    } else if ($result == "paiementComplet_payement")

    {
        $result = $paiementComplet_payement;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set paiementComplet_payement = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    } else if ($result == "depotBanque_payement")

    {
        $result = $depotBanque_payement;
        $dbh=getConnection();
        $sql="Update payement p , commun c , licence l set depotBanque_payement = ".$result."WHERE p.id_payement = c.id_payement
            AND c.id_licence = l.id_licence
            AND l.id_joueur = :id_joueur";
        $res=$dbh->prepare($sql);
        $res->execute();

    }



}



function updateSaison(){
    //TODO
}
