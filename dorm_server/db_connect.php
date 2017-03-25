<?php
// simple DB class
class DB {

  // DB Connection
  var $db;

  // constructor
  function __construct($host, $user, $pass, $dbName) {
    $this->connect($host, $user, $pass);
    $this->selectDB($dbName);
  }

  // connect to DB host
  function connect($host, $user, $pass) {
    $this->db = mysql_connect($host, $user, $pass) or die("!! DB connect failed.");
    mysql_query("set names utf8");
  }

  // select database
  function selectDB($dbName) {
    mysql_select_db($dbName, $this->db) or die("!! DB Select failed.");
  }

  // execute query
  function execQuery($query) {
    if($this->isAlive())
      $this->result = mysql_query($query, $this->db) or die("!! DB execQuery faild.");
  }

  // check db variable
  function isAlive() {
    return is_resource($this->db);
  }

  // check has result
  function hasResult(){
    return is_resource($this->result);
  }

  // get query result
  function getResult(){
    if($this->hasResult())
      return $this->result;
  }

  // get query result length
  function getResultLength(){
    if($this->hasResult())
      return mysql_num_rows($this->result);
  }

  // close db
  function close(){
    if(is_resource($this->result))
      mysql_free_result($this->result);

    mysql_close($this->db);
  }

  // destructor
  function __destruct(){
    $this->close();
  }
}
?>
