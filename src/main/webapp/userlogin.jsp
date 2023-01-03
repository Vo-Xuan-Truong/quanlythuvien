<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
    padding: 0px;
    margin: 0px;
    font-family: sans-serif;
    box-sizing: border-box;
}
.container{
    width: 100%;
    max-width: 1200px;
    margin-left: auto;
    margin-right: auto;
}
.login-form{
    width: 100%;
    max-width: 400px;
    margin: 20px auto;
    background-color: #ffffff;
    padding: 15px;
    border: 2px dotted #cccccc;
    border-radius: 10px;
}
h1{
    color: #009999;
    font-size: 20px;
    margin-bottom: 30px;
}
.input-box{
    margin-bottom: 10px;
}
.input-box input{
    padding: 7.5px 15px;
    width: 100%;
    border: 1px solid #cccccc;
    outline: none;
}
.btn-box{
    text-align: right;
    margin-top: 30px;
}
.btn-box button{
    padding: 7.5px 15px;
    border-radius: 2px;
    background-color: #009999;
    color: #ffffff;
    border: none;
    outline: none;
}
</style>
</head>
<body>
            <div class="container">
            <div class="login-form">
                <form action="UserLogin" method="post">
                    <h1>User Login</h1>
                    <div class="input-box">
                        <i ></i>
                        <input type="text" placeholder="Email" name="UEmail">
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <input type="password" placeholder="Password" name="UPassword">
                    </div>
                    <div class="btn-box">
                        <a href = ""><button type="submit">Login</button></a>
                    </div>
                </form>
            </div>
            </div>

</body>
</html>