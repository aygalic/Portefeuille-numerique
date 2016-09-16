
<!-- formulaire d'inscription -->
<section style="margin-bottom:10%">
    <div class="container" >
        <h1 class="display-4"><span  class="label super-label">Gerer les Prestations</span></h1>
        <?php require_once('menu-perso.php');?>
        <div class="col-xl-8 col-sm-12 col-xl-pull-3">
            <h1>Besoins d'un services ? Faites nous une demande!</h1>
            <form action="../controler/controler.php?process=demandePrestation" method="post">
                <fieldset class="form-group">
                    <label for="intitule">Intitulé</label>
                    <input type="text" class="form-control" required="" id="intitule" name="intitule" placeholder="Intitulé de votre demande">
                </fieldset>
                <fieldset class="form-group">
                    <label for="multipleSelect">Service </label>
                    <select class="form-control" name="prestation" id="multipleSelect">
                        <option value="1">Garde d'enfants</option>
                        <option value="2">Soutien Scolaire</option>
                        <option value="3">Menage et Repassage</option>
                        <option value="4">Aide au Seniors</option>
                        <option value="5">Bricolage et Jardinage</option>
                    </select>
                </fieldset>
                <fieldset class="form-group">
                    <label for="demande">Exprimez votre demande ici</label>
                    <textarea class="form-control" id="demande" required="" name="demande" rows="3"></textarea>
                </fieldset>        
                <fieldset class="form-group">
                    <label for="datepicker">Choisissez une date</label>
                    <input type="text"  class="form-control" required="" name="date" id="datepicker">
                </fieldset>
                <fieldset class="form-group">
                    <label for="timepicker">Choisissez une heure</label>
                    <input  id="timepicker" type="text" required="" name="time" class="timepicker form-control">
                </fieldset>
                <button type="submit" class="btn btn-success-outline">Soumettre</button>
            </form>
        </div>
    </div>
</section>
<!-- /formulaire d'inscription -->
<!--footer-->