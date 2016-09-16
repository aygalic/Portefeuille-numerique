<?php require_once('head.php');?>
<div class="confirmation">
    <div class="dark-confirmation">
        <div class="container">
            <div class="card-outline">
                <h1>Votre demande a été prise en compte</h1>
                <h2>Vous allez etre reririgé vers l'<a href="acceuil.php">acceuil</a>.</h2>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    setTimeout(function(){
        window.location.replace("../view/acceuil.php");
    }, 5000);
</script>
<?php require_once('footer.php');?>