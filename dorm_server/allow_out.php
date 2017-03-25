<?php
  include ("db_connect.php");
  $apply_outnum = $_GET['apply_outnum'];
  $is_accept = $_GET['is_accept'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("UPDATE apply_out set is_accept='$is_accept' WHERE apply_outnum='$apply_outnum'");
  $db->close();
?>
