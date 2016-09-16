
<footer class="footer">
    <div class="container">
        <div class="col-xs-4"><img src="../img/logo.svg" style="height:50px;margin:1%"> </div>
        <div class="col-xs-4"><p class="text-muted"style ="margin:20px;text-align:left">Powered by <a href="http://www.eden-com.fr/">EDEN COM</a></p></div>
        <div class="col-xs-4"><p class="text-muted"style ="margin:20px;text-align:right"><a href="mention.php">mentions légales</a></p></div>
    </div>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../bootstrap-4.0.0-alpha.2/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="../js/wickedpicker.js"></script>
<script defer src="../js/jquery.flexslider.js"></script>

<script type="text/javascript">
    $(window).load(function(){
        $('.flexslider').flexslider({
            animation: "slide"
        });
    });
</script>
<script>
    $(function() {
        $( "#datepicker" ).datepicker();
        $('.timepicker').wickedpicker({twentyFour: true});
    });
</script>
</body>
</html>