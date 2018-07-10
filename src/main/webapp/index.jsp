<html>
	<head>
		<title>
			Main Page for Logistic Site
		</title>
		<link href="style/index.css" type="text/css" rel="stylesheet" />

        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div id="mainDiv">
			<div id="authenticationForm">
				<!-- Login field -->
				<form action="user/register" method="post">
                    <div class="enterField">
                        Login
                        <input type="text" id="loginField" name="login">
                    </div>
                    <!-- Password field-->
                    <div class="enterField">
                        Password
                        <input type="password" id="passwordField" name="password">
                    </div>
				    <input type="submit" text="login">
                </form>
			</div>
		</div>
		
	</body>
</html>
