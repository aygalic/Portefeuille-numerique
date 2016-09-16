<?php 
require_once('../view/head.php');
require_once('../model/model.php');?>
<section>
    <div class="container">
        <h1 class="display-4"><span  class="label super-label">Mes Factures</span></h1>
        <?php require_once('../view/menu-perso.php');?>
        <div class="col-xl-8 col-sm-12 col-xl-pull-3">
            <?php afficheFacture($_SESSION['id']);?>
        </div>
    </div>
</section>