
<style>
    .navbar-brand {
        float: none;
    }
    .navbar-nav .nav-item {
        float: none;
    }
    .navbar-divider,
    .navbar-nav .nav-item+.nav-item,
    .navbar-nav .nav-link + .nav-link {
        margin-left: 0;
    }
    @media (min-width: 992px) {
        .navbar-brand {
            float: left;
        }
        .navbar-nav .nav-item {
            float: left;
        }
        .navbar-divider,
        .navbar-nav .nav-item + .nav-item,
        .navbar-nav .nav-link + .nav-link {
            margin-left: 1rem;
        }
    }
    .navbar{
        padding: 1rem 1rem !important;
    }
</style>
<nav class="navbar navbar-fixed-top navbar-light bg-faded">
    <button class="navbar-toggler hidden-lg-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar2">
        &#9776;
    </button>
    <div class="collapse navbar-toggleable-md" id="exCollapsingNavbar2">
        <a class="navbar-brand" href="acceuil.php">PENUEL SERVICES</a>
        <ul class="nav navbar-nav">
            <li class="nav-item<?php if($_SERVER['PHP_SELF']=="/PENUEL SERVICES/view/acceuil.php")echo' active';?>">
                <a class="nav-link" href="../view/acceuil.php">Accueil</a>
            </li>
            <li class="nav-item<?php if($_SERVER['PHP_SELF']=="/PENUEL SERVICES/view/services.php")echo' active';?>">
                <a class="nav-link" href="../view/services.php">Nos Services</a>
            </li>
            <li class="nav-item<?php if($_SERVER['PHP_SELF']=="/PENUEL SERVICES/view/fonctionnement.php")echo' active';?>">
                <a class="nav-link" href="../view/fonctionnement.php">Notre Fonctionnement</a>
            </li>
            <li class="nav-item<?php if($_SERVER['PHP_SELF']=="/PENUEL SERVICES/view/charte.php")echo' active';?>">
                <a class="nav-link" href="../view/charte.php">Notre Charte Prestation</a>
            </li>
            <li class="nav-item<?php if($_SERVER['PHP_SELF']=="/PENUEL SERVICES/view/aide_avantage.php")echo' active';?>">
                <a class="nav-link" href="../view/aide_avantage.php">Les Aides et Avantages</a>
            </li>
        </ul>
    </div>
</nav>


