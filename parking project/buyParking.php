<?php
session_start();
$host = "localhost";
$username = "root";
$password = "";
$scheme = "parking";

//Create connection
$conn = mysqli_connect($host, $username, $password, $scheme);

$username = $_COOKIE['username'];
if($username == null || strlen($username) == 0){
    header('Location: ./signin.html?sign_in_first');
}
else{
    //Check connection
    if($conn == false){
        die("Connection failed: " . mysqli_connect_error());
    }

    $url = $_SERVER['REQUEST_URI'];
    $parts = parse_url($url);
    $parkingID = explode("=", $parts["query"])[1];

    $query = "UPDATE parkingspots SET boughtBy ='$username' WHERE id='$parkingID'";
    if(mysqli_query($conn, $query)){
        header('Location: ./home.html');
    }
    else{
        echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
    }
    echo $parkingID;
}
mysqli_close($conn);

?>