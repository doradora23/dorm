<?php
  include ("db_connect.php");
  $num = $_GET['num'];
  $name = $_GET['name'];
  $pw = $_GET['pw'];
  $gender = $_GET['gender'];
  $roomnum = $_GET['roomnum'];
  $enter = $_GET['enter'];
  $parent_phone = $_GET['parent_phone'];
  $isfloormaster = $_GET['isfloormaster'];
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("INSERT INTO students (num,name,pw,gender,roomnum,enter,parent_phone,isfloormaster) VALUES ('$num','$name','$pw','$gender','$roomnum','$enter','$parent_phone','$isfloormaster')");
  $db->close();
?>
