<?php
	$username = "phpuser";
	$password = "chyour2016";
	$database = "chyourDB";
	$server = "127.0.0.1";

	$db_handle = mysqli_connect($server,$username,$password);
	$db_found = mysqli_select_db($db_handle,$database);

	if($db_found){
		print "Database Found!!";
		mysqli_close($db_handle);
	}
	else{
		print "Database not found!!!";
	}
?>
