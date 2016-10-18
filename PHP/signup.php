<?php
$con=mysqli_connect("127.0.0.1", "phpuser", "chyour2016");
if(mysqli_connect_errno($con))
{
	echo '{"query_result":"ERROR"}';
}

$userName = $_GET['username'];
$firstName = $_GET['firstname'];
$lastName = $_GET['lastname'];
$email = $_GET['email'];
$passWord = $_GET['password'];

$result = mysqli_query($con, "INSERT INTO usertbl (username, firstname, lastname, email, password) VALUES ('$userName', '$firstName', '$lastName', '$email', '$passWord')");

if($result == true){
	echo '{"query_result":"SUCCESS"}';
}
else{
	echo '{"query_result":"FAILURE"}';
}
mysqli_close($con);
?>
