<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("SELECT SUM(score) FROM score WHERE student_num = '$num'");
  $row = mysql_fetch_array($db->getResult());

  $json_result[0] = $row[0];

  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>
