addTask
<?php
 
require_once 'include/dbFunctions.php';
$db = new dbFunctions();
 
// json response array
$response = array("error" => FALSE);

if (isset($_GET['userID']) && isset($_GET['description']) && isset($_GET['date']) && isset($_GET['address']) &&
	isset($_GET['taskTitle']) && isset($_GET['taskRange']) &&  isset($_GET['latitude']) && isset($_GET['longitude']) ) {
    	
    // receiving the post params
    $uid = $_GET['userID'];
    $title = $_GET['taskTitle'];
    $desc = $_GET['description'];
    $date = $_GET['date'];
    $addr = $_GET['address'];
    $range = $_GET['taskRange'];
    $lat = $_GET['latitude'];
    $long = $_GET['longitude'];

    // store task to the server 
    $db->addTask($uid, $title, $desc, $date, $addr, $range, $lat, $long);

	
}

?>
