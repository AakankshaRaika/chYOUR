<?php
class DB_connect{
	private $conn;
	
	public function connect(){
	
	$this->conn = new mysqli_connect("127.0.0.1", "phpuser", "chyour2016");
	
	
	return $this->conn;
	
	}


}