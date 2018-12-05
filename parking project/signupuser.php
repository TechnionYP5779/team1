<?php

$cookie_name = "username";
$cookie_value = null;
setcookie($cookie_name, $cookie_value, time() + (86400), "/");

session_start();
$host = "localhost";
$username = "root";
$password = "";
$scheme = "parking";

//Create connection
$conn = mysqli_connect($host, $username, $password, $scheme);

//Check connection
if($conn == false){
	die("Connection failed: " . mysqli_connect_error());
}

$username = $_POST['username'];
$email = $_POST['email'];
$password = $_POST['password'];

$query = "SELECT * FROM users WHERE username = '$username' OR email = '$email'";
$result = $conn->query($query);

if ($username == 'none' || $result->num_rows > 0) {
    header('Location: ./signup.html?exist');
}
else{
    $query = "INSERT INTO users VALUES ('$username', '$email', '$password')";
    header('Location: ./signin.html');
    mysqli_query($conn, $query);
}
 
// Close connection
mysqli_close($conn);

?>
