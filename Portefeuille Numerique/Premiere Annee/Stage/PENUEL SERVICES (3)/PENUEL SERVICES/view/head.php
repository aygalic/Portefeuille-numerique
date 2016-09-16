<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Penuel Services</title>
        <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>        
        <!-- Bootstrap core CSS -->
        <link href="../bootstrap-4.0.0-alpha.2/dist/css/bootstrap.css" rel="stylesheet" />

        <link rel="stylesheet" href="../css/flexslider.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="../css/calendar.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="../css/facture.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="../css/wickedpicker.css" type="text/css" media="screen" />
        <script src="https://use.fontawesome.com/9d2d3a8f0c.js"></script>

    </head>
    <?php session_start();
    if(isset($_SESSION['id'])){$etatConnexion=TRUE;}
    else{$etatConnexion=FALSE;}?>
    <html>
        <body>
            <?php require_once('../view/nav.php');?>

