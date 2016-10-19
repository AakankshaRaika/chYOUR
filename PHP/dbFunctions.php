<?php

class DB_Functions {
 
    private $conn;
 
    // constructor
    function __construct() {
        require_once 'dbConnect.php';
        // connecting to database
        $db = new Db_Connect();
        $this->conn = $db->connect();
    }
	// destructor
    function __destruct() {
         
    }
public function storeUser($name, $email, $password) {
        $uuid = uniqid('', true);
 
        $stmt = $this->conn->prepare("INSERT INTO usertbl(unique_id, name, email, password, created_at) VALUES(?, ?, ?, ?, NOW())");
        $stmt->bind_param("sssss", $uuid, $name, $email, $password);
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
     * Check user is existed or not
     */
    public function isUserExisted($email) {
        $stmt = $this->conn->prepare("SELECT email from users WHERE email = ?");
 
        $stmt->bind_param("s", $email);
 
        $stmt->execute();
 
        $stmt->store_result();
 
        if ($stmt->num_rows > 0) {
            // user existed 
            $stmt->close();
            return true;
        } else {
            // user not existed
            $stmt->close();
            return false;
        }
    }
}

?>
