<?php
  include ("db_connect.php");
  $db = new db('localhost','root','111111','dp_DB');
  $floor = $_GET['floor'];
  $gender = $_GET['gender'];
  $db->execQuery("SELECT * FROM students WHERE floor(roomnum/100) = '$floor' AND gender = '$gender'");
  $count = mysql_num_rows($db->getResult());
  for($i=0; $i<$count; $i++){
      $row[$i] = mysql_fetch_array($db->getResult());
  }

  for($i = 0; $i < $count; $i++){
    $json_result[$i] = $row[$i];
  }

  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>