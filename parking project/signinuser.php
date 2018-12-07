<?php
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
$password = $_POST['password'];

$query = "SELECT * FROM users WHERE username = '$username' AND password ='$password'";
$result = $conn->query($query);

if ($result->num_rows > 0) {
    header('Location: ./home.html');
    $cookie_name = "username";
    $cookie_value = $username;
    setcookie($cookie_name, $cookie_value, time() + (86400), "/");
}
else{
    header('Location: ./signin.html?bad_cred');
    $cookie_name = "username";
    $cookie_value = null;
    setcookie($cookie_name, $cookie_value, time() + (86400), "/");
}
 
// Close connection
mysqli_close($conn);

?>
