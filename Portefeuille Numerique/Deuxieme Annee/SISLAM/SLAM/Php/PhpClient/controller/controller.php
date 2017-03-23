<?php 
$url = "http://localhost/utilisateurs";
$action= $_GET["action"];
switch($action){
        //Connection : Envoyer au serveur 1 mail et mdp hashé (md5)
    case "connexion"{


    }
        //création d'utilisateur
    case "addUser"{
        $login=$_GET["login"];
        $mail=$_GET["mail"];
        $pass=$_GET["pass"];
        $url =+ "user?login="+$login;
        $url =+ "&mail="+$mail;
        $url =+ "&pass="+$pass;
        post($url);
    }
        //modification des droits
    case "changeDroit"{
        $utilisateur=$_GET["utilisateur"];
        $niveauDeDroit=$_GET["niveauDeDroit"];
        $url =+ "user?utilisateur="+$utilisateur;
        $url =+ "&niveauDeDroit="+$niveauDeDroit;
        put($url);

    }
        //saisie des licences
    case "addLicence"{
        $notesLicence=$_GET["notesLicence"];
        $dateLicence=$_GET["dateLicence"];
        $catLicence=$_GET["catLicence"];
        $dirigeant=$_GET["dirigeant"];
        $inscritNewLetter=$_GET["inscritNewLette"];
        $licenceDistrictDispo=$_GET["licenceDistrictDispo"];
        $formationLicence=$_GET["formationLicence"];
        $demandeAttFincancier=$_GET["demandeAttFincancie"];
        $demandeCotiFinancier=$_GET["demandeCotiFinancier"];
        $numChequeFinancier=$_GET["numChequeFinancier"];
        $renouvLicence=$_GET["renouvLicence"];
        $url=+"licence?notesLicence="+$notesLicence;
        $url=+"&dateLicence="+$dateLicence;
        $url=+"&catLicence="+$catLicence;
        $url=+"&dirigeant="+$dirigeant;
        $url=+"&inscritNewLette="+$inscritNewLetter;
        $url=+"&licenceDistrictDispo="+$licenceDistrictDispo;
        $url=+"&formationLicence="+$formationLicence;
        $url=+"&demandeAttFincancie="+$demandeAttFincancier;
        $url=+"&demandeCotiFinancier="+$demandeCotiFinancier;
        $url=+"&numChequeFinancier="+$numChequeFinancier;
        $url=+"&renouvLicence="+$renouvLicence;
        post($url);


    }
        //saisie coordonnées
    case "addCoord"{
        //type de personne (joueur, pere, mere)
        $personne=$_GET["personne"]
        $mailJ1=$_GET["mailJ1"];
        $mailJ2=$_GET["mailJ2"];
        $nom=$_GET["nom"];
        $prenom=$_GET["prenom"];
        $telPort=$_GET["telPort"];
        $telFix=$_GET["telFix"];
        $adresse=$_GET["adresse"];
        $ville=$_GET["ville"];
        $codePostal=$_GET["codePostal"];
        $url=+ $personne+"?mailJ1="+$mailJ1;
        $url=+ "&mailJ2="+$mailJ2;
        $url=+ "&nom="+$nom;
        $url=+ "&prenom="+$prenom;
        $url=+ "&telPort="+$telPort;
        $url=+ "&telFix="+$telFix;
        $url=+ "&adresse="+$adresse;
        $url=+ "&ville="+$ville;
        $url=+ "&codePostal="+$codePostal;
        post(url);

    }   
        //saisie photo
    case "addPhoto"{
        //a gerer plus tard
        
    }   
        //saisie des données financières
    case "addFinance"{
        //a completer plus tard
        //remplir la table payement
        
        
    }   
        //saisie Attestation de paiemen
    case "addAttestationPaiement"{
        $noteFinanciere=$_GET["noteFinanciere"];
        $sommePayee=$_GET["sommePayee"];
        $url=+"payement?noteFinanciere="+$noteFinanciere;
        $url=+"&sommePayee="+$sommePayee;
        post(url);

    }
        //affichage des coordonnées
    case "getCoord"{
        //type de personne (joueur, pere, mere)
        $personne=$_GET["personne"]
        $numPersonne=$_GET["numPersonne"]
        $url=+$personne+"/"+$numPersonne;
        get(url);
    }
        //affichage du suivi sportif
    case "getSuiviSportif"{
        //a revoir coté BDD
        //afficher les catégories des joueurs 
        //Affiche joueur et section

    }
        //affichage etat financier
    case "getEtatFinancier"{
        //a demander au proffesseur
        //afficher la table payement

    }
        //suppression d'un licencier
    case "delLicencier"{
        //a demander

    }
        //initialisation du saison???????
    case "initSaison"{
        //a demander

    }

        //Exploitation des données
        //GET d'affichage Etat des paiements: Nom, prénom, montant attendu, montant payé, paiement complet
        //GET d'affichage Annuaire simple: Nom, prénom, photo, numéro de licence, téléphone portable de contact		
        //GET d'affichage Annuaire complet: annuaire simple + coordonnées des parents, adresse mail

}



/*echo $_SERVER["REQUEST_METHOD"];
echo "<br>";
echo $_SERVER["REQUEST_URI"];
$json =  file_get_contents($_SERVER["REQUEST_URI"]);
/*echo $_POST['data'];
echo json_decode($_POST['data']);
echo var_dump(json_decode($json));*/


?>
