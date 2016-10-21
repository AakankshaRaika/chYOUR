<?php
session_start();
if(!$_SESSION['chyourdb'])
{
	header('location:login.php');
}
?>

<h1>Welcome you are signed in!</h1>
