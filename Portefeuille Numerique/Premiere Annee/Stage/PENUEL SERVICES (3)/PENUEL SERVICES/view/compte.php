
<!-- formulaire d'inscription -->
<section>
    <div class="container">
        <h1 class="display-4"><span  class="label super-label">Mon compte</span></h1>
        <?php require_once('menu-perso.php');?>
        <div class="col-xl-8 col-sm-12 col-xl-pull-3">
            <h2>Vous souhaitez modifier vos information personnelles ?</h2>
            <div class="card">
                <div class="card-block">
                    <form action="../controler/controler.php?process=updatepass" method="post">
                        <!-- Form Name -->
                        <legend>Changement de mot de passe</legend>
                        <!-- Text input-->
                        <!-- Password input-->
                        <fieldset class="form-group">
                            <label for="passwordinput">Mot de passe</label>
                            <div>
                                <input id="passwordinput" name="pass" placeholder="" class="form-control" required="" type="password">
                            </div>
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="passwordinput">Nouveau mot de passe</label>
                            <div>
                                <input id="passwordinput" name="newpass" placeholder="" class="form-control" required="" type="password">
                            </div>
                        </fieldset>
                        <!-- Password input 2-->
                        <fieldset class="form-group">
                            <label for="passwordinput">Verification</label>
                            <div>
                                <input id="passwordinput" name="passCheck" placeholder="" class="form-control" required="" type="password">
                            </div>
                        </fieldset>
                        <button type="submit" class="btn btn-primary-outline">Valider</button>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-block">
                    <form action="../controler/controler.php?process=updateadress" method="post">
                        <legend>Changement d'adresse</legend>

                        <!-- Text input-->
                        <fieldset class="form-group">
                            <label for="adresse">Nouvelle Adresse :</label>  
                            <div>
                                <input id="adresse" name="adresse" placeholder="" class="form-control" required="" type="text">
                            </div>
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="postal">Nouvueau Code postal</label>  
                            <div>
                                <input id="postal" name="postal" placeholder="" class="form-control" type="text">
                            </div>
                            <div class="blockquote-footer">Si le code postal reste le meme, laissez ce champ vide.</div>
                        </fieldset>
                        <button type="submit" class="btn btn-primary-outline">Valider</button>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-block">
                    <form action="../controler/controler.php?process=updatephone" method="post">
                        <legend>Changement de numero de telephone</legend>
                        <!-- Text input-->
                        <fieldset class="form-group">
                            <label for="telephone">Nouveau Numero de Telephone</label>  
                            <div>
                                <input id="telephone" name="phone" placeholder="" class="form-control" required="" type="text">
                            </div>
                        </fieldset>
                        <button type="submit" class="btn btn-primary-outline">Valider</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
