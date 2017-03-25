<?php
  include ("db_connect.php");
  $roomnum = $_GET['roomnum'];
  $gender = $_GET['gender'];
  $student_num = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');

  $db->execQuery("SELECT roomnum,gender FROM students WHERE num = '$student_num'");
  $row = mysql_fetch_array($db->getResult());
  if($roomnum==$row['roomnum']&&$gender==$row['gender']){
    $json_result = ["P"];
  }
  else {
    $json_result = ["F"];
  }
  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>
