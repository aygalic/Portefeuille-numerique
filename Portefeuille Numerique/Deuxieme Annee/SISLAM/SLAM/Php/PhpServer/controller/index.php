<?php
require 'slim3/vendor/autoload.php';
require '../model/model.php';
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

$configuration = [
    'settings' => [
        'displayErrorDetails' => true,
    ],
];
$c = new \Slim\Container($configuration);
$app = new \Slim\App($c);

//Création d'utilisateur
//soit la premiere soit la deuxiemme


/*$app->post({'/utilisateur'}, function ($request, $response, $args){
   //Methode d'inssertion d'utilisateur
});*/
//fin du block

//Afficher un utilisateur
//same

$app->get('/utilisateur', function ($request, $response, $args) {
    //renvois un utilisateur ?
    //Probablement unutile pour notre application
    return $response->write("Hello " . $args);
});



$app->get('/utilisateur/licence/{id}', function ($request, $response, $args) {
   //TODO
    $result = getLicenceFromJoueur($args['id']);
		foreach ($result as $value){
      $response = $response->withJson($value, 201, JSON_PRETTY_PRINT);
			}
      return 'fjeizojzef'.$response;
});


$app->get('/joueurs', function($request, $response, $args) {
  $result = getAllJoueurs();
  //print_r($result);
  echo json_encode($result, JSON_PRETTY_PRINT);
});

$app->get('/parents/{ids}', function($request, $response, $args) {
  $result = $args['ids'];
  $ids = explode(" ", $result);
  $resut = getMereFromJoueur($ids[0]);
  $result = $result + getPereFromJoueur($ids[1]);
});


//Affichage des donnés d'un utilisateur
/*$app->get('/utilisateur/{data}', function ($request, $response, $args) {
   //TODO
    switch($args['data']){
        case "suivi":
            //TODO
            break;
        case "etat financier":
            //TODO
            break;
				case 'licence':
					   //TODO
						$result = getLicenceFromJoueur($args['utilisateur']);
						foreach ($result as $value){
              $response = $response->withJson($value, 201, JSON_PRETTY_PRINT);
						}
            return $response;

					break;
				}
});*/




/*
A faire plus tard
reponse d'initialisation du saison
Exploitation des données :
reponse d'affichage Etat des paiements: Nom, prénom, montant attendu, montant payé, paiement complet
reponse d'affichage Annuaire simple: Nom, prénom, photo, numéro de licence, téléphone portable de contact
reponse d'affichage Annuaire complet: annuaire simple + coordonnées des parents, adresse mail*/

$app->run();
