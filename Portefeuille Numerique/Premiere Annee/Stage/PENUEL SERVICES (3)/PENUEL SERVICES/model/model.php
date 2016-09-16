<?php
function connexion(){
    $dsn = "mysql:dbname=penuel;host=127.0.0.1";
    $user = 'root';
    try {
        return $dbh = new PDO($dsn, $user,'',array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8'));
    } catch (PDOException $e) {
    }
}
function utilisateur(){ // fonction qui ajoute les infos remplis dans le formulaire
    $dbh=connexion();
    $mail=$_POST['mail'];
    $nom=$_POST['nom'];
    $pass=sha1($_POST['pass']);
    $prenom=$_POST['prenom'];
    $adresse=$_POST['adresse'];
    $postal=$_POST['postal'];
    $phone=$_POST['phone'];
    $phone=str_replace(" ","",$phone);
    $postal=str_replace(" ","",$postal);

    $sql ="SELECT mail FROM membre WHERE mail ='".$mail."'";//selection de l'id et mdp
    $resultat = $dbh->query($sql);
    if($resultat->rowCount()!=0){ 
        echo '<script type="text/javascript">alert("adresse mail utilisée");</script>';
        echo '<script type="text/javascript">window.location.replace("../view/inscription.php");</script>';
    }
    else{
        if(sha1($_POST['passCheck'])==$pass){
            if(preg_match("/^[0-9]{10}$/", $phone)&&is_numeric($phone)) {
                if(preg_match("/^[0-9]{5}$/", $postal)&&is_numeric($postal)) {
                    if(isset($_POST['prestation'])){
                        $prestation=$_POST['prestation'];
                        $sql = "INSERT INTO membre(id, pass ,nom, prenom, mail, adresse, postal, phone, prestation) VALUES('','$pass','$nom','$prenom','$mail','$adresse','$postal','$phone','$prestation')"; 
                    }
                    else{
                        $sql = "INSERT INTO membre(id, pass, nom, prenom, mail, adresse, postal, phone prestation) VALUES('','$pass','$nom','$prenom','$mail','$adresse','$postal','$phone',NULL)"; 
                    }
                    $dbh->exec($sql); 

                }
                else{
                    echo '<script type="text/javascript">alert("format du code postale invalive\nExemple : 75000");</script>';
                    echo '<script type="text/javascript">window.location.replace("../view/inscription.php");</script>';
                }
            }
            else{
                echo '<script type="text/javascript">alert("format du numero de telephone invalive");</script>';
                echo '<script type="text/javascript">window.location.replace("../view/inscription.php");</script>';
            }
        }
        else{
            echo '<script type="text/javascript">alert("les mots de passes saisis ne correspondent pas");</script>';
            echo '<script type="text/javascript">window.location.replace("../view/inscription.php");</script>';


        }
    }


}
function demandePrestation(){ // fonction qui ajoute les infos remplis dans le formulaire
    $intitule=$_POST['intitule'];
    $text=$_POST['demande'];
    $heure=$_POST['time'];
    $service=$_POST['prestation'];
    $date=$_POST['date'];
    //verification du format de la date
    if($date[2]=="/"&&$date[5]=="/"&&strlen($date)==10){
        $intitule=str_replace("'"," ",$intitule);
        $text=str_replace("'"," ",$text);
        $date = date("Y-m-d", strtotime($date));
        $heure=str_replace(' ','',$heure);
        $heure=$heure.':00';
        $datetime=$date.' '.$heure;
        $id_membre=$_SESSION['id'];
        $sql = "INSERT INTO demande(service, text, datetime, intitule, id_membre) VALUES($service,'$text','$datetime','$intitule',$id_membre)"; 
        $dbh=connexion(); // connection à la sgbdr
        $dbh->exec($sql); 

    }
    else{
        echo '<script type="text/javascript">alert("Veuillez entrer un date au format mm/jj/aaaa");</script>';
        echo '<script type="text/javascript">window.location.replace("../controler/demande_prestation.php");</script>';
    }

}
function connexionClient(){
    $dbh=connexion();
    $sql ="SELECT id, mail, pass FROM membre WHERE mail ='".$_POST['txtMail']."'";//selection de l'id et mdp
    foreach  ($dbh->query($sql) as $row) {
        $pass = $row['pass'];
        $id = $row['id'];
    }
    //se connecte si les deux sont égaux aux valeurs de la base de donnée
    if($pass == sha1($_POST['txtPass']))
    {   
        $_SESSION['id'] = $id;
        echo '<script type="text/javascript">window.location.replace("../view/acceuil.php");</script>';

    }

    //erreur sinon
    else
    {	
        echo '<script type="text/javascript">alert("utilisateur/mot de passe incorrecte !");</script>';
        echo '<script type="text/javascript">window.location.replace("../view/acceuil.php");</script>';
    }
}
// ALL DONE ------------ TOUT EST A TESTER -------------------
function updatepass(){
    $dbh=connexion();
    $sql ="SELECT id, mail, pass FROM membre WHERE pass ='".sha1($_POST['pass'])."' AND id = '".$_SESSION['id']."'";
    $STH = $dbh->query($sql);
    $row  = $STH -> fetch();
    $pass = $row['pass'];
    if($pass == sha1($_POST['pass']))
    {   
        if($_POST['newpass']==$_POST['passCheck'])
        {   
            $sql ="UPDATE membre SET pass = '".sha1($_POST['newpass'])."' WHERE membre.ID =".$_SESSION['id'];
            $count = $dbh->exec($sql) or die(print_r($dhb->errorInfo(), true));
            if($count==1){
                echo '<script type="text/javascript">alert("Le changement a été effectué.");</script>';
                echo '<script type="text/javascript">window.location.replace("../view/compte.php");</script>';
            }
            else{
                echo 'fail';
            }
        }
        else{
            echo '<script type="text/javascript">alert("Les deux mot de passe que vous saisissez doivent etre identiques !");</script>';
            echo '<script type="text/javascript">window.location.replace("../view/compte.php");</script>';
        }
    }
    else
    {
        echo '<script type="text/javascript">alert("Mot de passe éroné.");</script>';
        echo '<script type="text/javascript">window.location.replace("../view/compte.php");</script>';
    }
}
function updateadress(){
    $dbh=connexion();
    if($_POST['postal']!=""){
        $sql ="UPDATE membre SET adresse = '".$_POST['adresse']."' WHERE membre.ID = ".$_SESSION['id'].";UPDATE membre SET postal = '".$_POST['postal']."' WHERE membre.ID =".$_SESSION['id'];
    }
    else{
        $sql ="UPDATE membre SET adresse = '".$_POST['adresse']."' WHERE membre.ID = ".$_SESSION['id'];
    }
    $count = $dbh->exec($sql) or die(print_r($dbh->errorInfo(), true));
    if($count==1){
        echo '<script type="text/javascript">alert("Le changement a été effectué.");</script>';
        echo '<script type="text/javascript">window.location.replace("../view/compte.php");</script>';
    }
}
function updatephone(){
    $dbh=connexion();
    $sql ="UPDATE membre SET phone = ".$_POST['phone']." WHERE membre.ID = ".$_SESSION['id'];
    $count = $dbh->exec($sql) or die(print_r($dbh->errorInfo(), true));
    if($count==1){
        echo '<script type="text/javascript">alert("Le changement a été effectué.");</script>';
        echo '<script type="text/javascript">window.location.replace("../view/compte.php");</script>';
    }
}
//fonction relatives au calendrier
function recuPrestation($day){
    $dbh=connexion();
    $sql ="SELECT id_prestation, label, description, date FROM prestation, membre WHERE id_membre = id AND date LIKE '".$day." %'";
    $retour='';
    $resultat = $dbh->query($sql);
    foreach ($resultat ->fetchAll(PDO::FETCH_OBJ) as $ligne) { 
        $retour = $retour.'<div class="popup-header">'.$ligne->label.'</div>'; 
        $retour = $retour.'<div class="popup-descritpion">'.$ligne->description.'</div>'; 
        $retour = $retour.'<div class="popup-date"><i class="fa fa-clock-o" aria-hidden="true"></i> '.$ligne->date.'</div>'; 
    } 

    if($resultat->rowCount()!=0){ 
        return $retour;
    }
    else{
        return 'Aucune prestation ce jour ci';
    }


}
function frenchMonth($month){
    switch ($month) {
        case 1:
            $month='Janvier';
            break;
        case 2:
            $month='Fevrier';
            break;
        case 3:
            $month='Mars';
            break;
        case 4:
            $month='Avril';
            break;
        case 5:
            $month='Mai';
            break;
        case 6:
            $month='Juin';
            break;
        case 7:
            $month='Juillet';
            break;
        case 8:
            $month='Aout';
            break;
        case 9:
            $month='Septembre';
            break;
        case 10:
            $month='Octobre';
            break;
        case 11:
            $month='Novembre';
            break;
        case 12:
            $month='Decembre';
            break;
    }
    return $month;
}
//fonction relatives a l'affichage des factures
function recupFacture($id){
    $dbh=connexion();
    $sql = "SELECT * FROM facture, prestation where facture.id_prestation=prestation.id_prestation AND id_membre=".$id." ORDER BY prestation.date DESC";
    $resultat = $dbh->query($sql);
    return $resultat;
}
function afficheFacture($id){
    $html ="";  
    $facture = recupFacture($id);
    if($facture->rowCount()!=0){ 
        foreach ($facture ->fetchAll(PDO::FETCH_OBJ) as $ligne) {
            $dateTime=$ligne->date;
            echo'<div class="card row"><div class="card-block" style="padding:0"><div class="facture-header">';
            echo'<div class="num-facture"><i class="fa fa-file" aria-hidden="true"></i> '.$ligne->id_facture.' </div>'; 
            echo'<div class="date">'.$dateTime.'</div><div style="clear:both"></div> ';
            echo'<div><h2>'.$ligne->label.'</h2></div></div>'; 
            echo'<div class="facture-footer"><div>'.$ligne->description.'</div>'; 
            echo'<div style="text-align:right"><h2><b>'.$ligne->montant.'</b> <i class="fa fa-eur" aria-hidden="true"></i></h2><hr class="facture"></div>'; 
            echo'</div></div></div>';
        } 
    }
    else{
        echo "Vous n'avez encore aucune facture à ce jour";
    }
}