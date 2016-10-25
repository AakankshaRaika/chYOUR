<?php

class dbFunctions {
 
    private $conn;
 
   /* // constructor
    function __construct() {
        require_once 'dbConnect.php';
        // connecting to database
        $db = new dbConnect();
        $this->conn = $db->connect();
    }
	// destructor
    function __destruct() {
    */

	$username = "phpuser";
	$password = "chyour2016";
	$database = "chyourDB";
	$server = "127.0.0.1";

	$conn = mysqli_connect($server,$username,$password);
	$db_found = mysqli_select_db($db_handle,$database);

	if($db_found){
		print "Database Found!!";
		mysqli_close($db_handle);
	}
	else{
		print "Database not found!!!";
	}
     
    }
public function storeUser($fullname, $email, $password) {
        $uuid = uniqid('', true);
 
        $stmt = $this->conn->prepare("INSERT INTO usersTBL(userID, fullname, email, password) VALUES(?, ?, ?, ?)");
        $stmt->bind_param("ssss", $uuid, $fullname, $email, $password);
        $result = $stmt->execute();
        $stmt->close();
 
        // check for successful store
        if ($result) {
            $stmt = $this->conn->prepare("SELECT * FROM usersTBL WHERE email = ?");
            $stmt->bind_param("s", $email);
            $stmt->execute();
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();
 
            return $user;
        } else {
            return false;
        }
    }
/**
     * Check if user exists
     */
    public function isUserExisted($email) {
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
}

?>
