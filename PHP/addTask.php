<?php
 
require_once 'include/dbFunctions.php';
$db = new dbFunctions();
 
// json response array
$response = array("error" => FALSE);

if (isset($_GET['userID']) &&isset($_GET['description']) && isset($_GET['date']) && isset($_GET['address']) && isset($_GET['latitude']) && isset($_GET['longitude']) ) {
    
    // receiving the post params
    $uid = $_GET['userID'];
    $desc = $_GET['description'];
    $date = $_GET['date'];
    $addr = $_GET['address'];
    $lat = $_GET['latitude'];
    $long = $_GET['longitude'];

    //store

    $stmt = $this->conn->prepare("INSERT INTO tasksTBL(userID, description, date, address, latitude, longitude) VALUES(?,?, ?, ?, ?, ?)");
            $stmt->bind_param('isisii',/* $uuid,*/ $uid, $desc, $date, $addr, $lat, $long);
            $result = $stmt->execute();
            $stmt->close();
            

}

?>