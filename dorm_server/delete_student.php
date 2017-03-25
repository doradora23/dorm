<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("DELETE from students WHERE num = '$num'");
  $db->close();
?>
