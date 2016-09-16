<?php 
require_once('../view/head.php');
require_once('../model/model.php');
if(isset($_REQUEST["process"])){
    $process = $_REQUEST["process"];
    switch($process){
        case "previous":
            $time = $_POST['moins'];
            if(date('m',$time)==date('m',time())){
                $today=date('j',time());
            }
            else{
                $today=null;

            }
            break;
        case "next":
            $time = $_POST['plus'];
            if(date('m',$time)==date('m',time())){
                $today=date('j',time());

            }
            else{
                $today=null;

            }            
            break;
    }
}
else{
    $time = time();
    $today=date('j',time());
}
$month=date('m',$time);
$month=frenchMonth($month);
$year=date('Y',$time);
$test=date('F Y',$time);
$firstDay = new DateTime('first day of '.$test);
$firstDay=$firstDay->format('N');
$lastDay = new DateTime('last day of '.$test);
$lastDay=$lastDay->format('j');
//preparation des boutons
$plus = date('U',strtotime("+1 month", $time));
$moins = date('U', strtotime("-1 month", $time));
?>
<section>
    <div class="container">
        <h1 class="display-4"><span  class="label super-label">Mon planning</span></h1>
        <?php require_once('../view/menu-perso.php');?>
        <div class="col-xl-8 col-sm-12 col-xl-pull-3">





            <h1 class="calendar-header">
                <form action="planning.php" method="post">
                    <button type="submit" formaction="mon_planning.php?process=previous" name="moins" value="<?php echo $moins?>">
                        <i class="fa fa-angle-left" aria-hidden="true"></i>
                    </button>
                    <?php echo $month.' '.$year;?>
                    <button type="submit" formaction="mon_planning.php?process=next" name="plus" value="<?php echo $plus?>">
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                    </button>
                </form>
            </h1>


            <table>
                <thead> <!-- En-tête du tableau -->
                    <tr>
                        <th class="white">Lundi</th>
                        <th class="white">Mardi</th>
                        <th class="white">Mercredi</th>
                        <th class="white">Jeudi</th>
                        <th class="white">Vendredi</th>
                        <th class="white">Samedi</th>
                        <th class="white">Dimanche</th>
                    </tr>
                </thead>
                <?php
    for ($i = 0; $i < 6; $i++) {
        echo '<tr>';
        for ($j = 1; $j <= 7; $j++) {
            $day=($j+$i*7)-$firstDay;
            if($day==$today-1&&$today!==null){
                echo '<td class="today">';
            }
            else if($day>=0 && $day<$lastDay){
                echo '<td class="notToday">';
            }
            else{
                echo '<td>';
            }
            if($day>=0 && $day<$lastDay){
                echo $day+1;
                echo '<div class="popup">'.recuPrestation($year.'-'.date('m', $time).'-'.($day+1)).'</div>';
            }
            else{
                echo '';
            }
            echo '</td>';
        }
        echo '</tr>';
    }
                ?>
            </table>
        </div>
    </div>
</section>
<?php require_once('../view/footer.php');?>