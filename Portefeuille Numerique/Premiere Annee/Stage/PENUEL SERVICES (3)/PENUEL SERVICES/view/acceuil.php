<?php require_once('head.php')?>
        <style type="text/css">
            .flex-caption {
                width: 96%;
                padding: 2%;
                left: 0;
                bottom: 0;
                background: rgba(0,0,0,.5);
                color: #fff;
                text-shadow: 0 -1px 0 rgba(0,0,0,.3);
                font-size: 14px;
                line-height: 18px;
            }
            li.css a {
                border-radius: 0;
            }
        </style>

        <!-- Content -->
        <div class="logo-acceuil">
            <img src="../img/logo.svg">  
        </div>
        <div class="flexslider"style="width: 100vw">
            <ul class="slides">
                <li>
                    <img class="slide" src="../img/slides/jardinage.jpe"style="object-fit: cover;"/>
                </li>
                <li>
                    <img class="slide" src="../img/slides/garde%20d'enfant.jpe" style="object-fit: cover;"/>
                </li>
                <li>
                    <img class="slide" src="../img/slides/bricolage.jpe" style="object-fit: cover;"/>
                </li>
                <li>
                    <img class="slide" src="../img/slides/assisance%20agee.jpe" style="object-fit: cover;"/>
                </li>
                <li>
                    <img class="slide" src="../img/slides/menage.jpe" style="object-fit: cover;"/>
                </li>
            </ul>
        </div>
        <div class="row" style="padding-top:5%">
            <div class="container">
                <?php require_once('menu-perso.php');?>
                <div class="col-xl-8 col-sm-12 col-xl-pull-3">
                    <div class="row">
                        <div class="card">
                            <div class="card-block">
                                <h1><span class="label super-label">Penuel Services</span></h1>
                                <h3 style="padding:2%">Acteur du service à la personne depuis 2012.</h3>   
                                <p style="padding:2%">Présent en Ile de France, nous intervenons en  prestataire ou en mandataire. Nous avons acquis un <span class="blue">professionnalisme</span> et une <span class="blue">exigence</span> qui sied au métier du <span class="blue">service à la personne.</span> Notre but est de fournir à notre clientèle des prestations <span class="blue">clés en main.</span> Ceci afin de  décharger les familles des aléas inhérents  à l'emploi d'une personne à domicile.</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="card">
                            <div class="card-block">
                                <h1><span class="label super-label">Nos services</span></h1>
                                <p style="padding:2%">La <span class="blue">proximité</span> est notre maître mot et nous souhaitons dans notre approche jouer cette carte pour le bien de la famille et pour le bien de nos intervenantes. C'est pour cela que le bien être des familles et des intervenantes est primordiale dans notre politique. Dans tous les cas de figures. Pour ce faire dans la cadre d'une <span  class="blue">nouvelle prestation nous n'envoyons jamais une nouvelle intervenante</span>. Nous envoyons en fait une intervenante qui a déjà fait ces preuves  et que nous avons pris le temps de connaître.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Content -->  
<?php require_once('footer.php');?>