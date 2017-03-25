<?php
  include ("db_connect.php");
  $gender = $_GET['gender'];
  $student_num = $_GET['num'];
  $db = new db('localhost','root','111111','dp_DB');

  $db->execQuery("SELECT gender,enter FROM students WHERE num = '$student_num'");
  $row = mysql_fetch_array($db->getResult());
  if($gender==$row['gender']){
    $json_result = ["P"];
    if ($row['enter'] == 0) // 나감
    {
      $db->execQuery("INSERT INTO access VALUES (NULL,'$student_num',1,NOW())");
      $db->execQuery("UPDATE students set enter=1 WHERE num='$student_num'");
    }
    else if ($row['enter'] == 1) // 들어옴
    {
      $db->execQuery("INSERT INTO access VALUES (NULL,'$student_num',0,NOW())");
      $db->execQuery("UPDATE students set enter=0 WHERE num='$student_num'");
    }
  }
  else {
    $json_result = ["F"];
  }
  header('Content-Type: application/json');
  echo json_encode($json_result,JSON_UNESCAPED_UNICODE);
  $db->close();
?>
