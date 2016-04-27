<!doctype html>
  
<html>
<head>
    <meta charset="utf-8" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


    <title>Calendário jQuery</title>   
</head>
<body>

<script>
$(function() {
    $("#calendario").datepicker({
        changeMonth: true,
        changeYear: true
    });
});
</script>


Read more: http://www.linhadecodigo.com.br/artigo/3604/calendario-em-jquery-criando-calendarios-com-datepicker.aspx#ixzz46gNLzJX5


    <p>Data: <input type="text" id="calendario" /></p>
 </body>
</html>

