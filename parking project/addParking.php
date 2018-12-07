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

$location = $_POST['location'];
$askingPrice = (int)$_POST['asking_price'];
echo $location;
echo $askingPrice;

//need to change the username inputted to the current session's username
$username = $_COOKIE['username'];
if($username == null || strlen($username) == 0){
    header('Location: ./signin.html?sign_in_first');
}
else{
    $query = "INSERT INTO parkingspots (username, location, price) VALUES ('$username', '$location', '$askingPrice')";
    if(mysqli_query($conn, $query)){
        echo "Records inserted successfully.";
        header('Location: ./confirmAdded.html');
    } else{
        echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
    }
}
 
// Close connection
mysqli_close($conn);

?>
