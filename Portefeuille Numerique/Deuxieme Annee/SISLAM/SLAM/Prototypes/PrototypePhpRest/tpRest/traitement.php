<?php
session_start();
$id=$_GET['id'];
$login=$_GET['login'];
$username=$_GET['username'];

$opts = array(
           'http'=>array(
                   'method'=>'POST',
                   'header'=>'Content-type: application/x-www-form-urlencoded',
                )
);
$context = stream_context_create($opts);
//Utilisation du contexte dans l'appel
$utilisateur = file_get_contents(
               'http://localhost/tpRestServer/utilisateurs?id='.$id.'&login='.$login.'&username='.$username, 
               false, 
               $context);
echo $utilisateur;


?>
