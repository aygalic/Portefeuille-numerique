<meta charset="utf-8">
<?php session_start();
if(isset($_REQUEST["process"])){
    $process = $_REQUEST["process"];

    // switch qui choisi la page en fonction de maVar
    switch($process){
        case "inscription":
            require_once('../model/model.php');
            utilisateur();
            echo '<script type="text/javascript">alert("Inscription réussie");</script>';
            echo '<script type="text/javascript">window.location.replace("../view/acceuil.php");</script>';
            break;
        case "connexion":
            require_once "../model/model.php";
            connexionClient();
            break;
        case "deconnexion":
            session_destroy();
            echo '<script type="text/javascript">window.location.replace("../view/acceuil.php");</script>';
            break;
        case "demandePrestation":
            require_once "../model/model.php";
            demandePrestation();
            echo '<script type="text/javascript">window.location.replace("../view/confirmationdemande.php");</script>';
            break;
        case "updatepass":
            require_once "../model/model.php";
            updatepass();
            break;
        case "updateadress":
            require_once "../model/model.php";
            updateadress();
            break;
        case "updatephone":
            require_once "../model/model.php";
            updatephone();
            break;
        default:
            echo 'echec';
            break;
    }
}

// pas de fermeture de la balise php