<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("SELECT * FROM out_list");
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
