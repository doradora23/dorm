<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $gender = $_GET['gender'];
  $admin_floor = $_GET['admin_floor'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("SELECT * FROM students WHERE num='$num'");
  $res = mysql_fetch_row($db->getResult());
  if($res[0] != ""){
    $db->execQuery("INSERT INTO floormaster (num,gender,admin_floor) VALUES ('$num','$gender','$admin_floor')");
    $db->execQuery("UPDATE students SET isfloormaster = 1 WHERE num = '$num'");
  }
  $db->close();
?>
