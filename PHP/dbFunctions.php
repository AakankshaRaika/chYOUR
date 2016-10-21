<?php

class dbFunctions {
 
    private $conn;
 
    // constructor
    function __construct() {
        require_once 'dbConnect.php';
        // connecting to database
        $db = new dbConnect();
        $this->conn = $db->connect();
    }
	// destructor
    function __destruct() {
         
    }
public function storeUser($fullname, $email, $password) {
        $uuid = uniqid('', true);
 
        $stmt = $this->conn->prepare("INSERT INTO usertbl(userID, fullname, email, password) VALUES(?, ?, ?)");
        $stmt->bind_param("sssss", $uuid, $fullname, $email, $password);
        $result = $stmt->execute();
        $stmt->close();
 
        // check for successful store
        if ($result) {
            $stmt = $this->conn->prepare("SELECT * FROM users WHERE email = ?");
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
        $stmt = $this->conn->prepare("SELECT email from users WHERE email = ?");
 
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
