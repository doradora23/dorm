<?php
  include ("db_connect.php");
  $breaknum = $_GET['breaknum'];
  $is_processed = $_GET['is_processed'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("UPDATE break set is_processed='$is_processed' WHERE breaknum='$breaknum'");
  $db->close();
?>
