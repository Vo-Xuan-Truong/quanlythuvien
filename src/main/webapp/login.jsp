<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Login</title>
    <style>
    *{margin:0;padding:0}
       body{
           width:100%;
           margin: 0 auto;
           max-width: 1350px;
           font-family: 'Oswald', sans-serif;
           background: #F0E4E4;
       }
       .form_hoa{
           width: 40%;
           margin: auto;
       }
       .form_hoa>.box_login{
           width: 100%;
           margin-top: 30%;
           background-color: #d5d5d5;
           box-shadow: 0 0 2px #000;
           border-radius: 10px;
           padding: 20px;
           box-sizing: border-box;
       }
       .box_login form h2{
           text-align: center;
           color:#000;
           font-size: 30px;
       }
       .box_login form>div{
           padding: 5px 0px;
       }
       .box_login form label{
           padding: 3px 0;
           display: block;
           font-weight: bold;
       }
       .box_login form input{
           width: 100%;
           border:none;
           background-color: #fff;
           padding: 15px;
           border-radius: 5px;
           box-sizing: border-box;
       }
       .box_login form button{
           width: 100%;
            border:none;
            background: #e5e5e5;
            color:#fff;
            padding: 11px;
            border-radius: 5px;
            box-sizing: border-box;
            text-align: center;
            font-size: 20px;
       }
    
    </style>
</head>
<body>
    <div class="form_hoa">
        <div class="box_login">
            <form>
                <h2>Select Login</h2>
                <div>
                    <button ><a href = "librarianlogin.jsp">Librarian Login</a></button>
                </div>
                <div>
                    <button><a href = "userlogin.jsp">User Login</a></button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
