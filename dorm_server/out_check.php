<?php
  include ("db_connect.php");
  $db = new db('localhost','root','111111','dp_DB');
  $db->execQuery("SELECT * FROM students WHERE enter = '1'");
  $count = mysql_num_rows($db->getResult());
  for($i=0; $i<$count; $i++){
      $row[$i] = mysql_fetch_array($db->getResult());
  }

  for($i = 0; $i < $count; $i++){
    $temp_num = $row[$i][num];
    $db->execQuery("SELECT is_accept FROM apply_out WHERE num = '$temp_num' AND date_out = CURRENT_DATE()");
    $temp_isaccept = mysql_fetch_row($db->getResult());
    if($temp_isaccept[0]==NULL)
    {
      $temp_isaccept[0] = 0;
    }
    $db->execQuery("INSERT INTO out_list (num,date_out,is_accept) VALUES ('$temp_num',CURRENT_DATE(),$temp_isaccept[0])");
  }
    $db->close();
?>
