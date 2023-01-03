package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.MySQLConnUtils;

/**
 * Servlet implementation class UserManage
 */
@WebServlet("/UserManage")
public class UserManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try 
		{		
			Connection con = MySQLConnUtils.getMyConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");
			
			out.print("<!DOCTYPE html>");
			out.print("<html>");
			out.println("<head>");
			out.println("<title>View Book</title>");
			out.println("<style type=\"text/css\">");
			out.println("table, th, td{border:1px solid #ccc;}");
			out.println("table{border-collapse:collapse;width:100%;}");
			out.println("th, td{text-align:left;padding:10px;}");
			out.println(" tr:hover{background-color:#ddd;cursor:pointer;}");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.print("<table width=50% border=1 cellpadding=0 cellspacing=0>");
			out.print("<caption>Người Dùng</caption>");
			ResultSet rs = ps.executeQuery();
			out.print("</br></br>");
			out.print("</tr>");
			out.println("<tr><th>Mã Sinh Viên</th><th>Tên Sinh Viên</th><th>Email</th><th>Số Điên Thoại</th><th></th></tr>");
			/* Printing result */
			while (rs.next()) {
				out.print("<tr><td>" + rs.getString(1)
						+ " </td><td>" + rs.getString(2) 
						+ " </td><td>" + rs.getString(3)
						+ " </td><td>" + rs.getString(5)+ "</td><td align=center>"
						+ "<a href='UpdateUser?id="+ rs.getString(1) +"'>Sửa  |  </a> "
						+ "<a href='DeleteUser?id="+ rs.getString(1) +"'>Xóa</a> "
						+ "</td></tr>");
			}
			out.print("</table>");

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
	}
