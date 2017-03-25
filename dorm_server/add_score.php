<?php
  include ("db_connect.php");
  $score = $_GET['score'];
  $date = $_GET['date'];
  $reason = $_GET['reason'];
  $student_num = $_GET['student_num'];
  $floormaster_num = $_GET['floormaster_num'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("INSERT INTO score (score,date,reason,student_num,floormaster_num) VALUES ('$score','$date','$reason','$student_num','$floormaster_num')");
  $db->close();
?>
