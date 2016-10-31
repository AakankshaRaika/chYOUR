<?php
 
require_once 'include/dbFunctions.php';
$db = new dbFunctions();
 
// json response array
$response = array("error" => FALSE);
 
if (isset($_GET['fullname']) && isset($_GET['email']) && isset($_GET['password'])) {
    
    // receiving the post params
    $fullname = $_GET['fullname'];
    $email = $_GET['email'];
    $password = $_GET['password'];
    
    // check if user is already exists with the same email
    if ($db->userExists($email)) {
        // user already exists
        $response["error"] = TRUE;
        $response["error_msg"] = "User already exists with email address " . $email;
        echo json_encode($response);
    } else {
        // create a new user
        $user = $db->storeUser($fullname, $email, $password);
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["uid"] = $user["userID"];
            $response["user"]["fullname"] = $user["fullname"];
            $response["user"]["email"] = $user["email"];
	    echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Failed to store user";
            echo json_encode($response);
        }
    }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (fullname, email or password) is missing!";
    echo json_encode($response);
}
?>
