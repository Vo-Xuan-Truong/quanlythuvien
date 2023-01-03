<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body{
	background-image: url('image/a.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover; 
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
</head>
<body>
<ul>
  <li><a href="user.jsp">Home</a></li>
  <li><a href="UserXemSach">Library</a></li>
  <li><a href="InfoUser">Account Info</a></li>
  <li style="float:right"><a class="active" href="index.html">Logout</a></li>
</ul>
</body>
</html>