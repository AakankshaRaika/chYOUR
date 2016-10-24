register.php
<?php
 
require_once 'include/dbFunctions.php';
$db = new dbFunctions();
 
// json response array
$response = array("error" => FALSE);
 
if (isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['password'])) {
 
    // receiving the post params
    $fullname = $_POST['fullname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
 
    // check if user is already exists with the same email
    if ($db->isUserExisted($email)) {
        // user already exists
        $response["error"] = TRUE;
        $response["error_msg"] = "User already existed with " . $email;
        echo json_encode($response);
    } else {
        // create a new user
        $user = $db->storeUser($fullname, $email, $password);
        if ($user) {
            // user stored successfully
            $response["error"] = FALSE;
            $response["uid"] = $user["unique_id"];
            $response["user"]["fullname"] = $user["fullname"];
            $response["user"]["email"] = $user["email"];
            
            echo json_encode($fullname);
	    echo json_encode($response);
        } else {
            // user failed to store
            $response["error"] = TRUE;
            $response["error_msg"] = "Unknown error occurred in registration!";
            echo json_encode($response);
        }
    }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters (fullname, email or password) is missing!";
    echo json_encode($response);
}
?>