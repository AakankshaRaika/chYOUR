<?php
session_start();
if(!$_SESSION['id11983_chyourdb'])
{
	header('location:login.php');
}
?>

<h1>Welcome you are signed in!</h1>
