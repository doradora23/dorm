<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $date_apply = $_GET['date_apply'];
  $date_out = $_GET['date_out'];
  $reason = $_GET['reason'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("INSERT INTO apply_out (apply_outnum,num,reason,date_apply,date_out,is_accept) VALUES (NULL,'$num','$reason',STR_TO_DATE('$date_apply', '%Y%m%d'),STR_TO_DATE('$date_out', '%Y%m%d'),NULL)");
  $db->close();
?>
