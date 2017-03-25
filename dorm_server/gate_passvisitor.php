<?php
  include ("db_connect.php");
  $gender = $_GET['gender'];
  $name = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');

  $db->execQuery("SELECT gender,isout,outdatetime FROM visitor WHERE name = '$name'");
  $row = mysql_fetch_array($db->getResult());
  if($gender==$row['gender']){
    if(date("Y-m-d H:i:s",strtotime('+17 hours'))<$row['outdatetime']){
      $json_result = ["P"];
      if ($row['isout'] == 0) // ³ª°¨
      {
        $db->execQuery("UPDATE visitor set isout=1 WHERE name='$name'");
      }
      else if ($row['isout'] == 1) // µé¾î¿È
      {
        $db->execQuery("UPDATE visitor set isout=0 WHERE name='$name'");
      }
    }
    else{
      $json_result = ["T"];
    }
  }
  else {
    $json_result = ["F"];
  }
  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>