<?php require_once('head.php')?>

<!-- formulaire d'inscription -->
<section>
    <div class="container">
        <h1 class="display-4"><span  class="label super-label">Inscription</span></h1>

        <form action="../controler/controler.php?process=inscription" method="post">
            <!-- Form Name -->
            <legend>Inscription</legend>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="mail">Mail</label>  
                <div>
                    <input id="mail" name="mail" placeholder="" class="form-control" required="" type="email">
                </div>
            </fieldset>
            <!-- Password input-->
            <fieldset class="form-group">
                <label for="passwordinput">Mot de passe</label>
                <div>
                    <input id="passwordinput" name="pass" placeholder="" class="form-control" required="" type="password">
                </div>
            </fieldset>
            <!-- Password input 2-->
            <fieldset class="form-group">
                <label for="passwordinput">Verification</label>
                <div>
                    <input id="passwordinput" name="passCheck" placeholder="" class="form-control" required="" type="password">
                </div>
            </fieldset>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="nom">Nom</label>  
                <div>
                    <input id="nom" name="nom" placeholder="" class="form-control input-md" required="" type="text">
                </div>
            </fieldset>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="prenom">Prenom</label>  
                <div>
                    <input id="prenom" name="prenom" placeholder="" class="form-control" required="" type="text">
                </div>
            </fieldset>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="adresse">Adresse</label>  
                <div>
                    <input id="adresse" name="adresse" placeholder="" class="form-control" required="" type="text">
                </div>
            </fieldset>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="postal">Code postal</label>  
                <div>
                    <input id="postal" name="postal" placeholder="" class="form-control" required="" type="text">
                </div>
            </fieldset>
            <!-- Text input-->
            <fieldset class="form-group">
                <label for="telephone">Numero de Telephone</label>  
                <div>
                    <input id="telephone" name="phone" placeholder="" class="form-control" required="" type="text">
                </div>
            </fieldset>
            <!-- Select Multiple -->
            <fieldset class="form-group">
                <label for="prestation">Préstation désirée</label>
                <div>
                    <select id="prestation" name="prestation" class="form-control" multiple="multiple">
                        <option value="1">Garde d'enfants</option>
                        <option value="2">Soutien Scolaire</option>
                        <option value="3">Menage et Repassage</option>
                        <option value="4">Aide au Seniors</option>
                        <option value="5">Bricolage et Jardinage</option>
                    </select>
                </div>
            </fieldset>
            <button type="submit" style="margin-bottom:10%"class="btn btn-success-outline">Valider</button>
        </form>
    </div>
</section>
<!-- /formulaire d'inscription -->
<?php require_once('footer.php');?>