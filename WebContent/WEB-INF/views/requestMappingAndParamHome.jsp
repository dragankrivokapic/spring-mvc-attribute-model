<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping and @RequestParam test bed</title>
<style>
input [type=text] {
	padding: 10px;
	margin: 10 px;
	font-size: 20 px
}

input [type=submit] {
	border: none;
	background-color: #4CAF50;
	color: white;
	padding: 16 px;
	margin: 16 px;
	cursor: pointer;
	font-size: 20 px
}

h2 {
	color: #08298A;
	text-align: center
}
</style>
</head>
<body>

	<div align="left">
		<h2 align="center">Hello, Welcome to the @RequestMapping &
			RequestParam Test bed</h2>
		<hr>
		<form action="test1">
			<h3>test1: Testing @RequestParam without explicit attributes</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40"> <input type="submit" value="Submit" />
		</form>
		<br> <br>
		<form action="test2">
			<h3>test2: Testing @RequestMapping 'method' attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40"> <input type="submit" value="Submit" />
		</form>

		<br> <br>
		<form action="test3">
			<h3>test3: Testing @RequestMapping fallback feature</h3>
			<input type="submit" value="Submit" />
		</form>
		<br> <br>
		<form action="test4">
			<h3>test4: Testing @RequestParam 'defaultValue' attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40"> <input type="submit" value="Submit" />
		</form>
		<br> <br>
		<form action="test5">
			<h3>test5: Testing @RequestParam without 'name' or 'value' attributes</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" placeholder="Enter organization name"
				size="40"> <input type="submit" value="Submit" />
		</form>
	</div>

</body>
</html>