<!--This is the skeleton all the ParkNet pages-->
<!doctype html>
<html lang=''>

<head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles.css">
    <script src="./validationScript.js" type="text/javascript"></script>
    <title>ParkNet - Offer Praking Spot</title>
</head>

<body>

    <div id='cssmenu'>
        <ul>
            <li><a href='./home.html'>Home</a></li>
            <li><a href='./parkingspots.php'>Available Parking Spots</a></li>
			<li><a href='./offerParkingSpot.html'>Add Parking Sport</a></li>
            <!--When logged in should turn to "My Profile"-->
            <!--When adding more pages, keep this one as the last one-->
            <li class='active'><a href='./signup.html'>Sign In/Sign up</a></li>
        </ul>
    </div>

    <div class="page-wrapper bg-gra-02 p-t-30 font-poppins">
        <div class="wrapper wrapper--w960">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Available Parking Spots</h2>      
                    <?php
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
						$query = "SELECT * FROM parkingspots";
						$result = mysqli_query($conn,$query);

						echo "<table border='1'>
						<tr>
						<th>Owner Username</th>
						<th>Location</th>
						<th>Price</th>
						</tr>";

						while($row = mysqli_fetch_array($result))
						{
							echo "<tr>";
							echo "<td>" . $row['username'] . "</td>";
							echo "<td>" . $row['location'] . "</td>";
							echo "<td>" . $row['price'] . "</td>";
							echo "</tr>";
						}
						echo "</table>";
						mysqli_close($conn);
					?>
                </div>
            </div>
        </div>
    </div>


    <footer class="footer">
        <center>
            <p>All rights reserved to Team 1 of the Yearly Technion Project©</p>
        </center>
    </footer>
</body>
<html>