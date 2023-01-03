package conn;

import java.sql.*;  

public class LibrarianLoginDao {  
public static boolean validate(String lemail,String lpassword){  
boolean status=false;  
try{  
	Connection con = MySQLConnUtils.getMyConnection();
	PreparedStatement ps = con.prepareStatement("select * from librarian where email=? and password=?");

ps.setString(1,lemail);  
ps.setString(2,lpassword);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  