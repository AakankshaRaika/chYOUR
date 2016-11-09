<?php

class dbFunctions {
 
    	private $conn;

	// Constructor

    	function __construct() {
		$username = "phpuser";
   		$password = "chyour2016";
    		$database = "chyourDB";
		$server = "127.0.0.1";

		$this->conn = mysqli_connect($server,$username,$password);
		$db_found = mysqli_select_db($this->conn,$database);
    	}
    	
	// Testing code

	/*if($db_found){
    		print "Database Found!!";
    		mysqli_close($conn);
    	}else{
        	print "Database not found!!!";
    	}
    	
    	require_once 'dbConnect.php';
    	// connecting to database
    	$db = new dbConnect();
    	$this->conn = $db->connect();
    	*/
    
    	// Destructor

    	function __destruct() {
    	
	}

	// Attempt to store user in database
    
	public function storeUser($fullname, $email, $password) {
        	//$uuid = uniqid('', true);
 
	        $stmt = $this->conn->prepare("INSERT INTO usersTBL(fullname, email, password) VALUES(?, ?, ?)");
        	$stmt->bind_param('sss',/* $uuid,*/ $fullname, $email, $password);
        	$result = $stmt->execute();
        	$stmt->close();
		 
	        // Check for successful store

        	if ($result) {
            		$stmt = $this->conn->prepare("SELECT * FROM usersTBL WHERE email = ?");
            		$stmt->bind_param('s', $email);
            		$stmt->execute();
            		$user = $stmt->get_result()->fetch_assoc();
            		$stmt->close();
			return $user;
        	} else {
            		return false;
        	}
	}
     
	// Check if user exists
     
	public function userExists($email) {
	        $stmt = $this->conn->prepare("SELECT email from usersTBL WHERE email = ?");
        	$stmt->bind_param("s", $email);
	        $stmt->execute();
	        $stmt->store_result();
 
        	if ($stmt->num_rows > 0) {
            		// user exists 
            		$stmt->close();
            		return true;
        	} else {
         	   	// user does not exist
            		$stmt->close();
            		return false;
        	}
    	}

	public function checkUser($email, $password){

		$stmt = $this->conn->prepare("SELECT * FROM usersTBL WHERE email = ?");
		$stmt->bind_param("s". $email);
		$result = $stmt->execute();
		if($result){
			$user = $stmt->get_result()->fetch_assoc();
			$stmt->close(); 
			
			$pass = $user['password'];
			if($pass == $password){
				return $user;
			}
		} else {
			return NULL;
		}
	}

	public function badEmail($email){

                if(strpos($email, '@') == false || strpos($email, '.') == false){
                        return true;
                }

        }
				
}

?>
