<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $pw = $_GET['pw'];
  $parent_phone = $_GET['parent_phone'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("UPDATE students set pw='$pw',parent_phone='$parent_phone' WHERE num='$num'");
  $db->close();
?>
