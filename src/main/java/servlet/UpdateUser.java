package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.MySQLConnUtils;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try 
		{		
			Connection con = MySQLConnUtils.getMyConnection();
			
			PreparedStatement ps = con.prepareStatement("select*from user Where masinhvien = '" + request.getParameter("id") + "'");
			out.print(" <form method='POST' action= UpdateUser>");
			out.print("<table width=50% border=1 cellpadding=0 cellspacing=0>");
			out.print("<caption>Chỉnh sửa thông sinh vien:</caption>");
			ResultSet rs = ps.executeQuery();
			/* Printing column names */
			out.print("</br></br>");
			ResultSetMetaData rsmd = rs.getMetaData();
			int total = rsmd.getColumnCount();
			out.print("<tr>");
			for (int i = 1; i <= total; i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			/* Printing result */
			while (rs.next()) {
				out.print("<tr><td><input type= text name= txtEditMaSV value='" + rs.getString(1) + "'></td>"
							+ "<td><input type= text name= txtEditTen value='" + rs.getString(2) + "'></td>" 
							+ "<td><input type= text name= txtEditEmail value='" + rs.getString(3) + "'></td>" 
							+ "<td><input type= text name= txtEditPassWord value='" + rs.getString(4) + "'></td>"
							+ "<td><input type= text name= txtEditSoDienThoai value=" + rs.getString(5) + ">"
							+ "<input type=submit value= Save>"
							+ "</td></tr>");
			}
			out.print("</table>");	
			out.print("</form>");
			
		} 
		catch (Exception e2) 
		{
			e2.printStackTrace();
		} 
		finally 
		{
			out.close();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String sql = "update user set "
	    			+ "ten ='" + request.getParameter("txtEditTen") + "',"
	    			+ "email = '" + request.getParameter("txtEditEmail")+ "',"
	    			+ "password = '" + request.getParameter("txtEditPassWord")+ "',"
	    			+ "sodienthoai ='" + request.getParameter("txtEditSoDienThoai")  + "'"	    	
	    			+ " Where masinhvien ='" +request.getParameter("txtEditMaSV") + "'";
	    	PrintWriter out = response.getWriter();
	    	out.println(sql);
	    	
	    	try {
				Connection con = MySQLConnUtils.getMyConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
				out.print("Sửa thành công");
			} 
	    	catch (Exception e2) {
				e2.printStackTrace();
				out.print(e2);
				out.print("Sửa thất bại");
			} finally {
				out.close();
			}	
	    			
	    }

}
