<?php

class dbConnect{
	private $conn;
	
	public function connect(){
	
		//Open connection to database
		$this->conn = new mysqli_connect("127.0.0.1", "phpuser", "chyour2016");
		return $this->conn;
	
	}

}
?>
