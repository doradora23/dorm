<?php
  include ("db_connect.php");
  $name = $_GET['name'];
  $pw = $_GET['pw'];
  $gender = $_GET['gender'];
  $roomnum = $_GET['roomnum'];
  $reason = $_GET['reason'];
  $date = $_GET['date'];
  $phone = $_GET['phone'];
  $out_time = $_GET['out_time'];
  $db = new db('localhost','root','111111','dp_DB');
  $str_datetime = $date.$out_time;
  $db->execQuery("INSERT INTO visitor VALUES (NULL,'$name','$gender','$pw','$phone','$roomnum','$reason',STR_TO_DATE('$str_datetime', '%Y%m%d%H%i'),0)");
  $db->execQuery("SELECT * FROM visitor WHERE name = '$name'");
  $row = mysql_fetch_array($db->getResult());
  $json_result = $row;

  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);$db->close();
?>
