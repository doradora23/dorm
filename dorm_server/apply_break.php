<?php
  include ("db_connect.php");
  $roomnum = $_GET['roomnum'];
  $content = $_GET['content'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("INSERT into break (breaknum,roomnum,content) VALUES (NULL,'$roomnum','$content')");
  $db->close();
?>
