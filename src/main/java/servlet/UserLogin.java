package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.UserLoginDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("UEmail");  
	    String p=request.getParameter("UPassword");  
	          
	    if(UserLoginDao.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("user.jsp");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry email or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("userlogin.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  

}
