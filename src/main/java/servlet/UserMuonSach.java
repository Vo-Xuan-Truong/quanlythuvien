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
 * Servlet implementation class UserMuonSach
 */
@WebServlet("/UserMuonSach")
public class UserMuonSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMuonSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try 
		{		
			Connection con = MySQLConnUtils.getMyConnection();
			
			PreparedStatement ps = con.prepareStatement("select*from book Where masach = '" + request.getParameter("id") + "'");
			out.print(" <form method='POST' action= UserMuonSach>");
			out.print("<table width=50% border=1 cellpadding=0 cellspacing=0>");
			out.print("<caption>Mượn sách:</caption>");
			ResultSet rs = ps.executeQuery();
			/* Printing column names */
			out.print("</br></br>");
			out.print("<tr>");

			out.println("<tr><th>Mã Sách</th><th>Mã Sinh Viên</th><th>Ngày Mượn</th><th></th></tr>");

			/* Printing result */
			while (rs.next()) {
				out.print("<tr><td><input type= text name= txtMaSach value='" + rs.getString(1) + "'></td>"
							+ "<td><input type= text name= txtMaSV value=''></td>" 
							+ "<td><input type= date name= txtNgayMuon value=''>"
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "Insert into muonsach (Masinhvien,Masach,Ngaymuon) values ('"
				+ request.getParameter("txtMaSV") + "','"
				+ request.getParameter("txtMaSach") + "','"
				+ request.getParameter("txtNgayMuon") + "')";
    	PrintWriter out = response.getWriter();
    	out.println(sql);
    	
    	try {
			Connection con = MySQLConnUtils.getMyConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			out.print("Mượn thành công");
		} 
    	catch (Exception e2) {
			e2.printStackTrace();
			out.print(e2);
			out.print("Mượn thất bại");
		} finally {
			out.close();
		}	
	}

}
