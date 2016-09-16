<div class="col-xl-3 col-md-12 col-xl-push-9" >
    <div class="row">
        <div class="card">
            <div class="card-block">
                <h1><span class="label super-label">Espace Personnel</span></h1>

                <div <?php if(!isset($_SESSION['id'])){echo'style="display: none;"';}?>>
                    <div>
                        <ul class="nav nav-pills nav-stacked">
                            <li class="nav-item">
                                <a class="nav-link" href="../controler/mon_compte.php">Mon compte</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../controler/mon_planning.php">Planning</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../controler/mes_factures.php">Facture</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../controler/demande_prestation.php">Gerer les prestations</a>
                            </li>
                            <li>
                                <form action="../controler/controler.php?process=deconnexion" method="post">
                                    <button type="submit" class="btn btn-warning-outline">Se deconnecter</button>

                                </form>
                            </li>
                        </ul>
                    </div>
                </div>

                <div <?php if(isset($_SESSION['id'])){echo'style="display: none;"';}?>>
                    <form action="../controler/controler.php?process=connexion" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail3">Email</label>
                            <input type="email" name="txtMail"class="form-control" id="exampleInputEmail3" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword3">Mot de passe</label>
                            <input type="password" name="txtPass"class="form-control" id="exampleInputPassword3" placeholder="Password">
                        </div>
                        <div class="checkbox" style="display:none">
                            <label>
                                <input type="checkbox"> Se souvenir de moi
                            </label>
                        </div>
                        <button type="submit" class="btn btn-success-outline">Connection</button>

                    </form>
                    <a href="inscription.php">Pas encore client?</a>
                </div>
            </div>
        </div>

    </div>
</div>