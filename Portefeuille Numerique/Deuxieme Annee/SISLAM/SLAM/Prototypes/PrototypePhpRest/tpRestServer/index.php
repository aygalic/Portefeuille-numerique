<?php 
require 'slim3/vendor/autoload.php';

use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

$app = new \Slim\App;
$app->post('/utilisateurs/insert', function(Request $request, Response $response){
	$comptes = json_decode($request->getBody());
	insertUser($comptes->Id, $comptes->Login, $comptes->User);
});

$app->get('/utilisateurs[/{id}]', function(Request $request, Response $response){
	$id = $request->getAttribute('id');
	getAccounts($id);
});

function connexion(){ //fonction qui créer une connection à la SGBDR
    
    
    $dsn='mysql:dbname=tpRest;host=127.0.0.1';
    
    try {
        
    return $dbh = new PDO($dsn,'root','');
    
	} catch (PDOException $e){
   		echo "error"; 
	}
}
function getAccounts($id)
{
	$sql = "SELECT * FROM users WHERE id=:id";
	try{
		$dbh=connexion();
		$statement = $dbh->prepare($sql);
		$statement->bindParam(":id", $id);
		$statement->execute();
		$result = $statement->fetchObject();
		$dbh = null;
		echo '{"utilisateurs": '.json_encode($result, JSON_PRETTY_PRINT).'}';
	} catch(PDOException $e){
		echo '{"error":'.$e->getMessage().'}}';
	}
	

}

function insertUser($id, $login, $user)
{
$dbh=connexion(); // connection à la sgbdr
	$insertUt=$dbh->prepare('INSERT INTO users VALUES(:id, :login, :username)');
	//préparation de la requête sql pour insérer les valeurs dans les tables
	$insertUt->execute(array(
		':id'=> $id,
		':login' => $login,
		':username' => $user,
	));
	echo "Inscription validée";
}

$app->run();