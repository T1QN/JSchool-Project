<html lang="en">
	<head>
		<title>
			Main Page for Logistic Site
		</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<link href="style/index.css" type="text/css" rel="stylesheet" />
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	</head>
	<body>
		<div class="container">
			<c:url value="/j_spring_security_check" var="loginUrl" />
			<form action="${loginUrl}" method="post">
			<h2 class="form-signin-heading"> Sign In to continue </h2>
				<input type="text" class="form-control" name="j_username" >
				<input type="password" class="form-control" name="j_password" >
				<div class="form-group">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</button>
					<button class="btn btn-success btn-lg btn-block" type="button">Sign Up</button>					
				</div>
		</div>		
	</body>
</html>
