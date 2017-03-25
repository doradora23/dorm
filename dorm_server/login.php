<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $pw = $_GET['pw'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("SELECT pw FROM students WHERE num='$num'");
  $res = mysql_fetch_row($db->getResult());
  if($res[0] == "")
      $json_result = ["N"];
  else if($pw == $res[0])
  {
    $json_result = ["L"];
    $db->execQuery("SELECT * FROM students WHERE num='$num'");
    $res = mysql_fetch_array($db->getResult());
    $json_result[1] = $res;
    if($res[isfloormaster]==1)
    {
    $db->execQuery("SELECT admin_floor FROM floormaster WHERE num='$num'");
    $admin_floor = mysql_fetch_array($db->getResult());
    $json_result[2] = $admin_floor;
    }
  }
  else if($pw != $res[0])
      $json_result = ["P"];
  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>
