package conn;

import java.sql.*;  

public class UserLoginDao {  
public static boolean validate(String uemail,String upassword){  
boolean status=false;  
try{  
	Connection con = MySQLConnUtils.getMyConnection();
	PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");

ps.setString(1,uemail);  
ps.setString(2,upassword);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  